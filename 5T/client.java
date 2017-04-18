import java.io.*;
import java.net.*;
import java.util.*;

class client
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("192.168.0.17",6566);
		
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=new String(" ");
		String str1=new String(" ");
		while(true)
		{
			try
			{
				System.out.println("Enter the degree ");
				str=br.readLine();
				dout.writeUTF(str);
				str1=din.readUTF();
				System.out.println(" Degree "+str+" = radian "+str1);

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}