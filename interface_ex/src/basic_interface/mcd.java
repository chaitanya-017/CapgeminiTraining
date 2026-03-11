package basic_interface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class mcd {
    public static void main(String[] args) {
        List<String> names = List.of("ram","shyam","raghav", "randu");

        Predicate<String> filter = name -> name.startsWith("r");
        Function<String,String> transform = text -> text.toUpperCase();
        Consumer<String> print = System.out::println;

        names.stream()
                .filter(filter) // name that starts with R
                .map(transform) // convert to uppercase
                .forEach(print); // printing each filtered out name
    }
}
