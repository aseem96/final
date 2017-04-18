import java.io.*;
import java.net.*;
class client
{
 public static void main(String[] args) throws Exception
 {
 	Socket s = new Socket("127.0.0.1",6566);
 		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout =new DataOutputStream(s.getOutputStream());
		int a,b,c;
	while(true)
	{
		System.out.println("Enter add to perform addition");
		String str=br.readLine();
		dout.writeUTF(str);
		System.out.println("Enter two parameters");
		dout.writeUTF(br.readLine());
		dout.writeUTF(br.readLine());
		System.out.println("Server returned :"+din.readUTF());

	}

 }
}