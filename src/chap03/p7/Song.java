package chap03.p7;

abstract class Song {

    private String title;
    private int playTime;
    private String artist;

    public Song(String title, int playTime, String artist) {
        this.title = title;
        this.playTime = playTime;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayTime() {
        return playTime;
    }

    public String getArtist() {
        return artist;
    }

    public void displayInfo() {
        System.out.println("\"" + this.getTitle() + ", " + this.getPlayTime() + "분, " + this.getArtist());
    }
}
