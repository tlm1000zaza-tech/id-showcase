public class ChageConditionAction extends Action {

    public ChageConditionAction() {

        super(15, 1);

    }

    @Override
    String setName() {
        return "Change Condition";
    }

    @Override
    void execute(Game game, PlayerPoker player) throws Exception {

        if(game.getActiveConditions().isEmpty()) {

            System.out.println("No condition to change.");
            return;

        }

        System.out.println("\n=== CHANGE CONDITION ===");

        for(int i = 0; i < game.getActiveConditions().size(); i++) {

            System.out.println(i + ": " +
                    game.getActiveConditions().get(i));

        }

        System.out.print("Select condition index to remove: ");

        int index = game.getScanner().nextInt();


        if(index < 0 ||
                index >= game.getActiveConditions().size()) {

            System.out.println("Invalid index.");
            return;

        }


        SpecialCondition removed =
                game.getActiveConditions().remove(index);


        System.out.println("Removed Condition: " + removed);


        // reset everything
        game.resetAllConditionEffects();


        SpecialCondition newCondition =
                game.getRandomCondition(removed);


        if(newCondition == null) {

            System.out.println("No new condition available");
            return;

        }


        game.getActiveConditions().add(newCondition);


        System.out.println("New Condition: " + newCondition);


        // apply all again
        for(SpecialCondition condition :
                game.getActiveConditions()) {

            condition.apply(game, player);

        }


        game.refillPlayerHand(player);
        System.out.println("Condition Changed Successfully.");

    }

}