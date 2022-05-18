package org.apache.jsp.WEB_002dINF.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _005fheader_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t <title>HEADER</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <!--  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>  -->\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("     <!--\r\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("    -->\r\n");
      out.write("      <script src=\"https://ishopper.tk/JS_STUFF/SSL_STUFF/core.js\"></script>\r\n");
      out.write("\t<script src=\"https://ishopper.tk/JS_STUFF/SSL_STUFF/enc-base64.js\"></script>\r\n");
      out.write("\t<script src=\"https://ishopper.tk/JS_STUFF/SSL_STUFF/cipher-core.js\"></script>\r\n");
      out.write("\t<script src=\"https://ishopper.tk/JS_STUFF/SSL_STUFF/mode-ecb.js\"></script>\r\n");
      out.write("\t<script src=\"https://ishopper.tk/JS_STUFF/SSL_STUFF/aes.js\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://ishopper.tk/JS_STUFF/bootstrap.css\">\r\n");
      out.write("    <script src=\"https://ishopper.tk/JS_STUFF/jquery.js\"></script>\r\n");
      out.write("    <script src=\"https://ishopper.tk/JS_STUFF/bootstrap.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<script>\r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("     function postAjaxASYNC(url, data, success) {\r\n");
      out.write("            var params = typeof data == 'string' ? data : Object.keys(data).map(\r\n");
      out.write("                function (k) { return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }\r\n");
      out.write("            ).join('&');\r\n");
      out.write("\r\n");
      out.write("            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("            xhr.open('POST', url, true);\r\n");
      out.write("            xhr.onreadystatechange = function () {\r\n");
      out.write("                if (xhr.readyState > 3 && xhr.status == 200) { success(xhr.responseText); }\r\n");
      out.write("            };\r\n");
      out.write("            xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');\r\n");
      out.write("            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\r\n");
      out.write("            xhr.send(params);\r\n");
      out.write("            return xhr;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function postAjax(url, data, success) {\r\n");
      out.write("            var params = typeof data == 'string' ? data : Object.keys(data).map(\r\n");
      out.write("                function (k) { return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }\r\n");
      out.write("            ).join('&');\r\n");
      out.write("\r\n");
      out.write("            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("            xhr.open('POST', url, false);\r\n");
      out.write("            xhr.onreadystatechange = function () {\r\n");
      out.write("                if (xhr.readyState > 3 && xhr.status == 200) { success(xhr.responseText); }\r\n");
      out.write("            };\r\n");
      out.write("            xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');\r\n");
      out.write("            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\r\n");
      out.write("            xhr.send(params);\r\n");
      out.write("            return xhr;\r\n");
      out.write("        }\r\n");
      out.write("    \r\n");
      out.write("</script>\r\n");
      out.write("<div style=\"background: #E0E0E0; height: 55px; padding: 5px;\">\r\n");
      out.write("  <div style=\"float: left\">\r\n");
      out.write("     <h1>MAIN TRACKER ADMIN MODE</h1>\r\n");
      out.write("  </div>\r\n");
      out.write(" ");

     
	//SESSION_CLASS  my_Session=new SESSION_CLASS();
	//  my_Session=(SESSION_CLASS) request.getAttribute("session_CLASS");
  
 
      out.write("\r\n");
      out.write("  <div style=\"float: right; padding: 10px; text-align: right; display: inline-block;\">\r\n");
      out.write("   \r\n");
      out.write("   <!--  Hello <b>USER</b> -->\r\n");
      out.write("   <!-- SESSION  <b>{sessionInfo.getId()}</b><BR> -->\r\n");
      out.write("      <b>");

           
                         
      out.write("\r\n");
      out.write("                         Private KEY  <input type=\"text\" id=\"myKEYtxt\" />  <button onclick=\"getPASSkeyNOW()\" >GET PRIVATE KEY</button><BR>\r\n");
      out.write("                       PUBLIC Key <input type=\"text\" id=\"myPUBLICKEYtxt\" />  <button onclick=\"getPUBLICkeyNOW()\" >GET PUBLIC KEY</button>\r\n");
      out.write("                       \r\n");
      out.write("                       <div id=\"div_ENCODE_TEXT\"></div>\r\n");
      out.write("                        <div id=\"txt_DECODE_TEXT\"></div>\r\n");
      out.write("                        <button onclick=\"startENC()\">ENCRYPT</button>\r\n");
      out.write("                         <button onclick=\"startDEC()\">DECRYPT</button>\r\n");
      out.write("               <script>\r\n");
      out.write("                   var myENCODED=null;\r\n");
      out.write("                   \r\n");
      out.write("                    function startDEC(){\r\n");
      out.write("                       if(myENCODED!=null){\r\n");
      out.write("                           \r\n");
      out.write("                             decrypt(myENCODED);\r\n");
      out.write("                       }else{\r\n");
      out.write("                           console.log(\"NEED TO ENCODE FIRST\");\r\n");
      out.write("                           \r\n");
      out.write("                       }\r\n");
      out.write("                      \r\n");
      out.write("                        xx=null;\r\n");
      out.write("                       \r\n");
      out.write("                       \r\n");
      out.write("                   }\r\n");
      out.write("                   function startENC(){\r\n");
      out.write("                       \r\n");
      out.write("                        var xx=document.getElementById(\"myKEYtxt\");\r\n");
      out.write("                         \r\n");
      out.write("                       myENCODED= encrypt(xx.value);\r\n");
      out.write("                        xx=null;\r\n");
      out.write("                   }\r\n");
      out.write("                   \r\n");
      out.write("                   function getPASSkeyNOW() {\r\n");
      out.write("                        var SET_ID_AJAX_url = \"https://\" +\r\n");
      out.write("                           \"ishopper.tk\"\r\n");
      out.write("                            + \":\" +\r\n");
      out.write("                      \"8545\"\r\n");
      out.write("                        + \"/MY_SSL/ssl_GET_PASS_TEXT\";\r\n");
      out.write("                    var SENDPARAM = {};\r\n");
      out.write("                    SENDPARAM[\"ACTION\"] = \"GET_PRIVATE_KEY\";\r\n");
      out.write("                    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            var strJSON = JSON.stringify(SENDPARAM);\r\n");
      out.write("                            postAjax(\r\n");
      out.write("                                SET_ID_AJAX_url,\r\n");
      out.write("                                { param: strJSON },\r\n");
      out.write("                                function (data) {\r\n");
      out.write("                                    var myAJAXDATA = JSON.parse(data);\r\n");
      out.write("                                    console.log(\"SERVER SAID:\" + JSON.stringify(myAJAXDATA));\r\n");
      out.write("                                    document.getElementById(\"myKEYtxt\").value = myAJAXDATA[\"KEY\"];\r\n");
      out.write("\r\n");
      out.write("                                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("          function encrypt(word) {\r\n");
      out.write("            // word = document.getElementById(\"txt_ENCODE\").value;\r\n");
      out.write("            // word=document.getElementById(word).value;\r\n");
      out.write("\r\n");
      out.write("            //word = document.getElementById(\"txt_DECODE\").value;\r\n");
      out.write("            // word=decrypt(word);\r\n");
      out.write("            var key_VALUE = document.getElementById(\"myPUBLICKEYtxt\").value;\r\n");
      out.write("            //var key = CryptoJS.enc.Utf8.parse(\"abcdefgabcdefg12\");\r\n");
      out.write("\r\n");
      out.write("            var key = CryptoJS.enc.Utf8.parse(key_VALUE);\r\n");
      out.write("            var srcs = CryptoJS.enc.Utf8.parse(word);\r\n");
      out.write("            var encrypted = CryptoJS.AES.encrypt(srcs, key, { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 });\r\n");
      out.write("            var encrypted_STRING = encrypted.toString();\r\n");
      out.write("            // alert(encrypted.toString());\r\n");
      out.write("           // document.getElementById(\"txt_DECODE_TEXT\").value = encrypted_STRING;\r\n");
      out.write("           // document.getElementById(\"txt_QR_JSON\").value = encrypted_STRING;\r\n");
      out.write("           // document.getElementById(\"txt_KEY\").value = key;\r\n");
      out.write("           // txt_QR_JSON = encrypted_STRING;\r\n");
      out.write("          //  txt_KEY = key_VALUE;\r\n");
      out.write("           // sendFRM();\r\n");
      out.write("           document.getElementById(\"div_ENCODE_TEXT\").innerHTML =                   encrypted_STRING + \"<BR>\";\r\n");
      out.write("           //     \r\n");
      out.write("           //     \r\n");
      out.write("            // var decrypted=decrypt(txt_DECODE.value);\r\n");
      out.write("            //document.getElementById(\"txt_DECODE\").value=CryptoJS.enc.Utf8.stringify(encrypted).toString();\r\n");
      out.write("\r\n");
      out.write("            return encrypted.toString();\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        function decrypt(word) {\r\n");
      out.write("            var key_VALUE = document.getElementById(\"myPUBLICKEYtxt\").value;\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("            //var key = CryptoJS.enc.Utf8.parse(\"abcdefgabcdefg12\");\r\n");
      out.write("            var key = CryptoJS.enc.Utf8.parse(key_VALUE);\r\n");
      out.write("            var decrypt = CryptoJS.AES.decrypt(word, key, { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 });\r\n");
      out.write("            console.log(\"DEC : \"+decrypt);\r\n");
      out.write("            var decrypted_STRING =CryptoJS.enc.Utf8.stringify(decrypt).toString();\r\n");
      out.write("            //alert(CryptoJS.enc.Utf8.stringify(decrypt).toString());\r\n");
      out.write("            document.getElementById(\"txt_DECODE_TEXT\").innerHTML =      decrypted_STRING+\"<BR>\" ;\r\n");
      out.write("\r\n");
      out.write("            return CryptoJS.enc.Utf8.stringify(decrypt).toString();\r\n");
      out.write("        }\r\n");
      out.write("         function getPUBLICkeyNOW() {\r\n");
      out.write("                        var SET_ID_AJAX_url = \"https://\" +\r\n");
      out.write("                           \"ishopper.tk\"\r\n");
      out.write("                            + \":\" +\r\n");
      out.write("                      \"8545\"\r\n");
      out.write("                        + \"/MY_SSL/ssl_GET_PASS_TEXT\";\r\n");
      out.write("                    var SENDPARAM = {};\r\n");
      out.write("                    SENDPARAM[\"ACTION\"] = \"GET_PUBLIC_KEY\";\r\n");
      out.write("                   // SENDPARAM[\"USER_ID\"] = \" \";\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            var strJSON = JSON.stringify(SENDPARAM);\r\n");
      out.write("                            postAjax(\r\n");
      out.write("                                SET_ID_AJAX_url,\r\n");
      out.write("                                { param: strJSON },\r\n");
      out.write("                                function (data) {\r\n");
      out.write("                                    var myAJAXDATA = JSON.parse(data);\r\n");
      out.write("                                    console.log(\"SERVER SAID:\" + JSON.stringify(myAJAXDATA));\r\n");
      out.write("                                    document.getElementById(\"myPUBLICKEYtxt\").value = myAJAXDATA[\"KEY\"];\r\n");
      out.write("\r\n");
      out.write("                                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("                 </script>");

                        
                /*
                   if(my_Session!=null){
                 String SessionID=  my_Session.getSESSION_ID();
                   
                   String SessionSECUREID=  my_Session.getSESSION_SECURE_ID();
                   // String SessionISnew =  my_Session.getSESSION_isNew();
                       
                      
                      out.println("SESSION ID : " +SessionID+"<BR>");
                       out.println("SessionSECUREID: " +SessionSECUREID+"<BR>");
                      //  out.println("SessionISnew : "+SessionISnew+"<BR>");
                    
                      
                        if(my_Session.getSESSION_USER_CLASS()!=null){
                        System.out.println("thisUSER NOT NYULL " );

                        out.println("thisUSER: " +my_Session.getSESSION_USER_CLASS().getUSER_ID()+"<BR>");
                        }else{
                        out.println("NOT LOGGED IN "  +"<BR>");
                        System.out.println("thisUSER NYULL " );

                        }
                   
                   
                   } 
             */
 
   
      out.write("</b><BR>\r\n");
      out.write("  \r\n");
      out.write("   \r\n");
      out.write("       secure_ID  <b>");

	  /*
	  if(my_Session!=null){
	      out.println(my_Session.getSESSION_SECURE_ID()+"<BR>");
	  }
       */
   
      out.write("</b>\r\n");
      out.write("   <br/>\r\n");
      out.write("   CIPHER STRENGTH : <b>");

       //out.println(SSL.AES.ALGO_STRENGTH );
   
      out.write("</b>  BiTS\r\n");
      out.write("   <br/>\r\n");
      out.write("   <BR>\r\n");
      out.write("   \r\n");
      out.write("   <form action=\"/SearchFor\">\r\n");
      out.write("   Search <input name=\"search\" >\r\n");
      out.write("   <!-- <input type=\"submit\" name=\"btn_Search\"> -->\r\n");
      out.write("   </form>\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("  </div>\r\n");
      out.write(" \r\n");
      out.write("</div>\r\n");
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
