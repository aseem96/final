import java.rmi.*;
import java.util.*;
import java.io.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

class client
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);

		String str1 =sc.next();
		String str2=sc.next();
		Registry reg=LocateRegistry.getRegistry("localhost",6566);
		Sub test=(Sub)reg.lookup("obj");
		int i=test.subCheck(str1,str2);
		if(i==1)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}