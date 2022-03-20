package designpattern.observer;

public interface Subject {

    void registerObservers(Observer o);
    void removeObservers(Observer o);
    void notifyObservers();
}
