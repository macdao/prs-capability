package training;

import com.google.common.base.Optional;

public class MultipleGameRule implements GameRule {

    private FizzGame fizzGame;

    public MultipleGameRule(FizzGame fizzGame) {
        this.fizzGame = fizzGame;
    }

    @Override
    public Optional<String> say(int index) {
        final StringBuilder sb = new StringBuilder();

        if (index % fizzGame.getNumber1() == 0) {
            sb.append("Fizz");
        }

        if (index % fizzGame.getNumber2() == 0) {
            sb.append("Buzz");
        }

        if (index % fizzGame.getNumber3() == 0) {
            sb.append("Whizz");
        }

        if (sb.length() != 0) {
            return Optional.of(sb.toString());
        }

        return Optional.absent();
    }
}
