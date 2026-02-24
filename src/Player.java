// ========================================
// Player Class
// เป็น class ลูกของ PlayerPoker
// ใช้แทนผู้เล่นหลักของเกม
//
// เวอร์ชันนี้ไม่กระทบระบบเดิม
// ========================================

public class Player extends PlayerPoker {

    // ========================================
    // CONSTRUCTOR
    // ========================================

    public Player() {

        // เรียก constructor ของ PlayerPoker
        // default hand size = 2 (ค่ามาตรฐานของเกม)
        super(2);

    }

}