<%-- 
    Document   : CHECK_MAIN_TICKER_STATUS
    Created on : Oct 4, 2020, 8:21:23 PM
    Author     : RAMEZ
--%>

<%@page import="binance_bot.COIN"%>
<%@page import="binance_bot.MARKET_STREAMS"%>
<%@page import="java.util.List"%>
<%@page import="org.json.JSONObject"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CHECK_MAIN_TICKER_STATUS</title>
    </head>
    <body>
          <jsp:include page="../layout/_header.jsp"></jsp:include><BR>
        <jsp:include page="../layout/_menu.jsp"></jsp:include>
         <h1>CHECK STATUS </h1>
         <%
            
             
             
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
               
             
             
                 
            
             
           
                 %>
                 
    </body>
</html>
