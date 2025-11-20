package org.mathiasus.services.observer;

public interface IObserverSubject {
    public void register(IObserver iObserver);
    public void unregister(IObserver iObserver);
    public void notifyObservers();
    public Object getUpdate(IObserver iObserver);
}
