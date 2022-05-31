/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GITHUB;

import static GITHUB.GITutils.ISrepo;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.TreeWalk;

/**
 *
 * @author RAMEZ
 */
public class TESTGIT {
	  public static void main(String[] args) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder
                .setGitDir(new File("D:\\JAVA_CHECKOUT\\BOT_WEB\\.git"))
                .findGitDir().build();

        listRepositoryContents(repository);

        repository.close();
	
	 boolean isREPO=ISrepo(repository);
	 System.out.println(isREPO);
	 
	  
	/* Git git = new Git(repository);
	 
	 CredentialsProvider cp = new UsernamePasswordCredentialsProvider("username", "p4ssw0rd");
Collection<Ref> remoteRefs = git.log()
    .setCredentialsProvider(cp)
    .setRemote("origin")
    .setTags(true)
    .setHeads(false)
    .call();
for (Ref ref : remoteRefs) {
    System.out.println(ref.getName() + " -> " + ref.getObjectId().name());
}*/
    }

	  
	  
	 
	  
	  
    private static void listRepositoryContents(Repository repository) throws IOException {
        Ref head = repository.getRef("HEAD");

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
