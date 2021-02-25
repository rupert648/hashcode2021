import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;

public class InputParser {
    
    public Simulation parse() throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        StringTokenizer st
            = new StringTokenizer(br.readLine());
        int duration = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        // street description
        ArrayList<road> roads = new ArrayList<road>();
        ArrayList<car> cars = new ArrayList<car>();
        intersection[] intersections = new intersection[I]; 
        
        while (S-- > 0) {
            int B, E, L;

            StringTokenizer x = new StringTokenizer(br.readLine());

            B = Integer.parseInt(x.nextToken());
            E = Integer.parseInt(x.nextToken());
            // TODO input sanitisation

            String streetname = x.nextToken();
            L = Integer.parseInt(x.nextToken());

            roads.add(new road(streetname, B, E, L));
        }

        while (V-- > 0) {
            int P;

            StringTokenizer x = new StringTokenizer(br.readLine());
            P = Integer.parseInt(x.nextToken());
            ArrayList<String> streetnames = new ArrayList<String>();
            while (P-- > 0) {
                String streetname = x.nextToken();
                streetnames.add(streetname);
            }

            cars.add(new car(0, streetnames));
        }

        // create intersections
        // iterate through array of intersections, and array of roads, and check if any are the exit/entrance roads
        for (int i = 0; i < intersections.length; i++) {
            // init intersection
            intersections[i] = new intersection(i);

            for (int j = 0; j < roads.size(); j++) {
                road current = roads.get(j);
                if (current.start == i) {
                    intersections[i].outGoing.add(current);
                } else if (current.start == j) {
                    intersections[i].incoming.add(current);
                }
            }

            intersections[i].initTrafficLights();
            intersections[i].initSchedule();

        }
        


        // iterate through cars and roads and set path to roads
        for (int i = 0; i < cars.size(); i++) {
            // iterate through paths
            for (int j = 0; j < cars.get(i).path.size(); j++) {
                // iterate through roads and find road with same name
                for (int k = 0; k < roads.size(); k++) {
                    if (roads.get(k).name.equals(cars.get(i).path.get(j))) {
                        cars.get(i).roadPath.add(roads.get(k));
                    }
                }
            }

             cars.get(i).currentlyOn = cars.get(i).roadPath.get(0);
        }

        return new Simulation(intersections, cars, roads, duration);
    }
}
