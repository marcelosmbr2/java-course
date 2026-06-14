/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
	
	    // =============================================
        // Variables and data types
        // =============================================
        
        // Primitives
        int age = 25;
        double salary = 4500.75;
        float height = 1.75f;
        long population = 8000000000L;
        boolean is_active = true;
        char initial = 'M';
        String name = "John Doe";

        // Type conversion
        int whole_number = (int) height;
        double decimal = (double) age;

        // Constants
        final double PI = 3.14159;
        final int CURRENT_YEAR = 2025;

        // =============================================
        // Output
        // =============================================
        
        System.out.println("Hello, " + name + "!");
        System.out.print("No line break here ");
        System.out.printf("Salary: $%.2f%n", salary);

        // =============================================
        // Input 
        // =============================================
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String user_name = sc.nextLine();
        System.out.println("Hello, " + user_name);

        // =============================================
        // Conditions
        // =============================================
        
        int grade = 75;

        // If-else-if
        if (grade >= 90) {
            System.out.println("Passed with distinction");
        } else if (grade >= 70) {
            System.out.println("Passed");
        } else if (grade >= 50) {
            System.out.println("Make-up exam");
        } else {
            System.out.println("Failed");
        }

        // Ternary
        String result = (grade >= 70) ? "Passed" : "Failed";

        // Switch-case
        int day_of_week = 3;
        switch (day_of_week) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");
        }

        // =============================================
        // Loops
        // =============================================
        
        // For
        for (int i = 1; i <= 5; i++) {
            System.out.println("For: " + i);
        }

        // While
        int counter = 1;
        while (counter <= 5) {
            System.out.println("While: " + counter);
            counter++;
        }

        // Do-while (runs at least once)
        int x = 1;
        do {
            System.out.println("Do-While: " + x);
            x++;
        } while (x <= 5);

        // =============================================
        // Data Structure
        // =============================================
        
        // Array Vector (fixed size)
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("First: " + numbers[0]);
        System.out.println("Length: " + numbers.length);

        // Iterate array with for-each
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        // Array Matrix (fixed size)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Matrix center: " + matrix[1][1]);

        // ArrayList (dynamic size)
        java.util.ArrayList<String> fruits = new java.util.ArrayList<>();
        fruits.add("Apple");
        fruits.add(0, "Strawberry");
        fruits.add("Banana");
        fruits.remove("Banana");
        System.out.println("Fruits: " + fruits);

        // HashMap (key → value)
        java.util.HashMap<String, Integer> ages = new java.util.HashMap<>();
        ages.put("Alice", 28);
        ages.put("Bob", 35);
        ages.put("Carol", 22);
        System.out.println("Alice's age: " + ages.get("Alice"));
        System.out.println("Bob exists: " + ages.containsKey("Bob"));

        // =============================================
        // Libraries
        // =============================================
        
        // Math
        System.out.println("Square root of 16: " + Math.sqrt(16));

        // String
        String text = "  Java is awesome!  ";
        System.out.println(text.trim());                              // removes whitespace
        System.out.println(text.toUpperCase());                       // uppercase

        // LocalDate (dates)
        java.time.LocalDate today = java.time.LocalDate.now();
        System.out.println("Today: " + today);
        System.out.println("Year: " + today.getYear());

        // =============================================
        // Error Handling
        // =============================================
        
        try {
            int division = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: division by zero → " + e.getMessage());
        } finally {
            System.out.println("Finally");
        }

        // =============================================
        // Lambdas (anonymous functions)
        // =============================================
        
        // No parameters
        Runnable lambda1 = () -> System.out.println("Hello!");
        lambda1.run();
        
        // With 1 parameter
        Consumer<String> lambda2 = name -> System.out.println("Hello, " + name);
        lambda2.accept("Marce");
        
        // With 2 parameters
        BiFunction<Integer, Integer, Integer> lambda3 = (a, b) -> a + b;
        System.out.println(lambda3.apply(10, 20));
        
        // With code block
        Function<Integer, String> lambda4 = grade -> {
            if (grade >= 90) {
                return "A";
            } else if (grade >= 70) {
                return "B";
            } else {
                return "F";
            }
        };
        System.out.println(lambda4.apply(85));
        
	}
}