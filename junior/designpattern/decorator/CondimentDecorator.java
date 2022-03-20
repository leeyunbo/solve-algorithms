package designpattern.decorator;

// Beverage 형태의 변수에 삽입되어야 하기 때문에 상속 활용
public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}
