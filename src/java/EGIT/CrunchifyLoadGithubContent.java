/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EGIT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author RAMEZ
 */ 
public class CrunchifyLoadGithubContent {
 
	public static void main(String[] args) throws Throwable {
		
		
		String githubROOT="https://raw.githubusercontent.com";
		
		String githubUSER="Strouroul";
		String gitREPO="strouroul.github.io";
		
		String fileNAME="index.html";
		String link = githubROOT+"/"+githubUSER+"/"+gitREPO+"/master/"+fileNAME;
		
		
		  JSONObject myINFO= getINFO(link);
		  System.out.println(myINFO);
		  if(myINFO.getBoolean("STATUS")){}
		  else{
		  
		  }
	}
	
	
	public static JSONObject getINFO(String myLINK){
		JSONObject myRETURN=new JSONObject();
		myRETURN.put("STATUS", false);
		try { 
			
			URL crunchifyUrl = new URL(myLINK);
			HttpURLConnection crunchifyHttp = (HttpURLConnection) crunchifyUrl.openConnection();
			Map<String, List<String>> crunchifyHeader = crunchifyHttp.getHeaderFields();
			
			// If URL is getting 301 and 302 redirection HTTP code then get new URL link.
			// This below for loop is totally optional if you are sure that your URL is not getting redirected to anywhere
			for (String header : crunchifyHeader.get(null)) {
				if (header.contains(" 302 ") || header.contains(" 301 ")) {
					myLINK = crunchifyHeader.get("Location").get(0);
					crunchifyUrl = new URL(myLINK);
					crunchifyHttp = (HttpURLConnection) crunchifyUrl.openConnection();
					crunchifyHeader = crunchifyHttp.getHeaderFields();
				}
			}
			InputStream crunchifyStream = crunchifyHttp.getInputStream();
			String crunchifyResponse = GET_FILE_AS_STRING(crunchifyStream);
			//System.out.println(crunchifyResponse);
			myRETURN.put("FILE_DATA", crunchifyResponse);
			myRETURN.put("STATUS", false);
		} catch (Exception ex) {
			 System.out.println(ex.getMessage());
		}
		
		return myRETURN;
	}
 
        // ConvertStreamToString() Utility - we name it as crunchifyGetStringFromStream()
	private static String GET_FILE_AS_STRING(InputStream crunchifyStream) throws IOException {
		if (crunchifyStream != null) {
			Writer crunchifyWriter = new StringWriter();
 
			char[] crunchifyBuffer = new char[2048];
			try {
				Reader crunchifyReader = new BufferedReader(new InputStreamReader(crunchifyStream, "UTF-8"));
				int counter;
				while ((counter = crunchifyReader.read(crunchifyBuffer)) != -1) {
					crunchifyWriter.write(crunchifyBuffer, 0, counter);
				}
			} finally {
				crunchifyStream.close();
			}
			return crunchifyWriter.toString();
		} else {
			return "No Contents";
		}
	}
}
