import java.util.Random;

public class FragileMiddleCondition extends SpecialCondition {

    @Override
    String setName() {
        return "Fragile Middle (1 card locked)";
    }

    @Override
    public void apply(Game game, PlayerPoker player) {

        Middle middle = game.getMiddle();

        Random r = new Random();

        int index = r.nextInt(middle.size());

        middle.lockCard(index);

        System.out.println("Fragile lock applied at index " + index);

    }

}