package strategy;

import java.util.List;

// Concrete strategy: sorts files chronologically by date
public class SortByDateStrategy implements SortStrategy {
    @Override
    public void sort(List<String> photoList) {
        photoList.sort(String::compareTo);
        System.out.println("Sorted gallery by Date.");
    }
}