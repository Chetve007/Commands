package org.itstep;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FilterNumbersCommand implements Command {
    private final Predicate<Integer> pred;
    private final List<Integer> lst;

    public FilterNumbersCommand(Predicate<Integer> pred, List<Integer> lst) {
        this.pred = pred;
        this.lst  = lst;
    }

    @Override
    public void exec() throws Exception {
        Iterator<Integer> it = lst.iterator();
        while(it.hasNext())
            if (!pred.test(it.next()))
                it.remove();
    }
}
