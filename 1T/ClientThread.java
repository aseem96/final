import java.net.*;
import java.io.*;	
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

			String str=new String(" ");
			
			while(!str.equals("quit"))
			{	System.out.print("client "+din.readUTF()+" says :");
				str=din.readUTF();
				System.out.println(str);
				dout.writeUTF(str);
				dout.flush();

			}
			din.close();
			s.close();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}