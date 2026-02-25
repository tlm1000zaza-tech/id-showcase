public class PeekNextCardActionTai extends ActionTai {

    public PeekNextCardActionTai() {

        super(5, 3);

    }

    @Override
    void execute(Game game, PlayerPoker player, int index)  {

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