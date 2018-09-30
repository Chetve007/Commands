package org.itstep;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GenerateNumbersCommand implements Command {
    private final List<Integer> numbers;
    private final int howMany, bound;



    public GenerateNumbersCommand(List<Integer> numbers, int howMany, int bound) {

        System.out.println("Введите количество генерируемых чисел: ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if(i >= 0)

        {
            howMany = i;
            System.out.println("Сгенерировано число: " + i);
        }
        else

        {
            System.out.println("Вы ввели не корректное число, сгенерировано по умолчанию 1000");
            howMany = 1000;
        }

        this.numbers = numbers;
        this.howMany = howMany;
        this.bound = bound;

    }

    @Override
    public void exec() throws Exception {
        Random r = new Random();
        numbers.clear();
        for (int pos = 0; pos != howMany; ++pos)
            numbers.add(r.nextInt(bound));
    }





}