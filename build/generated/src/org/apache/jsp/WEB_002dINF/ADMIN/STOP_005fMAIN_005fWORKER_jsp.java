package org.apache.jsp.WEB_002dINF.ADMIN;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import binance_bot.MARKET_STREAMS;

public final class STOP_005fMAIN_005fWORKER_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>STOP MAIN TICKER</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layout/_header.jsp", out, false);
      out.write("<BR>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layout/_menu.jsp", out, false);
      out.write("\n");
      out.write("       \n");
      out.write("         ");

                    try{
                      if(MARKET_STREAMS.botRUNNING){out.println("RUNNING");
                               
                                MARKET_STREAMS.STOPnow();
                                   // try{ }
                             // catch(Exception ex){System.out.println("ERROR : "+ex.getMessage());}
                                }else{
                               out.println("NOT RUNNING");
                               } 
                    }
                    catch(Exception ex){}
                        
                             
                        
                        
                        
         /*   if(thisBOTNOW.botRUNNING){
                    out.println("CLIENT RUNNING : " +thisBOTNOW.botRUNNING +"<BR>");
                        //ClientSTARTER myCLIENTnowTOSTOP=ClientSTARTER.getMy_CLIENT();
                     
                    
                       out.println("CLIENT RUNNING : " +thisBOTNOW.botRUNNING +"<BR>");
                       
                            if(thisBOTNOW.my_CLIENT==null){out.println("CLIENT NOT RUNNING " +"<BR>");}
                            else{ out.println("CLIENT RUNNING : " +thisBOTNOW.botRUNNING +"<BR>");}
                     }else{
                            if(thisBOTNOW.my_CLIENT!=null){
                                    out.println("CLIENT RUNNING : " +thisBOTNOW.botRUNNING +"<BR>");
                            }else{out.println("CLIENT RUNNING : " +"FALSE" +"<BR>");}
                             if(thisBOTNOW.my_CLIENT.coinsDATA==null){out.println("CLIENT NOT RUNNING " +"<BR>");}
                                 else{ 
                                    out.println();
                                    out.println("CLIENT myCOINSdata : " +thisBOTNOW.my_CLIENT.coinsDATA  +"<BR>");

                                }
                    }
                          
                          
                     */  
                       
               
               
            
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}