import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CommunicationC extends UnicastRemoteObject implements Communication{
    public String msg="";

    protected CommunicationC(String msg) throws RemoteException {
        super();
        this.msg=msg;
    }

    @Override
    public void Send(String msg1) throws RemoteException {
        this.msg=msg1;
        System.out.println("The Message is sent: "+msg1);
    }

    @Override
    public String Receive() throws RemoteException {
        return this.msg;
    }
}
