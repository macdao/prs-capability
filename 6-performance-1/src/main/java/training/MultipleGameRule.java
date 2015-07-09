package training;

import com.google.common.base.Optional;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MultipleGameRule implements GameRule {

    private GameInput gameInput;

    public static final Map<String, Optional<String>> cache = Collections.synchronizedMap(new HashMap<String, Optional<String>>());

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
            String key = sb.toString();
            final Optional<String> result;
            if (!cache.containsKey(key)) {
                result = Optional.of(key);
                cache.put(key, result);
            } else {
                result = cache.get(key);
            }
            return result;
        }

        return Optional.absent();
    }
}
