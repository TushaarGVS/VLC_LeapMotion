/*
 * This file reads content from web page. Modified to work with hue_json.java
 */

package vlc_leapmotion;

import java.net.*;
import java.io.*;

public class url_reader {
	public static String address(String x) {
		String nextLine;
		URL url;
		URLConnection urlConn;
		InputStreamReader  inStream;
		BufferedReader buff;
		
		try{
			url  = new URL(x) ;
       		urlConn = url.openConnection() ;
       		inStream = new InputStreamReader(urlConn.getInputStream()) ;
       		buff= new BufferedReader(inStream) ;
        
            nextLine =buff.readLine();  
            if (nextLine !=null)
                return nextLine;
            return null;
        } catch(MalformedURLException e) {
       		System.out.println("Please check the URL:" + e.toString()) ;
		} catch(IOException  ioe) {
      		System.out.println("Can't read  from the Internet: "+ ioe.toString()); 
		}
       return null;
	}  
}
