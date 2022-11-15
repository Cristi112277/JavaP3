import fruits.Apple;
import fruits.Banana;
import fruits.Fruit;
import fruits.Mango;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class InputDevice {
    InputStream inputStream;
    Scanner scanner;
    public InputDevice(InputStream inputStream) {
        this.inputStream = inputStream;
        scanner = new Scanner(inputStream);
    }

    public String getType(){
        return "random";
    }

    public int[] getNumbers(int n){
        int[] numbers = new int[n];
        for(int idx = 0; idx < n;idx++){
            numbers[idx] = this.nextInt();
        }

        return numbers;
    }

    public String getLine() {
        try{
            return scanner.nextLine();
        }
        catch(Exception exception){
            System.out.println("Exception: " + exception);
            return "";
        }

    }

    public int nextInt() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public Fruit[] readFruit(){
        return new Fruit[]{new Banana(15, 3, 6), new Banana(25, 19, 2),
        new Apple(11, 4, 8, Fruit.Color.RED), new Mango(20, 4, 4, Fruit.Color.GREEN)};
    }
}
