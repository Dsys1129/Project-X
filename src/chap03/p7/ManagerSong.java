package chap03.p7;

public class ManagerSong extends Song{

    private String genre;

    public ManagerSong(String title, int playTime, String artist, String genre) {
        super(title, playTime, artist);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.print("\"" + this.getTitle() + ", " + this.getPlayTime() + "분, " + this.getArtist() + ", " + this.genre + "\"");
    }
}
