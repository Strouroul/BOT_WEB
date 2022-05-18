package org.apache.jsp.WEB_002dINF.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _005fmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("     \r\n");
      out.write("<head>\r\n");
      out.write("\t <title>MENU</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write(" \r\n");
      out.write("<div style=\"padding: 5px;\">\r\n");
      out.write("    \r\n");
      out.write("    <a href=\"https://ishopper.tk/index_LAYOUT.html\">HOME</a>\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("   \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("    <div style=\"padding: 5px;\"> \r\n");
      out.write("   <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CHECK_MAIN_TICKER_STATUS\">CHECK_MAIN_TICKER_STATUS</a>  \r\n");
      out.write("    | \r\n");
      out.write("   <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/START_MAIN_WORKER\">START_MAIN_WORKER</a>  \r\n");
      out.write("    |\r\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/STOP_MAIN_TICKER\">STOP_MAIN_TICKER</a>\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("</div>\r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("   <!--  \r\n");
      out.write("    <div style=\"padding: 5px;\"> \r\n");
      out.write("     <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/NEW_MAKE_CLASSES_FROM_DB\">NEW_MAKE_CLASSES_FROM_DB</a>    \r\n");
      out.write("      |  \r\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/New_READ_FROM_TABLES\">New_READ_FROM_TABLES</a>\r\n");
      out.write("    |\r\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/WRITE_Module_TABLES\">WRITE_Module_TABLES (ALL IN JSON) WRITE TO CLASS_INFO.json</a>\r\n");
      out.write("      \r\n");
      out.write("     <div style=\"padding: 5px;\">\r\n");
      out.write("   SSL STUFF (SERVER SIDE AND JS)  <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Test_AES\">Test_AES</a>\r\n");
      out.write("     </div>\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("   -->\r\n");
      out.write("   \r\n");
      out.write("      \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
