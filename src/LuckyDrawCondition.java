import java.util.Random;

public class LuckyDrawCondition extends SpecialCondition {

    private Random random = new Random();

    // ⭐ เพิ่ม field นี้
    private boolean active = false;


    @Override
    String setName() {
        return "Lucky Draw";
    }


    // ⭐ ตอน condition ถูก apply
    @Override
    public void apply(Game game, PlayerPoker player) {

        active = true;

    }


    // ⭐ method นี้ Game จะใช้ reset
    public void setActive(boolean active) {

        this.active = active;

    }


    // ⭐ Game ใช้เช็ค
    public boolean isActive() {

        return active;

    }


    // ⭐ logic 33% +1 / -1 / 0
    public Card modifyCard(Card original) {

        if(!active)
            return original;


        int roll = random.nextInt(3);


        if(roll == 0)
            return changeRank(original, +1);

        else if(roll == 1)
            return changeRank(original, -1);


        return original;

    }


    private Card changeRank(Card card, int delta) {

        int newRank = card.getRank().ordinal() + delta;


        if(newRank < 0)
            newRank = 0;


        if(newRank >= Rank.values().length)
            newRank = Rank.values().length - 1;


        return new Card(
                card.getType(),
                Rank.values()[newRank]
        );

    }

}