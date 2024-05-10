package chap03.p7;

public class Player {

    private Song song;
    private int volume;

    public Player() {
        this.volume = 1;
    }

    public void play() {
        if (song instanceof AnimalSong && volume > 5) {
            System.out.println("동물 노래의 볼륨이 5 초과이므로 5로 줄입니다.");
            setVolume(5);
        }
        song.displayInfo();
        System.out.println(" 재생합니다");
    }

    public void setVolume(int volume) {
        if (this.song instanceof AnimalSong) {
            if (volume < 0 || volume > 5) {
                System.out.println("동물 음악의 볼륨은 0~5입니다.");
                return;
            }
        }
        if (this.song instanceof ManagerSong) {
            if (volume <0 || volume > 50) {
                System.out.println("사람 음악의 볼륨은 0~50입니다.");
                return;
            }
        }
        System.out.println("볼륨을 " + volume + "으로 설정합니다.");
        this.volume = volume;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
