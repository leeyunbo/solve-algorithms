class Stack {
    List<Integer> list = new ArrayList<>();
    private final int STACK_MAX_SIZE;
    private int top = 0;

    public Stack(int STACK_MAX_SIZE) {
        this.STACK_MAX_SIZE = STACK_MAX_SIZE;
    }

    void push(int data) {
        if(isFull()) return ;

        list.add(top, data);
        top += 1;
    }

    void pop() {
        if(isEmpty()) return;

        top -= 1;
        list.remove(top);
    }

    boolean isEmpty() {
        return list.size() == 0;
    }

    boolean isFull() {
        return list.size() == STACK_MAX_SIZE;
    }
}
