public class WeakHandCondition extends SpecialCondition {

    @Override
    String setName() {
        return "Weak Hand (Start with 1 card)";
    }

    @Override
    public void apply(Game game, PlayerPoker player)  {

        // ตั้ง limit
        game.setHandSizeLimit(1);

        // ล้างมือ
        player.getHand().clear();

        // draw ผ่าน Game system
        player.getHand().addCard(game.drawCard());

        System.out.println("Player starts with only 1 card.");

    }

}