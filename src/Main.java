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
                /*System.out.println("Введите номер месяца (1-Январь; 2-Февраль; 3-Март; 4-Апрель; " +
                "5-Май; 6-Июнь; 7-Июль; 8-Август; 9-Сентябрь; 10-Октябрь; 11-Ноябрь; 12-Декабрь)");

                int month = scanner.nextInt();
                if (month >= 1 && month <= 12) {
                    step.stepsPerDayForMonth(month - 1);
                    Converter con = new Converter();
                    System.out.printf("Всего шагов в месяц: %s; %nМаксимальное количество шагов: %s; %nСреднее количество шагов: %s; %n" +
                            "Пройденная дистанция: %s км; %nКоличество потраченных килокалорий: %s ккал; %nЛучшая серия: %s дней.%n",
                            step.stepsByMonth(month - 1), step.maxSteps(month - 1), step.averageSteps(month - 1),
                            con.distance(step.stepsByMonth(month - 1)), con.calories(step.stepsByMonth(month - 1)), step.bestSeries(month - 1));
                } else {
                    System.out.println("Неверное значение. Введите значение от 1 до 12");
                }*/
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

