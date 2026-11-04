package strategy;

import factory.MediaFile;

import java.util.List;

// Oldest files first
public class SortByDateStrategy implements SortStrategy {
    @Override
    public void sort(List<MediaFile> mediaList) {
        mediaList.sort((a, b) -> a.getDate().compareTo(b.getDate()));
    }

    @Override
    public String getName() {
        return "Date (oldest first)";
    }
}