package training;

import com.google.common.base.Predicate;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.Arrays.copyOf;

public class FizzGameMain {
    public static void main(String[] args) throws Exception {
        if (isInvalidLength(args) || isInvalidSpecialNumber(args)) {
            System.err.println("invalid input");
            System.exit(1);
        }
        final GameInput gameInput = new GameInput(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]));
        final List<GameRule> rules = newArrayList(new ContainGameRule(gameInput), new MultipleGameRule(gameInput), new DefaultGameRule());

        PrintStream out;
        if (args.length == 4) {
            out = new PrintStream(new FileOutputStream(args[3]));
        } else {
            out = System.out;
        }
        for (int i = 1; i <= 100; i++) {
            out.println(new CompositeGameRule(rules).say(i).get());
        }
    }

    private static boolean isInvalidLength(String[] args) {
        return args.length != 3 && args.length != 4;
    }

    private static boolean isInvalidSpecialNumber(String[] args) {
        return any(asList(copyOf(args, 3)), new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return !input.matches("[1-9]");
            }
        });
    }
}
