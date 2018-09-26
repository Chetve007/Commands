package org.itstep;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumberApplicationExtendedBuilder extends NumberApplicationBuilder {
    private final List<Integer> numbers;
    private String listName;
    private NumberCommandFactory list;

    private void build(Map<String,Command> commands) {
        commands.put(this.listName,this.list.construct(numbers));
    }

    public NumberApplicationExtendedBuilder(List<Integer> lst) {
        super(lst);
        numbers = lst;
    }

    public NumberApplicationExtendedBuilder listFrom(String listName, NumberCommandFactory list) {
        this.listName = listName;
        this.list     = list;
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
