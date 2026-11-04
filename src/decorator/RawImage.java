package decorator;

// Concrete component representing an unprocessed photo
public class RawImage implements Image {
    private String filename;

    public RawImage(String filename) {
        this.filename = filename;
    }

    @Override
    public String render() {
        return "Photo: " + filename;
    }
}