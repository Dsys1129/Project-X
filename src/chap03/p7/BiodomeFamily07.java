package chap03.p7;

import java.util.List;

public class BiodomeFamily07 {
    public static void main(String[] args) {

        MusicLibrary musicLibrary = new MusicLibrary();
        Player player = new Player();
        Song song1 = new AnimalSong("초원을 그리며", 2, "레이나", "사슴");
        Song song2 = new AnimalSong("영웅 호테", 1, "돈키", "당나귀");
        Song song3 = new AnimalSong("과자를 줄게", 3, "제롬", "코끼리");
        Song song4 = new ManagerSong("화양연화", 2, "장양림", "재즈");
        Song song5 = new ManagerSong("시간의 수평선", 4, "하윤", "팝");

        musicLibrary.addSong(song1);
        musicLibrary.addSong(song2);
        musicLibrary.addSong(song3);
        musicLibrary.addSong(song4);
        musicLibrary.addSong(song5);

        System.out.println();

        List<Song> searchedManagerSongs = musicLibrary.searchManagerSongs();
        player.setSong(searchedManagerSongs.get(0));
        player.play();
        player.setVolume(30);
        player.setVolume(5);
        List<Song> searchedAnimalSongs = musicLibrary.searchAnimalSongsByTargetAnimal("당나귀");
        player.setSong(searchedAnimalSongs.get(0));
        player.play();

        musicLibrary.removeSong("시간의 수평선");

        System.out.println();
        System.out.println("============== Bonus ==============");
        List<Song> randomSongs = musicLibrary.randomShuffle();

        System.out.print("원본 : ");
        for (Song song : musicLibrary.getSongs()) {
            System.out.print(song.getTitle() + ", ");
        }
        System.out.println();
        System.out.print("랜덤 : ");
        for (Song song : randomSongs) {
            System.out.print(song.getTitle() + ", ");
        }
    }
}
