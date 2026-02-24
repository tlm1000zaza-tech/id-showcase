// ========================================
// SpecialCondition (Abstract Class)
//
// คลาสแม่ของ condition ทุกประเภทในเกม
//
// ใช้สำหรับ:
//
// - WeakHandCondition
// - HiddenMiddleCardCondition
// - FragileMiddleCondition
// - LimitedActionsCondition
// - ExpensiveActionCondition
// - LimitedRevealCondition
// - LuckyDrawCondition
//
// ========================================

public abstract class SpecialCondition {

    // ========================================
    // FIELD
    // ========================================

    // ชื่อ condition
    // ใช้แสดงผลในเกม
    protected String name;



    // ========================================
    // CONSTRUCTOR
    // ========================================

    public SpecialCondition() {

        // ให้ subclass เป็นคนกำหนดชื่อ
        name = setName();

    }



    // ========================================
    // SET NAME (ABSTRACT)
    //
    // subclass ต้อง implement
    // ========================================

    abstract String setName();



    // ========================================
    // GET NAME
    //
    // ใช้แสดงชื่อ condition
    // ========================================

    public String getName() {

        return name;

    }



    // ========================================
    // APPLY EFFECT (ABSTRACT)
    //
    // method หลักของ condition
    //
    // ถูกเรียกเมื่อ:
    //
    // - เริ่ม level
    // - ChangeConditionAction
    //
    // ตัวอย่าง:
    //
    // WeakHandCondition:
    // ลด hand size
    //
    // FragileMiddleCondition:
    // lock middle card
    //
    // LuckyDrawCondition:
    // เปิดใช้งาน lucky system
    // ========================================

    public abstract void apply(Game game,
                               PlayerPoker player)
            ;



    // ========================================
    // RESET EFFECT (OPTIONAL)
    //
    // ⭐ ใช้เมื่อ condition ถูกลบ
    // โดย ChangeConditionAction
    //
    // subclass สามารถ override
    //
    // default:
    // ไม่มี effect
    // ========================================

    public void reset(Game game,
                      PlayerPoker player)
            throws Exception {

        // default ไม่มีอะไร

    }



    // ========================================
    // TO STRING
    //
    // ใช้ตอน print condition
    // ========================================

    @Override
    public String toString() {

        return name;

    }

}