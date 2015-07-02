package training;


import com.google.common.collect.Lists;

import java.util.List;

public class FizzGame {
    private final int number1;
    private final int number2;
    private final int number3;

    public FizzGame(int number1, int number2, int number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }

    public static void main(String[] args) {
        final FizzGame fizzGame = new FizzGame(3, 5, 7);
        final List<GameRule> rules = Lists.newArrayList(new MultipleGameRule(fizzGame), new DefaultGameRule());
        for (int i = 1; i <= 100; i++) {
            System.out.println(new Student(rules, i).say());
        }
    }
}
