public class PerfectResetActionTai extends ActionTai {

    public PerfectResetActionTai() {

        super(25,1);

    }

    @Override
    void execute(Game game, PlayerPoker player, int index) {

        Middle middle = game.getMiddle();
        Hand hand = player.getHand();
        Deck deck = game.getDeck();

        System.out.println("\n--- PERFECT RESET ACTIVATED ---");


        // =========================
        // RESET MIDDLE
        // =========================

        for(int i = 0; i < middle.size(); i++) {

            middle.forceSetCard(i, deck.drawCard());

        }


        // =========================
        // RESET HAND
        // =========================

        hand.clear();

        // ⭐ FIX ตรงนี้
        int drawCount = game.getHandSixeLimit();

        for(int i = 0; i < drawCount; i++) {

            hand.addCard(game.drawCard());

        }


        System.out.println("All cards reset. Locks removed.");

    }

    @Override
    String setName() {

        return "Perfect Reset";

    }

}