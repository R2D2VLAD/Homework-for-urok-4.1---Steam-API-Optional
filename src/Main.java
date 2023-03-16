
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        findMinMax(list.stream(), (s1, s2) -> s2 - s1, (s1, s2) -> System.out.printf("max: %s, min: %s%n", s1, s2));
        System.out.println();

        System.out.println("Задача 2");
        list.stream()
                .filter(s -> s % 2 == 0)
                .forEach(System.out::println);

    }
    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(order).toList();
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
}