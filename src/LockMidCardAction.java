import java.util.Scanner;

public class LockMidCardAction extends Action {

    public LockMidCardAction() {
        super(6, 3);
    }

    @Override
    String setName() {
        return "Lock Middle Card";
    }

    @Override
    void execute(Game game, PlayerPoker player) {

        Middle middle = game.getMiddle();

        if(middle.size() == 0) {

            System.out.println("No middle cards.");
            return;

        }

        middle.show();

        Scanner sc = new Scanner(System.in);

        System.out.println("Select index to lock:");

        int index = sc.nextInt();

        if(index < 0 || index >= middle.size()) {

            System.out.println("Invalid index");
            return;

        }

        if(middle.isLocked(index)) {

            System.out.println("Card already locked.");
            return;

        }

        middle.lockCard(index);

        System.out.println("Card locked successfully.");

    }

}