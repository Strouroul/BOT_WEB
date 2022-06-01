/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EGIT;
  
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.client.GitHubClient;
import static org.eclipse.egit.github.core.client.IGitHubConstants.CHARSET_UTF8;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.DataService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.util.EncodingUtils;
import org.json.JSONObject;

/**
 *
 * @author RAMEZ
 */
public class finalGITMAN {
	public static GitHubClient client = new GitHubClient();
		 // create needed services
     public static    RepositoryService repositoryService = new RepositoryService();
      public static   CommitService commitService =  null;
      public static   DataService dataService =    null;
	     public static List<org.eclipse.egit.github.core.Repository> myREPOS=new ArrayList<>();
      public finalGITMAN(){
       client.setOAuth2Token("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");	 
	client.setUserAgent("GitMan ( version: " + "2.35" + ", https://github.com/pridkett/gitminer, based off egit, user: " + "Strouroul" + " email: " + "kool_egypt@hotmail.com" + " )");
	
	   commitService = new CommitService(client);
        dataService = new DataService(client);
	
	try{
		myREPOS=	getRepositories();

		}
		catch(Exception ex){
		 System.out.println(ex.getMessage());
		}
      }
	
	public static void main(String[] args) throws IOException{
	/*//Basic authentication
	 client.setOAuth2Token("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");	 
	client.setUserAgent("GitMan ( version: " + "2.35" + ", https://github.com/pridkett/gitminer, based off egit, user: " + "Strouroul" + " email: " + "kool_egypt@hotmail.com" + " )");
	
	   commitService = new CommitService(client);
        dataService = new DataService(client);
	  	*/
		finalGITMAN thisGITMAN=new finalGITMAN();
		
		  for (org.eclipse.egit.github.core.Repository thisREPO : myREPOS){
		     if(thisREPO.getName().equals("strouroul.github.io")){
		        System.out.println("REPO NAME : "+thisREPO.getName());
		        List<RepositoryContents> myFILES=new ArrayList<>();
			try{ 
			    myFILES =   getREPOfiles(thisREPO,""); 
			}catch(Exception ex){System.out.println("ERROR : "+ex.getMessage());}
			JSONObject myINFO=  PARSEREPOFILES(thisREPO,myFILES);
			System.out.println(myINFO);
		      }//   strouroul.github.io  
		  }
	}
	public static JSONObject PARSEREPOFILES(org.eclipse.egit.github.core.Repository thisREPO,List<RepositoryContents> myFILES) throws UnsupportedEncodingException, IOException{
		JSONObject thisREPOfilesJSON=new JSONObject();
		
	for (RepositoryContents thisCONT : myFILES){ 
		if(thisCONT.getType().equals(RepositoryContents.TYPE_FILE) ){
			String myCONTENT=  new String(
				EncodingUtils.fromBase64(  dataService.getBlob(
				thisREPO, thisCONT.getSha()
				) .getContent()),CHARSET_UTF8); 
			if( //thisCONT.getName().equals("index.html")&&
				thisCONT.getType().equals("file")){ 
				
				/*System.out.println("getName : "+thisCONT.getName() +
				"     getPath : "+thisCONT.getPath()+
				"     getType : "+thisCONT.getType()+
				"     getSize : "+thisCONT.getSize() + 
				"     CONTENT : "+   myCONTENT+ 
				"     getSha : "+thisCONT.getSha()
				); */
				
				
			} else{
				/*System.out.println("getName : "+thisCONT.getName() +
				"     getPath : "+thisCONT.getPath()+
				"     getType : "+thisCONT.getType()+
				"     getSize : "+thisCONT.getSize() +

				      "     getSha : "+thisCONT.getSha()
				); */
			}
			
			JSONObject thisFILEjson=new JSONObject();
				thisFILEjson.put("NAME", thisCONT.getName());
				thisFILEjson.put("PATH", thisCONT.getPath());
				thisFILEjson.put("TYPE", thisCONT.getType());
				thisFILEjson.put("SIZE", thisCONT.getSize());
				thisFILEjson.put("CONTENT",  myCONTENT);
				thisFILEjson.put("SHA", thisCONT.getSha());
				thisREPOfilesJSON.put(thisCONT.getName(), thisFILEjson);
		}//END OF FILE
		if(thisCONT.getType().equals(RepositoryContents.TYPE_DIR)){
		 /*System.out.println("DIR : "+thisCONT.getName()  +
		"     getPath : "+thisCONT.getPath()   ); */

	       List<RepositoryContents> files=  getREPOfiles(
		       thisREPO,thisCONT.getPath());

		for (RepositoryContents thisREPOfilesINDIR : files){
		    /*  System.out.println(
			      "getName : "+ thisREPOfilesINDIR.getName() +
			      "     getPath : "+thisREPOfilesINDIR.getPath()+
			      "     getType : "+thisREPOfilesINDIR.getType()+
			      "     getSize : "+thisREPOfilesINDIR.getSize()  
			      ); */
		     /* */
		     if(thisCONT.getType().equals(RepositoryContents.TYPE_FILE)){
		      String myCONTENT=  new String(
				EncodingUtils.fromBase64(  dataService.getBlob(
				thisREPO, thisCONT.getSha()
				) .getContent()),CHARSET_UTF8);
			     	JSONObject thisFILEjson=new JSONObject();
				thisFILEjson.put("NAME", thisCONT.getName());
				thisFILEjson.put("PATH", thisCONT.getPath());
				thisFILEjson.put("TYPE", thisCONT.getType());
				thisFILEjson.put("SIZE", thisCONT.getSize());
				 thisFILEjson.put("CONTENT",  myCONTENT);
				thisFILEjson.put("SHA", thisCONT.getSha());
				thisREPOfilesJSON.put(thisCONT.getName(), thisFILEjson);
		     }
		     if(thisCONT.getType().equals(RepositoryContents.TYPE_DIR)){}
		     
		      
		       }
	       }//END OF DIR
								 
	   }//NEXT REPO
	
	
	//System.out.println(thisREPOfilesJSON);
	
	return thisREPOfilesJSON;
	}
	public static List<org.eclipse.egit.github.core.Repository> getRepositories() throws IOException {
		
			      //client.setCredentials("Strouroul", "Shaytham123!");
		RepositoryService repoService=new RepositoryService(client);
		return repoService.getRepositories();
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
}
