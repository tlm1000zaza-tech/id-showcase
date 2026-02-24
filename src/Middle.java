import java.util.ArrayList;
import java.util.List;

// ========================================
// Middle Class
// ใช้แทน "กองไพ่กลาง"
// รองรับ:
// - Lock
// - Double Lock
// - Hidden
// - Replace / Swap / Copy
// - Perfect Reset
// - Condition effects
// ========================================

public class Middle {

    // ========================================
    // FIELD
    // ========================================

    // ไพ่ในกองกลาง
    private ArrayList<Card> cards;

    // lock จาก action LockMidCardAction
    private boolean[] locked;

    // lock จาก DoubleLockAction
    private boolean[] doubleLocked;

    // hidden จาก HiddenMiddleCondition
    private boolean[] hidden;


    // ========================================
    // CONSTRUCTOR
    // ========================================

    public Middle(int maxSize) {

        cards = new ArrayList<>();

        locked = new boolean[maxSize];
        doubleLocked = new boolean[maxSize];
        hidden = new boolean[maxSize];

    }


    // ========================================
    // BASIC INFO
    // ========================================

    public int size() {

        return cards.size();

    }


    public Card getCard(int index) {

        return cards.get(index);

    }


    public ArrayList<Card> getCards() {

        return cards;

    }


    // ========================================
    // PLACE CARD (ใช้ตอนเริ่มเกม)
    // ========================================

    public void placeCard(Card card) {

        cards.add(card);

//        RemoteEvent.Event().fireEvent(Remote.MIDDLESHOW_CHANNEL , (card.toString() + statusget(cards.indexOf(card))));
//        RemoteEvent.Event().fireEvent(Remote.MIDDLESHOW_CHANNEL , (card.toString()));

    }


    // ========================================
    // CLEAR ALL
    // ใช้ตอนเริ่ม level ใหม่
    // ========================================

    public void clear() {

        cards.clear();

        resetAllStates();

    }


    // ========================================
    // LOCK SYSTEM
    // ========================================

    public void lockCard(int index) {

        if(validIndex(index)) {

            locked[index] = true;

            cards.get(index).setLocked(true);

        }

    }


    public void doubleLockCard(int index) {

        if(validIndex(index)) {

            locked[index] = true;
            doubleLocked[index] = true;

            cards.get(index).setLocked(true);

        }

    }


    public boolean isLocked(int index) {

        if(validIndex(index)) {

            return locked[index];

        }

        return false;

    }


    public boolean isDoubleLocked(int index) {

        if(validIndex(index)) {

            return doubleLocked[index];

        }

        return false;

    }


    // ========================================
    // HIDDEN SYSTEM
    // ========================================

    public void hideCard(int index) {

        if(validIndex(index)) {

            hidden[index] = true;

            cards.get(index).setHidden(true);

        }

    }


    public boolean isHidden(int index) {

        if(validIndex(index)) {

            return hidden[index];

        }

        return false;

    }


    public void resetHidden() {

        for(int i = 0; i < hidden.length; i++) {

            hidden[i] = false;

        }

        for(Card card : cards) {

            card.setHidden(false);

        }

    }


    // ========================================
    // SAFE SET CARD
    // ใช้โดย:
    // Replace
    // Swap
    // Copy
    // ResetMiddle
    // ========================================

    public void setCard(int index, Card card) {

        if(!validIndex(index)) {

            System.out.println("Invalid index");

        }

        if(doubleLocked[index]) {

            System.out.println("Card is DOUBLE LOCKED");

        }

        if(locked[index]) {

            System.out.println("Card is LOCKED");

        }

        cards.set(index, card);

    }


    // ========================================
    // FORCE SET CARD
    // ใช้โดย PerfectReset เท่านั้น
    // bypass lock และ hidden ทั้งหมด
    // ========================================

    public void forceSetCard(int index, Card card) {

        if(validIndex(index)) {

            cards.set(index, card);

            locked[index] = false;
            doubleLocked[index] = false;
            hidden[index] = false;

            card.resetState();

        }

    }


    // ========================================
    // RESET LOCK จาก condition reset
    // ========================================

    public void resetConditionLock() {

        for(int i = 0; i < locked.length; i++) {

            locked[i] = false;
            doubleLocked[i] = false;

        }

        for(Card card : cards) {

            card.setLocked(false);

        }

    }


    // ========================================
    // RESTORE SIZE (ใช้กับ LimitedRevealCondition)
    // ========================================

    public void restoreToMaxSize(Game game)  {

        while(cards.size() < game.getMaxMiddleCards()) {

            cards.add(game.drawCard());

        }

    }


    // ========================================
    // DISPLAY
    // ========================================

    public void show() {
        System.out.println("\n--- MIDDLE ---");
        List<String> stringsshow = new ArrayList<>();

        for(int i = 0; i < cards.size(); i++) {

            String status = "";

            if(doubleLocked[i]) {

                status = " [DOUBLE LOCK]";

            }
            else if(locked[i]) {

                status = " [LOCK]";

            }
            System.out.println("[CARD] " + cards.get(i).isHidden());
            System.out.println("[HIDDEN ?] " + cards.get(i).isHidden());
            System.out.println("[LOCKED ?] " + cards.get(i).isLocked());

            System.out.println(i + ": " + cards.get(i) + status);

            stringsshow.add(cards.get(i) + status);
        }
        RemoteEvent.Event().fireEvent(Remote.MIDDLESHOW_CHANNEL, stringsshow);
    }

    private String statusget(int i) {
        String status = "";

        if(doubleLocked[i]) {

            status = " [DOUBLE LOCK]";

        }
        else if(locked[i]) {

            status = " [LOCK]";

        }

        return  status;
    }


    // ========================================
    // PRIVATE HELPER
    // ========================================

    private boolean validIndex(int index) {

        return index >= 0 && index < cards.size();

    }


    private void resetAllStates() {

        for(int i = 0; i < locked.length; i++) {

            locked[i] = false;
            doubleLocked[i] = false;
            hidden[i] = false;

        }

    }

}
