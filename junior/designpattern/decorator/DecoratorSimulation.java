package designpattern.decorator;

public class DecoratorSimulation {
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage); // 하우스 블랜드 커피 + 모카 + 모카
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
    }
}
