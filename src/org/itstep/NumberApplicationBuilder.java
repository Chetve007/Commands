package org.itstep;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumberApplicationBuilder {
    private NumberCommandFactory generate, sort, save, onUnknown;
    private String genName, srtName, svName;
    private List<Integer> lst;

    private void build(Map<String,Command> commands) {
        if (null == generate || null == genName || null == sort || null == srtName || null == save || null == svName)
            throw new IllegalStateException("Not all commands set");
        commands.put(genName,generate.construct(lst));
        commands.put(srtName,sort.construct(lst));
        commands.put(svName,save.construct(lst));
    }

    public NumberApplicationBuilder(List<Integer> lst) {
        this.lst = lst;
    }

    public NumberApplicationBuilder generateFrom(String genName, NumberCommandFactory generate) {
        this.genName  = genName;
        this.generate = generate;
        return this;
    }

    public NumberApplicationBuilder sortFrom(String srtName, NumberCommandFactory sort) {
        this.srtName = srtName;
        this.sort    = sort;
        return this;
    }

    public NumberApplicationBuilder saveFrom(String svName, NumberCommandFactory save) {
        this.svName = svName;
        this.save   = save;
        return this;
    }

    public NumberApplicationBuilder unknownFrom(NumberCommandFactory onUnknown) {
        this.onUnknown = onUnknown;
        return this;
    }

    public NumberApplication buildUpon(Scanner source, Map<String,Command> commands, Command onUnknown) {
        build(commands);
        return new NumberApplication(source,commands,onUnknown,lst);
    }

    public NumberApplication buildUpon(Scanner source, Map<String,Command> commands) {
        build(commands);
        return null != onUnknown
                ? new NumberApplication(source,commands,onUnknown.construct(lst),lst)
                : new NumberApplication(source,commands,lst);
    }
}
