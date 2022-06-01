/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EGIT;

import static EGIT.finalGITMAN.myREPOS;
import static EGIT.finalGITMAN.repositoryService;
import static binance_bot.MARKET_STREAMS.client;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.eclipse.egit.github.core.Blob;
import org.eclipse.egit.github.core.Commit;
import org.eclipse.egit.github.core.CommitUser;
import org.eclipse.egit.github.core.Reference;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.Tree;
import org.eclipse.egit.github.core.TreeEntry;
import org.eclipse.egit.github.core.TypedResource;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.UserService;


/**
 *
 * @author RAMEZ
 */
public class addTOgit {
	
	
	public static void main(String[] args){
	finalGITMAN thisGITMAN=new finalGITMAN();
	 String myNUMBnow=getRandomNumberString()+getRandomNumberString();
	
	for (org.eclipse.egit.github.core.Repository thisREPO : myREPOS){
		     if(thisREPO.getName().equals("strouroul.github.io")){
			 try{
				 	// get some sha's from current state in git
    Repository repository =  thisGITMAN.repositoryService.getRepository("Strouroul", "strouroul.github.io");
    String baseCommitSha = thisGITMAN.repositoryService.getBranches(repository).get(0).getCommit().getSha();
    RepositoryCommit baseCommit = thisGITMAN.commitService.getCommit(repository, baseCommitSha);
    String treeSha = baseCommit.getSha();

    // create new blob with data
    Blob blob = new Blob();
        blob.setContent("[\"" + System.currentTimeMillis() + "\"]").setEncoding(Blob.ENCODING_UTF8);
    String blob_sha = thisGITMAN.dataService.createBlob(repository, blob);
    Tree baseTree = thisGITMAN.dataService.getTree(repository, treeSha);

   
    String newFILEname=myNUMBnow+".txt";
    // create new tree entry
    
    String fileWITHdir="wallet/"+newFILEname;
    TreeEntry treeEntry = new TreeEntry();
    treeEntry.setPath(fileWITHdir);
    treeEntry.setMode(TreeEntry.MODE_BLOB);
    treeEntry.setType(TreeEntry.TYPE_BLOB);
    treeEntry.setSha(blob_sha);
    treeEntry.setSize(blob.getContent().length());
    Collection<TreeEntry> entries = new ArrayList<TreeEntry>();
    entries.add(treeEntry);
    Tree newTree = thisGITMAN.dataService.createTree(repository, entries, baseTree.getSha());

    // create commit
    Commit commit = new Commit();
        commit.setMessage("first commit at " + new Date(System.currentTimeMillis()).toLocaleString());
    commit.setTree(newTree);

   // UserService userService = new UserService( thisGITMAN.client );
    //User user = userService.getUser();
    CommitUser author = new CommitUser();
    //author.setName( user.getName() );
          author.setName(myNUMBnow );
           author.setEmail("kool_egypt@hotmail.com" );
    Calendar now = Calendar.getInstance();
    author.setDate(now.getTime());
    
 
    commit.setAuthor(author);
    commit.setCommitter(author);


    List<Commit> listOfCommits = new ArrayList<Commit>();
    listOfCommits.add(new Commit().setSha(baseCommitSha));
    // listOfCommits.containsAll(base_commit.getParents());
    commit.setParents(listOfCommits);
    // commit.setSha(base_commit.getSha());
    Commit newCommit = thisGITMAN.dataService.createCommit(repository, commit);

    // create resource
    TypedResource commitResource = new TypedResource();
    commitResource.setSha(newCommit.getSha());
    commitResource.setType(TypedResource.TYPE_COMMIT);
    commitResource.setUrl(newCommit.getUrl());

    // get master reference and update it
    Reference reference = thisGITMAN.dataService.getReference(repository, "heads/master");
        reference.setObject(commitResource);
        thisGITMAN.dataService.editReference(repository, reference, true);
        System.out.println("Committed URL: "+ newCommit.getUrl());
			 }
			 catch(Exception ex){
			  System.out.println("Error   : "+ex.getMessage());
			 }
			     
		     }
		     
	}
	
     
	}
	
	  public static String getRandomNumberString() {
                // It will generate 6 digit random Number.
                // from 0 to 999999
                Random rnd = new Random();
                //int number = rnd.nextInt(999999);
                int number = rnd.nextInt(99999999);
                // this will convert any number sequence into 6 character.
                return String.format("%08d", number);
            }
}
