package training;

import com.google.common.base.Optional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MultipleGameRule implements GameRule {

    private GameInput gameInput;

    public MultipleGameRule(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    @Override
    public Optional<String> say(int index) {
//        final StringBuilder sb = new StringBuilder();
        int i = 0;

        if (index % gameInput.getNumber1() == 0) {
            i = i | 0b1;
        }

        if (index % gameInput.getNumber2() == 0) {
            i = i | 0b10;
        }

        if (index % gameInput.getNumber3() == 0) {
            i = i | 0b100;
        }

        if (i != 0) {
            return getOf(i);
        }

        return Optional.absent();
    }

    private static final Optional<String>[] cache = new Optional[8];

    static {
        cache[0b1] = Optional.of("Fizz");
        cache[0b10] = Optional.of("Buzz");
        cache[0b100] = Optional.of("Whizz");
        cache[0b11] = Optional.of("FizzBuzz");
        cache[0b101] = Optional.of("FizzWhizz");
        cache[0b110] = Optional.of("BuzzWhizz");
        cache[0b111] = Optional.of("FizzBuzzWhizz");
    }

    private Optional<String> getOf(int sb) {
        return cache[sb];
    }
}
