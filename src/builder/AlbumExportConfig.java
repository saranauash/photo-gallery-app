package builder;

import factory.MediaFile;

import java.util.ArrayList;
import java.util.List;

// Product of the Builder pattern: export settings for an album
public class AlbumExportConfig {
    private final String albumTitle;
    private final String exportFormat;
    private final boolean includeMetadata;
    private final boolean applyWatermark;
    private final List<MediaFile> files;

    private AlbumExportConfig(Builder builder) {
        this.albumTitle = builder.albumTitle;
        this.exportFormat = builder.exportFormat;
        this.includeMetadata = builder.includeMetadata;
        this.applyWatermark = builder.applyWatermark;
        this.files = builder.files;
    }

    public static class Builder {
        private String albumTitle;
        private String exportFormat = "ZIP"; // default format
        private boolean includeMetadata = false;
        private boolean applyWatermark = false;
        private List<MediaFile> files = new ArrayList<>();

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

        public Builder setFiles(List<MediaFile> files) {
            this.files = new ArrayList<>(files);
            return this;
        }

        public AlbumExportConfig build() {
            // simple validation before creating the object
            if (albumTitle == null || albumTitle.trim().isEmpty()) {
                throw new IllegalStateException("Album title can not be empty");
            }
            if (!exportFormat.equals("ZIP") && !exportFormat.equals("PDF")) {
                throw new IllegalStateException("Unsupported export format: " + exportFormat);
            }
            if (files.isEmpty()) {
                throw new IllegalStateException("Album has no files to export");
            }
            return new AlbumExportConfig(this);
        }
    }

    public int getFileCount() {
        return files.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exporting album '").append(albumTitle).append("' as ").append(exportFormat);
        sb.append(" [Metadata: ").append(includeMetadata);
        sb.append(", Watermark: ").append(applyWatermark).append("]\n");
        sb.append("Files (").append(files.size()).append("):");
        for (MediaFile file : files) {
            sb.append("\n  - ").append(file.getName());
            if (includeMetadata) {
                sb.append(" | ").append(file.getType()).append(", ")
                        .append(file.getDate()).append(", rating ").append(file.getRating());
            }
            if (applyWatermark) {
                sb.append(" [watermarked]");
            }
        }
        return sb.toString();
    }
}