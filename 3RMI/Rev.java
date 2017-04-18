import java.rmi.*;
import java.io.*;
import java.util.*;

public interface Rev extends Remote
{
	public int revcheck(String s1,String s2) throws RemoteException;
}