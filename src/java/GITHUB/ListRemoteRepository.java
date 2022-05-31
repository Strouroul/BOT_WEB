/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GITHUB;

/*
   Copyright 2013, 2014 Dominik Stadler
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

import java.io.IOException;
import java.util.Arrays;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.jgit.api.LsRemoteCommand;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.TreeWalk;


/**
 * Simple snippet which shows how to list heads/tags of remote repositories without
 * a local repository
 *
 * @author dominik.stadler at gmx.at
 */
public class ListRemoteRepository {

    private static final String REMOTE_URL = "https://github.com/Strouroul/BOT_WEB.git";
 
    public static void main(String[] args) throws GitAPIException {
        // then clone
        System.out.println("Listing remote repository " + REMOTE_URL);
	LsRemoteCommand myGIT=   Git.lsRemoteRepository()
                .setHeads(true)
               .setTags(true)
                 
	.setRemote(REMOTE_URL)
            .setCredentialsProvider(new UsernamePasswordCredentialsProvider("Strouroul", "Shaytham123!@"));
	
	   Repository repository =myGIT.getRepository();
	try{listRepositoryContents(repository );}
		catch(Exception ex){  System.out.println(ex.getMessage()); } 
	Collection<Ref> refs = myGIT.call();
	
	  for (Ref ref : refs) {
            System.out.println("Ref: " + ref);
	    System.out.println("Ref getName: " + ref.getName());
	    System.out.println("Ref getObjectId: " + ref.getObjectId());
	    
        }
	System.out.println("LS : " +myGIT.call().toString());
	
	
	
	
	
	/*
	try{ 
		
	}
	catch(Exception ex){  System.out.println(ex.getMessage()); }
        Collection<Ref> refs = Git.lsRemoteRepository()
                .setHeads(true)
                .setTags(true)
                .setRemote(REMOTE_URL)
                .call();

        for (Ref ref : refs) {
            System.out.println("Ref: " + ref);
	    System.out.println("Ref: " + ref.getName());
	    System.out.println("Ref: " + ref.getObjectId());
	    
        }

	final List<String> repos = Arrays.asList(
   REMOTE_URL
		//,  "Strouroul@github.com:Strouroul/BOT_WEB.git"
	);
 for (String gitRepo: repos){
	 System.out.println("REPO : "+gitRepo);
 //  lsCmd.setRemote(gitRepo);

 
  

 }
	
	/*
        final Map<String, Ref> map = Git.lsRemoteRepository()
                .setHeads(true)
                .setTags(true)
                .setRemote(REMOTE_URL)
                .callAsMap();

        System.out.println("As map");
        for (Map.Entry<String, Ref> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Ref: " + entry.getValue());
        }

        refs = Git.lsRemoteRepository()
                .setRemote(REMOTE_URL)
                .call();

        System.out.println("All refs");
        for (Ref ref : refs) {
            System.out.println("Ref: " + ref);
        }

*/
    } 
    
      
	  
    private static void listRepositoryContents(Repository repository) throws IOException {
        Ref head = repository.getRef("heads");

        // a RevWalk allows to walk over commits based on some filtering that is defined
        RevWalk walk = new RevWalk(repository);

        RevCommit commit = walk.parseCommit(head.getObjectId());
        RevTree tree = commit.getTree();
        System.out.println("Having tree: " + tree);

        // now use a TreeWalk to iterate over all files in the Tree recursively
        // you can set Filters to narrow down the results if needed
      TreeWalk treeWalk = new TreeWalk(repository);
	treeWalk.addTree(tree);
	treeWalk.setRecursive(false);
	while (treeWalk.next()) {
	    if (treeWalk.isSubtree()) {
		System.out.println("dir: " + treeWalk.getPathString());
		treeWalk.enterSubtree();
	    } else {
		System.out.println("file: " + treeWalk.getPathString());
	    }
	}
    }
}
