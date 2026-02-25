public class LimitedActionsCondition extends SpecialCondition{

    @Override
    String setName() {
        return "Limited Actions";
    }

    @Override
    public void apply(Game game,PlayerPoker player) {

        for(ActionTai actionTai : player.getActions()) {

            // ยกเว้น ChangeConditionAction

            if(actionTai instanceof ChageConditionActionTai) {

                continue;
            }

            actionTai.decreaseMaxUse(1);

        }

        System.out.println("All actions usage reduced by 1.");

    }
}
