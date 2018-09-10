package com.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

public class Otpgen {

public static void main(String[] args) {
		
		Random r=new Random();
		String otp=String.valueOf(r.nextInt(1000000));
		System.out.println(otp);
		
		  //Your authentication key
      String authkey = "187525A9Sl9ilTD5a2d75dd";
        //Multiple mobiles numbers separated by comma
        String mobiles = "9618977547";
        //Sender ID,While using route4 sender id should be 6 characters long.
        String senderId = "143143";
        //Your message to send, Add URL encoding here.
        String message = "msg91:"+otp;
        System.out.println(message);
        //define route
        String route="default";

        //Prepare Url
        URLConnection myURLConnection=null;
        URL myURL=null;
        BufferedReader reader=null;

        //encoding message
        String encoded_message=URLEncoder.encode(message);

        //Send SMS API
        String mainUrl="http://api.msg91.com/api/sendhttp.php?";

        //Prepare parameter string
        StringBuilder sbPostData= new StringBuilder(mainUrl);
      //  sbPostData.append("authkey="+authkey);
        sbPostData.append("&mobiles="+mobiles);
        sbPostData.append("&message="+encoded_message);
        sbPostData.append("&route="+route);
        sbPostData.append("&sender="+senderId);

        //final string
        mainUrl = sbPostData.toString();
        try
        {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            //reading response
            String response;
            while ((response = reader.readLine()) != null)
            //print response
            System.out.println(response);

            //finally close connection
            reader.close();
        }
        catch (IOException e)
        {
                e.printStackTrace();
        }
	}
}
