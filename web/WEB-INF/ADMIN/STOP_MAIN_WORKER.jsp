<%-- 
    Document   : STOP_MAIN_WORKER
    Created on : Oct 4, 2020, 8:33:39 PM
    Author     : RAMEZ
--%>

<%@page import="binance_bot.MARKET_STREAMS"%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STOP MAIN TICKER</title>
    </head>
    <body>
         <jsp:include page="../layout/_header.jsp"></jsp:include><BR>
        <jsp:include page="../layout/_menu.jsp"></jsp:include>
       
         <%
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
                       
               
               
            %>
    </body>
</html>
