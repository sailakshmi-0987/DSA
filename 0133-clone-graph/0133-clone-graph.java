/*
// Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node){
        if(node == null){
            return node;
        }
        Map<Node,Node> map = new  HashMap<>();
        return dfs(map,node);
    }
    private Node dfs(Map<Node,Node> map ,Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node,copy);

        for(Node nei : node.neighbors){
            copy.neighbors.add(dfs(map,nei));
        }
        return copy;
    }
}