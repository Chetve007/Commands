package org.itstep;

import java.util.Collections;
import java.util.List;

public class ReverseNumbersCommand implements Command {
    private final List<Integer> lst;

    public ReverseNumbersCommand(List<Integer> lst) {
        this.lst = lst;
    }

    @Override
    public void exec() throws Exception {
        Collections.reverse(lst);
    }
}
