package facade;

import java.util.ArrayList;
import java.util.List;

import factory.*;
import observer.*;
import decorator.*;
import strategy.*;
import builder.*;

public class GalleryFacade {
    private List<String> photos = new ArrayList<>();
    private GalleryPublisher publisher = new GalleryPublisher();
    private SortStrategy sortStrategy;

    public GalleryFacade() {
        // Подключаем слушателей (Observer)
        publisher.addObserver(new UIStatusNotification());
        publisher.addObserver(new ImageCounterListener());

        // Устанавливаем стратегию по умолчанию
        this.sortStrategy = new SortByDateStrategy();
    }

    public void addPhoto(String name, String type) {
        MediaFactory factory;
        if (type.equalsIgnoreCase("video")) {
            factory = new VideoFactory();
        } else {
            factory = new PhotoFactory();
        }

        MediaFile media = factory.createMedia(name);
        media.open();

        photos.add(name);
        publisher.notifyObservers("Added new media: " + name);
    }

    public void setSortStrategy(SortStrategy strategy) {
        this.sortStrategy = strategy;
    }

    public void sortGallery() {
        sortStrategy.sort(photos);
    }

    public void applyFilterAndDisplay(String photoName) {
        Image baseImage = new RawImage(photoName);
        Image filteredImage = new GrayscaleDecorator(new SepiaDecorator(baseImage));
        System.out.println("Render Result: " + filteredImage.render());
    }

    public void exportAlbum(String albumName) {
        AlbumExportConfig config = new AlbumExportConfig.Builder(albumName)
                .setExportFormat("PDF")
                .setIncludeMetadata(true)
                .setApplyWatermark(true)
                .build();

        System.out.println(config);
    }
}