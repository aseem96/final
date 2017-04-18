import java.rmi.*;
import java.util.*;
import java.io.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class server{

public static void main(String args[]) throws Exception{
		ConcString obj = new Conc();
		System.setProperty("java.rmi.server.hostname", "192.168.0.17");  
		Registry reg = LocateRegistry.createRegistry(5003);  
// RemoteFoo foo = new RemoteFoo();        
reg.rebind("obj", obj); 
		// Naming.rebind("rmi://localhost:5001/ConcString",obj);
		System.out.println("Server Started");

}

}