package company;

/**
 * Created by ASemeykin on 19.10.2016.
 */
public interface IObserverable {
    void add(IObserver observer);
    void remove(IObserver observer);
    void notifyObservers();
}
