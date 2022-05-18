package org.apache.jsp.WEB_002dINF.ADMIN;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import binance_bot.COIN;
import binance_bot.MARKET_STREAMS;
import java.util.List;
import org.json.JSONObject;

public final class CHECK_005fMAIN_005fTICKER_005fSTATUS_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>CHECK_MAIN_TICKER_STATUS</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layout/_header.jsp", out, false);
      out.write("<BR>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layout/_menu.jsp", out, false);
      out.write("\n");
      out.write("         <h1>CHECK STATUS </h1>\n");
      out.write("         ");

            
             
             
             try{
                
                 
                  if(MARKET_STREAMS.my_CLIENT!=null){  out.println("CLIENT   RUNNING"+"<BR>");
                 out.println("FROM CLASS STATUS : "+MARKET_STREAMS.isBOTrunning()+"<BR>");
                }
                else{
                    out.println("CLIENT NOT RUNNING"+"<BR>");
                 out.println("FROM CLASS STATUS : "+MARKET_STREAMS.isBOTrunning()+"<BR>");
                    
                }  
             ///////////////////////////////////////////////////////////////////////
              if(MARKET_STREAMS.coinsDATA!=null){
               if(!MARKET_STREAMS.coinsDATA.isEmpty()){
                     out.println("COINS FOUND : "+ MARKET_STREAMS.coinsDATA.names().length()+"<BR>");
                     for(int x=0;x< MARKET_STREAMS.coinsDATA.names().length();x++){
                       String  thisCOINNAME=  MARKET_STREAMS.coinsDATA.names().getString(x);
                       
                       COIN thisCOIN=(COIN)MARKET_STREAMS.coinsDATA.get(thisCOINNAME);
                       out.println("COIN SYMB : "+thisCOIN.Symbol);
                       out.println("COIN  PRICE: "+thisCOIN.NowPrice+"<BR>");
                       out.println("COIN STATS : "+thisCOIN.STATS);
                       out.println("<BR> " );
                        //   out.println("COIN STATS : "+thisCOIN.INTERVALS);
                           for(int xx=0;xx< thisCOIN.INTERVALS.names().length();xx++){
                                String intNAME=thisCOIN.INTERVALS.names().getString(xx);
                                JSONObject thisINTJSON=new JSONObject( thisCOIN.INTERVALS.get(intNAME).toString());
                                out.println(intNAME+"  :  "+thisINTJSON+"<BR>"); 
                                
                            
                               /* for(int xxxx=0;xxxx<thisINTJSON.names().length();xxxx++){
                                    String intKEY=thisINTJSON.names().getString(xxxx);
                                    String intVAL=thisINTJSON.get(intKEY).toString();
                                     out.println(intKEY+"  :  "+intVAL+"<BR>"); 
                                }*/ 
                                  
                                
                            } 
                        out.println("<BR> " );
                     }
                    }
                    else{
                    out.println("NULL");}
              }
             
             
             
             } 
             catch(Exception ex){out.println("ERROR: "+ex.getMessage());}
               
             
             
                 
            
             
           
                 
      out.write("\n");
      out.write("                 \n");
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
