import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker step = new StepTracker(scanner);
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput == 1) {
                step.giveData(); // Ввод и сохранение кол-ва шагов
            } else if (userInput == 2) {
                step.statistic();
            } else if (userInput == 3) {
                step.changeObject(); // изменить цель
            } else {
                System.out.println("Не верное значение.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
        scanner.close();
    }
    private static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день;");
        System.out.println("2 - Напечатать статистику за определённый месяц;");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("0 - Выйти из приложения.");
    }
}

