package training;

import com.google.common.collect.Lists;

import java.util.List;

public class FizzGameMain {
    public static void main(String[] args) {
        final FizzGame fizzGame = new FizzGame(3, 5, 7);
        final List<GameRule> rules = Lists.newArrayList(new MultipleGameRule(fizzGame), new DefaultGameRule());
        for (int i = 1; i <= 100; i++) {
            System.out.println(new Student(rules, i).say());
        }
    }
}
