package org.itstep;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReverseNumberApplicationBuilder extends NumberApplicationBuilder {
    private final List<Integer> lst;
    private String revName;
    private NumberCommandFactory reverse;

    private void build(Map<String,Command> commands) {
        if (null == revName || null == reverse)
            throw new IllegalStateException("Reverse command not set");
        commands.put(revName,reverse.construct(lst));
    }

    public ReverseNumberApplicationBuilder(List<Integer> lst, List<Integer> lst1) {
        super(lst);
        this.lst = lst1;
    }

    public ReverseNumberApplicationBuilder reverseFrom(String revName, NumberCommandFactory reverse) {
        this.revName = revName;
        this.reverse = reverse;
        return this;
    }

    @Override
    public NumberApplication buildUpon(Scanner source, Map<String, Command> commands, Command onUnknown) {
        build(commands);
        return super.buildUpon(source, commands, onUnknown);
    }

    @Override
    public NumberApplication buildUpon(Scanner source, Map<String, Command> commands) {
        build(commands);
        return super.buildUpon(source, commands);
    }
}
