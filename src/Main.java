import facade.GalleryFacade;
import strategy.SortByNameStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Photo Gallery Application ===\n");

        // Initialize Facade
        GalleryFacade gallery = new GalleryFacade();

        // 1. Media Creation & Notifications (Factory Method + Observer - Aisulu)
        System.out.println("--- 1. Adding Files (Factory Method + Observer) ---");
        gallery.addPhoto("sunset.jpg", "photo");
        gallery.addPhoto("vacation_video.mp4", "video");

        // 2. Image Filter Pipeline (Decorator - Sara)
        System.out.println("\n--- 2. Dynamic Image Filtering (Decorator - Sara) ---");
        gallery.applyFilterAndDisplay("sunset.jpg");

        // 3. Sorting Algorithms (Strategy - Sara)
        System.out.println("\n--- 3. Sorting Gallery (Strategy - Sara) ---");
        gallery.setSortStrategy(new SortByNameStrategy());
        gallery.sortGallery();

        // 4. Album Export Configuration (Builder - Sara)
        System.out.println("\n--- 4. Exporting Album (Builder - Sara) ---");
        gallery.exportAlbum("Summer 2026 Memories");
    }
}