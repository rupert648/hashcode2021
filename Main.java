

// Working program using BufferedReader
import java.io.IOException;


/// overall - time of simulation
/// car
/// roads
/// intersections - series roads entering and exiting

public class Main {
    public static void main(String[] args) throws IOException {

        InputParser myparser = new InputParser();
        Simulation sim = myparser.parse();

        for (road aRoad: sim.roads) {
            System.out.println(aRoad.name);
        }

        System.out.println();
        sim.run();
        
    }

}