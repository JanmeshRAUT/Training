package SpotifyPremium;

import java.util.LinkedList;

public class Music {

    private LinkedList<String> playlist = new LinkedList<>();
    private LinkedList<String> history = new LinkedList<>();
    private String currentSong = null;

    public void playSong(String song) {
        if (playlist.contains(song)) {

            if (currentSong != null) {
                history.add(currentSong);
            }

            currentSong = song;
            System.out.println("Now Playing: " + song);

        } else {
            System.out.println("Song not found in the playlist.");
        }
    }

    public void addSongAtLast(String song) {
        playlist.addLast(song);
        System.out.println(song + " added to the end of playlist.");
    }

    public void addSongAtFirst(String song) {
        playlist.addFirst(song);
        System.out.println(song + " added to the beginning of playlist.");
    }

    public void removeSongFromLast() {
        if (playlist.isEmpty()) {
            System.out.println("No songs available to remove.");
        } else {
            System.out.println("Removed: " + playlist.removeLast());
        }
    }

    public void removeSongFromFirst() {
        if (playlist.isEmpty()) {
            System.out.println("No songs available to remove.");
        } else {
            System.out.println("Removed: " + playlist.removeFirst());
        }
    }

    public void displaySongs() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("\nPlaylist:");
            for (String song : playlist) {
                System.out.println(song);
            }
        }
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No songs played yet.");
        } else {
            System.out.println("\nSong History:");
            for (String song : history) {
                System.out.println(song);
            }
        }
    }

    public void upcomingSong() {

        if (currentSong == null) {
            System.out.println("No song is currently playing.");
            return;
        }

        int currentIndex = playlist.indexOf(currentSong);

        if (currentIndex == -1) {
            System.out.println("Current song is not in the playlist.");
            return;
        }

        System.out.println("\nCurrent Song: " + currentSong);
        System.out.println("Upcoming Songs:");

        int count = 1;

        for (int i = currentIndex + 1; i < playlist.size(); i++) {
            System.out.println(count + ". " + playlist.get(i));
            count++;
        }

        if (count == 1) {
            System.out.println("No upcoming songs.");
        }
    }

    public void searchSong(String song) {
        if (playlist.contains(song)) {
            System.out.println("Song found: " + song);
        } else {
            System.out.println("Song not found.");
        }
    }

    public void clearHistory() {
        history.clear();
        System.out.println("History cleared.");
    }

    public void currentSong() {
        if (currentSong == null) {
            System.out.println("No song is currently playing.");
        } else {
            System.out.println("Current Song: " + currentSong);
        }
    }
}