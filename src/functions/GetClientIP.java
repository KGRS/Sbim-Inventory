package functions;
import java.applet.*;
import java.net.InetAddress;

public class GetClientIP extends Applet {
    String Ip="";
  public String GetIp() {
    try {
         InetAddress thisIp = InetAddress.getLocalHost();
//         System.out.println("IP:"+thisIp.getHostAddress());
         Ip=thisIp.getHostAddress();

     }
    catch(Exception e) {
         e.printStackTrace();
     }
    return Ip;
    }
}