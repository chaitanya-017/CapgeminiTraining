import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,8,5};
        Arrays.stream(arr).filter(m->m>3).map(n->n*2).sorted().forEach(System.out::println);
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        String[] brr = {"Chaits","Manny","Om","Sanidhyss"};
        Arrays.stream(brr).map(String::toUpperCase).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        Arrays.stream(brr).filter(s->s.startsWith("C")).filter(s->s.length()>4).forEach(System.out::println);
        long count = Arrays.stream(brr).filter(s->s.length()>5).distinct().count();
        System.out.println(count);
        Optional<String> longest = Arrays.stream(brr).min(Comparator.comparing(String::length));
        longest.ifPresent(System.out::println);
        String res = Arrays.stream(brr).collect(Collectors.joining(","));
        System.out.println(res);
        Arrays.stream(brr).map(name->name.charAt(0)).forEach(System.out::println);
        Arrays.stream(brr).filter(name->!name.contains("a")).forEach(System.out::println);
        boolean exists = Arrays.stream(brr).anyMatch(s->s.startsWith("O"));
        System.out.println(exists);

    }
}