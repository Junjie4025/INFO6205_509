
import java.util.Random;


public class Map {
    private char[][] map;
    private final int ROW = 50;
    private final int COL = 50;

    public Map(){
        this.map = new char[ROW][COL];
    }

    //init the map and set elements
    public void initMap(){
        Random random = new Random();
        for(int i = 0; i < ROW; i++){
            for(int j= 0; j < COL; j++){
                int n = rand.nextInt(100);
                if(n >= 0 && n < 25){
                    //25% Diamonds
                    map[i][j] = 'D';
                }else if(n >= 25 && n < 45){
                    //20% Caps
                    map[i][j] = 'C';
                }else if(n >= 45 && n < 50){
                    //5% Passes
                    map[i][j] = 'P';
                }else if(n >= 50 && n < 60){
                    //10% Walls
                    map[i][j] = 'W';
                }else{
                    //40% Blank
                    map[i][j] = 'B';
                }

            }
        }

    }

    //print the map
    public void getMap(){
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                System.out.println(map[i][j] + " ")
            }
            System.out.println();
        }
    }
}
