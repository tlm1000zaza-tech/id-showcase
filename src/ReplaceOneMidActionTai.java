public class ReplaceOneMidActionTai extends ActionTai {

    public ReplaceOneMidActionTai() {
        super(8, 3);
    }

    @Override
    String setName() {
        return "Replace One Middle Card";
    }

    @Override
//    void execute(Game game, PlayerPoker player, int index) {
//
//        if(!canUse(game, player)) {
//
//            System.out.println("Action already used this level.");
//            return;
//
//        }
//
//        Middle middle = game.getMiddle();
//
//        middle.show();
//
//        System.out.println("Select index:");
//
//        int index = game.getScanner().nextInt();
//
//
//        // check index
//        if(index < 0 || index >= middle.size()) {
//
//            System.out.println("Invalid index");
//            return;
//
//        }
//
//
//        // check lock
//        if(middle.isLocked(index)) {
//
//            System.out.println("This card is locked.");
//            return;
//
//        }
//
//
//        // check hidden
//        if(middle.isHidden(index)) {
//
//            System.out.println("This card is hidden.");
//            return;
//
//        }
//
//
//        Card newCard = game.drawCard();
//
//        middle.setCard(index, newCard);
//
//
//        System.out.println("Card replaced.");
//
//    }
    void execute(Game game, PlayerPoker player, int index) {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");
            return;

        }

        Middle middle = game.getMiddle();

        middle.show();

        System.out.println("Select index:");


        // check index
        if(index < 0 || index >= middle.size()) {

            System.out.println("Invalid index");
            return;

        }


        // check lock
        if(middle.isLocked(index)) {

            System.out.println("This card is locked.");
            return;

        }


        // check hidden
        if(middle.isHidden(index)) {

            System.out.println("This card is hidden.");
            return;

        }


        Card newCard = game.drawCard();

        middle.setCard(index, newCard);

        useCount++;


        System.out.println("Replace maxUse = " + maxUse);
        System.out.println("Card replaced.");

    }

}