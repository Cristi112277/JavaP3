package  src;
import java.util.ArrayList;
import java.util.Random;

public class InputDevice {

    public String getType() {
        return "Random";
    }
    public ArrayList<Integer> getNumbers(int N){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i<N; i++){
            numbers.add(nextInt());
        }
        return numbers;
    }
    public Integer nextInt() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}
