package training;

import com.google.common.collect.Lists;

import java.util.List;

public class FizzGameMain {
    public static void main(String[] args) {
        final GameInput gameInput = new GameInput(3, 5, 7);
        final List<GameRule> rules = Lists.newArrayList(new ContainGameRule(gameInput), new MultipleGameRule(gameInput), new DefaultGameRule());
        for (int i = 1; i <= 100; i++) {
            System.out.println(new Student(rules, i).say());
        }
    }
}
