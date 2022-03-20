package junior.javapractice;

import java.util.ArrayList;

public class Generics {

    public static void main(String[] args) {
        Box box = new Box();

        // 특정 형의 객체를 제한할 수 없음
        box.setItem(new ArrayList<Integer>());

        // 타입체크
        if(box.getItem() instanceof ArrayList) {
            // 형변환
            ArrayList<Integer> item = (ArrayList<Integer>) box.getItem();
        }

        // 특정 형의 객체로 제한할 수 있다.
        GenericsBox<ArrayList> genericsBox = new GenericsBox<>();

        // 타입 체크, 형변환이 필요 없다.
        genericsBox.setItem(new ArrayList<Integer>());
        ArrayList<Integer> genericsItem = genericsBox.getItem();
    }
}


class Box {
    private Object item;

    void setItem(Object item) {
        this.item = item;
    }

    Object getItem() {
        return item;
    }
}

class GenericsBox <T> {
    private T item;

    void setItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

}