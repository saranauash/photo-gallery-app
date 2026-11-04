package strategy;

import factory.MediaFile;

import java.util.List;

// Best rated files first
public class SortByRatingStrategy implements SortStrategy {
    @Override
    public void sort(List<MediaFile> mediaList) {
        mediaList.sort((a, b) -> b.getRating() - a.getRating());
    }

    @Override
    public String getName() {
        return "Rating (highest first)";
    }
}