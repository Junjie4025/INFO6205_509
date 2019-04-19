import org.junit.Assert;
import org.junit.Test;

public class CollectDiamondProcessTest {
    @Test
    public void collectScoreTest(){
        Map m = new Map();
        m.initMap();
        CollectDiamondProcess cdp = new CollectDiamondProcess(m.getMap());
        PinkPanther p = new PinkPanther();
        int maxScore = 0;
        for(int i = 0; i < m.getROW();i++){
            for(int j = 0;j<m.getCOL();j++){
                if(m.getMap()[i][j] == 'D'){
                    maxScore += 5;
                }
            }
        }
        cdp.collectDiamond(p);
        Assert.assertTrue(p.getScore() < maxScore);
    }

    @Test
    public void collectPassesTest(){
        Map m = new Map();
        m.initMap();
        CollectDiamondProcess cdp = new CollectDiamondProcess(m.getMap());
        PinkPanther p = new PinkPanther();
        int maxPasses = 0;
        for(int i = 0; i < m.getROW();i++){
            for(int j = 0;j<m.getCOL();j++){
                if(m.getMap()[i][j] == 'P'){
                    maxPasses += 1;
                }
            }
        }
        cdp.collectDiamond(p);
        Assert.assertTrue(p.getPass() < maxPasses);
    }
}
