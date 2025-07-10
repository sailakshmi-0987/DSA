class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course); 
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] res = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                
                if(result(graph,vis,res,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean result(List<List<Integer>> graph ,boolean[] vis,boolean[] res,int curr){
        vis[curr]=true;
        res[curr]=true;
        for(int dest:graph.get(curr)){
            
            if(res[dest]){
                return true;
            }else if(!vis[dest] && result(graph,vis,res,dest)){
                return true;
            }
        }
        res[curr]=false;
        return false;

    }
}