import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
public class Conc extends UnicastRemoteObject implements ConcString{
	public Conc()throws Exception{
		super();
	}
public String conc(String first, String second)throws RemoteException{
	return (first + second);
}	
}