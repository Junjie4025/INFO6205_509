import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

    public void collectDiamond(List<PinkPanther> list) {

        for(PinkPanther p : list) {
            collectDiamond(p);
        }

    }

    private void route(PinkPanther p,int row, int col){
        LOGGER.log(Level.INFO, "pink panther has : "+ p.getPass() + " and its score is : " + p.getScore() + " now !");

        if(row < 0 || row >= 50 || col < 0 || col >= 50) return;

        char element = map[row][col];
        int score = p.getScore();
        int pass = p.getPass();

        //System.out.println("element in map is " + element);
        //System.out.println("current pass is " + pass + " score is " + score);

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

        //Init 200 pink panthers with random gene
        List<PinkPanther> ppList = new ArrayList<>(200);
        for(int i = 0; i < 200; i++) {
            ppList.add(new PinkPanther());
        }

        int generation = 1;
        List<Double> resultList = new ArrayList<>(1000);
        while(generation++ <= 1000) {

            cdp.collectDiamond(ppList);
            double averageScore = Average.getAverage(ppList);
            resultList.add(averageScore);

            LOGGER.log(Level.INFO, "The " + generation + "th generation: the average score is " + averageScore);
            List<PinkPanther> selectionList = EvolutionProcess.selection(ppList);
            ppList = EvolutionProcess.evolution(selectionList);

        }

        try {
            FileOutputStream fis = new FileOutputStream("./src/result.csv");
            OutputStreamWriter isr = new OutputStreamWriter(fis);
            BufferedWriter bw = new BufferedWriter(isr);
            for (int j = 0; j < resultList.size(); j++) {
                String content =  j + "," + (double) resultList.get(j) + "\n";
                bw.write(content);
                bw.flush();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
