package lesson3;

public class TriangleTypeChecker {
    public static void main(String args[]) {
        int a=5;
        int b=10;
        int c=5;

        System.out.println((a==b || a==c || b==c) ? "The triangle is isosceles" : "The triangle is not isosceles");
    }
}

