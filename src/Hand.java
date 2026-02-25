import java.util.ArrayList;
import java.util.List;

// ========================================
// Hand Class
// ใช้แทน "ไพ่ในมือผู้เล่น"
// รองรับ:
// - add card
// - replace card
// - clear hand
// - show hand
// ========================================

public class Hand {

    // ========================================
    // FIELD
    // ========================================

    // เก็บไพ่ในมือทั้งหมด
    private ArrayList<Card> cards;


    // ========================================
    // CONSTRUCTOR
    // ========================================

    public Hand() {

        cards = new ArrayList<>();

    }


    // ========================================
    // BASIC INFO
    // ========================================

    // จำนวนไพ่ในมือ
    public int size() {

        return cards.size();

    }


    // ใช้ get ไพ่
    public Card getCard(int index) {

        return cards.get(index);

    }


    // ใช้ access list ทั้งหมด (ใช้ในบาง condition)
    public ArrayList<Card> getCards() {

        return cards;

    }


    // ========================================
    // ADD CARD
    // ========================================

    public void addCard(Card card) {

        cards.add(card);

    }


    // ========================================
    // REPLACE CARD
    // ใช้โดย:
    // SwapWithHandAction
    // EmergencyDrawAction
    // ========================================

    public void setCard(int index, Card card) {

        if(!isValidIndex(index)) {

            System.out.println("Invalid hand index");

        }

        cards.set(index, card);

    }


    // ========================================
    // REMOVE CARD
    // (optional ใช้อนาคตได้)
    // ========================================

    public Card removeCard(int index) throws Exception {

        if(!isValidIndex(index)) {

            throw new Exception("Invalid hand index");

        }

        return cards.remove(index);

    }


    // ========================================
    // CLEAR HAND
    // ใช้โดย:
    // ResetHandAction
    // PerfectResetAction
    // WeakHandCondition
    // ========================================

    public void clear() {

        cards.clear();

    }


    // ========================================
    // DISPLAY HAND
    // ========================================

    public void showHand() {
        List<String> n = new ArrayList<>();
        System.out.println("\n--- HAND ---");

        if(cards.isEmpty()) {

            System.out.println("(empty)");

            return;

        }

        for(int i = 0; i < cards.size(); i++) {

            System.out.println(i + ": " + cards.get(i));
            n.add(cards.get(i).toString());
        }
        RemoteEvent.Event().fireEvent(Remote.SHOW_CHANNEL, n);
    }


    // ========================================
    // PRIVATE HELPER
    // ========================================

    private boolean isValidIndex(int index) {

        return index >= 0 && index < cards.size();

    }

    //-----------------------------------------------------------

    public void removeCard(Card card) {
        cards.remove(card);
    }
}