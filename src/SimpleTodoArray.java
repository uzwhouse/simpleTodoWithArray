import java.util.Scanner;

public class SimpleTodoArray {
    static final String RESET = "\u001b[0m";
    static final String BLACK = "\u001b[30m";
    static final String RED = "\u001b[31m";
    static final String GREEN = "\u001b[32m";
    static final String YELLOW = "\u001b[33m";
    static final String BLUE = "\u001b[34m";
    static final String PURPLE = "\u001b[35m";
    static final String CYAN = "\u001b[36m";
    static final String WHITE = "\u001b[37m";
    static Scanner scanS = new Scanner(System.in);
    static Scanner scanN = new Scanner(System.in);
    static String[] todos = {"✅", "✅", "✅", "✅", "✅", "✅", "✅", "✅", "✅", "✅"};

    public static void main(String[] args) {
        app();
    }

    private static void app() {
        displayMenu();
        switch (readLine("? : ")) {
            case "1" -> todoList();
            case "2" -> todoCreate();
            case "3" -> todoDelete();
            case "4" -> todoUpdate();
            case "q" -> {
                System.out.println("Bye )))");
                System.exit(0);
            }
            default -> System.err.println("Wrong Choice !!!");
        }
        todoList();
        app();
    }

    private static void todoUpdate() {
        int index = readNum("Choice index : ");
        if (!todos[index - 1].equals("✅")) {
            todos[index - 1] = readLine("Update todo :");
        } else {
            System.out.println("Index empty");
        }
    }

    private static void todoDelete() {
        int index = readNum("Choice index : ");
        if (!todos[index - 1].equals("✅")) {
            todos[index - 1] = "✅";
        } else {
            System.out.println("Index empty");
        }
    }

    private static void todoCreate() {
        int index = readNum("Choice index : ");
        if (todos[index - 1].equals("✅")) {
            todos[index - 1] = readLine("Create todo : ");
        } else {
            System.out.println("Index full");
        }
    }

    private static void todoList() {
        for (String todo : todos) {
            System.out.printf("%s\t", todo);
        }
        System.out.println();
    }

    private static String readLine(String str) {
        System.out.print(str);
        return scanS.nextLine();
    }

    private static int readNum(String str) {
        System.out.print(str);
        return scanN.nextInt();
    }

    private static void displayMenu() {
        System.out.println("TODO List       -> 1");
        System.out.println("TODO Create     -> 2");
        System.out.println("TODO Delete     -> 3");
        System.out.println("TODO Update     -> 4");
        System.out.println("QUIT            -> q");
    }
}
