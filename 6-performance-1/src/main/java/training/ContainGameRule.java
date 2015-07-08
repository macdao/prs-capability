package training;

import com.google.common.base.Optional;

public class ContainGameRule implements GameRule {
    private final GameInput gameInput;

    public ContainGameRule(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    @Override
    public Optional<String> say(int index) {
        if (String.valueOf(index).contains(String.valueOf(gameInput.getNumber1()))) {
            return Optional.of("Fizz");
        }
        return Optional.absent();
    }
}
