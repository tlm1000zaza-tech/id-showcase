import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoteEvent {
    private List<Remote> Aremote = new ArrayList<>();
    private static RemoteEvent instance;
    private RemoteEvent() {};

    public static RemoteEvent Event() {
        if (instance == null) {
            instance = new RemoteEvent();
        }
        return instance;
    }

    public void onEvent(Remote remote) {
        this.Aremote.add(remote);
    }

    public void fireEvent(int Channel, Object data) {
        for (Remote remote1 : Aremote){
            remote1.event(Channel, data);
        }
    }

}
