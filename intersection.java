
import java.util.ArrayList;
import java.util.HashMap;

public class intersection {
    int id;
	ArrayList<road> incoming = new ArrayList<road>();
	ArrayList<road> outGoing = new ArrayList<road>();
	ArrayList<Boolean> trafficLights;
	ArrayList<Pair> schedule;
    int currentInRotation;
    int scheduleSize;
    
// Bath 5
// London 5
// St Andrews 5

// time % 15 = 7

	public intersection(int id) {
        this.id = id;
    }

    public void initTrafficLights() {
        trafficLights = new ArrayList<Boolean>();
        for (int i = 0; i < incoming.size(); i++) {
            trafficLights.add(false);
        }
    }

    public void initSchedule() {
        for (int i = 0; i < incoming.size(); i++) {
            Pair newPair = new Pair();
            newPair.first = incoming.get(i);
            newPair.second = 5;
            schedule.add(newPair);
        }

        scheduleSize = incoming.size() * 5;
    }
}
