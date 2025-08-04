public class Prog1_GeometryCalculator {

    // Area methods
    public static double areaOfCircle(double radius) {
        return Math.PI * radius * radius;
    }

    public static double areaOfTriangle(double base, double height) {
        return 0.5 * base * height;
    }

    public static double areaOfRectangle(double length, double width) {
        return length * width;
    }

    public static double areaOfIsoscelesTriangle(double base, double height) {
        // Same as a general triangle (using base and height)
        return 0.5 * base * height;
    }
    //Learn
    public static double areaOfParallelogram(double base, double height) {
        return base * height;
    }
    //Learn
    public static double areaOfRhombus(double diagonal1, double diagonal2) {
        return 0.5 * diagonal1 * diagonal2;
    }
    //Learn
    public static double areaOfEquilateralTriangle(double side) {
        return (Math.sqrt(3) / 4) * side * side;
    }

    // Perimeter methods
    //Learn
    public static double perimeterOfCircle(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double perimeterOfEquilateralTriangle(double side) {
        return 3 * side;
    }
    //Learn
    public static double perimeterOfParallelogram(double base, double side) {
        return 2 * (base + side);
    }

    public static double perimeterOfRectangle(double length, double width) {
        return 2 * (length + width);
    }

    public static double perimeterOfSquare(double side) {
        return 4 * side;
    }

    public static double perimeterOfRhombus(double side) {
        return 4 * side;
    }

    // Volume methods
    //Learn
    public static double volumeOfCone(double radius, double height) {
        return (1.0 / 3) * Math.PI * radius * radius * height;
    }
    //Learn
    public static double volumeOfPrism(double baseArea, double height) {
        return baseArea * height;
    }
    //Learn
    public static double volumeOfCylinder(double radius, double height) {
        return Math.PI * radius * radius * height;
    }
    //Learn
    public static double volumeOfSphere(double radius) {
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }
    //Learn
    public static double volumeOfPyramid(double baseArea, double height) {
        return (1.0 / 3) * baseArea * height;
    }

    // Surface area methods
    //Learn
    public static double curvedSurfaceAreaOfCylinder(double radius, double height) {
        return 2 * Math.PI * radius * height;
    }
    //Learn
    public static double totalSurfaceAreaOfCube(double side) {
        return 6 * side * side;
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        // Example inputs
        double radius = 5.0;
        double base = 10.0;
        double height = 8.0;
        double length = 12.0;
        double width = 7.0;
        double side = 4.0;
        double diagonal1 = 6.0;
        double diagonal2 = 8.0;

        // Area calculations
        System.out.println("Area of Circle: " + areaOfCircle(radius));
        System.out.println("Area of Triangle: " + areaOfTriangle(base, height));
        System.out.println("Area of Rectangle: " + areaOfRectangle(length, width));
        System.out.println("Area of Isosceles Triangle: " + areaOfIsoscelesTriangle(base, height));
        System.out.println("Area of Parallelogram: " + areaOfParallelogram(base, height));
        System.out.println("Area of Rhombus: " + areaOfRhombus(diagonal1, diagonal2));
        System.out.println("Area of Equilateral Triangle: " + areaOfEquilateralTriangle(side));

        // Perimeter calculations
        System.out.println("Perimeter of Circle: " + perimeterOfCircle(radius));
        System.out.println("Perimeter of Equilateral Triangle: " + perimeterOfEquilateralTriangle(side));
        System.out.println("Perimeter of Parallelogram: " + perimeterOfParallelogram(base, side));
        System.out.println("Perimeter of Rectangle: " + perimeterOfRectangle(length, width));
        System.out.println("Perimeter of Square: " + perimeterOfSquare(side));
        System.out.println("Perimeter of Rhombus: " + perimeterOfRhombus(side));

        // Volume calculations
        System.out.println("Volume of Cone: " + volumeOfCone(radius, height));
        // For prism and pyramid, you might use the rectangle area as the base area example.
        System.out.println("Volume of Prism: " + volumeOfPrism(areaOfRectangle(length, width), height));
        System.out.println("Volume of Cylinder: " + volumeOfCylinder(radius, height));
        System.out.println("Volume of Sphere: " + volumeOfSphere(radius));
        System.out.println("Volume of Pyramid: " + volumeOfPyramid(areaOfRectangle(length, width), height));

        // Surface area calculations
        System.out.println("Curved Surface Area of Cylinder: " + curvedSurfaceAreaOfCylinder(radius, height));
        System.out.println("Total Surface Area of Cube: " + totalSurfaceAreaOfCube(side));
    }
}
