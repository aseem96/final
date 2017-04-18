import java.net.*;
import java.io.*;
import java.util.*;

class client
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("192.168.0.17",6566);
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str=new String(" ");
			while(true)
			{
				System.out.println("Enter value in feet");
				str=br.readLine();
				String str1=str;
				dout.writeUTF(str);
				str=din.readUTF();
				System.out.println("Feet "+str1+" = "+str+" meters");
				//dout.writeUTF(String.valueOf(c));
			}

	}
}