import com.education.ztu.LambdaTasks;
import com.education.ztu.Printable;
import com.education.ztu.StreamAPI;

public class Main {
    public static void main(String[] args) {
        // Завдання 2. Printable
        Printable printable = () -> System.out.println("Hello world!!!");
        printable.print();

        // Завдання 3a. Predicate
        String testString = "123.45";
        System.out.println("Is numeric and non-empty: " +
                LambdaTasks.isNumeric.and(str -> str != null && !str.isEmpty()).test(testString));

        // Завдання 3b. Consumer
        LambdaTasks.startPair.andThen(LambdaTasks.endPair).accept("");

        // Завдання 3c. Supplier
        System.out.println(LambdaTasks.upperCaseSupplier.get());

        // Завдання 3d. Function
        String numbers = "2 3 4";
        System.out.println("Product of numbers: " + LambdaTasks.multiplyNumbers.apply(numbers));



        // StreamAPI
        System.out.println("Brands:");
        StreamAPI.getBrands().forEach(System.out::println);

        System.out.println("\nProducts cheaper than 1000:");
        StreamAPI.getProductsCheaperThan(1000, 2).forEach(System.out::println);

        System.out.println("\nTotal product count:");
        System.out.println(StreamAPI.getTotalProductCount());

        System.out.println("\nProducts grouped by brand:");
        StreamAPI.groupByBrand().forEach((brand, list) -> {
            System.out.println(brand + ": " + list);
        });

        System.out.println("\nProducts sorted by price:");
        StreamAPI.sortByPrice().forEach(System.out::println);
    }
}
