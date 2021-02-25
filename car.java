import java.util.ArrayList;

public class car {

	road currentlyOn;
	int roadProgress = 0;
    int currentRoadNumb = 0;
    ArrayList<String> path;
    ArrayList<road> roadPath = new ArrayList<road>();

	public car(int roadProgress, ArrayList<String> path) {
		this.roadProgress = roadProgress;
		this.path = path;
	}

}
