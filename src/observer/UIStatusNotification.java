package observer;

public class UIStatusNotification implements GalleryObserver {
    @Override
    public void onGalleryChanged(String eventMessage) {
        System.out.println("[UI Notification]: " + eventMessage);
    }
}