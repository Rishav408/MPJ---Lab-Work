// Shapes.java
class Shapes {
    double area;

    // Constructor Overloading: No-arg constructor
    Shapes() {
        System.out.println("--- Calculating Areas ---");
    }

    // Method Overloading: Area of a Square (one parameter)
    void calculateArea(double side) {
        area = side * side;
        System.out.println("Area of Square: " + area);
    }

    // Method Overloading: Area of a Rectangle (two parameters)
    void calculateArea(double length, double width) {
        area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }

    // Method Overloading: Area of a Circle (different parameter type or logic)
    // Using a float to distinguish from the square's double parameter
    void calculateArea(float radius) {
        area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    public static void main(String[] args) {
        Shapes myShape = new Shapes(); // Calls no-arg constructor
        
        // Calling overloaded methods
        myShape.calculateArea(5.0);        // Square
        myShape.calculateArea(10.0, 4.0);  // Rectangle
        myShape.calculateArea(7.0);       // Circle
    }
}