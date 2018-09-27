package org.itstep;

import java.util.List;

public class ReverseNumbersCommandFactory implements NumberCommandFactory {
    @Override
    public Command construct(List<Integer> lst) {
        return new ReverseNumbersCommand(lst);
    }
}
