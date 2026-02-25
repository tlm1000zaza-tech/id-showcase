// ========================================
// Action Base Class
// คลาสแม่ของ Action ทุกใบ
// ========================================

public abstract class ActionTai {

    // =========================
    // FIELD
    // =========================

    protected String name;

    protected int cost;

    protected int extraCost = 0;

    protected int maxUse;

    protected int originalMaxUse;

    protected int useCount = 0;


    // =========================
    // CONSTRUCTOR
    // =========================

    public ActionTai(int cost, int maxUse) {

        this.cost = cost;

        this.maxUse = maxUse;

        this.originalMaxUse = maxUse;

        this.name = setName();

    }


    // =========================
    // ABSTRACT
    // =========================

    abstract String setName();

    abstract void execute(Game game, PlayerPoker player, int index) ;


    // =========================
    // USE SYSTEM
    // =========================

    public boolean canUse(Game game, PlayerPoker player) {

        return useCount < maxUse;

    }


    public void makeUsed() {

        useCount++;

    }


    public void resetUsage() {

        useCount = 0;

    }


    // =========================
    // COST SYSTEM
    // =========================

    public void addExtraCost(int amount) {

        extraCost += amount;

    }


    public void resetExtraCost() {

        extraCost = 0;

    }


    // =========================
    // MAX USE SYSTEM
    // =========================

    public void decreaseMaxUse(int amount) {

        maxUse -= amount;

        if(maxUse < 0)
            maxUse = 0;

    }


    public void resetMaxUse() {

        maxUse = originalMaxUse;

    }


    // ========================================
    // ✅ GETTER METHODS (เพิ่มตรงนี้)
    // ========================================

    public String getName() {

        return name;

    }


    public int getCost() {

        return cost + extraCost;

    }


    public int getRemainingUse() {

        return maxUse - useCount;

    }

}