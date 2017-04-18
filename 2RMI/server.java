import java.rmi.*;
import java.util.*;
import java.io.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

class server
{
	public static void main(String args[]) throws Exception
	{
		Sub s=new substring();
		Registry reg=LocateRegistry.createRegistry(6566);
		reg.rebind("obj",s);
	}
}