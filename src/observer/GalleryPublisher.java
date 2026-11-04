package observer;

import java.util.ArrayList;
import java.util.List;

// Subject (Publisher) maintaining observer registrations and event broadcasts
public class GalleryPublisher {
    private List<GalleryObserver> observers = new ArrayList<>();

    public void addObserver(GalleryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GalleryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (GalleryObserver observer : observers) {
            observer.onGalleryChanged(message);
        }
    }
}