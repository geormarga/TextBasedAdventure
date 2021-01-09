package textbasedadventure.webapp.game;

interface Subject {
    void register(Observer o);

    void unregister(Observer o);

    void notifyObserver();
}
