import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputDevice inputDevice = new InputDevice(System.in);
        OutputDevice outputDevice = new OutputDevice(System.out);
        //InputDevice inputDevice = new InputDevice(new FileInputStream("src\\test.txt"));
        //OutputDevice outputDevice = new OutputDevice(new FileOutputStream("src\\OUT.txt"));

        outputDevice.writeMessage(args);
        Application mainApp = new Application(inputDevice, outputDevice, args[0]);
        mainApp.run();
    }
}
