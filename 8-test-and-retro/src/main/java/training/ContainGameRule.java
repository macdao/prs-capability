package training;

import com.google.common.base.Optional;

public class ContainGameRule implements GameRule {
    private final GameInput gameInput;

    public ContainGameRule(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    @Override
    public Optional<String> say(int index) {
        if (isContains(index)) {
            return Optional.of("Fizz");
        }
        return Optional.absent();
    }

    private boolean isContains(int index) {
        while (index > 0) {
            if (index % 10 == gameInput.getNumber1()) {
                return true;
            }
            index = index / 10;
        }
        return false;
    }
}
