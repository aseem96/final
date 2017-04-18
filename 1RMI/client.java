import java.rmi.*;
import java.util.*;
import java.io.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class client
{

	public static void main (String args[]) throws Exception
	{
		System.out.println("Enter two Strings");
		Scanner sc = new Scanner(System.in);
		String[] input = new String [2];
		String first,second;
		input = sc.nextLine().split(" ");
		first = input[0];
		second = input[1];

Registry reg = LocateRegistry.getRegistry("192.168.0.17", 5003);
ConcString obj = (ConcString) reg.lookup("obj");
		//ConcString obj= (ConcString)Naming.lookup("rmi://localhost:5001/ConcString");
		String result = obj.conc(first,second);
		System.out.println(result);
	}

}