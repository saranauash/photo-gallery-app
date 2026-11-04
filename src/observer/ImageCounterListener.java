package observer;

// Counts how many files are in the gallery, based on ADD and REMOVE events
public class ImageCounterListener implements GalleryObserver {
    private int total = 0;

    @Override
    public void onGalleryChanged(String eventType, String message) {
        if (eventType.equals("ADD")) {
            total++;
            System.out.println("[Counter Service]: files in gallery = " + total);
        } else if (eventType.equals("REMOVE")) {
            total--;
            System.out.println("[Counter Service]: files in gallery = " + total);
        }
    }

    public int getTotal() {
        return total;
    }
}