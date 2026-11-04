import facade.GalleryFacade;
import strategy.SortByDateStrategy;
import strategy.SortByNameStrategy;
import strategy.SortByRatingStrategy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Photo Gallery Application ===\n");

        // Facade (Aisulu): the only class that Main talks to
        GalleryFacade gallery = new GalleryFacade();

        // 1. Factory Method + Observer (Aisulu)
        System.out.println("--- 1. Adding Files (Factory Method + Observer) ---");
        gallery.addMedia("sunset.jpg", "photo", LocalDate.of(2026, 7, 15), 5);
        gallery.addMedia("vacation_video.mp4", "video", LocalDate.of(2026, 6, 20), 3);
        gallery.addMedia("beach.jpg", "photo", LocalDate.of(2026, 8, 2), 4);
        gallery.addMedia("album_cover.jpg", "photo", LocalDate.of(2026, 5, 10), 2);

        // 2. Decorator (Sara): filters are chosen at runtime
        System.out.println("\n--- 2. Dynamic Image Filtering (Decorator) ---");
        gallery.applyFilterAndDisplay("sunset.jpg", "sepia");
        gallery.applyFilterAndDisplay("beach.jpg", "grayscale", "blur");
        gallery.applyFilterAndDisplay("vacation_video.mp4", "sepia");
        gallery.applyFilterAndDisplay("missing.jpg", "sepia");

        // 3. Strategy (Sara): the same gallery, three different algorithms
        System.out.println("\n--- 3. Sorting Gallery (Strategy) ---");
        gallery.setSortStrategy(new SortByNameStrategy());
        gallery.sortGallery();
        gallery.showGallery();

        gallery.setSortStrategy(new SortByDateStrategy());
        gallery.sortGallery();
        gallery.showGallery();

        gallery.setSortStrategy(new SortByRatingStrategy());
        gallery.sortGallery();
        gallery.showGallery();

        // 4. Remove a file (Observer updates the counter)
        System.out.println("\n--- 4. Removing a File (Observer) ---");
        gallery.removeMedia("album_cover.jpg");

        // 5. Builder (Sara): export uses the real files from the gallery
        System.out.println("\n--- 5. Exporting Album (Builder) ---");
        gallery.exportAlbum("Summer 2026 Memories", "PDF", true, true);
        gallery.exportAlbum("Bad Album", "RAR", false, false);

        // 6. History collected by one of the observers
        System.out.println("\n--- 6. Activity Log (Observer) ---");
        gallery.printActivityLog();
    }
}