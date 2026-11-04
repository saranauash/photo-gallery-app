package decorator;

// Concrete decorator applying a Sepia filter at runtime
public class SepiaDecorator extends ImageDecorator {
    public SepiaDecorator(Image image) {
        super(image);
    }

    @Override
    public String render() {
        return super.render() + " + [Filter: Sepia]";
    }
}