public class LimitedRevealCondition extends SpecialCondition {

    @Override
    String setName() {
        return "Limited Reveal";
    }

    @Override
    public void apply(Game game, PlayerPoker player) {

        game.setMaxMiddleCards(2);

        System.out.println("Reveal limited to 2 cards.");

    }

}