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
   /* int stepsByMonth(int month) { //Метод, сохраняющий сумму шагов за месяц
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum = sum + monthToData[month].days[i];
        }
        return sum;
    }
    void stepsPerDayForMonth(int month) { // Метод, выводящий пройденные шаги за каждый день выбранного месяца
        for (int i = 0; i < (monthToData[month].days.length - 1); i++) {
            System.out.print((i + 1) + " день: " + monthToData[month].days[i] + ", ");
        }
        System.out.println("30 день: " + monthToData[month].days[29] + ".");
    }
    int maxSteps(int month) { // Метод, выводящий максимальное значение шагов за день выбранного месяца
        int maxnum = monthToData[month].days[0];
        for (int j = 0; j < monthToData[month].days.length; j++) {
            if (maxnum <= monthToData[month].days[j]) {
                maxnum = monthToData[month].days[j];
            }
        }
        return maxnum;
    }
    double averageSteps(int month) { // Метод, выводящий среднее значение пройденных шагов за день выбранного месяца
        return (double) stepsByMonth(month) / monthToData[month].days.length;
    }*/
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
    /*public int bestSeries(int month) { // Метод, выводящий лучшую серию шагов за выбранный месяц
        int moreObject = 1; // серия подряд идущих дней, кол-во шагов за которые превышают цель
        int saveMoreObject = 0; // сохраняет максимальную серию
        for (int i = 0; i < monthToData[month].days.length - 1; i++) {
            if (monthToData[month].days[i] >= object && monthToData[month].days[i + 1] >= object) {
                moreObject = moreObject + 1;
            } else if (monthToData[month].days[i + 1] < object){
                if (moreObject > saveMoreObject) {
                    saveMoreObject = moreObject;
                    moreObject = 1;
                }

            }
        }
        return saveMoreObject;
    }*/
    void statistic() {
        int month = inputMonth();
        Converter con = new Converter();
        monthToData[month - 1].stepsPerDayForMonth();
        System.out.printf("Всего шагов в месяц: %s; %nМаксимальное количество шагов: %s; %nСреднее количество шагов: %s; %n" +
                            "Пройденная дистанция: %s км; %nКоличество потраченных килокалорий: %s ккал; %nЛучшая серия: %s дней.%n",
                    monthToData[month - 1].stepsByMonth(), monthToData[month - 1].maxSteps(), monthToData[month - 1].averageSteps(),
                    con.distance(monthToData[month - 1].stepsByMonth()), con.calories(monthToData[month - 1].stepsByMonth()), monthToData[month - 1].bestSeries(object));

        /*monthToData[month].stepsPerDayForMonth();
        monthToData[month].maxSteps();
        monthToData[month].averageSteps();
        monthToData[month].stepsByMonth();
        monthToData[month].bestSeries(object);*/
    }

}