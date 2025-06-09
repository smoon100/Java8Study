import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalExample {

    public static void main(String[] args) {

        Function<String, String> toUpperCaseConverter = String::toUpperCase; // Method reference example
        System.out.println("Uppercase 'hello': " + toUpperCaseConverter.apply("hello"));
        System.out.println("\n--- Function Example Done ---\n");

        // --- 3. Predicate: Takes an argument, returns a boolean ---
        // Lambda expression to check if a number is even
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));

        // Using Predicate with a stream filter
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println("Even numbers in list: " + evenNumbers);
        System.out.println("\n--- Predicate Example Done ---\n");

        // --- 4. Runnable: Takes no arguments, returns nothing (used for threads) ---
        // Lambda expression for a simple task
        Runnable task = () -> System.out.println("Running a task in a new thread!");
        new Thread(task).start();
        System.out.println("\n--- Runnable Example Done ---\n");

        // --- 5. Custom Functional Interface ---
        // Define a simple custom functional interface
        @FunctionalInterface
        interface StringProcessor {
            String process(String input);
        }

        // Use a lambda expression with the custom functional interface
        StringProcessor reverseString = str -> new StringBuilder(str).reverse().toString();
        System.out.println("Reversed 'world': " + reverseString.process("world"));
        System.out.println("\n--- Custom Functional Interface Example Done ---\n");
    }
}
