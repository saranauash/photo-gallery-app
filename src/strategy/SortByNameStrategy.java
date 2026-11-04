package strategy;

import factory.MediaFile;

import java.util.List;

public class SortByNameStrategy implements SortStrategy {
    @Override
    public void sort(List<MediaFile> mediaList) {
        mediaList.sort((a, b) -> a.getName().toLowerCase().compareTo(b.getName().toLowerCase()));
    }

    @Override
    public String getName() {
        return "Name (A-Z)";
    }
}