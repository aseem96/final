  import java.rmi.*;
import java.util.*;
  public interface ConcString extends Remote{

  	public String conc(String first, String second) throws RemoteException;
  }