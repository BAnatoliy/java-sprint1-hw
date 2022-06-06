public class Converter {

    static double distance(int step) {
        return (double)step * 75 / 100000;
    }

    static double calories(int step) {
        return (double)step * 50 / 1000;
    }
}
