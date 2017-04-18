import java.io.*;
import java.net.*;
import java.util.*;

class ClientThread implements Runnable
{
	Socket s=new Socket();
	public ClientThread(Socket _s)
	{
		this.s=_s;
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
		int deg=Integer.parseInt(str);
		float rad=(float)deg*((float)3.14/180);
		dout.writeUTF(String.valueOf(rad));
	}
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
}
