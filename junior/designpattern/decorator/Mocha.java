package designpattern.decorator;

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", 모카";
    }

    /**
     * Mocha가 감싸고 있는 beverage의 가격 로직 + 본인의 세부 로직을 합친다.
     */
    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
