package factory;

import java.time.LocalDate;

// Common interface for everything that can be stored in the gallery
public interface MediaFile {
    void open();

    String getName();

    String getType();

    LocalDate getDate();

    int getRating();
}