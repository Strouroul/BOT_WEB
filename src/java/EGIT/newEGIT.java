/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EGIT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.DataService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;

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
	
	
	public static void main(String[] args){
		//Basic authentication
		client.setOAuth2Token("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");	
	client.setUserAgent("GitMiner ( version: " + "2.35" + ", https://github.com/pridkett/gitminer, based off egit, user: " + "Strouroul" + " email: " + "" + " )");
	
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
								   System.out.println("getName : "+thisCONT.getName() +
								  "     getPath : "+thisCONT.getPath()+
								  "     getType : "+thisCONT.getType()+
								  "     getSize : "+thisCONT.getSize() +
								 "     getContent : "+thisCONT.getContent()+
									    "     getSha : "+thisCONT.getSha()
								  ); 
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
