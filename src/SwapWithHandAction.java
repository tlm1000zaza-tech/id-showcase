public class SwapWithHandAction extends Action {

    public SwapWithHandAction() {

        super(12, 2);

    }

    @Override
    public void execute(Game game, PlayerPoker player)  {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");
            return;

        }


        Middle middle = game.getMiddle();

        Hand hand = player.getHand();


        System.out.println("\n--- MIDDLE ---");

        middle.show();


        System.out.println("\n--- HAND ---");

        hand.showHand();


        System.out.println("Select middle card index:");

        int middleIndex = game.getScanner().nextInt();


        System.out.println("Select hand card index:");

        int handIndex = game.getScanner().nextInt();



        // validate index

        if(middleIndex < 0 || middleIndex >= middle.size()) {

            System.out.println("Invalid middle index.");
            return;

        }

        if(handIndex < 0 || handIndex >= hand.size()) {

            System.out.println("Invalid hand index.");
            return;

        }



        // block LOCKED

        if(middle.isLocked(middleIndex)) {

            System.out.println("This middle card is LOCKED.");
            return;

        }


        // ⭐ block HIDDEN

        if(middle.isHidden(middleIndex)) {

            System.out.println("This middle card is HIDDEN.");
            return;

        }



        // swap safely

        Card middleCard = middle.getCard(middleIndex);

        Card handCard = hand.getCard(handIndex);


        middle.setCard(middleIndex, handCard);

        hand.setCard(handIndex, middleCard);


        System.out.println("Swap completed successfully.");

    }

    @Override
    String setName() {

        return "Swap With Hand";

    }

}