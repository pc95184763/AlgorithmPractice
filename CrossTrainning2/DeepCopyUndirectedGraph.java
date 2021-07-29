package CrossTrainning2;

import java.util.*;

public class DeepCopyUndirectedGraph {

  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    if (graph == null) {
      return null ;
    }
    HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>() ;
    for (GraphNode node: graph) {
      if (!map.containsKey(node)) {
        map.put(node, new GraphNode(node.key) ) ;
        DFS(node, map) ;
      }
    }
    return new ArrayList<GraphNode>(map.values() ) ;
  }

  private void DFS(GraphNode seed, HashMap<GraphNode, GraphNode> map) {
    GraphNode copy = map.get(seed) ;
    for (GraphNode nei: seed.neighbors) {
      if ( !map.containsKey(nei) ) {
        map.put(nei, new GraphNode(nei.key) ) ;
        DFS(nei,map) ;
      }
      copy.neighbors.add(map.get(nei)) ;
    }
  }
}



class GraphNode {
   public int key;
   public List<GraphNode> neighbors;
   public GraphNode(int key) {
     this.key = key;
     this.neighbors = new ArrayList<GraphNode>();
   }
}