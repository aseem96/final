import java.rmi.*;
import java.io.*;
import java.util.*;
import java.rmi.registry.*;

public class client
{
	public static void main(String args[]) throws Exception
	{
		Registry reg=LocateRegistry.getRegistry("192.168.0.17",6566);
		Rev r=(Rev)reg.lookup("obj");
		System.out.println("Enter two Strings");
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		int temp=r.revcheck(s1,s2);
		if(temp==1)
			System.out.println("yes ");
		else
			System.out.println("No ");


	}
}