package facade;

import builder.AlbumExportConfig;
import decorator.BlurDecorator;
import decorator.GrayscaleDecorator;
import decorator.Image;
import decorator.RawImage;
import decorator.SepiaDecorator;
import factory.MediaFactory;
import factory.MediaFile;
import factory.PhotoFactory;
import factory.VideoFactory;
import observer.ActivityLogListener;
import observer.GalleryPublisher;
import observer.ImageCounterListener;
import observer.UIStatusNotification;
import strategy.SortByDateStrategy;
import strategy.SortStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Facade: one simple entry point for the whole gallery subsystem.
// The client does not need to know about factories, observers, decorators etc.
public class GalleryFacade {
    private List<MediaFile> mediaList = new ArrayList<>();
    private GalleryPublisher publisher = new GalleryPublisher();
    private ActivityLogListener logListener = new ActivityLogListener();
    private SortStrategy sortStrategy;

    public GalleryFacade() {
        // connect listeners (Observer)
        publisher.addObserver(new UIStatusNotification());
        publisher.addObserver(new ImageCounterListener());
        publisher.addObserver(logListener);

        // default sorting strategy
        this.sortStrategy = new SortByDateStrategy();
    }

    // Factory Method: choose the right factory by type
    public void addMedia(String name, String type, LocalDate date, int rating) {
        MediaFactory factory;
        if (type.equalsIgnoreCase("video")) {
            factory = new VideoFactory();
        } else {
            factory = new PhotoFactory();
        }

        MediaFile media = factory.createMedia(name, date, rating);
        media.open();

        mediaList.add(media);
        publisher.notifyObservers("ADD", "Added new " + media.getType().toLowerCase() + ": " + name);
    }

    public void removeMedia(String name) {
        MediaFile found = findByName(name);
        if (found == null) {
            System.out.println("Can not remove, file not found: " + name);
            return;
        }
        mediaList.remove(found);
        publisher.notifyObservers("REMOVE", "Removed file: " + name);
    }

    // Strategy
    public void setSortStrategy(SortStrategy strategy) {
        this.sortStrategy = strategy;
    }

    public void sortGallery() {
        sortStrategy.sort(mediaList);
        publisher.notifyObservers("SORT", "Gallery sorted by " + sortStrategy.getName());
    }

    public void showGallery() {
        System.out.println("Gallery content (" + mediaList.size() + " files):");
        for (int i = 0; i < mediaList.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + mediaList.get(i));
        }
    }

    // Decorator: filters are chosen by the user at runtime, e.g. "sepia", "grayscale", "blur"
    public void applyFilterAndDisplay(String photoName, String... filters) {
        MediaFile media = findByName(photoName);
        if (media == null) {
            System.out.println("Can not apply filters, file not found: " + photoName);
            return;
        }
        if (!media.getType().equals("Photo")) {
            System.out.println("Filters can be applied only to photos: " + photoName);
            return;
        }

        Image image = new RawImage(photoName);
        for (String filter : filters) {
            if (filter.equalsIgnoreCase("grayscale")) {
                image = new GrayscaleDecorator(image);
            } else if (filter.equalsIgnoreCase("sepia")) {
                image = new SepiaDecorator(image);
            } else if (filter.equalsIgnoreCase("blur")) {
                image = new BlurDecorator(image);
            } else {
                System.out.println("Unknown filter skipped: " + filter);
            }
        }

        System.out.println("Render Result: " + image.render());
        publisher.notifyObservers("FILTER", "Filters applied to " + photoName);
    }

    // Builder: export the real files of the gallery
    public void exportAlbum(String albumName, String format, boolean metadata, boolean watermark) {
        try {
            AlbumExportConfig config = new AlbumExportConfig.Builder(albumName)
                    .setExportFormat(format)
                    .setIncludeMetadata(metadata)
                    .setApplyWatermark(watermark)
                    .setFiles(mediaList)
                    .build();

            System.out.println(config);
            publisher.notifyObservers("EXPORT", "Album '" + albumName + "' exported (" + config.getFileCount() + " files)");
        } catch (IllegalStateException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    public void printActivityLog() {
        logListener.printLog();
    }

    private MediaFile findByName(String name) {
        for (MediaFile media : mediaList) {
            if (media.getName().equals(name)) {
                return media;
            }
        }
        return null;
    }
}