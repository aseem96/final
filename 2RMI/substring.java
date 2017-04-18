import java.rmi.*;
import java.util.*;
import java.io.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

class substring extends UnicastRemoteObject implements Sub
{
	public substring() throws Exception
	{
		super();
	}
	
	public int subCheck(String s1,String s2) throws RemoteException
	{
		if(s1.contains(s2))
			return 1;
		return 0;
	}
}
