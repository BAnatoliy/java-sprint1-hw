public class MonthData {
    int[] days;
    MonthData() {
        days = new int[30];
    }
    void saveStep(int day, int step) { //Метод, сохраняющий значение шагов
        days[day] = step;
    }
}
