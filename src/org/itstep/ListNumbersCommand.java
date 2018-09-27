package org.itstep;

import java.io.PrintWriter;
import java.util.List;

public class ListNumbersCommand implements Command {
    private final List<Integer> numbers;
    private final PrintWriter sendTo;
    private final int inOneLine;

    public ListNumbersCommand(List<Integer> numbers, PrintWriter sendTo, int inOneLine) {
        this.numbers = numbers;
        this.sendTo = sendTo;
        this.inOneLine = 0 >= inOneLine ? 1 : inOneLine;
    }

    @Override
    public void exec() throws Exception {
        int counter = 0;
        for (Integer i : numbers) {
            sendTo.write(i + " ");
            if (++counter == inOneLine) {
                sendTo.println();
                sendTo.flush();
                counter = 0;
            }
        }
        sendTo.println();
        sendTo.flush();
    }
}
