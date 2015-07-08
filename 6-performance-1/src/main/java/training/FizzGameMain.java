package training;

import com.google.common.base.Predicate;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.parseInt;

public class FizzGameMain {
    public static void main(String[] args) {
        if (args.length != 3 || isNotValid(args)) {
            System.err.println("invalid input");
            System.exit(1);
        }
        final GameInput gameInput = new GameInput(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]));
        final List<GameRule> rules = newArrayList(new ContainGameRule(gameInput), new MultipleGameRule(gameInput), new DefaultGameRule());
        for (int i = 1; i <= 100; i++) {
            System.out.println(new Student(rules, i).say());
        }
    }

    private static boolean isNotValid(String[] args) {
        return any(Arrays.asList(args), new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return !input.matches("[1-9]");
            }
        });
    }
}
