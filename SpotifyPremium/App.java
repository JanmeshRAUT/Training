package SpotifyPremium;

public class App {

    public static void main(String[] args) {

        Music music = new Music();

        music.addSongAtLast("Song A");
        music.addSongAtLast("Song B");
        music.addSongAtFirst("Song C");
        music.addSongAtFirst("Song D");

        music.displaySongs();

        music.playSong("Song B");
        music.playSong("Song A");

        music.currentSong();

        music.displayHistory();

        music.upcomingSong();

        music.searchSong("Song C");
        music.searchSong("Song X");

        music.removeSongFromFirst();
        music.removeSongFromLast();

        music.displaySongs();

        music.clearHistory();
        music.displayHistory();
    }
}