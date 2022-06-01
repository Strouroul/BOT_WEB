/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EGIT;

import static EGIT.CrunchifyLoadGithubContent.getINFO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.client.GitHubClient;
import static org.eclipse.egit.github.core.client.IGitHubConstants.CHARSET_UTF8;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.DataService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.util.EncodingUtils;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.json.JSONObject;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

/**
 *
 * @author RAMEZ
 */
public class newEGIT {
	public static GitHubClient client = new GitHubClient();
		 // create needed services
     public static    RepositoryService repositoryService = new RepositoryService();
      public static   CommitService commitService =  null;
      public static   DataService dataService =    null;
	
	
	public static void main(String[] args) throws IOException{
		
		// GitHub github   = new GitHubBuilder().withPassword("my_user", "my_passwd").build();
		
		 
		
		//Basic authentication
		 client.setOAuth2Token("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");	
		
		
		 
	client.setUserAgent("GitMan ( version: " + "2.35" + ", https://github.com/pridkett/gitminer, based off egit, user: " + "Strouroul" + " email: " + "kool_egypt@hotmail.com" + " )");
	
	   commitService = new CommitService(client);
        dataService = new DataService(client);
	
	
		List<org.eclipse.egit.github.core.Repository> myREPOS=new ArrayList<>();	
			try{
			myREPOS=	getRepositories();
				
			}
			catch(Exception ex){
			 System.out.println(ex.getMessage());
			}
		if(myREPOS!=null){
		    for (org.eclipse.egit.github.core.Repository thisREPO : myREPOS){
					if(thisREPO.getName().equals("strouroul.github.io")){
							System.out.println("REPO NAME : "+thisREPO.getName());
							try{
							    //String myREADME=getReadmeContent(client,thisREPO) ; 

							 List<RepositoryContents> myFILES=   getREPOfiles(thisREPO,"");

							 for (RepositoryContents thisCONT : myFILES){

								 if(thisCONT.getType().equals(RepositoryContents.TYPE_FILE) ){
									/* String fileConent = new String(
										 Base64.decodeBase64( thisCONT.getContent().getBytes()));*/
	                                             /*    System.out.println(dataService.getCommit(thisREPO, thisCONT.getSha()));*/
						     
						     JSONObject myINFO=null; 
						     
						     if( //thisCONT.getName().equals("index.html")&&
							     thisCONT.getType().equals("file")){
						      
							     String myCONTENT=  new String(EncodingUtils.fromBase64(
						  dataService.getBlob(thisREPO, thisCONT.getSha()) .getContent()),CHARSET_UTF8);
								    
							     System.out.println("getName : "+thisCONT.getName() +
								  "     getPath : "+thisCONT.getPath()+
								  "     getType : "+thisCONT.getType()+
								  "     getSize : "+thisCONT.getSize() +
								// "     getContent : "+myINFO.getString("FILE_DATA")+
									   
									   "OTHER CON : "+
								    myCONTENT+ 
					 	// Base64.decodeBase64( myCONTENT	 .getBytes()  ) +
									    "     getSha : "+thisCONT.getSha()
								  );  
							     
							  /*   try{
						     String githubROOT="https://raw.githubusercontent.com"; 
							String githubUSER="Strouroul";
							String gitREPO=thisREPO.getName(); 
							String fileNAME=thisCONT.getPath();
							String link = githubROOT+"/"+githubUSER+"/"+gitREPO+"/master/"+fileNAME;
		 
							myINFO=  getINFO(link);
						       //  System.out.println(myINFO);
							 if(myINFO.getBoolean("STATUS")){}
							 else{

							 }
							 
							  if(myINFO!=null){
								  
							}
						     }
						     catch(Exception ex){}*/
						     
						     }
						     else{
						      System.out.println("getName : "+thisCONT.getName() +
								  "     getPath : "+thisCONT.getPath()+
								  "     getType : "+thisCONT.getType()+
								  "     getSize : "+thisCONT.getSize() +
								 
									    "     getSha : "+thisCONT.getSha()
								  ); 
						     }
						    
						    
								
								 }

								 if(thisCONT.getType().equals(RepositoryContents.TYPE_DIR)){
								   System.out.println("DIR : "+thisCONT.getName()  +
								  "     getPath : "+thisCONT.getPath()   ); 

								 List<RepositoryContents> files=  getREPOfiles(thisREPO,thisCONT.getPath());

								  for (RepositoryContents thisREPOfilesINDIR : files){
									System.out.println("getName : "+thisREPOfilesINDIR.getName() +
										"     getPath : "+thisREPOfilesINDIR.getPath()+
										"     getType : "+thisREPOfilesINDIR.getType()+
										"     getSize : "+thisREPOfilesINDIR.getSize() 

										); 
									 }
								 }


								  if(thisCONT.getType().equals(RepositoryContents.ENCODING_BASE64)){

									System.out.println("getName : "+thisCONT.getName() +
										"     getPath : "+thisCONT.getPath()+
										"     getType : "+thisCONT.getType()+
										"     getSize : "+thisCONT.getSize() 

										); 
								  }


							 }

							}
							catch(Exception ex){
							  System.out.println("ERROR GETTING README : "+ex.getMessage());
							}

					}
					
				} 
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
	public static List<RepositoryContents> getREPOfiles( org.eclipse.egit.github.core.Repository repository, String path){
	ContentsService contentService = new ContentsService(client);
	List<RepositoryContents> files =new ArrayList<>();
	
		try {
			files= contentService.getContents(repository ,path);
		} catch (IOException ex) {
			System.out.println("ERROR: "+ex.getMessage());
			
			
		}
		
		return files;
	}
	public static String getReadmeContent(GitHubClient client, org.eclipse.egit.github.core.Repository rep) 
		throws Exception {
	ContentsService contentService = new ContentsService(client);
	RepositoryContents content = contentService.getReadme((IRepositoryIdProvider) rep);
	// TODO handle exception
	String fileConent = content.getContent();
	return new String(Base64.decodeBase64(fileConent.getBytes()));
}
	
	
	//   IRepositoryIdProvider   =   org.eclipse.egit.github.core.Repository
	public static List<org.eclipse.egit.github.core.Repository> getRepositories() throws IOException {
		
			      //client.setCredentials("Strouroul", "Shaytham123!");
		RepositoryService repoService=new RepositoryService(client);
		return repoService.getRepositories();
	}
}
