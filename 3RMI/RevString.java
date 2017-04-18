
import java.rmi.*;
import java.io.*;
import java.util.*;
import java.rmi.server.*;

public class RevString extends UnicastRemoteObject implements Rev
{
	public RevString() throws Exception
	{
		super();
	}
	public int revcheck(String s1,String s2) throws RemoteException
	{
			int i=s1.length();
			int j=s2.length();
			if(i!=j)
				return 0;
			j=0;
			while(i!=0)
			{
				if(s1.charAt(j)!=s2.charAt(i-1))
					return 0;
				j++;
				i--;
			}
			return 1;

	}
}