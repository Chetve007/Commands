package org.itstep;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReverseNumberApplicationBuilder {
    private final List<Integer> lst;
    private final NumberApplicationBuilder mainBuilder;
    private String revName;
    private NumberCommandFactory reverse;


    private void build(Map<String,Command> commands) {
        if (null == revName || null == reverse)
            throw new IllegalStateException("Reverse command not set");
        commands.put(revName,reverse.construct(lst));
    }

    public ReverseNumberApplicationBuilder(List<Integer> lst, NumberApplicationBuilder mainBuilder) {
        this.lst         = lst;
        this.mainBuilder = mainBuilder;
    }

    public ReverseNumberApplicationBuilder reverseFrom(String revName, NumberCommandFactory reverse) {
        this.revName = revName;
        this.reverse = reverse;
        return this;
    }

    public ReverseNumberApplicationBuilder generateFrom(String genName, NumberCommandFactory generate) {
        mainBuilder.generateFrom(genName,generate);
        return this;
    }

    public ReverseNumberApplicationBuilder sortFrom(String srtName, NumberCommandFactory sort) {
        mainBuilder.sortFrom(srtName,sort);
        return this;
    }

    public ReverseNumberApplicationBuilder saveFrom(String svName, NumberCommandFactory save) {
        mainBuilder.saveFrom(svName,save);
        return this;
    }

    public ReverseNumberApplicationBuilder unknownFrom(NumberCommandFactory onUnknown) {
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
