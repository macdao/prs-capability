package training;

import com.google.common.base.Optional;

import java.util.List;

public class CompositeGameRule implements GameRule {
    private List<GameRule> rules;
    private GameRule defaultGameRule;

    public CompositeGameRule(List<GameRule> rules, GameRule defaultGameRule) {
        this.rules = rules;
        this.defaultGameRule = defaultGameRule;
    }

    public Optional<String> say(int index) {
        final StringBuilder result = new StringBuilder();
        for (GameRule rule : rules) {
            final Optional<String> say = rule.say(index);
            result.append(say.or(""));
        }

        if (result.length() != 0) {
            return Optional.of(result.toString());
        }

        return defaultGameRule.say(index);
    }
}
