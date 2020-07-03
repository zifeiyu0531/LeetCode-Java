import java.util.*;

public class MapNode {
    public int val;
    public List<MapNode> neighbors;

    public MapNode() {
        val = 0;
        neighbors = new ArrayList<MapNode>();
    }

    public MapNode(int val) {
        this.val = val;
        neighbors = new ArrayList<MapNode>();
    }

    public MapNode(int val, ArrayList<MapNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}