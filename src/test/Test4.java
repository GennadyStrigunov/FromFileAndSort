package test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {

    public static void main(String[] args) {
        List<Integer> values = Stream.of("32", "43", "74", "54", "3")
                .map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        System.out.println(values.toString());
    }
}
