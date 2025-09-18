import java.util.*;

class TaskManager {
    private static class Task {
        int priority;
        int taskId;
        Task(int priority, int taskId) {
            this.priority = priority;
            this.taskId = taskId;
        }
    }

    private PriorityQueue<Task> pq;
    // taskId -> { userId, priority }
    private Map<Integer, int[]> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return Integer.compare(b.priority, a.priority);
            return Integer.compare(b.taskId, a.taskId); // higher taskId first if tie
        });
        taskMap = new HashMap<>();

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            pq.offer(new Task(priority, taskId));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        pq.offer(new Task(priority, taskId));
    }

    public void edit(int taskId, int newPriority) {
        int[] info = taskMap.get(taskId);
        if (info == null) return; // defensive (problem statement guarantees existence)
        int userId = info[0];
        taskMap.put(taskId, new int[]{userId, newPriority});
        pq.offer(new Task(newPriority, taskId));
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy removal
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            int[] info = taskMap.get(top.taskId);
            // valid if task exists and priority matches the current priority
            if (info != null && info[1] == top.priority) {
                int userId = info[0];
                taskMap.remove(top.taskId);
                return userId;
            }
            // otherwise stale entry: continue
        }
        return -1;
    }
}
