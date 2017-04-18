import java.io.*;
import java.net.*;
import java.util.*;

class ClientThread implements Runnable
{
	Socket s;
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
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str1 =new String(" ");
		String str2 =new String(" ");
		while(true)
		{
			str1=din.readUTF();
			System.out.println("Client says :"+str1);
			System.out.println(" enter your message");
			str2=br.readLine();
			dout.writeUTF(str2);
			dout.flush();
		}
		//s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}