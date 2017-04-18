import java.net.*;
import java.io.*;	
import java.lang.*;
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
			{	
				System.out.print("client "+din.readUTF()+" says :");
				str=din.readUTF();
				System.out.println(str);
				String arr[]=str.split(",");
				double a=Double.parseDouble(arr[0]);
				double b=Double.parseDouble(arr[1]);
				double c=Math.pow(a,b);
				dout.writeUTF(Double.toString(c));
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