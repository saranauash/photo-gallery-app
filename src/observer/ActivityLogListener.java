package observer;

import java.util.ArrayList;
import java.util.List;

// Saves all events in a list so we can print the history at the end
public class ActivityLogListener implements GalleryObserver {
    private List<String> log = new ArrayList<>();

    @Override
    public void onGalleryChanged(String eventType, String message) {
        log.add(eventType + ": " + message);
    }

    public void printLog() {
        System.out.println("Activity log (" + log.size() + " events):");
        for (int i = 0; i < log.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + log.get(i));
        }
    }
}