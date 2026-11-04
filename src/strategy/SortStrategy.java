package strategy;

import factory.MediaFile;

import java.util.List;

// Strategy interface for sorting the gallery
public interface SortStrategy {
    void sort(List<MediaFile> mediaList);

    String getName();
}