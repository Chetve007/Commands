package org.itstep;

import java.util.Collections;
import java.util.List;

public class SortNumbersCommand implements Command {
    private final List<Integer> lst;

    public SortNumbersCommand(List<Integer> lst) {
        this.lst = lst;
    }

    @Override
    public void exec() throws Exception {
        if (0 == lst.size())
            return;
        for (int i =0; i != lst.size(); ++i)
            for (int j=0; j != lst.size(); ++j)
                if (lst.get(j) > lst.get(j+1))
                    Collections.swap(lst,j,j+1);
    }
}
