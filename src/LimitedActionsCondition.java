public class LimitedActionsCondition extends SpecialCondition{

    @Override
    String setName() {
        return "Limited Actions";
    }

    @Override
    public void apply(Game game,PlayerPoker player) {

        for(Action action : player.getActions()) {

            // ยกเว้น ChangeConditionAction

            if(action instanceof ChageConditionAction) {

                continue;
            }

            action.decreaseMaxUse(1);

        }

        System.out.println("All actions usage reduced by 1.");

    }
}
