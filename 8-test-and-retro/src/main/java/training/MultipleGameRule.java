package training;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.google.common.base.Optional.of;

public class MultipleGameRule implements GameRule {

    private GameInput gameInput;

    public MultipleGameRule(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    private static List<Optional<String>> cache = ImmutableList.of(Optional.<String>absent(),
            of("Fizz"), of("Buzz"), of("FizzBuzz"), of("Whizz"), of("FizzWhizz"), of("BuzzWhizz"), of("FizzBuzzWhizz"));

    @Override
    public Optional<String> say(int index) {
        int flag = 0;

        if (index % gameInput.getNumber1() == 0) {
            flag += 0b1;
        }

        if (index % gameInput.getNumber2() == 0) {
            flag += 0b10;
        }

        if (index % gameInput.getNumber3() == 0) {
            flag += 0b100;
        }

        return cache.get(flag);
    }
}
