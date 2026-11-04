package factory;

import java.time.LocalDate;

public class PhotoMedia extends BaseMedia {

    public PhotoMedia(String name, LocalDate date, int rating) {
        super(name, date, rating);
    }

    @Override
    public void open() {
        System.out.println("Displaying photo: " + name);
    }

    @Override
    public String getType() {
        return "Photo";
    }
}