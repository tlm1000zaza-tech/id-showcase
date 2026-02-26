// ========================================
// Card Class
// ใช้แทนไพ่ 1 ใบในเกม
// เป็น core object ที่ใช้ทั้ง Deck, Hand, Middle
// ========================================

public class Card {

    // ========================================
    // FIELDS
    // ========================================

    private Type type;      // ดอกไพ่
    private Rank rank;      // เลขไพ่

    // state ของไพ่ (ใช้กับ Middle และ Condition)
    private boolean hidden;
    private boolean locked;


    // ========================================
    // CONSTRUCTOR
    // ========================================

    // constructor ปกติ
    public Card(Type type, Rank rank) {

        this.type = type;
        this.rank = rank;

        this.hidden = false;
        this.locked = false;
    }


    // copy constructor (ใช้ copy card อย่างปลอดภัย)
    public Card(Card other) {

        this.type = other.type;
        this.rank = other.rank;

        this.hidden = other.hidden;
        this.locked = other.locked;
    }


    // ========================================
    // COPY METHOD
    // แนะนำให้ใช้ method นี้แทน new Card(...)
    // ========================================

    public Card copy() {

        return new Card(this);

    }


    // ========================================
    // GETTER
    // ========================================

    public Type getType() {

        return type;

    }


    public Rank getRank() {

        return rank;

    }


    public boolean isHidden() {

        return hidden;

    }


    public boolean isLocked() {

        return locked;

    }


    // ========================================
    // SETTER
    // ใช้โดย Middle และ Condition
    // ========================================

    public void setHidden(boolean hidden) {

        this.hidden = hidden;

    }


    public void setLocked(boolean locked) {

        this.locked = locked;

    }


    // ========================================
    // RESET STATE
    // ใช้เมื่อ reset condition หรือ perfect reset
    // ========================================

    public void resetState() {

        hidden = false;
        locked = false;

    }


    // ========================================
    // DISPLAY
    // ========================================

    @Override
    public String toString() {

        if(hidden) {

            return "???";

        }

        return rank.getRankSymbol() + " " + type.getSuitSymbol();

    }

}