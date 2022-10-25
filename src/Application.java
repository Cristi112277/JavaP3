package src;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class Application {
    public InputDevice inputDevice;
    public OutputDevice outputDevice;
    public Application(InputDevice inputDevice,OutputDevice outputDevice){
        this.inputDevice = inputDevice;
        this.outputDevice = outputDevice;
    }
    public void run(){
        outputDevice.writeMessage("Application  started");
        outputDevice.writeMessage("Lucky Numbers: " + inputDevice.nextInt() + " " + inputDevice.nextInt());
    }

    public ArrayList<Integer> SortNumbers(ArrayList<Integer> list){
        Collections.sort(list);
        return list;
    }

}
