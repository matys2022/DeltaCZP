package org.mathiasus.services.observer;

public interface IObserver {
    public void update();
    public void setSubject(IObserverSubject subject);
}
