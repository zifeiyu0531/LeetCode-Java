import java.util.*;

public class MapNode {
    public int val;
    public List<Node> neighbors;

    public MapNode() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public MapNode(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }

    public MapNode(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}