package org.itstep;

import java.io.Writer;
import java.util.List;

public class LogCommandDecoratorFactory implements NumberCommandFactory {
    private final NumberCommandFactory factory;
    private final String name;
    private final Writer writer;

    public LogCommandDecoratorFactory(NumberCommandFactory factory, String name, Writer writer) {
        this.factory = factory;
        this.writer  = writer;
        this.name    = name;
    }

    @Override
    public Command construct(List<Integer> lst) {
        return new LogCommandDecorator(factory.construct(lst),name,writer,lst);
    }
}
