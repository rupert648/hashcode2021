import java.util.Queue;

public class road {
	String name;
    int start;
    int end;
    int length;
    Queue<car> waiting;
    
    public road(String name, int start, int end, int length) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.length = length;
    }

}
