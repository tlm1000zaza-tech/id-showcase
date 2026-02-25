import java.util.ArrayList;

// ========================================
// PlayerPoker Class
// ใช้แทน "ผู้เล่น"
// รับผิดชอบ:
// - เก็บ Hand
// - เก็บ Action ทั้งหมด
// - ควบคุม Hand Size Limit
// ========================================

public class PlayerPoker {

    // ========================================
    // FIELD
    // ========================================

    // ไพ่ในมือผู้เล่น
    private Hand hand;

    // list ของ Action ที่ผู้เล่นมี
    private ArrayList<ActionTai> actionTais;

    // จำนวนไพ่สูงสุดในมือ
    // (ถูกแก้โดย WeakHandCondition)
    private int handSizeLimit;

    // ค่า default (ใช้ reset หลัง change condition)
    private int defaultHandSizeLimit;


    // ========================================
    // CONSTRUCTOR
    // ========================================

    public PlayerPoker(int defaultHandSizeLimit) {

        this.defaultHandSizeLimit = defaultHandSizeLimit;
        this.handSizeLimit = defaultHandSizeLimit;

        hand = new Hand();

        actionTais = new ArrayList<>();

    }


    // ========================================
    // HAND SYSTEM
    // ========================================

    public Hand getHand() {

        return hand;

    }


    public int getHandSizeLimit() {

        return handSizeLimit;

    }


    public void setHandSizeLimit(int limit) {

        this.handSizeLimit = limit;

    }


    public void resetHandLimit() {

        this.handSizeLimit = defaultHandSizeLimit;

    }


    // ========================================
    // ACTION SYSTEM
    // ========================================

    public void addAction(ActionTai actionTai) {

        actionTais.add(actionTai);

    }


    public ArrayList<ActionTai> getActions() {

        return actionTais;

    }


    public ActionTai getAction(int index) {

        return actionTais.get(index);

    }


    public int getActionCount() {

        return actionTais.size();

    }


    // ========================================
    // RESET ACTION STATES
    // ใช้เมื่อ:
    // - เริ่ม level ใหม่
    // - ChangeConditionAction
    // ========================================

    public void resetAllActions() {

        for(ActionTai actionTai : actionTais) {

            actionTai.resetUsage();
            actionTai.resetExtraCost();
            actionTai.resetMaxUse();

        }

    }


    // ========================================
    // DISPLAY ACTION LIST
    // ========================================

    public void showActions() {

        System.out.println("\n--- ACTION LIST ---");

        for(int i = 0; i < actionTais.size(); i++) {

            ActionTai actionTai = actionTais.get(i);

            System.out.println(
                    i + ": " +
                            actionTai.getName() +
                            " | Cost: " + actionTai.getCost() +
                            " | Use Left: " + actionTai.getRemainingUse()
            );

        }

    }

}