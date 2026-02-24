import java.util.Scanner;

public class ResetMidAction extends Action{

    public ResetMidAction() {
        super(18,1);
    }

    @Override
    String setName() {
        return "Reset Middle";
    }

    @Override
    void execute(Game game, PlayerPoker player)  {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");
            return;

        }

        Middle middle = game.getMiddle();

        int size = middle.size();

        for(int i = 0; i < size; i++) {

            if(!middle.isLocked(i)) {

                middle.setCard(i, game.drawCard());

            }

        }

        System.out.println("Middle cards have been reset.");
    }
}