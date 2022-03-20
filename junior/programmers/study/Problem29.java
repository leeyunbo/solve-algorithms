package junior.programmers.study;

public class Problem29 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] pattern) {
        int[] answer = new int[pattern.length-1];
        Link[] links = new Link[pattern.length-1];

        for(int i=0; i<pattern.length-1; i++) {
            links[i] = new Link(pattern[i], pattern[i+1]);
        }

        

        return answer;
    }

    class Link {
        private int start;
        private int end;
        public Link(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
