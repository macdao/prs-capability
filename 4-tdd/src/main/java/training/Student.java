package training;

import com.google.common.base.Optional;

import java.util.List;

public class Student {
    private List<GameRule> rules;
    private final int index;

    public Student(List<GameRule> rules, int index) {
        this.rules = rules;
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
