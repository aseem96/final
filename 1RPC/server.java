import java.io.*;
import java.net.*;

class server
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(6566);
		Socket s=ss.accept();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout =new DataOutputStream(s.getOutputStream());
		int a,b,c;
		while(true)
		{
			String str=new String(" ");
			str=din.readUTF();
			if(str!=null)
			{
				System.out.println("Operation :"+str);
			}
			a=Integer.parseInt(din.readUTF());
			b=Integer.parseInt(din.readUTF());
			if(str.compareTo("add")==0)
			{
				dout.writeUTF(String.valueOf(a+b));
			}


		}



	}
}