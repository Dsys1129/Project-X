package chap03.p7;

public class AnimalSong extends Song {

    private String targetAnimal;

    public AnimalSong(String title, int playTime, String artist, String targetAnimal) {
        super(title, playTime, artist);
        this.targetAnimal = targetAnimal;
    }

    @Override
    public void displayInfo() {
        System.out.print("\"" + this.getTitle() + ", " + this.getPlayTime() + "분, " + this.getArtist() + ", " + this.targetAnimal + "\"");
    }

    public String getTargetAnimal() {
        return targetAnimal;
    }
}
