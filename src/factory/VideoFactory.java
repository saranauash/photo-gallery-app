package factory;

import java.time.LocalDate;

public class VideoFactory extends MediaFactory {
    @Override
    public MediaFile createMedia(String name, LocalDate date, int rating) {
        return new VideoMedia(name, date, rating);
    }
}