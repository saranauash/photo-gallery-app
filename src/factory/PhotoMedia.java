package factory;

public class PhotoMedia implements MediaFile {
    private String name;

    public PhotoMedia(String name) {
        this.name = name;
    }

    @Override
    public void open() {
        System.out.println("Displaying photo: " + name);
    }
}