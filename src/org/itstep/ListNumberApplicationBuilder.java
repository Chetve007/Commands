package org.itstep;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListNumberApplicationBuilder {
    private final List<Integer> lst;
    private final NumberApplicationBuilder mainBuilder;
    private String listName;
    private NumberCommandFactory list;

    private void build(Map<String,Command> commands) {
        if (null == this.listName || null == this.list)
            throw new IllegalStateException("List command not set");
        commands.put(this.listName,this.list.construct(lst));
    }

    public ListNumberApplicationBuilder(List<Integer> lst, NumberApplicationBuilder mainBuilder) {
        this.lst         = lst;
        this.mainBuilder = mainBuilder;
    }

    public ListNumberApplicationBuilder listFrom(String listName, NumberCommandFactory list) {
        this.listName = listName;
        this.list     = list;
        return this;
    }

    public ListNumberApplicationBuilder generateFrom(String genName, NumberCommandFactory generate) {
        mainBuilder.generateFrom(genName,generate);
        return this;
    }

    public ListNumberApplicationBuilder sortFrom(String srtName, NumberCommandFactory sort) {
        mainBuilder.sortFrom(srtName,sort);
        return this;
    }

    public ListNumberApplicationBuilder saveFrom(String svName, NumberCommandFactory save) {
        mainBuilder.saveFrom(svName,save);
        return this;
    }

    public ListNumberApplicationBuilder unknownFrom(NumberCommandFactory onUnknown) {
        mainBuilder.unknownFrom(onUnknown);
        return this;
    }

    public NumberApplication buildUpon(Scanner source, Map<String, Command> commands, Command onUnknown) {
        build(commands);
        return mainBuilder.buildUpon(source, commands, onUnknown);
    }

    public NumberApplication buildUpon(Scanner source, Map<String, Command> commands) {
        build(commands);
        return mainBuilder.buildUpon(source, commands);
    }
}
