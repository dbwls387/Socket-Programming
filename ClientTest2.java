package game.baseball;

import java.net.*;
import java.io.*;
public class ClientTest2 {
	public static void main(String[] args){
		//�����͸� �ۼ����ϱ� ���� ������ �غ�
		int cnt=0;
		Socket socket = null;
		try {
			// 1. ���ϰ�ü �����ϱ�
			System.out.println("������ ���� ��û �ߡ�����");
			socket = new Socket("localhost",1999); //IP,Port ��ȣ�� �˾ƾ� ������ ����
			System.out.println("������ ���ӵǾ����ϴ�.");

			// 2. ������ �ۼ����� ���� I/O stream ���
			InputStream is = socket.getInputStream(); //���� --> read();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = socket.getOutputStream(); //�۽� --> write();
			PrintWriter pw = new PrintWriter(os);

			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

			// 3-1. ������ �۽�
			String str = "",str1="";
			System.out.println("������ �������� ��_��");
			while(true){
				//������ �Է�
				System.out.print("���� 4���� �Է��Ͻÿ�>>");
				cnt++;
				str = stdin.readLine();

				if(str.length()!=4){
					System.out.println("�ٽ� �Է��ϼ���\n���� 4���� �Է��Ͻÿ�>>");
					str = stdin.readLine();
				}
				//������ ����
				pw.println(str);
				pw.flush();
			
				str1 = br.readLine();

				System.out.println(">>"+str1);
				
				if(cnt==20) {break;}
				if(str1.subSequence(6, 8).charAt(0)!='F'){break;}
			}
			if(cnt==20) {System.out.println("�����ϴ�. ���� ��ȸ��..��_��");}
			else{System.out.println("����! �����մϴ�~!");}

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally{
			try {
				// 4. ���� �ݱ� --> ���� ����
				socket.close();
			}catch(IOException e) {e.printStackTrace();}
		}}
}