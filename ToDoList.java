import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter a command (add, remove, display, exit):");
            command = scanner.nextLine();

            if (command.equals("add")) {
                System.out.println("Enter a task:");
                String task = scanner.nextLine();
                toDoList.addTask(task);
            } else if (command.equals("remove")) {
                System.out.println("Enter the task number to remove:");
                int taskNumber = scanner.nextInt();
                scanner.nextLine(); // consume newline
                toDoList.removeTask(taskNumber - 1);
            } else if (command.equals("display")) {
                toDoList.displayTasks();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}
