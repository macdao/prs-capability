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
            return getOf(sb.toString());
        }

        return Optional.absent();
    }

    public static final Map<String, Optional<String>> cache = new ConcurrentHashMap<>();

    private Optional<String> getOf(String sb) {
        if (cache.containsKey(sb)) {
            return cache.get(sb);
        }
        final Optional<String> of = Optional.of(sb);
        cache.put(sb, of);
        return of;
    }
}
