package training;

public class Student {
    private final FizzGame fizzGame;
    private final int index;

    public Student(FizzGame fizzGame, int index) {
        this.fizzGame = fizzGame;
        this.index = index;
    }

    public String say() {
        if (index % fizzGame.getNumber1() == 0) {
            return "Fizz";
        } else if (index % fizzGame.getNumber2() == 0) {
            return "Buzz";
        } else if (index % fizzGame.getNumber3() == 0) {
            return "Whizz";
        } else {
            return String.valueOf(index);
        }
    }
}
