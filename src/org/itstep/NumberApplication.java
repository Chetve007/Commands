package org.itstep;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumberApplication extends AbstractCommandAplication {
    private List<Integer> numbers;

    public NumberApplication(
            Scanner source, Map<String, Command> commands, Command onUnknownCommand, List<Integer> numbers) {
        super(source, commands, onUnknownCommand);
        this.numbers = numbers;
    }

    public NumberApplication(Scanner source, Map<String, Command> commands, List<Integer> numbers) {
        super(source, commands);
        this.numbers = numbers;
    }
}
