package observer;

// Shows every event as a message in the "UI"
public class UIStatusNotification implements GalleryObserver {
    @Override
    public void onGalleryChanged(String eventType, String message) {
        System.out.println("[UI Notification] (" + eventType + "): " + message);
    }
}