package training;

public class Student {
    private final FizzGame fizzGame;
    private final int index;

    public Student(FizzGame fizzGame, int index) {
        this.fizzGame = fizzGame;
        this.index = index;
    }

    public String say() {
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
            return sb.toString();
        }

        return String.valueOf(index);
    }
}
