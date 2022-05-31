/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GITHUB;
 
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

/**
 *
 * @author RAMEZ
 */
public class mainGITbot {
	public static void main(String[] args){
		try {
			/*String myREPO="D:\\JAVA_CHECKOUT\\BOT_WEB\\.git";
			Repository openREPO=GITutils.openREPO(myREPO);
			if(openREPO!=null){
			boolean isREPO=GITutils.ISrepo(openREPO);
			System.out.println(isREPO);
			
			}*/
			String myREPO="D:\\JAVA_CHECKOUT\\BOT_WEB\\.git";
			Repository openREPO=GITutils.openREPO(myREPO);
			Git git = new Git(openREPO);
			CredentialsProvider cp = new UsernamePasswordCredentialsProvider("Strouroul", "Shaytham123!");
			Collection<Ref> remoteRefs = git.lsRemote()
				.setCredentialsProvider(cp)
				.setRemote("origin")
				.setTags(true)
				.setHeads(false)
				.call();
			for (Ref ref : remoteRefs) {
				System.out.println(ref.getName() + " -> " + ref.getObjectId().name());
			}		} catch (GitAPIException ex) {
			Logger.getLogger(mainGITbot.class.getName()).log(Level.SEVERE, null, ex);
		}
	
	}
}
