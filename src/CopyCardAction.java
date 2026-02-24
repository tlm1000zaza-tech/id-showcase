public class CopyCardAction extends Action {

    public CopyCardAction() {

        super(20, 1);

    }

    @Override
    String setName() {

        return "Copy Card";

    }

    @Override
    void execute(Game game, PlayerPoker player)  {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");
            return;

        }

        Middle middle = game.getMiddle();

        System.out.println("Select source index:");
        int source = game.getScanner().nextInt();

        System.out.println("Select target index:");
        int target = game.getScanner().nextInt();


        // validate index

        if(source < 0 || source >= middle.size()
                || target < 0 || target >= middle.size()) {

            System.out.println("Invalid index.");
            return;

        }


        // block hidden source

        if(middle.isHidden(source)) {

            System.out.println("Cannot copy hidden card.");
            return;

        }


        // block locked target

        if(middle.isLocked(target)) {

            System.out.println("Target card is locked.");
            return;

        }


        Card original = middle.getCard(source);


        Card copy = new Card(

                original.getType(),
                original.getRank()

        );


        middle.setCard(target, copy);
        System.out.println("Copied successfully.");

    }

}