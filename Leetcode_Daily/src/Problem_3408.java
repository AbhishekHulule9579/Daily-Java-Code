import java.util.*;

public class Problem_3408 {

    static class TaskManager {
        private static class Task {
            int priority;
            int taskId;

            Task(int priority, int taskId) {
                this.priority = priority;
                this.taskId = taskId;
            }
        }

        private PriorityQueue<Task> maxHeap;
        private Map<Integer, Integer> taskPriorityMap;
        private Map<Integer, Integer> taskOwnerMap;

        public TaskManager(List<List<Integer>> tasks) {
            maxHeap = new PriorityQueue<>(
                    (a, b) -> {
                        if (a.priority != b.priority) {
                            return b.priority - a.priority;
                        }
                        return b.taskId - a.taskId;
                    }
            );
            taskPriorityMap = new HashMap<>();
            taskOwnerMap = new HashMap<>();

            for (List<Integer> t : tasks) {
                add(t.get(0), t.get(1), t.get(2));
            }
        }

        public void add(int userId, int taskId, int priority) {
            maxHeap.offer(new Task(priority, taskId));
            taskPriorityMap.put(taskId, priority);
            taskOwnerMap.put(taskId, userId);
        }

        public void edit(int taskId, int newPriority) {
            maxHeap.offer(new Task(newPriority, taskId));
            taskPriorityMap.put(taskId, newPriority);
        }

        public void rmv(int taskId) {
            taskPriorityMap.put(taskId, -1);
        }

        public int execTop() {
            while (!maxHeap.isEmpty()) {
                Task top = maxHeap.poll();
                int currPriority = taskPriorityMap.getOrDefault(top.taskId, -1);

                if (top.priority == currPriority) {
                    taskPriorityMap.put(top.taskId, -1);
                    return taskOwnerMap.get(top.taskId);
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> tasks = new ArrayList<>();
        tasks.add(Arrays.asList(1, 101, 5));
        tasks.add(Arrays.asList(2, 102, 3));
        tasks.add(Arrays.asList(3, 103, 8));

        TaskManager manager = new TaskManager(tasks);

        System.out.println(manager.execTop());
        manager.add(4, 104, 10);
        System.out.println(manager.execTop());
        manager.edit(102, 12);
        System.out.println(manager.execTop());
        manager.rmv(101);
        System.out.println(manager.execTop());
    }
}
