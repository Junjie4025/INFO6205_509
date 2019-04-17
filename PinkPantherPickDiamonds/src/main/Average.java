import java.util.List;

public class Average {

    public static double getAverage(List<PinkPanther> list) throws IllegalArgumentException{

        if(list == null || list.size() <= 0)
            throw new IllegalArgumentException("The input is not correct!");

        double average = 0;
        for(PinkPanther p : list) {

            average += p.getScore();

        }
        return average / list.size();
    }


}

