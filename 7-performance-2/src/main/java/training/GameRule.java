package training;

import com.google.common.base.Optional;

public interface GameRule {
    Optional<String> say(int index);
}
