package lesson4;

public class SinCalculator {
    public static void main(String[] args) {
        System.out.println("degrees | sin");
        for (double degrees = 0; degrees <= 360; degrees = degrees + 10) {
            System.out.format("%.0f | %.4f%n", degrees, Math.sin(Math.toRadians(degrees)));
            System.out.println("-------------");
        }
    }
}
