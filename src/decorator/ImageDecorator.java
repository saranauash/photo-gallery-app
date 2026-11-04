package decorator;

// Base decorator: holds the wrapped image and passes render() to it
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