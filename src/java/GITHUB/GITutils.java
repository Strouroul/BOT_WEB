/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GITHUB;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.RemoteRefUpdate.Status;

/**
 *
 * @author RAMEZ
 */
public class GITutils {
	
	public static Repository openREPO(String myREPO)  {
         FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository =null;
	
	try{
	repository = builder
                .setGitDir(new File(myREPO))
                .findGitDir().build();
	}
	catch(Exception ex){
	}
	
	return repository;
		}
	 public static boolean ISrepo(Repository repository){
	  boolean myreturn=false;
	  
if( repository.getObjectDatabase().exists() ) {
  System.out.println("IS REPO "  );
  myreturn=true;
  
}
	  
	  return myreturn;
	  }
	
	public Set<String> getModifiedFiles(File repositoryLocalPath) {
	Set<String> modifiedFilesSet = null;
		
	
	/*	
		
	try  {
	  Git git = new Git(openREPO(repositoryLocalPath.getPath()+"\\.git"));
	
		Status status = git.status().call();
	  Set<String> modifiedFiles = status.getModified();
	  modifiedFilesSet = new HashSet<>(modifiedFiles);

	} catch (Exception e) {
	 System.out.println(e.getMessage());
	}

}*/
	return modifiedFilesSet;
	}
}
