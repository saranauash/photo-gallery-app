package strategy;

import java.util.List;

// Concrete strategy: sorts files alphabetically by name
public class SortByNameStrategy implements SortStrategy {
    @Override
    public void sort(List<String> photoList) {
        photoList.sort((a, b) -> a.toLowerCase().compareTo(b.toLowerCase()));
        System.out.println("Sorted gallery by Name.");
    }
}