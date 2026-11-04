package decorator;

// Concrete decorator applying a Grayscale filter at runtime
public class GrayscaleDecorator extends ImageDecorator {
    public GrayscaleDecorator(Image image) {
        super(image);
    }

    @Override
    public String render() {
        return super.render() + " + [Filter: Grayscale]";
    }
}