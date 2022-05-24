<%-- 
    Document   : RESET_COINS_DATA
    Created on : May 19, 2022, 10:05:12 PM
    Author     : RAMEZ
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="binance_bot.MARKET_STREAMS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <jsp:include page="../layout/_header.jsp"></jsp:include><BR>
        <jsp:include page="../layout/_menu.jsp"></jsp:include>
        <h1>RESET DATA</h1>
        <%
               try{
                
                 
                  if(MARKET_STREAMS.my_CLIENT!=null){  out.println("CLIENT   RUNNING"+"<BR>");
                 out.println("FROM CLASS STATUS : "+MARKET_STREAMS.isBOTrunning()+"<BR>");
                }
                else{
                    out.println("CLIENT NOT RUNNING"+"<BR>");
                 out.println("FROM CLASS STATUS : "+MARKET_STREAMS.isBOTrunning()+"<BR>");
                    
                }
                  
                     if(MARKET_STREAMS.coinsDATA!=null){ 
                         if(MARKET_STREAMS.coinsDATA.isEmpty()){ out.println("ALREADY EMPTY");}
                         else{MARKET_STREAMS.coinsDATA=new JSONObject(); out.println("EMPTIED coinsDATA  OK ");}
                     }
                      if(MARKET_STREAMS.winnersBYCOUNTandTIME!=null){ 
                         if(MARKET_STREAMS.winnersBYCOUNTandTIME.isEmpty()){ out.println("ALREADY EMPTY");}
                         else{MARKET_STREAMS.winnersBYCOUNTandTIME=new JSONObject(); out.println("EMPTIED winnersBYCOUNTandTIME    OK ");}
                     }
                       
                     
                  
               }catch(Exception ex){
               out.println("ERROR "+ex.getMessage());
               }
                  
                  
                  %>
    </body>
</html>
