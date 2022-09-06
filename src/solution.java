import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Node {
  public int val;
  public List<Node> neighbors;
  public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
  }
  public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
  }
  public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
  }
}

class Solution {
  private HashMap<Node, Node> map = new HashMap<>();
  public Node cloneGraph(Node node) {
    if (node ==  null) {
      return node;
    }
    
    map.put(node, new Node(node.val, new ArrayList<Node>()));

    for(Node neighbour : node.neighbors) {
      if (map.containsKey(neighbour)) {
        map.get(node).neighbors.add(map.get(neighbour));
      } else {
        map.get(node).neighbors.add(cloneGraph(neighbour));
      }
    }
    return map.get(node);
  }
}