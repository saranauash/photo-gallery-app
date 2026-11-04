package strategy;

import java.util.List;

// Common strategy interface for gallery sorting algorithms
public interface SortStrategy {
    void sort(List<String> photoList);
}