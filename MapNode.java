import java.util.*;

public class MapNode {
    public int val;
    public List<Node> neighbors;

    public MapNode() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public MapNode(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public MapNode(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}