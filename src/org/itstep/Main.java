package org.itstep;

import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        try(Scanner sc = new Scanner(System.in)) {
            PrintWriter sysout = new PrintWriter(System.out);
            Map<String,Command> commands = new HashMap<>();
            NumberApplicationExtendedBuilder numAppBuilder = new NumberApplicationExtendedBuilder(new ArrayList<>());

            AbstractCommandAplication app = numAppBuilder
                    .listFrom("list", new ListNumbersCommandFactory(sysout,100))
                    .generateFrom("generate", new GenerateNumbersCommandFactory(1000, 1000))
                    .sortFrom("sort", new SortNumbersCommandFactory(sysout))
                    .saveFrom("save", new SaveNumbersCommandFactory(new File("./numbers.txt")))

                    .buildUpon(sc, commands, () -> System.out.println("Неизвестная команда повторите ввод"));

            commands.put("exit",()->app.stop());

            app.loop();
        }
    }
}
