import java.util.ArrayList;
import java.util.List;

public class FutureSightActionTai extends ActionTai {

    public FutureSightActionTai() {

        super(12,2);

    }

    @Override
    void execute(Game game, PlayerPoker player, int index)  {

        if(!canUse(game, player)) {

            System.out.println("Action already used this level.");

            return;

        }


        Deck deck = game.getDeck();


        System.out.println("Next 3 cards:");

        List<Card> list2send = new ArrayList<>();

        for(int i = 0; i < 3; i++) {

            Card original = deck.peek(i);


            if(original != null) {

                Card preview =
                        game.processDrawnCard(original);

                System.out.println(i + ": " + preview);
                list2send.add(preview);
            }

        }
        RemoteEvent.Event().fireEvent(Remote.FUTURE, list2send);
    }

    @Override
    String setName() {

        return "Future Sight";

    }

}