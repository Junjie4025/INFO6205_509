import java.util.*;

public class EvolutionProcess {

    public static final int SUPERIOR = 80;
    public static final int TOTALNUMBER = 200;
    public static final int INFERIOR = 20;

    /*
    * The method accept list with 200 element and return a list with 100 element.
    *
    * */
    public static List<PinkPanther> evolution(List<PinkPanther> list) throws IllegalArgumentException {

        if(list.size() != TOTALNUMBER)
            throw new IllegalArgumentException("The input size is not correct!");


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

        return result;
    }

}
