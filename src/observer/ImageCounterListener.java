package observer;

public class ImageCounterListener implements GalleryObserver {
    @Override
    public void onGalleryChanged(String eventMessage) {
        System.out.println("[Counter Service]: Gallery state updated -> " + eventMessage);
    }
}