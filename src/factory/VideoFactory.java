package factory;

public class VideoFactory extends MediaFactory {
    @Override
    public MediaFile createMedia(String name) {
        return new VideoMedia(name);
    }
}