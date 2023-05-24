package exercises.streams.joins;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Joins {
    public static void main(String[] args) {
        /**
         * SELECT *
         * FROM (
         *   VALUES(1, 1),
         *         (2, 2)
         * ) t(v1, v2)
         *
         * yields
         * +----+----+
         * | v1 | v2 |
         * +----+----+
         * |  1 |  1 |
         * |  2 |  2 |
         * +----+----+
         */
        Stream.of(new Tuple<>(1, 1), new Tuple<>(2, 2)).forEach(System.out::println);

        /**
         * -- Table list syntax
         * SELECT *
         * FROM (VALUES( 1 ), ( 2 )) t1(v1),
         *      (VALUES('A'), ('B')) t2(v2)
         *
         * -- CROSS JOIN syntax
         * SELECT *
         * FROM       (VALUES( 1 ), ( 2 )) t1(v1)
         * CROSS JOIN (VALUES('A'), ('B')) t2(v2)
         * yielding
         * +----+----+
         * | v1 | v2 |
         * +----+----+
         * |  1 |  A |
         * |  1 |  B |
         * |  2 |  A |
         * |  2 |  B |
         * +----+----+
         */
        Stream<Integer> s1 = Stream.of(1, 2);
        Supplier<Stream<String>> s2 = ()->Stream.of("A", "B");

        s1.flatMap(v1 -> s2.get().map(v2 -> new Tuple<>(v1, v2))).forEach(System.out::println);


            //inner join
        List<Integer> ss1 = Arrays.asList(1, 2);
        List<Integer> ss2 = Arrays.asList(1, 3);

        ss1.stream()
                .flatMap(v1 -> ss2.stream()
                        .map(v2 -> new Tuple<>(v1, v2)))
                .filter(t -> Objects.equals(t.v1, t.v2))
                .forEach(System.out::println);
    }
}