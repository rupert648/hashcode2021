import java.util.ArrayList;

public class Simulation {

	intersection[] intersections;
	ArrayList<car> cars;
	ArrayList<road> roads;
	int time;

    public Simulation(intersection[] intersections, ArrayList<car> cars, ArrayList<road> roads, int time) {
        this.intersections = intersections;
        this.cars = cars;
        this.roads = roads;
        this.time = time;
    }
	
    public void run() {
        for(int i = 0; i < time; ++i){

            //update traffic lights


						

            for (car c: cars){
            
                if(c.roadProgress != c.currentlyOn.length){   //not at end of road
                    c.roadProgress++;
                }
            }
			for(intersection currentIntersection: intersections) {
                // reset all lights to false
                for (boolean light: currentIntersection.trafficLights) {
                    light = false;
                }
                
                int lightSelector = (i % currentIntersection.scheduleSize) / 5;
				currentIntersection.trafficLights.set(lightSelector, true);

                car carToBeMoved = currentIntersection.incoming.get(lightSelector).waiting.remove();
                // car moved = current.waiting.remove();
                if (carToBeMoved.currentRoadNumb == carToBeMoved.roadPath.size()-1) {
                    cars.remove(carToBeMoved);
					System.out.println("car complete");
                } else {
                    
                    carToBeMoved.currentlyOn = carToBeMoved.roadPath.get(++carToBeMoved.currentRoadNumb);
                }
				
			}
            //advance time.
        }
    }
	

}	
	