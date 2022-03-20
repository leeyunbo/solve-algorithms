package designpattern.decorator;

/**
 * HouseBlend 커피 클래스
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "하우스 블랜드 커피";
    }

    public double cost() {
        return 0.89;
    }
}
