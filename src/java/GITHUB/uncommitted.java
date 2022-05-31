/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GITHUB;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.RemoteRefUpdate.Status;

/**
 *
 * @author RAMEZ
 */
public class uncommitted {
	  public static void main(String[] args) throws IOException {
	 /*
		  Iterable<RevCommit> logs = git.log().call();
for(RevCommit commit : logs) {
    String commitID = commit.getName();
    if(commitID != null && !commitID.isEmpty()) {
    TableItem item = new TableItem(table, SWT.None);
    item.setText(commitID);
    // Here I want to get the file list for the commit object
}
}
		  */
	 
	  FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder
                .setGitDir(new File("D:\\JAVA_CHECKOUT\\BOT_WEB\\.git"))
                .findGitDir().build();
	 
	  }
}
