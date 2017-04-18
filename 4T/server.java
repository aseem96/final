import java.net.*;
import java.io.*;

class server
{
static ServerSocket ss=null;
public static void main(String args[])
{
	Runnable listen= new Runnable()
	{
		public void run()
		{
			try
			{
			ss=new ServerSocket(6566);
			int i=0;
			while(true)
			{
				Socket s=ss.accept();
				if(i<10 && s!=null)
				{
					i++;
					new Thread(new ClientThread(s)).start();
				}
				else
				{
					break;
				} 
			}


			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	};
	new Thread(listen).start();
}
}
