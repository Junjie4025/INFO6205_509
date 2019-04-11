import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    @Test
    public void mapSizeTest(){
        Map m = new Map();
        Assert.assertTrue(m.getCOL() == 50);
        Assert.assertTrue(m.getROW() == 50);
    }

    @Test
    public void mapContentTest(){
        Map m = new Map();
        m.initMap();
        char[][] map = m.getMap();
        for(int i =0; i < m.getROW(); i++){
            for(int j = 0; j < m.getCOL(); j++){
                boolean content = map[i][j] == 'D' || map[i][j] == 'C' || map[i][j] == 'P' || map[i][j] == 'W' || map[i][j] == 'B';
                Assert.assertTrue(content == true);
            }
        }
    }

}