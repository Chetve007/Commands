package org.itstep;

import java.util.List;
import java.util.Random;

public class GenerateNumbersCommand implements Command {
    private final List<Integer> numbers;
    private final int howMany, bound;

    public GenerateNumbersCommand(List<Integer> numbers, int howMany, int bound) {
        this.numbers = numbers;
        this.howMany = howMany;
        this.bound   = bound;

    }

    @Override
    public void exec() throws Exception {
        Random r = new Random();
        numbers.clear();
        for (int pos=0; pos != howMany; ++pos)
            numbers.add(r.nextInt(bound));
    }
}
