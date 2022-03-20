package junior.programmers.study;

import java.util.LinkedList;
import java.util.Queue;

public class Problem12 {

    public static void main(String[] args) {
        int[] truck_weights = {5,3,2,4,5,2,1,3};


        Problem12 problem12 = new Problem12();
        System.out.println(problem12.solution(13, 100, truck_weights));

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Truck> waitQueue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            waitQueue.add(new Truck(truck_weight, bridge_length));
        }

        Bridge bridge = new Bridge(bridge_length, weight);
        bridge.add(waitQueue.poll());
        answer += 1;

        while(bridge.size() != 0 || !waitQueue.isEmpty()) {
            if (!waitQueue.isEmpty() && bridge.isPassBridge(waitQueue.peek().getWeight())) {
                bridge.moveInBridge(1);
                bridge.add(waitQueue.poll());
                answer += 1;
            } else {
                int distance = bridge.pass();
                bridge.moveInBridge(distance);
                answer += distance;

                if (!waitQueue.isEmpty() && bridge.isPassBridge(waitQueue.peek().getWeight()))
                    bridge.add(waitQueue.poll());
            }
        }

        return answer;
    }
}

class Bridge {
    private Queue<Truck> trucks = new LinkedList<>();
    private int bridge_length;
    private int weight;
    private int totalWeight = 0;

    public Bridge(int bridge_length, int weight) {
        this.bridge_length = bridge_length;
        this.weight = weight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public int size() {
        return trucks.size();
    }

    public void add(Truck truck) {
        trucks.add(truck);
        totalWeight += truck.getWeight();
    }

    public int pass() {
        Truck truck = trucks.poll();
        totalWeight -= truck.getWeight();
        return truck.getDistance();
    }

    public void moveInBridge(int distance) {
        for (Truck truck : trucks) {
            truck.setDistance(distance);
        }

        if(!trucks.isEmpty() && trucks.peek().getDistance() == 0)
            pass();
    }

    public boolean isPassBridge(int weightOfTruck) {
        return totalWeight + weightOfTruck <= weight && trucks.size() < bridge_length;
    }
}

class Truck {
    private int weight;
    private int distance;

    public Truck(int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public int getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance -= distance;
    }
}
