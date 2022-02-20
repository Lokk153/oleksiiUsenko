package lesson2;

public class HomeWorkLesson2 {
    public static void main(String[] args){
        double d = 5/2; System.out.println(d);

        //1 Temperature Converter
        double celsius = 20.5;
        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin  = celsius + 273.16;
        System.out.println("Temperature in Celsius is : " + celsius);
        System.out.println("Temperature in Fahrenheit is : " + fahrenheit);
        System.out.println("Temperature in Kelvin is : " + kelvin);

        //2 Area of a triangle
        double cathetus = 2.5;
        System.out.println("Area of a triangle is: " + (cathetus*cathetus)/2);

        //3 Area of a circle
        double radius = 2.5;
        System.out.println("Area of a circle is: " + (Math.PI*Math.pow(radius, 2)));



    }
}
