package factory;

public class PhotoFactory extends MediaFactory {
    @Override
    public MediaFile createMedia(String name) {
        return new PhotoMedia(name);
    }
}
