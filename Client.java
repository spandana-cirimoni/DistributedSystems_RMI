import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client implements Runnable{
    public int ThreadNumber;
    public int counter;
    public String msg;
    public Communication obj;
    public Client(int ThreadNumber,Communication obj){
        this.ThreadNumber=ThreadNumber;
        this.counter=0;
        this.obj=obj;
    }

    @Override
    public void run(){
        try {
            while(true){
                System.out.println(this.ThreadNumber+" is running successfully");
                int random=getRandomNumber(1, 4);
                if(random==this.ThreadNumber){
                    this.counter++;
                    System.out.println("Internal Event: P"+this.ThreadNumber+" Timestamp: "+this.counter);
                }
                else if(this.obj.Receive()==null){
                    this.obj.Send("Hi");
                    this.counter++;
                    System.out.println("P"+this.ThreadNumber+" sent message to P"+random+" Timestamp: "+this.counter);
                }
                else{
                    this.counter++;
                    System.out.println("P"+this.ThreadNumber+" received a message from P"+random+" Timestamp: "+this.counter);
                }
            }
        }
        catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
    public int getRandomNumber(int n1, int n2) {
        return (int) ((Math.random() * (n1 - n2)) + n2);
    }
    public static void main(String[] args) throws Exception{
        Registry register=LocateRegistry.getRegistry("in-csci-rrpc01.cs.iupui.edu",9999);
        for(int i=1;i<=4;i++){
            String s=String.valueOf(i);
            Communication obj= (Communication) register.lookup(s);
            Client c=new Client(i,obj);
            Thread t=new Thread(c);
            t.start();
        }
    }
}
