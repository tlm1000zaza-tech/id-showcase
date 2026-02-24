public class ExpensiveActionCondition extends SpecialCondition{

    @Override
    String setName() {
        return "Expensive Actions (+2 cost)";
    }

    @Override
    public void apply(Game game, PlayerPoker player) {

        for(Action action : player.getActions()) {

            action.addExtraCost(2);

        }

        System.out.println("All action costs increased by 2.");

    }
}
