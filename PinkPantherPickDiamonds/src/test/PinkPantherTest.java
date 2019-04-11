import org.junit.Assert;
import org.junit.Test;

public class PinkPantherTest {

    @Test
    public void pinkPantherGenreTest() {

        PinkPanther p = new PinkPanther();
        int[] genre = p.getGenre();
        Assert.assertTrue(genre.length == 500);

        for(int i = 0; i < genre.length; i++){
            boolean content = genre[i] == 0 || genre[i] == 1 || genre[i] == 2 || genre[i] == 3;
            Assert.assertTrue(content == true);
        }
    }





}