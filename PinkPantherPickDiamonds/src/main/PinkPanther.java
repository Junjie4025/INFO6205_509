
import java.util.Random;

public class PinkPanther {
    private int[] genre;
    private Integer score;
    private int pass;

    public PinkPanther(){
        genre = new int[500];
        score = 0;
        pass = 0;

        Random rand = new Random();
        for(int i = 0; i < genre.length; i++) {
            genre[i] = rand.nextInt(4);
        }
    }


    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public Integer getScore(){
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public int[] getGenre() {
        return this.genre;
    }


}
