package decorator;

// Base abstract decorator class wrapping an Image instance
public abstract class ImageDecorator implements Image {
    protected Image wrappedImage;

    public ImageDecorator(Image image) {
        this.wrappedImage = image;
    }

    @Override
    public String render() {
        return wrappedImage.render();
    }
}