package factory;

import java.time.LocalDate;

// Creator class of the Factory Method pattern
public abstract class MediaFactory {
    public abstract MediaFile createMedia(String name, LocalDate date, int rating);
}