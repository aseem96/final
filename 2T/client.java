import java.io.*;
import java.net.*;
import java.util.*;

class client
{
	public static void main(String args[])
	{
		try
		{
		Socket s=new Socket("127.0.0.1",6566);
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str1 =new String(" ");
		String str2 =new String(" ");
		while(true)
		{
			System.out.println(" enter your message");
			str2=br.readLine();
			dout.writeUTF(str2);
			dout.flush();
			str1=din.readUTF();
			System.out.println("Server says :"+str1);
				
		}
		//s.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}