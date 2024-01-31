import java.rmi.*;

public interface Communication extends Remote{
    public void Send(String msg) throws RemoteException;
    public String Receive() throws RemoteException;
}