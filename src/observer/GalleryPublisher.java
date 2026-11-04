package observer;

import java.util.ArrayList;
import java.util.List;

// Subject (publisher): keeps the list of observers and notifies them
public class GalleryPublisher {
    private List<GalleryObserver> observers = new ArrayList<>();

    public void addObserver(GalleryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GalleryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String eventType, String message) {
        for (GalleryObserver observer : observers) {
            observer.onGalleryChanged(eventType, message);
        }
    }
}