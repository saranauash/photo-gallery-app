package factory;

import java.time.LocalDate;

public class PhotoFactory extends MediaFactory {
    @Override
    public MediaFile createMedia(String name, LocalDate date, int rating) {
        return new PhotoMedia(name, date, rating);
    }
}