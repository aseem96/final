import java.rmi.*;
import java.util.*;
import java.io.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public interface Sub extends Remote
{
	public int subCheck(String s1,String s2)throws RemoteException;
}