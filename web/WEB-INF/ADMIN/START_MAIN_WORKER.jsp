<%-- 
    Document   : VIEW_MAIN_WORKER_STATUS
    Created on : Oct 4, 2020, 8:11:42 PM
    Author     : RAMEZ
--%> 
<%@page import="binance_bot.MARKET_STREAMS"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>START MAIN TICKER</title>
    </head>
    <body>
          <jsp:include page="../layout/_header.jsp"></jsp:include><BR>
        <jsp:include page="../layout/_menu.jsp"></jsp:include>
        <h1>START MAIN TICKER</h1>
        
        <%
           
               
        
            
try{
       if(MARKET_STREAMS.my_CLIENT!=null){out.println("Already Running");}
           else{out.println("NOT Running");}
            out.println(MARKET_STREAMS.botRUNNING);
            
     MARKET_STREAMS thisBOT=new MARKET_STREAMS();
        thisBOT.run();
}
catch(Exception ex){
 out.println(ex.getMessage());
}

            %>
    </body>
</html>
