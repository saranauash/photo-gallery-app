package observer;

// Observer interface: every listener gets the event type and a message
public interface GalleryObserver {
    void onGalleryChanged(String eventType, String message);
}