public interface Remote {
    final int STAGE_CHANNEL = 0; // Sent Stage Value
    final int ACTION_CHANNEL = 1; // Enable Action
    final int SHOW_CHANNEL = 2; // Enable Action
    final int MIDDLESHOW_CHANNEL = 3; // Enable Action
    final int PASS_CHANNEL = 4; // Enable Action
    final int END_CHANNEL = 5; // Enable Action
    final int CONDITION_CHANNEL = 6; // Enable Action
    final int SCORE_CHANNEL = 7; // Enable Action


    void event(int Channel, Object data) ;
}
