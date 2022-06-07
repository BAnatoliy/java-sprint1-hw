import java.util.Scanner;
public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData;
    int object = 10000;
    public StepTracker(Scanner scanner) {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        this.scanner = scanner;
    }
    public int inputMonth() {
        System.out.println("Введите номер месяца (1-Январь; 2-Февраль; 3-Март; 4-Апрель; " +
                "5-Май; 6-Июнь; 7-Июль; 8-Август; 9-Сентябрь; 10-Октябрь; 11-Ноябрь; 12-Декабрь)");
        while (true) {
            int month = scanner.nextInt();
            if ((month - 1) >= 0 && (month - 1 ) <= 12) {
                return month;
            } else {
                System.out.println("Неверное значение. Введите значение от 1 до 12");
            }
        }
    }
    public int inputDay() {
        System.out.println("Введите день");
        while (true) {
            int day = scanner.nextInt() - 1;
            if (day >= 0 && day < 30) {
                return day;
            } else {
                System.out.println("Неверное значение. Введите значение от 1 до 30");
            }
        }
    }
    public int inputStep() {
        System.out.println("Введите количество шагов");
        while (true) {
            int steps = scanner.nextInt();
            if (steps >= 0) {
                return steps;
            } else {
                System.out.println("Количество шагов не может быть отрицательным! Повторите ввод.");
            }
        }
    }
    void giveData() { // Метод, который получает ввод пользователя для сохранения значения шагов
        int month = inputMonth();
        int day = inputDay();
        int step = inputStep();
        monthToData[month-1].saveStep(day, step);
    }
    public void changeObject() { // Метод, изменяющий цель по количеству шагов в день
        System.out.println("Введите цель по количеству шагов в сутки");
        while (true) {
            object = scanner.nextInt();
            if (object >= 0) {
                System.out.println("Задана цель: " + object + " шагов.");
                break;
            } else {
                System.out.println("Количество шагов не может быть отрицательным! Повторите ввод.");
            }
        }
    }
    void statistic() {
        int month = inputMonth();
        Converter con = new Converter();
        monthToData[month - 1].stepsPerDayForMonth();
        System.out.printf("Всего шагов в месяц: %s; %nМаксимальное количество шагов: %s; %nСреднее количество шагов: %s; %n" +
                            "Пройденная дистанция: %s км; %nКоличество потраченных килокалорий: %s ккал; %nЛучшая серия: %s дней.%n",
                    monthToData[month - 1].stepsByMonth(), monthToData[month - 1].maxSteps(), monthToData[month - 1].averageSteps(),
                    con.distance(monthToData[month - 1].stepsByMonth()), con.calories(monthToData[month - 1].stepsByMonth()), monthToData[month - 1].bestSeries(object));
    }

}