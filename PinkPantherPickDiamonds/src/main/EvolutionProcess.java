import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvolutionProcess {

    public static final int SUPERIOR = 80;
    public static final int TOTALNUMBER = 200;
    public static final int INFERIOR = 20;
    public static final int SELECTIONNUMBER = 100;


    private static final Logger LOGGER = Logger.getLogger(EvolutionProcess.class.getName());

    /*
    * The method accept list with 200 element and return a list with 100 element.
    *
    * */
    public static List<PinkPanther> selection(List<PinkPanther> list) throws IllegalArgumentException {

        if(list.size() != TOTALNUMBER) {
            //LOGGER.log(Level.WARNING, "The input size is wrong when calling EvolutionProcess.selection() method!");
            throw new IllegalArgumentException("The input size is not correct!");
        }


        List<PinkPanther> result = new ArrayList<>(SUPERIOR + INFERIOR);

        PriorityQueue<PinkPanther> pq = new PriorityQueue<>((a, b) -> (b.getScore() - a.getScore()));

        for(int i = 0; i < list.size(); i++) {
            pq.offer(list.get(i));
        }

        //First get first 80 candidate with highest scores
        int number = SUPERIOR;
        while(number > 0) {
            result.add(pq.poll());
            number--;
        }
        //LOGGER.log(Level.INFO, "80 pink panthers with highest scores have been selected!");

        List<PinkPanther> temp = new ArrayList<>(TOTALNUMBER - SUPERIOR);
        while(!pq.isEmpty()) {
            temp.add(pq.poll());
        }

        //Then randomly select 20 candidate from remaining candidate
        Random rand = new Random();
        for(int i = 0; i < INFERIOR; i++) {
            int index = rand.nextInt(temp.size());
            result.add(temp.remove(index));
        }
        //LOGGER.log(Level.INFO, "20 remaining pink panthers have been selected RANDOMLY!");
        //LOGGER.log(Level.INFO, "All 100 pink panthers have been selected from original list!");
        //LOGGER.log(Level.INFO, "Selection process completed!");

        return result;
    }

    public static List<PinkPanther> evolution(List<PinkPanther> list) throws IllegalArgumentException {

        if(list.size() != SELECTIONNUMBER) {
            //LOGGER.log(Level.WARNING, "The input size is wrong when calling EvolutionProcess.evolution() method!");
            throw new IllegalArgumentException("The input size is not correct!");
        }

        List<PinkPanther> result = new ArrayList<>(TOTALNUMBER);
        Random rand = new Random();

        for(int i = 0; i < list.size(); i = i + 2) {

            int[] pp1Genre = list.get(i).getGenre();
            int[] pp2Genre = list.get(i + 1).getGenre();
            PinkPanther newP1 = new PinkPanther();
            PinkPanther newP2 = new PinkPanther();

            for(int j = 0; j < 500; j++) {

                //crossover -- exchange genres between 2 pink panther when index % 3 == 0
                if(j % 3 != 0) {
                    newP1.getGenre()[j] = pp1Genre[j];
                    newP2.getGenre()[j] = pp2Genre[j];
                }
                else {
                    newP1.getGenre()[j] = pp2Genre[j];
                    newP2.getGenre()[j] = pp1Genre[j];
                }

                //mutation -- 1% possibility to change 1 genre in pink panther
                int chance = rand.nextInt(100);
                if(chance <= 1) {
                    //LOGGER.log(Level.INFO, "Mutation happened at " + j + "th pink panther in the list");
                    int index = rand.nextInt(500);
                    int value = rand.nextInt(4);
                    if(chance == 0) {
                        newP1.getGenre()[index] = value;
                    }
                    else {
                        newP2.getGenre()[index] = value;
                    }
                }
            }

            result.add(list.get(i));
            result.add(list.get(i + 1));
            result.add(newP1);
            result.add(newP2);
        }
        //LOGGER.log(Level.INFO, "New 100 pink panthers have been generated successfully! And totally 200 pink panthers put into the list");
        //LOGGER.log(Level.INFO, "Evolution process completed!");
        return result;
    }

}
