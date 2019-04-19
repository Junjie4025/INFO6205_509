import org.junit.Assert;
import org.junit.Test;

public class PinkPantherTest {

    @Test
    public void pinkPantherGenreLengthTest() {

        PinkPanther p = new PinkPanther();
        int[] genre = p.getGenre();
        Assert.assertTrue(genre.length == 500);
    }

    @Test
    public void pinkPantherGenreContentTest() {
        PinkPanther p = new PinkPanther();
        int[] genre = p.getGenre();
        for(int i = 0; i < genre.length; i++){
            boolean content = genre[i] == 0 || genre[i] == 1 || genre[i] == 2 || genre[i] == 3;
            Assert.assertTrue(content == true);
        }
    }
}