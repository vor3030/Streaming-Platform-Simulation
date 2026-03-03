package content;

import java.util.*;

public class ContentLibrary {
    private final List<Media> mediaList = new ArrayList<>();

    public ContentLibrary(){
        mediaList.add(new Movie(
            "Inception", "Sci-Fi", 8.8, 2010,
            "A thief who steals corporate secrets through dream-sharing tech.",
            148,
            "Leonardo DiCaprio, Joseph Gordon-Levitt",
            "Christopher Nolan"
        ));

        mediaList.add(new Movie(
                "The Matrix", "Action/Sci-Fi", 8.7, 1999,
                "A hacker discovers the shocking truth about reality.",
                136,
                "Keanu Reeves, Laurence Fishburne",
                "The Wachowskis"
        ));
    }

    public List<Media> getAllMedia() {
        return mediaList;
    }

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public Media findByTitle(String title) {
        for (Media m : mediaList) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
}
