import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EvolutionProcessTest {


    @Test
    public void selectionTest() {

        List<PinkPanther> list = new ArrayList<>(200);
        for(int i = 0; i < 200; i++) {
            list.add(new PinkPanther());
        }

        List<PinkPanther> testList = EvolutionProcess.selection(list);
        Assert.assertTrue(testList.size() == 100);



    }

    @Test
    public void evolutionTest() {

        List<PinkPanther> list = new ArrayList<>(100);
        for(int i = 0; i < 100; i++) {
            list.add(new PinkPanther());
        }

        List<PinkPanther> testList = EvolutionProcess.evolution(list);

        Assert.assertTrue(testList.size() == 200);

    }
}