package dtu.planning.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Date {
    private List<Integer> range;

    public Date(int fromWeek, int toWeek) {
        /**
         * We should check that toWeek >= fromWeek
         */
        this.range = IntStream.rangeClosed(fromWeek, toWeek)
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> getWeeks() { return this.range; }
}
