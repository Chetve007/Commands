package org.itstep;

import java.io.PrintWriter;
import java.util.List;

public class ListNumbersCommandFactory implements NumberCommandFactory {
    private final PrintWriter printer;
    private final int inOneLine;

    public ListNumbersCommandFactory(PrintWriter printer, int inOneLine) {
        this.printer   = printer;
        this.inOneLine = inOneLine;
    }

    @Override
    public Command construct(List<Integer> lst) {
        return new ListNumbersCommand(lst,printer,inOneLine);
    }
}
