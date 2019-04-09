public class PinkPanther {
    private int[] genre;
    private Integer score;
    private int pass;

    public PinkPanther(){
        genre = new int[500];
        score = 0;
        pass = 0;
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

}
