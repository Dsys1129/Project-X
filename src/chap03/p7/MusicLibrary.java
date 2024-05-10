package chap03.p7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicLibrary {

    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        if (containsSong(song.getTitle())) {
            throw new IllegalArgumentException("해당하는 음악이 없습니다.");
        }
        songs.add(song);
        System.out.print("새로운 노래 ");
        song.displayInfo();
        System.out.println(" 추가되었습니다.");
    }

    public void removeSong(String songTitle) {
        if (!containsSong(songTitle)) {
            throw new IllegalArgumentException("해당하는 음악이 없습니다.");
        }

        for (Song song : songs) {
            if (song.getTitle().equals(songTitle)) {
                System.out.print("노래 ");
                song.displayInfo();
                System.out.print("삭제되었습니다.");
                return;
            }
        }
    }

    public List<Song> searchSongByTitle(String title) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                result.add(song);
            }
        }

        if (result.size() == 0) {
            throw new IllegalArgumentException("해당하는 음악이 없습니다.");
        }
        return result;
    }

    public List<Song> searchAnimalSongsByTargetAnimal(String targetAnimal) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song instanceof AnimalSong && ((AnimalSong) song).getTargetAnimal().equals(targetAnimal)) {
                result.add(song);
            }
        }
        return result;
    }

    public List<Song> searchManagerSongs() {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song instanceof ManagerSong) {
                result.add(song);
            }
        }

        if (result.size() == 0) {
            throw new IllegalArgumentException("해당하는 음악이 없습니다.");
        }
        return result;
    }

    private boolean containsSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public List<Song> randomShuffle() {
        System.out.println("Bonus => Random");
        List<Song> randomSongs = new ArrayList<>(songs);
        Collections.shuffle(randomSongs);
        return randomSongs;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
