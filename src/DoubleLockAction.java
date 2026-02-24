public class DoubleLockAction extends Action{

    public DoubleLockAction() {

        super(12,2);

    }

    @Override
    void execute(Game game, PlayerPoker player) {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");

            return;

        }


        Middle middle = game.getMiddle();


        middle.show();


        System.out.println("Select first card index to DOUBLE LOCK:");

        int first = game.getScanner().nextInt();


        System.out.println("Select second card index to DOUBLE LOCK:");

        int second = game.getScanner().nextInt();



        // validate index

        if(first < 0 || first >= middle.size()
                || second < 0 || second >= middle.size()) {

            System.out.println("Invalid index.");

            return;

        }


        // prevent same index

        if(first == second) {

            System.out.println("Cannot select same card.");

            return;

        }


        // prevent hidden

        if(middle.isHidden(first) || middle.isHidden(second)) {

            System.out.println("Cannot double lock hidden card.");

            return;

        }


        // prevent already locked

        if(middle.isLocked(first) || middle.isLocked(second)) {

            System.out.println("One of the cards is already locked.");

            return;

        }


        // ⭐ apply DOUBLE LOCK

        middle.doubleLockCard(first);

        middle.doubleLockCard(second);

        System.out.println("DOUBLE LOCK applied successfully.");

    }

    @Override
    String setName() {

        return "Double Lock";

    }

}