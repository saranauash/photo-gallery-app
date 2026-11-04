package builder;

// Complex product object configured step-by-step
public class AlbumExportConfig {
    private final String albumTitle;
    private final String exportFormat;
    private final boolean includeMetadata;
    private final boolean applyWatermark;

    private AlbumExportConfig(Builder builder) {
        this.albumTitle = builder.albumTitle;
        this.exportFormat = builder.exportFormat;
        this.includeMetadata = builder.includeMetadata;
        this.applyWatermark = builder.applyWatermark;
    }

    // Builder static inner class
    public static class Builder {
        private String albumTitle;
        private String exportFormat = "ZIP"; // Default fallback format
        private boolean includeMetadata = false;
        private boolean applyWatermark = false;

        public Builder(String albumTitle) {
            this.albumTitle = albumTitle;
        }

        public Builder setExportFormat(String exportFormat) {
            this.exportFormat = exportFormat;
            return this;
        }

        public Builder setIncludeMetadata(boolean includeMetadata) {
            this.includeMetadata = includeMetadata;
            return this;
        }

        public Builder setApplyWatermark(boolean applyWatermark) {
            this.applyWatermark = applyWatermark;
            return this;
        }

        public AlbumExportConfig build() {
            return new AlbumExportConfig(this);
        }
    }

    @Override
    public String toString() {
        return "Exporting Album '" + albumTitle + "' as " + exportFormat +
                " [Metadata: " + includeMetadata + ", Watermark: " + applyWatermark + "]";
    }
}