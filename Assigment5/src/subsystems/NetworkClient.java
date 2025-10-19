package subsystems;

public class NetworkClient {
    private boolean connected;

    public void connect() {
        connected = true;

        System.out.println("[Net] Connected");
    }

    public void disconnect() {
        connected = false;

        System.out.println("[Net] Disconnected");
    }

    public boolean isConnected() {
        return connected;
    }
}