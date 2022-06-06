public class MonthData {
    public static int amountOfDays = 30;
    private int[] days;
    MonthData() {
        days = new int[amountOfDays];
    }
    void saveStep(int day, int step) { //Метод, сохраняющий значение шагов
        days[day] = step;
    }

    public int bestSeries(int object) { // Метод, выводящий лучшую серию шагов за выбранный месяц
        int moreObject = 0; // серия подряд идущих дней, кол-во шагов за которые превышают цель
        int saveMoreObject = 0; // сохраняет максимальную серию
        for (int i = 0; i < amountOfDays; i++) {
            if (days[i] >= object) {
                moreObject++;
                if (moreObject > saveMoreObject) {
                    saveMoreObject = moreObject;
                }
            } else {
                moreObject = 0;
            }
        }
        return saveMoreObject;
    }

    int stepsByMonth() { //Метод, сохраняющий сумму шагов за месяц
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum = sum + days[i];
        }
        return sum;
    }
    void stepsPerDayForMonth() { // Метод, выводящий пройденные шаги за каждый день выбранного месяца
        for (int i = 0; i < (amountOfDays - 1); i++) {
            System.out.print((i + 1) + " день: " + days[i] + ", ");
        }
        System.out.println("30 день: " + days[29] + ".");
    }
    int maxSteps() { // Метод, выводящий максимальное значение шагов за день выбранного месяца
        int maxnum = days[0];
        for (int j = 0; j < amountOfDays; j++) {
            if (maxnum <= days[j]) {
                maxnum = days[j];
            }
        }
        return maxnum;
    }
    double averageSteps() { // Метод, выводящий среднее значение пройденных шагов за день выбранного месяца
        return (double) stepsByMonth() / amountOfDays;
    }

}
