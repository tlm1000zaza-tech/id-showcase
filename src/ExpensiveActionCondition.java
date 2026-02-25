public class ExpensiveActionCondition extends SpecialCondition{

    @Override
    String setName() {
        return "Expensive Actions (+2 cost)";
    }

    @Override
    public void apply(Game game, PlayerPoker player) {

        for(ActionTai actionTai : player.getActions()) {

            actionTai.addExtraCost(2);

        }

        System.out.println("All action costs increased by 2.");

    }
}
