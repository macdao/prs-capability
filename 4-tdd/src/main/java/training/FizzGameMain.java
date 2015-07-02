package training;

import com.google.common.collect.Lists;

import java.util.List;

public class FizzGameMain {
    public static void main(String[] args) {
        final int number1 = Integer.parseInt(args[0]);
        final int number2 = Integer.parseInt(args[1]);
        final int number3 = Integer.parseInt(args[2]);

        final GameInput gameInput = new GameInput(number1, number2, number3);
        final List<GameRule> rules = Lists.newArrayList(new ContainGameRule(gameInput.getNumber1()), new MultipleGameRule(gameInput), new DefaultGameRule());
        for (int i = 1; i <= 100; i++) {
            System.out.println(new Student(rules, i).say());
        }
    }
}
