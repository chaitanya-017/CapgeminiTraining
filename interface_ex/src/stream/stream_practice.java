package stream;

import java.util.*;
import java.util.stream.*;

public class stream_practice  {

    public static void main(String[] args) {

        List<String> immutableList =
                new ArrayList<>(Stream.of("red","green",null,null).toList());

        System.out.println(immutableList);
        immutableList.add("yellow");

        System.out.println("------------ ");

        record Product(String name, String category, int price) {}

        List<Product> products = List.of(
                new Product("bat","sportsitem",4000),
                new Product("bells","sportsitem",2000),
                new Product("mobile","item",1000),
                new Product("laptop","item",56000)
        );

        // Filtering
        List<Product> filtered =
                products.stream()
                        .filter(p -> p.price() > 2500)
                        .collect(Collectors.toList());
        System.out.println(filtered);

        // Mapping
        var extractfields =
                products.stream()
                        .map(Product::price)
                        .toList();
        System.out.println(extractfields);

        // Partition
        Map<Boolean,List<Product>> part =
                products.stream()
                        .collect(Collectors.partitioningBy(p -> p.price() > 1000));
        System.out.println(part);

        // Summary
        System.out.println(
                products.stream()
                        .collect(Collectors.summarizingInt(Product::price))
        );
    }
}