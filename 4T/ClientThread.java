import java.net.*;
import java.io.*;
import java.util.*;

class ClientThread implements Runnable
{
	Socket s;
	ClientThread(Socket ss)
	{
		this.s=ss;
	}
	public void run()
	{
		try
		{
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			String str=new String(" ");
			while(true)
			{
				str=din.readUTF();
				int i=Integer.parseInt(str);
				float c =34f;
				c=i*(float)0.3048;
				System.out.println("Feet "+i+" = "+c+" meters");
				dout.writeUTF(Float.toString(c));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}