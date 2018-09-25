package org.itstep;

import java.util.List;

public class GenerateNumbersCommandFactory implements NumberCommandFactory {
    private final int howMany, bound;

    public GenerateNumbersCommandFactory(int howMany, int bound) {
        this.howMany = howMany;
        this.bound = bound;
    }

    @Override
    public Command construct(List<Integer> lst) {
        return new GenerateNumbersCommand(lst,howMany,bound);
    }
}
