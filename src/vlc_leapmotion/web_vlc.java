package vlc_leapmotion;

import java.net.*;
import java.io.*;

public class web_vlc {
    
    public static void command(String cmd) throws Exception {
        web_vlc.connect(cmd) ;
    }

    public static void command(String cmd, Integer val) throws Exception {
        web_vlc.connect(cmd + "&val=" + val) ;
    }

    public static void connect(String cmd) throws Exception {
            Authenticator.setDefault (new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication ("", "Ab2abxyZ".toCharArray()) ;
                }
            });
            
            URL page = new URL("http://localhost:8080/requests/status.xml?command=" + cmd) ;
            URLConnection conn = page.openConnection() ;
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream())) ;
                String inputLine ;
                while ((inputLine = in.readLine()) != null) 
                    System.out.println(inputLine) ;
                in.close() ;
            } catch (Exception e) {
                System.out.println("Interface Web VLC not active.") ;
                System.out.println(e) ;
            }
    }

    public static void main(String args[]) {
        try {
            web_vlc.command("pl_play") ;
            web_vlc.command("volume", 250) ;
        } catch (Exception e) {
            System.out.println(e) ;
        }
    }
}
