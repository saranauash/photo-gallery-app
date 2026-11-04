package decorator;

public class BlurDecorator extends ImageDecorator {
    public BlurDecorator(Image image) {
        super(image);
    }

    @Override
    public String render() {
        return super.render() + " + [Filter: Blur]";
    }
}