public interface Remote {
    final int STAGE_CHANNEL = 0; // Sent Stage Value


    void event(int Channel, Object data);
}
