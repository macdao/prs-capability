package training;

import com.google.common.base.Optional;

import java.util.List;

public class CompositeGameRule implements GameRule {
    private List<GameRule> rules;

    public CompositeGameRule(List<GameRule> rules) {
        this.rules = rules;
    }

    public Optional<String> say(int index) {
        for (GameRule rule : rules) {
            final Optional<String> result = rule.say(index);
            if (result.isPresent()) {
                return result;
            }
        }

        return Optional.absent();
    }
}
