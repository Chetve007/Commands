package org.itstep;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        try(Scanner sc = new Scanner(System.in)) {
            PrintWriter sysout = new PrintWriter(System.out);
            Map<String,Command> commands = new HashMap<>();
            NumberApplicationBuilder numAppBuilder = new NumberApplicationBuilder(new ArrayList<>());

            Writer logFile = new FileWriter("./log.txt",true);
            logFile.write("New session: "+ new Date().toString()+System.lineSeparator());
            logFile.flush();


            AbstractCommandAplication app = numAppBuilder
                    .generateFrom(
                            "generate"
                            , new LogCommandDecoratorFactory(
                                    new GenerateNumbersCommandFactory(1000, 1000)
                                    , "generate"
                                    , logFile
                            )
                    )
                    .sortFrom(
                            "sort"
                            , new LogCommandDecoratorFactory(
                                    new SortNumbersCommandFactory(sysout)
                                    , "sort"
                                    , logFile
                            )
                    )
                    .saveFrom(
                            "save"
                            , new LogCommandDecoratorFactory(
                                    new SaveNumbersCommandFactory(new File("./numbers.txt"))
                                    , "save"
                                    , logFile
                            )
                    )
                    .buildUpon(sc, commands, () -> System.out.println("Неизвестная команда повторите ввод"));

            commands.put("exit",app::stop);

            app.loop();
        }
    }
}
