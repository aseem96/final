import java.io.*;
import java.net.*;
import java.util.*;
class client
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("127.0.0.1",6566);
		Random rnd=new Random();
		Integer i=rnd.nextInt(100);

		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=new String(" ");
		String str2=new String(" ");
		dout.flush();
		while(!str.equals("quit"))
		{
			str=br.readLine();
			dout.writeUTF(i.toString());
			dout.writeUTF(str);
			dout.flush();
			str2=din.readUTF();
			System.out.println("Server says back : "+str2);
		}
		dout.close();
		s.close();
	}
}