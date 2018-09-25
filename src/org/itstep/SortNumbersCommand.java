package org.itstep;

import java.io.Writer;
import java.util.Collections;
import java.util.List;

public class SortNumbersCommand implements Command {
    private final List<Integer> lst;
    private final Writer answerTo;

    public SortNumbersCommand(List<Integer> lst, Writer answerTo) {
        this.lst      = lst;
        this.answerTo = answerTo;
    }

    @Override
    public void exec() throws Exception {
        if (0 == lst.size()) {
            answerTo.write("Нечего сортировать!");
            return;
        }

        answerTo.write("Начинаю сортировку...");
        for (int i =0; i != lst.size(); ++i)
            for (int j=0; j != lst.size()-1; ++j)
                if (lst.get(j) > lst.get(j+1))
                    Collections.swap(lst,j,j+1);
        answerTo.write("Сортировка окончена!");
    }
}
