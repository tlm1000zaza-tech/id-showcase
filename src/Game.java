import java.util.*;

public class  Game {

    // ============================================
    // CORE GAME OBJECTS
    // ============================================

    private PlayerPoker player;
    private Deck deck;
    private Middle middle;


    // ============================================
    // LEVEL SYSTEM
    // ============================================

    private HandRank targetRank;

    private int level = 1;
    private final int MAX_LEVEL = 5;

    private int levelReward;


    // ============================================
    // SCORE SYSTEM
    // ============================================

    private int score;


    // ============================================
    // DRAW / HAND / MIDDLE CONTROL
    // ============================================

    private int revealedCount;

    private int handDrawCount = 2;

    private int handSizeLimit = 2;

    private int defaultMaxMiddleCards = 3;

    private final int maxMiddleCards = 5;


    // ============================================
    // CONDITION SYSTEM
    // ============================================

    private boolean luckyDrawActive = false;

    private ArrayList<SpecialCondition> conditionPool;

    private ArrayList<SpecialCondition> activeConditions = new ArrayList<>();


    // ============================================
    // ACTION SYSTEM
    // ============================================

    private ArrayList<ActionTai> actionTaiPool = new ArrayList<>();


    // ============================================
    // INPUT / RANDOM
    // ============================================

    private Scanner sc = new Scanner(System.in);

    private Random random = new Random();

    private ActionTai tempaction;


    // ============================================
    // CONSTRUCTOR
    // ============================================
    public Game() {

        deck = new Deck();

        middle = new Middle(5);

        player = new Player();

        conditionPool = new ArrayList<>();
        level = 1;
        score = 100;

        RemoteEvent.Event().onEvent((Channel, data) -> {
            if (Channel == Remote.PASS_CHANNEL) {
                if ( level <= MAX_LEVEL) {
                    passaction();
                    middle.show();
                } else {
                    System.out.println("ended");
                }

            } else if (Channel == Remote.ACTIONTEMP_CHANNEL) {
                tempaction = (ActionTai) data;
                System.out.println("ACTemp");
                System.out.println("Temp :" + tempaction);
                if (tempaction instanceof ReplaceOneMidActionTai) {
                    RemoteEvent.Event().fireEvent(Remote.REQUESTINDEX_CHANNEL, 1);
                } else if (tempaction instanceof ResetMidActionTai) {
                    tempaction.execute(this, player, 0);
                } else if (tempaction instanceof LockMidCardActionTai) {
                    RemoteEvent.Event().fireEvent(Remote.REQUESTINDEX_CHANNEL, 2);
                } else if (tempaction instanceof  ResetHandActionTai) {
                    tempaction.execute(this, player, 0);
                    player.getHand().showHand();
                } else if (tempaction instanceof ChageConditionActionTai) {
                    RemoteEvent.Event().fireEvent(Remote.REQUESTINDEX_CHANNEL, 3);
                }
                middle.show();

            } else if (Channel == Remote.ACTIONEXEC_CHANNEL) {
                if (tempaction != null) {
                    tempaction.execute(this, player, (int) data);
                }
                tempaction = null;
                middle.show();
            }

        });

        Init();

    }

    // ============================================
    // MAIN GAME LOOP
    // ============================================
    public void executeaction(Object index) {
        if (tempaction instanceof ReplaceOneMidActionTai) {
            tempaction.execute(this, player,(int) index);
        }
    }
    public void runGame()  {

        System.out.println("===== START GAME =====");

        level = 1;

        score = 100;

        while(level <= MAX_LEVEL) {
            RemoteEvent.Event().fireEvent(Remote.STAGE_CHANNEL, level);
            conditionPool.clear();

            deck = new Deck();

            setTargetRank();

            setupActionPool();

            setupAction();

            setupconditionPool();

            generateActiveConditions();

            start();

            level++;

        }

        showFinalResult();

        showStartMenu();

    }

    public void Init()  {
        System.out.println("===== START GAME =====");
        RemoteEvent.Event().fireEvent(Remote.STAGE_CHANNEL, level);
        RemoteEvent.Event().fireEvent(Remote.SCORE_CHANNEL, score);
        conditionPool.clear();
        deck = new Deck();
        setTargetRank();
        setupActionPool();
        setupAction();
        setupconditionPool();
        generateActiveConditions();

        getMiddle().clear();
        player.getHand().clear();
        player.resetAllActions();
        handSizeLimit = 2;

        for(ActionTai actionTai : player.getActions()) {

            actionTai.resetExtraCost();

            actionTai.resetUsage();

            actionTai.resetMaxUse();

        }

        System.out.println("===== LEVEL " + level + " =====");

        System.out.println("DEBUG: Loaded actions = " + player.getActions().size());

        System.out.println("TARGET : " + targetRank);

        System.out.println("SCORE : " + score);

        for(int i = 0; i < 3; i++) {

            middle.placeCard(drawCard());

        }
        System.out.println("TEST");
        int drawCount = handSizeLimit;

        for(int i = 0; i < drawCount; i++) {
            Card dcard =  drawCard();
            player.getHand().addCard(dcard);

        }

        System.out.println("\n=== SPECIAL CONDITIONS ===");

        for(SpecialCondition condition : activeConditions) {

            System.out.println("- " + condition.getName());

            condition.apply(this, player);

        }

        System.out.println("==========================\n");
        middle.show();
        player.getHand().showHand();
    }

    // ============================================
    // START MENU
    // ============================================

    public void showStartMenu()  {

        System.out.println("1. Play Again");

        System.out.println("2. Exit");

        int choice = getScanner().nextInt();

        if(choice == 1)
        {

            runGame();

        }
        else
        {

            System.out.println("Goodbye.");

        }

    }


    // ============================================
    // FINAL RESULT
    // ============================================

    public void showFinalResult() {

        System.out.println("\n======================");

        System.out.println("===== GAME COMPLETE =====");

        System.out.println("======================");

        System.out.println("Final Score : " + score);


        if(score > 0)
        {

            System.out.println("RESULT : WIN");

        }
        else
        {

            System.out.println("RESULT : LOSE");

        }

        System.out.println("======================\n");

    }

    // ============================================
    // START LEVEL
    // ============================================

    public void start()  {




        // reset action state
        for(ActionTai actionTai : player.getActions()) {

            actionTai.resetExtraCost();

            actionTai.resetUsage();

            actionTai.resetMaxUse();

        }


        System.out.println("===== LEVEL " + level + " =====");

        System.out.println("DEBUG: Loaded actions = " + player.getActions().size());

        System.out.println("TARGET : " + targetRank);

        System.out.println("SCORE : " + score);


        // draw middle cards
        for(int i = 0; i < 3; i++) {

            middle.placeCard(drawCard());

        }


        // draw player hand
        int drawCount = handSizeLimit;

        for(int i = 0; i < drawCount; i++) {
            Card dcard =  drawCard();
            player.getHand().addCard(dcard);

        }



        // apply conditions
        System.out.println("\n=== SPECIAL CONDITIONS ===");

        for(SpecialCondition condition : activeConditions) {

            System.out.println("- " + condition.getName());

            condition.apply(this, player);

        }

        System.out.println("==========================\n");



        // MAIN TURN LOOP
        while(true) {

            System.out.println("\n-----------------");

            System.out.println("Middle:");

            middle.show();

            System.out.println("\nPlayer Card: ");

            player.getHand().showHand();

            System.out.println("\nChoose:");

            System.out.println("1 = Use Action");

            System.out.println("2 = Pass");

            int choice = getScanner().nextInt();


            switch(choice)
            {

                case 1:

                    if(player.getActions().isEmpty()) {

                        System.out.println("No actions available.");

                        break;

                    }


                    System.out.println("\nSelect action index:");

                    for(int i = 0; i < player.getActions().size(); i++) {

                        System.out.println(i + ": " + player.getActions().get(i));

                    }

                    int actionIndex = getScanner().nextInt();


                    if(actionIndex < 0 || actionIndex >= player.getActions().size()) {

                        System.out.println("Invalid action index.");

                        break;

                    }


                    useAction(player, actionIndex);

                    break;



                case 2:

                    System.out.println("\nPass...");

                    if(middle.size() < maxMiddleCards) {

                        Card newCard = drawCard();

                        middle.placeCard(newCard);

                        revealedCount++;

                        System.out.println("Revealed: " + newCard);

                    }
                    else {

                        System.out.println("\nAll cards revealed.");

                        endLevel();

                        return;

                    }

                    break;




                default:

                    System.out.println("Invalid choice.");

            }

        }

    }


    // ============================================
    // USE ACTION
    // ============================================
    private void passaction()  {
        System.out.println("[SIZE] : "+middle.size());
        System.out.println("[max] : "+maxMiddleCards);
        System.out.println("\nPass...");

        if(middle.size() < maxMiddleCards) {

            Card newCard = drawCard();

            middle.placeCard(newCard);

            revealedCount++;

            System.out.println("Revealed: " + newCard);

        }
        else {

            System.out.println("\nAll cards revealed.");

            endLevel();

            return;

        }
    }


    public void useAction(PlayerPoker player,int actionIndex)  {

        List<ActionTai> actionTais = player.getActions();

        if (actionIndex < 0 || actionIndex >= actionTais.size()) {

            System.out.println("Invalid action index.");

            return;

        }

        ActionTai actionTai = actionTais.get(actionIndex);

        if (actionTai.canUse(this, player)) {

            score -= actionTai.getCost();

//            actionTai.execute(this, player, index);

            actionTai.makeUsed();

        }
        else {

            System.out.println("Action limit reached this level.");

        }


        System.out.println("===== NEW MIDDLE CARD =====");

        middle.show();

        System.out.println("Score: "+score);

    }

    // ============================================
    // END LEVEL
    // ============================================

    private void endLevel() {
        RemoteEvent.Event().fireEvent(Remote.END_CHANNEL, null);
        System.out.println("\n===== END LEVEL " + level + " =====");

        ArrayList<Card> allCards = new ArrayList<>();


        allCards.addAll(player.getHand().getCards());

        allCards.addAll(middle.getCards());


        HandRank playerRank = getPlayerHandRank(allCards);


        System.out.println("Your Rank : " + playerRank);

        System.out.println("Target Rank : " + targetRank);


        if(playerRank.getValue() >= targetRank.getValue()) {

            System.out.println("RESULT : WIN");

            score += levelReward;

            System.out.println("Score gained : +" + levelReward);

        }
        else {

            System.out.println("RESULT : LOSE");

            score -= levelReward;

            System.out.println("Score lost : -" + levelReward);

        }


        System.out.println("Total Score : " + score);

        revealedCount = 0;

        luckyDrawActive = false;

        System.out.println("=========================\n");

        level++;
        System.out.println(middle.size());
        middle.clear();
        System.out.println(middle.size());
        if ( level <= MAX_LEVEL) {
            Init();
        } else {
            showFinalResult();
            showStartMenu();
        }

    }


    // ============================================
    // HAND RANK CHECK SYSTEM
    // ============================================

    public HandRank getPlayerHandRank(List<Card> cards) {

        if(checkRoyalFlush(cards)) return HandRank.ROYAL_FLUSH;

        if(checkStraightFlush(cards)) return HandRank.STRAIGHT_FLUSH;

        if(checkFourOfKind(cards)) return HandRank.FOUR_OF_A_KIND;

        if(checkFullHouse(cards)) return HandRank.FULL_HOUSE;

        if(checkFlush(cards)) return HandRank.FLUSH;

        if(checkStraight(cards)) return HandRank.STRAIGHT;

        if(checkThreeOfKind(cards)) return HandRank.THREE_OF_A_KIND;

        if(checkTwoPair(cards)) return HandRank.TWO_PAIR;

        if(checkOnePair(cards)) return HandRank.ONE_PAIR;

        return HandRank.HIGH_CARD;

    }



    // ============================================
    // CHECK HAND
    // ============================================

    private void setTargetRank() {

        switch (level) {

            case 1:
                targetRank = HandRank.ONE_PAIR;
                levelReward = 10;
                break;
            case 2:
                targetRank = HandRank.THREE_OF_A_KIND;
                levelReward = 20;
                break;
            case 3:
                targetRank = HandRank.FLUSH;
                levelReward = 30;
                break;
            case 4:
                targetRank = HandRank.FOUR_OF_A_KIND;
                levelReward = 40;
                break;
            case 5:
                targetRank = HandRank.ROYAL_FLUSH;
                levelReward = 50;
                break;

        }

    }

    private boolean checkOnePair(List<Card> cards) {

        Map<Rank, Integer> countMap = new HashMap<>();

        for(Card card : cards) {

            Rank rank = card.getRank();

            countMap.put(rank, countMap.getOrDefault(rank, 0)+1);
        }

        for(Integer count : countMap.values()) {

            if(count >= 2) {
                return true;
            }
        }

        return false;
    }
    private boolean checkTwoPair(List<Card> cards) {

        Map<Rank, Integer> countMap = new HashMap<>();

        for(Card card : cards) {

            Rank rank = card.getRank();

            countMap.put(rank, countMap.getOrDefault(rank, 0)+1);
        }

        int pairCount = 0;

        for(Integer count : countMap.values()) {

            if (count >= 2) {
                pairCount++;
            }
        }

        return pairCount >= 2;
    }
    private boolean checkThreeOfKind(List<Card> cards) {

        Map<Rank, Integer> countMap = new HashMap<>();

        for(Card card : cards) {

            Rank rank = card.getRank();

            countMap.put(rank, countMap.getOrDefault(rank, 0)+1);
        }

        for(Integer count : countMap.values()) {

            if(count >= 3) {
                return true;
            }
        }

        return false;
    }
    private boolean checkStraight(List<Card> cards) {

        Set<Integer> values = new HashSet<>();

        for(Card card : cards) {

            values.add(card.getRank().getValue());

            if(card.getRank().getValue() == 14) {

                values.add(1);
            }
        }

        List<Integer> sorted = new ArrayList<>(values);

        Collections.sort(sorted);

        int count = 1;

        for(int i = 1; i < sorted.size(); i++) {

            if(sorted.get(i) == sorted.get(i-1) +1) {

                count++;

                if(count >= 5) {

                    return true;
                }
            }
            else {

                count = 1;
            }
        }

        return false;
    }
    private boolean checkFlush(List<Card> cards) {

        Map<Type, Integer> typeMap = new HashMap<>();

        for(Card card : cards) {

           Type type = card.getType();

            typeMap.put(type, typeMap.getOrDefault(type, 0)+1);
        }

        for(Integer count : typeMap.values()) {

            if(count >= 5) {
                return true;
            }
        }

        return false;
    }
    private boolean checkFullHouse(List<Card> cards) {

        Map<Rank, Integer> countMap = new HashMap<>();

        for(Card card : cards) {

            Rank rank = card.getRank();

            countMap.put(rank, countMap.getOrDefault(rank, 0)+1);
        }

        boolean hasThree = false;
        boolean hasPair = false;

        for(Integer count : countMap.values()) {
            if(count >= 3) {
                hasThree = true;
            } else if (count >= 2) {
                hasPair = true;
            }
        }

        return hasThree && hasPair;
    }
    private boolean checkFourOfKind(List<Card> cards) {

        Map<Rank, Integer> countMap = new HashMap<>();

        for(Card card : cards) {

            Rank rank = card.getRank();

            countMap.put(rank, countMap.getOrDefault(rank, 0)+1);
        }

        for(Integer count : countMap.values()) {

            if(count >= 4) {
                return true;
            }
        }

        return false;
    }
    private boolean checkStraightFlush(List<Card> cards) {

        Map<Type, List<Integer>> typeMap = new HashMap<>();

        for(Card card : cards) {

            Type type = card.getType();
            int value = card.getRank().getValue();

            typeMap.putIfAbsent(type, new ArrayList<>());
            typeMap.get(type).add(value);
        }

        for(List<Integer> values : typeMap.values()) {

            if(values.size() < 5) continue;

            Set<Integer> set =new HashSet<>(values);

            if(set.contains(14)) {
                set.add(1);
            }

            List<Integer> sorted = new ArrayList<>(set);

            Collections.sort(sorted);

            int count = 1;

            for(int i = 0; i < sorted.size()-1; i++) {

                if(sorted.get(i)+1 == sorted.get(i+1)) {

                    count++;

                    if(count >= 5) {

                        return true;
                    }
                }
                else {

                    count = 1;
                }
            }
        }

        return false;
    }
    private boolean checkRoyalFlush(List<Card> cards) {

        for(Type type : Type.values()) {

            boolean has10 = false;
            boolean hasJ = false;
            boolean hasQ = false;
            boolean hasK = false;
            boolean hasA = false;

            for(Card card : cards) {

                if(card.getType() == type) {
                    switch (card.getRank()) {
                        case TEN: has10 = true; break;
                        case JACK:  hasJ = true; break;
                        case QUEEN:  hasQ = true; break;
                        case KING: hasK = true; break;
                        case ACE: hasA = true; break;
                    }
                }

            }

            if(has10 && hasJ && hasQ && hasK && hasA) {
                return true;
            }
        }
        return false;
    }


    // ========================================
// SETUP CONDITION POOL
// สร้าง pool ของ condition ทั้งหมดในเกม
// pool นี้ใช้สำหรับสุ่ม condition ในแต่ละ level
// ========================================

    private void setupconditionPool() {

        conditionPool = new ArrayList<>();

        conditionPool.add(new FragileMiddleCondition());

        conditionPool.add(new ExpensiveActionCondition());

        conditionPool.add(new WeakHandCondition());

        conditionPool.add(new LimitedActionsCondition());

        conditionPool.add(new LimitedRevealCondition());

        conditionPool.add(new HiddenMiddleCardCondition());

        conditionPool.add(new LuckyDrawCondition());

    }


    // ========================================
// GENERATE ACTIVE CONDITIONS
// สุ่ม condition จาก pool ตาม level
//
// Level 1 = 1 condition
// Level 2-3 = 2 conditions
// Level 4-5 = 3 conditions
//
// และห้ามซ้ำ
// ========================================
    private void generateActiveConditions()  {

        if(conditionPool == null || conditionPool.isEmpty()) {

            System.out.println("No condition in pool.");

            return;

        }

        if(activeConditions == null) {

            activeConditions = new ArrayList<>();

        }

        activeConditions.clear();

        int conditionCount;

        if(level == 1) {

            conditionCount = 1;

        }
        else if(level < 4) {

            conditionCount = 2;

        }
        else {

            conditionCount = 3;

        }

        // ป้องกัน pool ไม่พอ
        conditionCount =
                Math.min(conditionCount, conditionPool.size());


        while(activeConditions.size() < conditionCount) {

            int index = random.nextInt(conditionPool.size());

            SpecialCondition condition =
                    conditionPool.get(index);

            boolean alreadyExists = false;


            for(SpecialCondition c : activeConditions) {

                if(c.getClass() == condition.getClass()) {

                    alreadyExists = true;

                    break;

                }

            }


            if(!alreadyExists) {

                activeConditions.add(condition);
                RemoteEvent.Event().fireEvent(Remote.CONDITION_CHANNEL, condition.getName());

            }

        }

    }


    // ========================================
    // SETUP ACTION POOL
    // สร้าง action ทั้งหมดตาม level
    // ========================================
    private void setupActionPool() {

        actionTaiPool = new ArrayList<>();

        // LEVEL 1
        actionTaiPool.add(new ReplaceOneMidActionTai());
        actionTaiPool.add(new ResetMidActionTai());
        actionTaiPool.add(new LockMidCardActionTai());
        actionTaiPool.add(new ResetHandActionTai());
        actionTaiPool.add(new ChageConditionActionTai());

        // LEVEL 2
        if(level >= 2) {

            actionTaiPool.add(new PeekNextCardActionTai());
        }

        if(level >= 3) {

            actionTaiPool.add(new CopyCardActionTai());
        }
        if(level >= 4) {

            actionTaiPool.add(new SwapWithHandActionTai());
            actionTaiPool.add(new DoubleLockActionTai());
        }

        if(level >= 5) {

            actionTaiPool.add(new FutureSightActionTai());
            actionTaiPool.add(new EmergencyDrawActionTai());
            actionTaiPool.add(new PerfectResetActionTai());
        }
    }


    // ========================================
    // CHECK ACTION UNLOCK
    // ใช้ตรวจว่า action index นี้ unlock หรือยัง
    // ========================================
    private boolean isUnlocked(int index) {

        switch(index) {

            case 0:
            case 1:
            case 2:
            case 3:
            case 4:

                return true;

            case 5:
                return level >= 2;


            case 6:
                return level >= 3;


            case 7:
            case 8:
                return level >= 4;


            case 9:
            case 10:
            case 11:
                return level >= 5;

        }

        return false;

    }


    // ========================================
    // SETUP PLAYER ACTION
    // นำ action จาก pool ไปใส่ player
    // ========================================
    private void setupAction() {
        player.getActions().clear();

        for(int i = 0; i < actionTaiPool.size(); i++) {

            if(isUnlocked(i)) {
                player.getActions().add(actionTaiPool.get(i));
            }
        }
        RemoteEvent.Event().fireEvent(Remote.ACTIONBINDING_CHANNEL, actionTaiPool);
    }


    // ========================================
    // DRAW CARD
    // ดึง card จาก deck และ apply condition
    // ========================================
    public Card drawCard()  {

        Card card = deck.drawCard();

        card = processDrawnCard(card);

        return card;

    }


    // ========================================
    // PROCESS DRAWN CARD
    // ใช้กับ LuckyDrawCondition
    // ========================================
    public Card processDrawnCard(Card original) {

        for(SpecialCondition condition : activeConditions)
        {

            if(condition instanceof LuckyDrawCondition)
            {

                LuckyDrawCondition lucky =
                        (LuckyDrawCondition) condition;

                if(lucky.isActive())
                {

                    return lucky.modifyCard(original);

                }

            }

        }

        return original;

    }


    // ========================================
    // SET MAX MIDDLE CARDS
    // ใช้โดย LimitedRevealCondition
    // ========================================
    public void setMaxMiddleCards(int value) {
//        maxMiddleCards = Math.max(3,value);
    }


    // ========================================
    // SET HAND SIZE LIMIT
    // ใช้โดย WeakHandCondition
    // ========================================
    public void setHandSizeLimit(int size) {
        handSizeLimit = size;
    }



    // ========================================
    // RESET ALL CONDITION EFFECTS
    //
    // ใช้โดย ChangeConditionAction
    //
    // reset:
    //
    // hand size
    // middle hidden
    // condition lock
    // middle limit
    // action cost
    // LuckyDraw
    // refill hand
    // ========================================
    public void resetAllConditionEffects() {


        // reset hand limit

        System.out.println("[HAND SIZE] : " + player.getHandSizeLimit());
        player.resetHandLimit();
        System.out.println("[HAND SIZE || RESET] : " + player.getHandSizeLimit());

        // reset middle state

        middle.resetHidden();

        middle.resetConditionLock();


        // reset middle limit

        resetMaxMiddleCards();


        // restore middle size

        middle.restoreToMaxSize(this);


        // reset actions

        for(ActionTai actionTai : player.getActions()) {

            actionTai.resetExtraCost();

            actionTai.resetMaxUse();

        }


        // reset LuckyDraw

        for(SpecialCondition condition : activeConditions) {

            if(condition instanceof LuckyDrawCondition) {

                ((LuckyDrawCondition) condition).setActive(false);

            }

        }


        // refill hand
//        if ()
//        refillPlayerHand(player);

    }


    // ========================================
    // GET RANDOM CONDITION
    // ใช้โดย ChangeConditionAction
    // ========================================
    public SpecialCondition getRandomCondition(SpecialCondition removed) {

        ArrayList<Class<? extends SpecialCondition>>
                available = new ArrayList<>();


        for(SpecialCondition condition : conditionPool) {

            if(condition.getClass()
                    != removed.getClass()) {

                available.add(condition.getClass());

            }

        }


        if(available.isEmpty()) return null;


        Random rand = new Random();


        Class<? extends SpecialCondition> clazz =

                available.get(
                        rand.nextInt(available.size())
                );


        try {

            return clazz.getDeclaredConstructor()
                    .newInstance();

        }

        catch(Exception e) {

            e.printStackTrace();

            return null;

        }

    }


    public void refillPlayerHand(PlayerPoker player) {
        while(player.getHand().size() < handSizeLimit) {
            player.getHand().addCard(drawCard());
        }
    }
    public void resetMaxMiddleCards() {
//        maxMiddleCards = defaultMaxMiddleCards;
    }
    public ArrayList<SpecialCondition> getActiveConditions() {
        return activeConditions;
    }
    public Scanner getScanner() {
        return sc;
    }
    public PlayerPoker getPlayer() {
        return player;
    }
    public Deck getDeck() {
        return deck;
    }
    public int getMaxMiddleCards() {
        return maxMiddleCards;
    }
    public int getHandSixeLimit() {
        return handSizeLimit;
    }
    public Middle getMiddle() {
        return middle;
    }


    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
    public HandRank getTargetRank() {
        return targetRank;
    }

    // ========================================
// PASS TURN METHOD
// ใช้เมื่อผู้เล่นกด "Pass"
//
// หน้าที่:
// - เปิดไพ่ใหม่ใน Middle ถ้ายังไม่เต็ม
// - ถ้า Middle เต็ม → จบ Level
// ========================================
    public void passTurn() throws Exception {

        // ตรวจว่า Middle ยังมีช่องว่างอยู่หรือไม่
        if (middle.size() < maxMiddleCards) {

            // จั่วไพ่ใหม่จาก Deck
            Card newCard = drawCard();

            // เพิ่มเข้า Middle
            middle.placeCard(newCard);

            // เพิ่มจำนวนไพ่ที่เปิดแล้ว (ใช้ในบาง condition)
            revealedCount++;

            // แสดงไพ่ที่เปิด (ใช้กับ Console version)
            System.out.println("Revealed: " + newCard);

        }
        else {

            // ถ้า Middle เต็มแล้ว → จบ Level ทันที
            endLevel();

        }

    }
}
