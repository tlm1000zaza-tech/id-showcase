import java.util.Random;

public class HiddenMiddleCardCondition extends SpecialCondition{

    private Random random = new Random();

    @Override
    String setName() {
        return "Hidden Middle Card";
    }

    @Override
    public void apply(Game game, PlayerPoker player) {

        Middle middle = game.getMiddle();

        if(middle.size() == 0) {

            return;

        }

        int index = random.nextInt(middle.size());

        middle.hideCard(index);


        System.out.println("Middle card " + index + " is now hidden.");

    }
}
