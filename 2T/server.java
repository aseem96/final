import java.io.*;
import java.net.*;

class server
{
	public static ServerSocket ss=null;

	public static void main(String args[])
	{
		Runnable listen=new Runnable()
		{
			public void run()
			{
			
				
				int i=0;
				
				try
				{
					ss=new ServerSocket(6566);
					while(true)
					{
					Socket s=ss.accept();
					if(s!=null && i<10)
					{
						i++;
					new Thread(new ClientThread(s)).start();
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