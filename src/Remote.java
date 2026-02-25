public interface Remote {
    final int STAGE_CHANNEL = 0; // Sent Stage Value
    final int ACTION_CHANNEL = 1; // Enable Action
    final int SHOW_CHANNEL = 2; // Enable Action
    final int MIDDLESHOW_CHANNEL = 3; // Enable Action
    final int PASS_CHANNEL = 4; // Enable Action
    final int END_CHANNEL = 5; // Enable Action
    final int CONDITION_CHANNEL = 6; // Enable Action
    final int CONDITIONLIST_CHANNEL = 66; // Enable Action
    final int SCORE_CHANNEL = 7; // Enable Action
    final int ACTIONBINDING_CHANNEL = 8; // Enable Action
    final int ACTIONTEMP_CHANNEL = 9; // Enable Action
    final int ACTIONEXEC_CHANNEL = 10; // Enable Action
    final int REQUESTINDEX_CHANNEL = 11; // Enable Action
    final int DISABLE = 12; // Enable Action
    final int PEEKY = 13; // Enable Action
    final int FUTURE = 14; // Enable Action
    final int COPY_REQUEST = 15; // Enable Action
    final int GETORI = 16; // Enable Action
    final int GETDES = 17; // Enable Action
    final int SEARCHDES = 18; // Enable Action
    final int KUYTOK = 500; // Enable Action
    int ENDSCREEN =654;
    int RESETCON = 625;

    void event(int Channel, Object data) ;
}
