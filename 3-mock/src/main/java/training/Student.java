package training;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import java.util.List;

public class Student {
    private List<GameRule> rules;
    private final int index;

    public Student(FizzGame fizzGame, int index) {
        this.rules = Lists.newArrayList(new MultipleGameRule(fizzGame), new DefaultGameRule());
        this.index = index;
    }

    public String say() {
        for (GameRule rule : rules) {
            final Optional<String> result = rule.say(index);
            if (result.isPresent()) {
                return result.get();
            }
        }

        throw new IllegalStateException();
    }
}
