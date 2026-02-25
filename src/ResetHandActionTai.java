public class ResetHandActionTai extends ActionTai {

    public ResetHandActionTai() {
        super(12, 3);
    }

    @Override
    String setName() {
        return "Reset Hand";
    }

    @Override
    void execute(Game game, PlayerPoker player) {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");
            return;

        }

        Hand hand = player.getHand();

        int drawCount = game.getHandSixeLimit();

        if(drawCount <= 0) {

            System.out.println("Invalid hand size limit.");
            return;

        }

        if(game.getDeck().size() < drawCount) {

            System.out.println("Not enough cards in deck.");
            return;

        }

        hand.clear();

        for(int i = 0; i < drawCount; i++) {

            hand.addCard(game.drawCard());

        }

        System.out.println("Player hand has been reset.");

        hand.showHand();

    }

}