/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
 //to prevent infinite loop due to cycles (especially in directed graph), add the node to queue only if it is first time discovery
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while(queue.size() > 0){
            UndirectedGraphNode oldNode = queue.poll();
            UndirectedGraphNode newNode = map.get(oldNode);
            for(UndirectedGraphNode oldNeibor: oldNode.neighbors){
                if(!map.containsKey(oldNeibor)){
                    UndirectedGraphNode newNeibor = new UndirectedGraphNode(oldNeibor.label);
                    map.put(oldNeibor, newNeibor);
                    newNode.neighbors.add(newNeibor);
                    queue.offer(oldNeibor);//discovered new Node
                }
                else{
                    newNode.neighbors.add(map.get(oldNeibor));
                }
            }
            
        }
        return map.get(node);        
    }
}
 
 
//original working version
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while(queue.size() > 0){
            UndirectedGraphNode oldNode = queue.poll();
            UndirectedGraphNode newNode;
            if(!map.containsKey(oldNode)){
                newNode = new UndirectedGraphNode(oldNode.label);
                map.put(oldNode, newNode);
            }
            else{
                newNode = map.get(oldNode);
            }
            if(newNode.neighbors.size() == 0){//have not copied the neighbors, without using this if, the node's neighbor could be copied multiple times since the node could appear in the queue multiple times
                for(UndirectedGraphNode oldNeibor: oldNode.neighbors){
                    UndirectedGraphNode newNeibor;
                    if(!map.containsKey(oldNeibor)){
                        newNeibor = new UndirectedGraphNode(oldNeibor.label);
                        map.put(oldNeibor, newNeibor);
                    }
                    else{
                        newNeibor = map.get(oldNeibor);
                    }
                    newNode.neighbors.add(newNeibor);
                    queue.offer(oldNeibor); //this is bad, because if you always add the node to queue, there could be cycles, thus result in infinite loops 
                }
            }
        }
        return map.get(node);        
    }
}
