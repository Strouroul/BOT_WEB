/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EGIT;

import static EGIT.finalGITMAN.PARSEREPOFILES;
import static EGIT.finalGITMAN.getREPOfiles;
import static EGIT.finalGITMAN.myREPOS;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.egit.github.core.RepositoryContents;
import org.json.JSONObject;

/**
 *
 * @author RAMEZ
 */
@WebServlet(name = "showGITHUB", urlPatterns = {"/showGITHUB"})
public class showGITHUB extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			finalGITMAN thisGITMAN=new finalGITMAN();
		out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet starter</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet starter at " + request.getContextPath() + "</h1>");
			
		  for (org.eclipse.egit.github.core.Repository thisREPO : myREPOS){
		     if(thisREPO.getName().equals("strouroul.github.io")){
		        System.out.println("REPO NAME : "+thisREPO.getName());
		        List<RepositoryContents> myFILES=new ArrayList<>();
			try{ 
			    myFILES =   getREPOfiles(thisREPO,""); 
			}catch(Exception ex){System.out.println("ERROR : "+ex.getMessage());}
			JSONObject myINFO=  PARSEREPOFILES(thisREPO,myFILES);
			for(int x=0;x<myINFO.names().length();x++){
				String myKEY=myINFO.names().getString(x);
				JSONObject thisVAL=myINFO.getJSONObject(myKEY); 
				  System.out.println("myKEY   : "+myKEY);
				
				if(myKEY.equals("index.html")){
				out.println("NAME"+" : "+thisVAL.getString("NAME")+
					"TYPE"+" : "+thisVAL.getString("TYPE")+
					"CONTENT"+" :  <pre>"+
					thisVAL.getString("CONTENT").replace("\n", "").replace("<", "< ").replace(">", " >")+
					"</pre> "+
						"<BR>");
				
				 System.out.println("VAL   : "+thisVAL.getString("CONTENT").replace("\n", "<BR>"));
				
				}
				 
				/*for (int y=0;y<thisVAL.names().length();y++){
					String subKEY=thisVAL.names().getString(y);
					String subVAL=thisVAL.getString(subKEY);
					out.println(subKEY+" : "+subVAL+"<BR>");
				}*/
			out.println( "<BR>");	
			}
			 
		      }//   strouroul.github.io  
		  }
		  
		  out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
