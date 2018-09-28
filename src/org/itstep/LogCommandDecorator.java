package org.itstep;

import java.io.Writer;
import java.util.List;

public class LogCommandDecorator implements Command {
    private final Command origin;
    private final String name;
    private final Writer writer;
    private final List<Integer> lst;

    public LogCommandDecorator(Command origin, String name, Writer writer, List<Integer> lst) {
        this.origin = origin;
        this.name   = name;
        this.writer = writer;
        this.lst    = lst;
    }

    @Override
    public void exec() throws Exception {
        writer.write(name+"\n");
        writer.write("before: "+lst.toString()+"\n");
        origin.exec();
        writer.write("after: "+lst.toString()+"\n");
    }
}