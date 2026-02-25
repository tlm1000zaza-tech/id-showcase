public class EmergencyDrawActionTai extends ActionTai {

    public EmergencyDrawActionTai() {

        super(14,2);

    }

    @Override
    void execute(Game game, PlayerPoker player, int index) {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");

            return;

        }


        Hand hand = player.getHand();


        if(hand.size() == 0) {

            System.out.println("No cards in hand.");

            return;

        }


        // ✅ ใช้ game.drawCard เพื่อรองรับ LuckyDraw

        Card draw1 = game.drawCard();

        Card draw2 = game.drawCard();


        System.out.println("\nYou drew:");

        System.out.println("0: " + draw1);

        System.out.println("1: " + draw2);



        System.out.println("\nSelect card to keep:");

        int choice = game.getScanner().nextInt();


        Card selected;

        Card discardedFromDraw;


        if(choice == 0) {

            selected = draw1;

            discardedFromDraw = draw2;

        }
        else if(choice == 1) {

            selected = draw2;

            discardedFromDraw = draw1;

        }
        else {

            System.out.println("Invalid choice.");

            return;

        }


        // discard unused draw

        System.out.println("Discarded: " + discardedFromDraw);



        // show hand

        System.out.println("\nYour hand:");

        hand.showHand();



        System.out.println("\nSelect hand index to discard:");

        int discardIndex = game.getScanner().nextInt();


        if(discardIndex < 0 || discardIndex >= hand.size()) {

            System.out.println("Invalid index.");

            return;

        }

        Card oldCard = hand.getCard(discardIndex);

        hand.setCard(discardIndex, selected);

        System.out.println("\nReplaced: " + oldCard + " → " + selected);

    }

    @Override
    String setName() {

        return "Emergency Draw";

    }

}