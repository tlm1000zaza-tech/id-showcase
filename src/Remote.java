public interface Remote {
    final int STAGE_CHANNEL = 0; // Sent Stage Value
    final int ACTION_CHANNEL = 1; // Enable Action
    final int SHOW_CHANNEL = 2; // SHOW HAND
    final int MIDDLESHOW_CHANNEL = 3; // Update middle
    final int PASS_CHANNEL = 4; // press Action
    final int END_CHANNEL = 5; // Resetstate
    final int CONDITION_CHANNEL = 6; // update condition
    final int SCORE_CHANNEL = 7; // update condition
    final int ACTIONBUTTON_CHANNEL = 8; // Enable Action
    final int TEMPMIDDLE_CHANNEL = 9; // Enable Action
    final int ACTIONREPLACEMIDDLE_CHANNEL = 10; // Enable Action


    void event(int Channel, Object data) ;
}
