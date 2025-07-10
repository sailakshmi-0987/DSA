class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] res = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(canFinish(graph,vis,res,i,stack)){
                    return new int[0];
                }
            }
        }
        int[] ans = new int[numCourses];
        int j=0;
        while(!stack.isEmpty()){
            ans[j++]=stack.pop();
        }

        return ans;
    }
    private static boolean canFinish(List<List<Integer>> graph,boolean[] vis,boolean[] res,int curr,Stack<Integer> stack){
        vis[curr]=true;
        res[curr]=true;
        for(int i=0;i<graph.get(curr).size();i++){
            int dest = graph.get(curr).get(i);
            if(!vis[dest]){
                if(canFinish(graph,vis,res,dest,stack)){
                    return true;
                }
            }else if(res[dest]){
                return true;
            } 
        }
        res[curr]=false;
        stack.push(curr);
        return false;
    }
}