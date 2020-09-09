package game.baseball;

import java.net.*;
import java.io.*;

public class ServerTest2 {
 public static void main(String[] args){
  
  ServerSocket serverSocket = null;
  Socket socket = null;
  try {
   // 1. �������� ����
   serverSocket = new ServerSocket(1999);
   while(true){
    // 2. Ŭ���̾�Ʈ�� ���ӿ�û�� ���
    System.out.println("���� ���� ��� �ߡ�����");
    socket = serverSocket.accept();
    System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ����ϴ�. ");
    
    // ���� ������ ����� �ڷ� �ۼ����ϰ� �Ѵ�.
    EchoThread echoThread = new EchoThread(socket);
    echoThread.start();
   }
   
  } catch (IOException e) {
   System.out.println(e.getMessage());
   e.printStackTrace();
  } finally{
   try {
   // 4. ���� �ݱ� --> ���� ����
    socket.close();
   }catch(IOException e) {e.printStackTrace();}
  }
 }

}

//������ Ŭ����
class EchoThread extends Thread{
    
 Socket socket;
 
 InputStream is=null;
 BufferedReader br=null;
 
 OutputStream os=null;
 PrintWriter pw=null;
 
 
 EchoThread(){}
 EchoThread(Socket socket){
  this.socket = socket;
  try{
   // 3. �������κ��� �ۼ����� ���� I/O stream ���
   is = socket.getInputStream(); //���� --> read();
   br = new BufferedReader(new InputStreamReader(is));
   os = socket.getOutputStream(); //�۽� --> write();
   pw = new PrintWriter(os);
   
  } catch (IOException e) {
   System.out.println(e.getMessage());
   e.printStackTrace();
  } 
 }
 public void run(){
  Game2 zz;
  
  try {
   String str = "";
   int cnt=0;
   boolean val=false;
   char val1;
   String cnt1=null;
   int x,y;
   int vvaall;
 
   
   zz = new Game2();  //�߱����� Ŭ���� ��ü ����
   zz.randomInt();
   
   while(!val){
    str=br.readLine(); //���δ����� �޾Ƽ� ��Ʈ���� ���� 
    
    zz.inputUserNumber1(str); //�Է� ���� ���ڸ� �迭�� ���
    
    x=zz.getX(); 

    y=zz.getY();
    
    vvaall=zz.getvvaall();
    
    cnt = zz.getCount(); //ī��Ʈ
    
    val = zz.getValue(); //����
    if(val) val1 = 'T';
    else val1 = 'F';
    
    System.out.println(str+" :"+x+"S "+y+"B"+" "+val1+" ���� Ƚ�� : "+(20-cnt));
    pw.println(x+"S "+y+"B"+" "+val1+" ���� Ƚ�� : "+(20-cnt)); //���
    pw.flush();
    if(vvaall==2) {System.out.println("�̰���ϴ�!");return;}
    if(val1=='T') {System.out.println("�����ϴ�. Ŭ���̾�Ʈ �¸�");}
   }

  } catch (IOException e) {
   System.out.println("������ �ۼ��ſ���");
   e.printStackTrace();
  }finally{
   close();
  }
 
 } 
 public void close(){
  try {
  // 4. ���� �ݱ� --> ���� ����
   is.close();
   br.close();
   os.close();
   pw.close();
   socket.close();
  }catch(IOException e) {
   System.out.println("close����");
   e.printStackTrace();
  }
 }
}    