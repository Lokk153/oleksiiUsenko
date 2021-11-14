package lesson3;

public class Magnitude {
    public static void main(String args[]) {
        int a=3;
        int b=-9;

        if (Math.abs(a) > Math.abs(b)){
            System.out.print("Greater value is " + a);
        } else {
            System.out.print("Greater value is " + b);
        }
    }
}

