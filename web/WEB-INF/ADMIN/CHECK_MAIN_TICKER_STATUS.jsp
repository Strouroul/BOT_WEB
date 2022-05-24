<%-- 
    Document   : CHECK_MAIN_TICKER_STATUS
    Created on : Oct 4, 2020, 8:21:23 PM
    Author     : RAMEZ
--%>
 
<%@page import="binance_bot.MyJSONComparator"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="binance_bot.INTERVAL"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
            
             JSONObject myWINNERSsinceSTART=new JSONObject ();
            JSONObject myLOSERSsinceSTART=new JSONObject ();
            
             JSONObject allUPSnow=new JSONObject ();
            
             
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
                      INTERVAL INT3SEC= (INTERVAL) thisCOIN.INTERVALS.get("3_SEC");
                      INTERVAL INT5SEC= (INTERVAL) thisCOIN.INTERVALS.get("5_SEC");
                      INTERVAL INT7SEC= (INTERVAL) thisCOIN.INTERVALS.get("7_SEC");
                      INTERVAL INT11SEC= (INTERVAL) thisCOIN.INTERVALS.get("11_SEC");
                       
                      // out.println("COIN 3_SEC : "+INT3SEC.GET_CHANGE_SINCE_START());
                      //  out.println("COIN 5_SEC : "+INT5SEC.GET_CHANGE_SINCE_START());
                      //   out.println("COIN 7_SEC : "+INT7SEC.GET_CHANGE_SINCE_START());
                      //    out.println("COIN 11_SEC : "+INT11SEC.GET_CHANGE_SINCE_START());
                          
                          if(
                                  (Float.parseFloat( INT3SEC.GET_CHANGE_SINCE_START())>0) &&
                                    (Float.parseFloat( INT5SEC.GET_CHANGE_SINCE_START())>0) &&
                                (Float.parseFloat( INT7SEC.GET_CHANGE_SINCE_START())>0) &&
                               (Float.parseFloat( INT11SEC.GET_CHANGE_SINCE_START())>0) 
                                  
                                  ){
                          //out.println(thisCOIN.Symbol+"<BR>");
                          JSONObject thisUPS=new JSONObject();
                          thisUPS.put("3_SEC", INT3SEC.GET_CHANGE_SINCE_START());
                            thisUPS.put("5_SEC", INT5SEC.GET_CHANGE_SINCE_START());
                              thisUPS.put("7_SEC", INT7SEC.GET_CHANGE_SINCE_START());
                                thisUPS.put("11_SEC", INT11SEC.GET_CHANGE_SINCE_START());
                          allUPSnow.put(thisCOIN.Symbol, thisUPS);
                          } 
                          
                       // out.println("COIN PROFIT : "+thisCOIN.GET_CHANGE_SINCE_START());
                       if(Float.parseFloat(thisCOIN.GET_CHANGE_SINCE_START())>0){
                      //   out.println("COIN SYMB : "+thisCOIN.Symbol);
                      // out.println("COIN  PRICE: "+String.format(java.util.Locale.US,"%.8f", thisCOIN.NowPrice)+"<BR>");
                      // out.println("COIN STATS : "+thisCOIN.STATS);
                      JSONObject toADD=new JSONObject();
                       toADD.put("WIN",thisCOIN.GET_CHANGE_SINCE_START());
                       myWINNERSsinceSTART.put(thisCOIN.Symbol,toADD);
                       myLOSERSsinceSTART.remove(thisCOIN.Symbol);
                       }else{
                     //   out.println("COIN SYMB (LOSER) : "+thisCOIN.Symbol);
                      //  out.println("COIN  PRICE (LOSER): "+String.format(java.util.Locale.US,"%.8f", thisCOIN.NowPrice)+"<BR>");
                      JSONObject toADD=new JSONObject();
                      toADD.put("LOST",thisCOIN.GET_CHANGE_SINCE_START());
                      myWINNERSsinceSTART.remove(thisCOIN.Symbol);
                       myLOSERSsinceSTART.put(thisCOIN.Symbol,toADD);
                       } 
                      // out.println("<BR> " );
                       
                        //   out.println("COIN STATS : "+thisCOIN.INTERVALS);
                           /*  out.println("INTERVALS : <BR> " );
                             out.println("3 sec : "+"  <BR>");
                             
                  JSONObject thisINTJSON= new JSONObject( thisCOIN.INTERVALS.get("3_SEC").toString());   
                             out.println("INTERVAL_START_PRICE : "+"  :  "+thisINTJSON.getFloat("INTERVAL_START_PRICE")+"<BR>"); 
                                float myWIN= (thisCOIN.NowPrice-thisINTJSON.getFloat("INTERVAL_START_PRICE"));
                             out.println("WINNING SO FAR  : "+"  :  "+String.format(java.util.Locale.US,"%.8f",myWIN)+"<BR>"); 
                             /*    
                             
                             out.println("INTERVAL_UPS : "+"  :  "+thisINTJSON.getInt("INTERVAL_UPS")+"<BR>"); 
                             out.println("INTERVAL_DOWNS : "+"  :  "+thisINTJSON.getInt("INTERVAL_DOWNS")+"<BR>"); 
                             out.println("INTERVAL_NOCHANGE : "+"  :  "+thisINTJSON.getInt("INTERVAL_NOCHANGE")+"<BR>"); 
                             
                           out.println("INTERVAL_TOTAL_UPS : "+"  :  "+thisINTJSON.getInt("INTERVAL_TOTAL_UPS")+"<BR>"); 
                           out.println("INTERVAL_TOTAL_DOWNS : "+"  :  "+thisINTJSON.getInt("INTERVAL_TOTAL_DOWNS")+"<BR>"); 
                           out.println("INTERVAL_TOTAL_NOCHANGE : "+"  :  "+thisINTJSON.getInt("INTERVAL_TOTAL_NOCHANGE")+"<BR>"); 
                    /*   for(int xx=0;xx< thisCOIN.INTERVALS.names().length();xx++){
                                String intNAME=thisCOIN.INTERVALS.names().getString(xx);
                                JSONObject thisINTJSON=new JSONObject( thisCOIN.INTERVALS.get(intNAME).toString());
                                out.println(intNAME+"  :  "+thisINTJSON+"<BR>"); 
                                
                            
                               /* for(int xxxx=0;xxxx<thisINTJSON.names().length();xxxx++){
                                    String intKEY=thisINTJSON.names().getString(xxxx);
                                    String intVAL=thisINTJSON.get(intKEY).toString();
                                     out.println(intKEY+"  :  "+intVAL+"<BR>"); 
                                }* / 
                                  
                                
                            } */
                    //    out.println("<BR> " );
                     }
                      if(MARKET_STREAMS.winnersBYCOUNTandTIME!=null){
                     
                      List<JSONObject> list=new ArrayList<>();
                      
                            for (int i = 0; i < MARKET_STREAMS.winnersBYCOUNTandTIME.names().length(); i++) {
                                if(MARKET_STREAMS.winnersBYCOUNTandTIME.getJSONObject(MARKET_STREAMS.winnersBYCOUNTandTIME.names().get(i).toString() ).getLong("TIME")== 
                                        MARKET_STREAMS.winnersBYCOUNTandTIME.getJSONObject(MARKET_STREAMS.winnersBYCOUNTandTIME.names().get(i).toString() ).getLong("LAST_TIME")){}
                                else{
                                    if(MARKET_STREAMS.winnersBYCOUNTandTIME.getJSONObject(MARKET_STREAMS.winnersBYCOUNTandTIME.names().get(i).toString() ).getLong("TIME")-MARKET_STREAMS.winnersBYCOUNTandTIME.getJSONObject(MARKET_STREAMS.winnersBYCOUNTandTIME.names().get(i).toString() ).getLong("TIME")<5000){
                                     list.add((JSONObject)  MARKET_STREAMS.winnersBYCOUNTandTIME.get(MARKET_STREAMS.winnersBYCOUNTandTIME.names().get(i).toString() ));
                                    }
                                     
                                }
                       
                    }
            
              
             
              //out.println("WINNERS : "+myWINNERSsinceSTART+"<BR><BR>");        
             
   /*   Iterator<?> keys = jsonObj.keys();
         Student student;
         while(keys.hasNext()) {
            String key = (String) keys.next();
            student = new Student(key, jsonObj.optInt(key));
            list.add(student);
         }
         Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
               return Integer.compare(s2.pwd, s1.pwd);
            }
         });*/

   
   if(list!=null){
         out.println("ALL INTERVALS UP NOW NOW :  <BR><BR>");       
          Collections.sort(list, new MyJSONComparator());
                 for (JSONObject obj : list) {
                    out.println(obj.getString("SYMBOL") +"   :  "+obj+"<BR>");
                 }
   }
     
             out.println( "<BR><BR>"); 
             
             
             
          out.println("winnersBYCOUNTandTIME : " +"<BR><BR>");
                // out.println("winnersBYCOUNTandTIME : "+MARKET_STREAMS.winnersBYCOUNTandTIME+"<BR><BR>"); 
                  for (int x=0;x<MARKET_STREAMS.winnersBYCOUNTandTIME.names().length();x++){
                   out.println(MARKET_STREAMS.winnersBYCOUNTandTIME.names().getString(x)+"  :  ");
                   out.println(MARKET_STREAMS.winnersBYCOUNTandTIME.get( MARKET_STREAMS.winnersBYCOUNTandTIME.names().getString(x) )+"<BR>");
               }
                  
              }
                      
                        out.println( "allUPSnow   <BR><BR>");
                   for (int x=0;x<allUPSnow.names().length();x++){
                   out.println(allUPSnow.names().getString(x)+"  :  ");
                   out.println(allUPSnow.get( allUPSnow.names().getString(x) )+"<BR>");
               } 
            out.println( "<BR><BR>");
out.println("LOSERS : "+myLOSERSsinceSTART+"<BR>");
                    }
                    else{
                    out.println("NULL");}
              }
                out.println( "<BR>");   out.println( "<BR>");
               if(MARKET_STREAMS.myCOINbinanceINFO!=null){
                         //out.println("myCOINbinanceINFO : "+MARKET_STREAMS.myCOINbinanceINFO+"<BR>");
                      for (int x=0;x<MARKET_STREAMS.myCOINbinanceINFO.names().length();x++){
                      
                            String myBASE=MARKET_STREAMS.myCOINbinanceINFO.names().getString(x);
                            JSONArray myQUOTE=MARKET_STREAMS.myCOINbinanceINFO.getJSONArray(myBASE);
                               out.println( myBASE+"             "+myQUOTE+"<BR>");
                            
                      }
                   }
                  else{}
                     out.println( "<BR>");
             
             } 
             catch(Exception ex){out.println("ERROR: "+ex.getMessage());}
    // out.println( "<BR><BR>");
               //out.println("allUPSnow : "+allUPSnow+"<BR><BR>");     
              
             
             
                 
            
             
           
                 %>
                 
    </body>
</html>
