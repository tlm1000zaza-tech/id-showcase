import java.util.ArrayList;
import java.util.Collections;

// ========================================
// Deck Class
// ใช้แทน "กองไพ่"
// รับผิดชอบ:
// - สร้างสำรับไพ่
// - สุ่มไพ่
// - แจกไพ่
// - peek ไพ่ล่วงหน้า
// ========================================

public class Deck {

    // ========================================
    // FIELD
    // ========================================

    // เก็บไพ่ทั้งหมดใน deck
    private ArrayList<Card> cards;


    // ========================================
    // CONSTRUCTOR
    // ========================================

    public Deck() {

        cards = new ArrayList<>();

        reset();   // สร้าง deck ใหม่ทันที

    }


    // ========================================
    // CREATE NEW DECK
    // ========================================

    public void reset() {

        cards.clear();

        // สร้างไพ่ 52 ใบ
        for(Type type : Type.values()) {

            for(Rank rank : Rank.values()) {

                cards.add(new Card(type, rank));

            }

        }

        shuffle();

    }


    // ========================================
    // SHUFFLE DECK
    // ========================================

    public void shuffle() {

        Collections.shuffle(cards);

    }


    // ========================================
    // BASIC INFO
    // ========================================

    public int size() {

        return cards.size();

    }


    public boolean isEmpty() {

        return cards.isEmpty();

    }


    // ========================================
    // DRAW CARD (สำคัญที่สุด)
    // ใช้โดย:
    // Game
    // Hand
    // Middle
    // Action
    // ========================================

    public Card drawCard()  {

//        if(isEmpty()) {
//
//            throw new Exception("Deck is empty");
//
//        }

        // draw จาก "top deck"
        Card card = cards.remove(cards.size() - 1);

        // reset state ป้องกัน hidden / lock ติดมา
        card.resetState();

        return card;

    }


    // ========================================
    // PEEK TOP CARD
    // ใช้โดย:
    // PeekNextCardAction
    // LuckyDraw preview
    // ========================================

    public Card peekTopCard() throws Exception {

        if(isEmpty()) {

            throw new Exception("Deck is empty");

        }

        // ⭐ FIX สำคัญ
        // ต้องใช้ index cards.size() - 1
        return cards.get(cards.size() - 1);

    }


    // ========================================
    // PEEK BY INDEX
    // ใช้โดย FutureSightAction
    // ========================================

    public Card peek(int index) {

        int realIndex = cards.size() - 1 - index;

        if(realIndex >= 0 && realIndex < cards.size()) {

            return cards.get(realIndex);

        }

        return null;

    }

}