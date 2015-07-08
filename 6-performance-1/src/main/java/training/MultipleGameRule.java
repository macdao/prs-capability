package training;

import com.google.common.base.Optional;

public class MultipleGameRule implements GameRule {

    private GameInput gameInput;

    public MultipleGameRule(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    @Override
    public Optional<String> say(int index) {
        final StringBuilder sb = new StringBuilder();

        if (index % gameInput.getNumber1() == 0) {
            sb.append("Fizz");
        }

        if (index % gameInput.getNumber2() == 0) {
            sb.append("Buzz");
        }

        if (index % gameInput.getNumber3() == 0) {
            sb.append("Whizz");
        }

        if (sb.length() != 0) {
            return Optional.of(sb.toString());
        }

        return Optional.absent();
    }
}
