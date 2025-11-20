package org.mathiasus.services.observer;

public abstract class SubjectObserver implements IObserver {
    public String name;
    private IObserverSubject subject;

    public SubjectObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        if(subject instanceof Subject) {
            System.out.println(((Subject) subject).message);
        }
    }

    @Override
    public void setSubject(IObserverSubject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }
}
