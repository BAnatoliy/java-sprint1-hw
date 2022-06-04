public class Converter {
    int step;
    Converter (int step) {
        this.step = step;
    }

    double distance() {
        return (double)step * 75 / 1000;
    }

    double callories() {
        return (double)step * 50 / 1000;
    }
}
