import java.util.ArrayList;
import java.util.Random;

public class Board {
    ArrayList<String> places = new ArrayList<>();
    public Board() {
        for (int i=0; i<40; i++) {
            places.add("-1");
        }
    }

    public int throwDice() {
        Random rand = new Random();
        return rand.nextInt(2, 13); // The bound is excluded
    }
}
