package org.mathiasus.services.observer;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Subject implements  IObserverSubject{
    public String message;
    public boolean changed;
    public Map<String, IObserver> observers = new LinkedHashMap<>();

    public Subject() {
    }

    @Override
    public void register(IObserver iObserver) {

        iObserver.setSubject(this);

        if(iObserver instanceof SubjectObserver) {
            observers.put(((SubjectObserver) iObserver).getName(), iObserver);
        }else {
            throw new ClassCastException("Unable to parse subject observer");
        }
    }

    @Override
    public void unregister(IObserver iObserver) {
        if(iObserver instanceof SubjectObserver) {
            observers.remove(((SubjectObserver) iObserver).getName());
        }else {
            throw new ClassCastException("Unable to parse subject observer");
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach((name, observer) -> {
           observer.update();
           this.changed = false;
        });
    }

    @Override
    public Object getUpdate(IObserver iObserver) {
        return this.message;
    }

    public void postMessage(String message) {
        this.message = message;
        changed = true;
    }
}
