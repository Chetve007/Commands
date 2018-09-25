package org.itstep;

import java.util.Map;
import java.util.Scanner;

abstract public class AbstractCommandAplication {
    private Scanner source;
    private Map<String,Command> commands;
    private Command onUnknownCommand;
    private boolean proceed;

    protected Command putCommand(String name,Command cmd) {
        return commands.put(name,cmd);
    }


    public AbstractCommandAplication(Scanner source, Map<String, Command> commands, Command onUnknownCommand) {
        this.source          = source;
        this.commands        = commands;
        this.onUnknownCommand = onUnknownCommand;
    }

    public AbstractCommandAplication(Scanner source, Map<String, Command> commands) {
        this(source,commands,()->{throw new Exception("Unknown command");});
    }

    public void loop() throws Exception {
        proceed = true;
        do {
            commands.getOrDefault(source.next(),onUnknownCommand).exec();
        } while (proceed);
    }

    public void stop() {
        proceed = false;
    }
}
