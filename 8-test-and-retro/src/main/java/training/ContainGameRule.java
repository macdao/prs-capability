package training;

import com.google.common.base.Optional;

import static com.google.common.base.Strings.repeat;

public class ContainGameRule implements GameRule {
    private final GameInput gameInput;

    public ContainGameRule(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    @Override
    public Optional<String> say(int index) {
        int amount = contain(index);

        if (amount == 0) {
            return Optional.absent();
        }

        return Optional.of(repeat("Fizz", amount));
    }

    private int contain(int index) {
        int count = 0;
        while (index > 0) {
            if (index % 10 == gameInput.getNumber1()) {
                count++;
            }
            index = index / 10;
        }
        return count;
    }
}
