import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CollectDiamondProcess {

    private char[][] map;
    private static final Logger LOGGER = Logger.getLogger(CollectDiamondProcess.class.getName());

    public CollectDiamondProcess(char[][] map) {
        this.map = map;
    }

    public void collectDiamond(PinkPanther p) {

        //First clear previous score
        p.setScore(0);

        int currentROW = 25;
        int currentCOL = 25;
        int[] genre = p.getGenre();
        route(p,currentROW,currentCOL);

        int i = 0;
        while(i < genre.length){
            //LOGGER.log(Level.INFO, "pink panther now is at row: "+ currentROW + " col: " + currentCOL + " !");
            //LOGGER.log(Level.INFO, "genre is got as "+ genre[i] + "!");

            if(genre[i] == 0){
                currentROW--;
            }else if(genre[i] == 1){
                currentCOL--;
            }else if(genre[i] == 2){
                currentROW++;
            }else if(genre[i] == 3){
                currentCOL++;
            }

            if( currentROW < 0 || currentROW == 50 || currentCOL < 0 || currentCOL == 50){
                LOGGER.log(Level.WARNING, "pink panther is out of map now !");
                i++;
            }else{
                route(p,currentROW,currentCOL);
                i++;
            }
            LOGGER.log(Level.INFO, "pink panther's location changed to row: "+ currentROW + " col: " + currentCOL + " !");
        }
        LOGGER.log(Level.INFO, "pink panther's score is: "+ p.getScore());
    }

    private void route(PinkPanther p,int row, int col){
        LOGGER.log(Level.INFO, "pink panther has : "+ p.getPass() + " and its score is : " + p.getScore() + " now !");

        char element = map[row][col];
        int score = p.getScore();
        int pass = p.getPass();

        System.out.println("element in map is " + element);
        System.out.println("current pass is " + pass + " score is " + score);

        switch (element){
                case 'D' :
                    score += 5;
                    p.setScore(score);
                    break;
                case 'C' :
                    if(pass != 0){
                        p.setPass(pass - 1);
                    }else{
                        score -= 3;
                        p.setScore(score);
                    }
                    break;
                case 'P':
                    pass++;
                    p.setPass(pass);
                    break;
                case 'W':
                    break;
                case 'B':
                    break;
            }
            LOGGER.log(Level.INFO, "pink panther's passes updated to : "+ p.getPass() + " and its score now is : " + p.getScore() + " !");

    }

    public static void main(String[] args){
        Map m = new Map();
        m.initMap();
        m.printMap();
        CollectDiamondProcess cdp = new CollectDiamondProcess(m.getMap());
        PinkPanther p = new PinkPanther();
        p.printGenre();
        cdp.collectDiamond(p);
    }

}
