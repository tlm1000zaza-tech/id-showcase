public class PeekNextCardAction extends Action {

    public PeekNextCardAction() {

        super(5, 3);

    }

    @Override
    void execute(Game game, PlayerPoker player)  {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");
            return;

        }

        Deck deck = game.getDeck();

        if(deck.size() == 0) {

            System.out.println("Deck is empty.");
            return;

        }

        Card original = deck.peekTopCard();

        Card preview = game.processDrawnCard(original);

        System.out.println("Next card is: " + preview);

    }

    @Override
    String setName() {

        return "Peek Next Card";

    }

}