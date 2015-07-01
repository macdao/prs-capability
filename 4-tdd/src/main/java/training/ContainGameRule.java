package training;


import com.google.common.base.Optional;

public class ContainGameRule implements GameRule {
    private final int number;

    public ContainGameRule(int number) {

        this.number = number;
    }

    @Override
    public Optional<String> say(int index) {
        if (String.valueOf(index).contains(String.valueOf(number))) {
            return Optional.of("Fizz");
        }
        return Optional.absent();
    }
}
