package decorator;

public class SepiaDecorator extends ImageDecorator {
    public SepiaDecorator(Image image) {
        super(image);
    }

    @Override
    public String render() {
        return super.render() + " + [Filter: Sepia]";
    }
}