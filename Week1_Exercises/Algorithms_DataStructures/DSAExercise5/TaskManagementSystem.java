package DSAExercise5;
public class TaskManagementSystem {

    public static class Task {
        private String taskId;
        private String taskName;
        private String status;

        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public String getTaskId() { return taskId; }
        public void setTaskId(String taskId) { this.taskId = taskId; }
        public String getTaskName() { return taskName; }
        public void setTaskName(String taskName) { this.taskName = taskName; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    public static class TaskManager {
        private class Node {
            Task task;
            Node nextNode;
            Node(Task task) {
                this.task = task;
                this.nextNode = null;
            }
        }

        private Node headNode;

        public TaskManager() {
            this.headNode = null;
        }

        public void addTaskToList(Task task) {
            Node newNode = new Node(task);
            if (headNode == null) {
                headNode = newNode;
            } else {
                Node currentNode = headNode;
                while (currentNode.nextNode != null) {
                    currentNode = currentNode.nextNode;
                }
                currentNode.nextNode = newNode;
            }
        }

        public Task findTaskById(String taskId) {
            Node currentNode = headNode;
            while (currentNode != null) {
                if (currentNode.task.getTaskId().equals(taskId)) {
                    return currentNode.task;
                }
                currentNode = currentNode.nextNode;
            }
            return null;
        }

        public void displayAllTasks() {
            Node currentNode = headNode;
            while (currentNode != null) {
                System.out.println(currentNode.task);
                currentNode = currentNode.nextNode;
            }
        }

        public void removeTaskById(String taskId) {
            if (headNode == null) return;
            if (headNode.task.getTaskId().equals(taskId)) {
                headNode = headNode.nextNode;
                return;
            }
            Node currentNode = headNode;
            while (currentNode.nextNode != null && !currentNode.nextNode.task.getTaskId().equals(taskId)) {
                currentNode = currentNode.nextNode;
            }
            if (currentNode.nextNode != null) {
                currentNode.nextNode = currentNode.nextNode.nextNode;
            }
        }
    }

    public static void main(String[] args) {
        TaskManager taskMgr = new TaskManager();

        taskMgr.addTaskToList(new Task("T101", "Design Database", "Pending"));
        taskMgr.addTaskToList(new Task("T102", "Implement API", "In Progress"));
        taskMgr.addTaskToList(new Task("T103", "Write Documentation", "Not Started"));

        System.out.println("All Tasks:");
        taskMgr.displayAllTasks();

        System.out.println("\nFinding task with ID T102:");
        Task task = taskMgr.findTaskById("T102");
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nRemoving task with ID T103.");
        taskMgr.removeTaskById("T103");

        System.out.println("\nUpdated Task List:");
        taskMgr.displayAllTasks();
    }
}
