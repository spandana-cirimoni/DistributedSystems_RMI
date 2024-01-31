import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        System.setProperty("java.rmi.server.hostname", "in-csci-rrpc01.cs.iupui.edu");
        Registry register=LocateRegistry.getRegistry("in-csci-rrpc01.cs.iupui.edu",9999);

        CommunicationC c1=new CommunicationC("Obj1");
        CommunicationC c2=new CommunicationC("Obj2");
        CommunicationC c3=new CommunicationC("Obj3");
        CommunicationC c4=new CommunicationC("Obj4");

        Communication stub1= (Communication) UnicastRemoteObject.exportObject(c1, 0);
        Communication stub2= (Communication) UnicastRemoteObject.exportObject(c2, 0);
        Communication stub3= (Communication) UnicastRemoteObject.exportObject(c3, 0);
        Communication stub4= (Communication) UnicastRemoteObject.exportObject(c4, 0);


        register.rebind("1", stub1);
        register.rebind("2", stub2);
        register.rebind("3", stub3);
        register.rebind("4", stub4);

        System.out.println("Server has been Started");
    }
}
