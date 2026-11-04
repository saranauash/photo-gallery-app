package factory;

import java.time.LocalDate;

// Shared fields and getters for photos and videos
public abstract class BaseMedia implements MediaFile {
    protected String name;
    protected LocalDate date;
    protected int rating;

    public BaseMedia(String name, LocalDate date, int rating) {
        this.name = name;
        this.date = date;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return getType() + " '" + name + "' (date: " + date + ", rating: " + rating + ")";
    }
}