import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PinkPantherPicksDiamonds {

    private static final Logger LOGGER = Logger.getLogger(CollectDiamondProcess.class.getName());

    public static void main(String[] args) {

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
        List<Double> resultList = new ArrayList<>(100);
        List<Integer> highestScoreList = new ArrayList<>(100);
        List<int[]> firstFiveGenerationGene = new ArrayList<>(5);
        List<int[]> lastFiveGenerationGene = new ArrayList<>(5);
        while(generation <= 500) {


            /**
             * If the algorithm need to be running in parallel environment, call the method collectDiamondParallel().
             * If not, call the method collectDiamondParallel().
             */
            try {
                cdp.collectDiamondParallel(ppList);
            }  catch(InterruptedException e) {
                e.printStackTrace();
            }

            if(generation <= 5) firstFiveGenerationGene.add(ppList.get(0).getGenre());
            if(generation > 495) lastFiveGenerationGene.add(ppList.get(0).getGenre());

            //cdp.collectDiamond(ppList);

            highestScoreList.add(ppList.get(0).getScore());

            double averageScore = Average.getAverage(ppList);
            resultList.add(averageScore);

            LOGGER.log(Level.INFO, "The " + generation + "th generation: the average score is " + averageScore);
            List<PinkPanther> selectionList = EvolutionProcess.selection(ppList);
            ppList = EvolutionProcess.evolution(selectionList);
            generation++;
        }

        try {
            FileOutputStream fis = new FileOutputStream("./src/generationResult.csv");
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

        try {
            FileOutputStream fis = new FileOutputStream("./src/highestScore.csv");
            OutputStreamWriter isr = new OutputStreamWriter(fis);
            BufferedWriter bw = new BufferedWriter(isr);
            for (int j = 0; j < highestScoreList.size(); j++) {
                String content =  j + "," + (Integer) highestScoreList.get(j) + "\n";
                bw.write(content);
                bw.flush();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fis = new FileOutputStream("./src/geneCode.txt");
            OutputStreamWriter isr = new OutputStreamWriter(fis);
            BufferedWriter bw = new BufferedWriter(isr);
            for (int j = 0; j < firstFiveGenerationGene.size(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append("Genre Code: ");
                for(int i : firstFiveGenerationGene.get(j)) {
                    sb.append(i).append(" ");
                }
                sb.append("\n");
                bw.write(sb.toString());
                bw.flush();
            }
            bw.write("\n");
            bw.flush();
            for (int j = 0; j < lastFiveGenerationGene.size(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append("Genre Code: ");
                for(int i : firstFiveGenerationGene.get(j)) {
                    sb.append(i).append(" ");
                }
                sb.append("\n");
                bw.write(sb.toString());
                bw.flush();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
