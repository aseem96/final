import java.rmi.*;
import java.io.*;
import java.util.*;
import java.rmi.registry.*;

public class server
{
	public static void main(String args[]) throws Exception
	{
		System.setProperty("java.rmi.server.hostname", "192.168.0.17");  
		Rev r=new RevString();
		Registry reg=LocateRegistry.createRegistry(6566);
		reg.rebind("obj",r);
	}
}