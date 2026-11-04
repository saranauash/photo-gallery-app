package factory;

public class VideoMedia implements MediaFile {
    private String name;

    public VideoMedia(String name) {
        this.name = name;
    }

    @Override
    public void open() {
        System.out.println("Playing video preview: " + name);
    }
}