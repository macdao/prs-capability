package training;


import com.google.common.base.Optional;

public class DefaultGameRule implements GameRule {
    @Override
    public Optional<String> say(int index) {
        return Optional.of(String.valueOf(index));
    }
}
