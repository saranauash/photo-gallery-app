package factory;

import java.time.LocalDate;

public class VideoMedia extends BaseMedia {

    public VideoMedia(String name, LocalDate date, int rating) {
        super(name, date, rating);
    }

    @Override
    public void open() {
        System.out.println("Playing video preview: " + name);
    }

    @Override
    public String getType() {
        return "Video";
    }
}