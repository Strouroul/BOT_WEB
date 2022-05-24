<%-- 
    Document   : SHOWWS
    Created on : May 21, 2022, 7:39:07 PM
    Author     : RAMEZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
        <div id="divRESULT"></div>
        
        <script>
            var divRESULT=document.getElementById("divRESULT");
            var myJSONid={ID:"fewihfiuwhefi",JSID:"fewiuhfiwhefiwheunwevnowevnowe"};
            var myURL="ws://localhost:8080/BOT_WEB/BOT_WEB/"+JSON.stringify(myJSONid);
            
           var myDATA={}; 
            
            
            var conn = new WebSocket(myURL);//new WebSocket("wss://dex.binance.org/api/ws");
    conn.onopen = function (evt) {
      // send Subscribe/Unsubscribe messages here (see below)

      // for data topics such as marketDepth, marketDelta, trades and ticker;
      // a list of symbols is required. Same message can be used to append new topic and/or symbols


      //conn.send(JSON.stringify(mySUB));
      //   conn.send(JSON.stringify({ method: "subscribe", topic: "allTickers", symbols: ["$all"] }));
      // conn.send(JSON.stringify({ method: "keepAlive" }));
      
      //console.log(JSON.stringify(evt));
    }
    conn.onmessage = function (evt) {
   //    console.info('received data', evt.data);
   //   divRESULT.innerHTML =  evt.data;
    var myDATAjson = JSON.parse(evt.data);
if( Object.keys(myDATAjson).length>0){
    var myKEYS; 
  
    for(myKEYS in myDATAjson){ 
       
     
       if(myKEYS==="ACCOUNT"){}
       else{
        if(myDATA.hasOwnProperty(myKEYS)){ 
             myDATA[myKEYS]["LAST_COUNT"]=myDATAjson[myKEYS]["LAST_COUNT"]; 
              myDATA[myKEYS]["COUNT"]=myDATAjson[myKEYS]["COUNT"]; 
               myDATA[myKEYS]["NOW"]=myDATAjson[myKEYS]["NOW"]; 
                  
        }else{ 
          //  var toADDjson={SYMBOL:myKEYS,COUNT:0};
            myDATA[myKEYS]={NOW:myDATAjson[myKEYS]["NOW"],
                COUNT:myDATAjson[myKEYS]["COUNT"],
                LAST_COUNT:myDATAjson[myKEYS]["LAST_COUNT"]
            };
        } 
           
       }
        
    }
    
   
   
}
  var mySTR=""; 

 for(myKEYS in myDATA){
        if(myDATAjson.hasOwnProperty(myKEYS)){
          
            
        }
        else{
            if(myDATA[myKEYS]["COUNT"]-2<0){ delete myDATA[myKEYS];}
            else{myDATA[myKEYS]["COUNT"]=myDATA[myKEYS]["COUNT"]-2;
           /*   mySTR=mySTR+
                   myKEYS+"   :  "+ myDATA[myKEYS]["COUNT"] +"<BR>"+JSON.stringify(myDATA[myKEYS] ) +"<BR>";*/
                }
           
        }
      mySTR=mySTR+
              myKEYS+"   :  "+ myDATA[myKEYS]["COUNT"] +"("+  myDATA[myKEYS]["LAST_COUNT"] +")<BR>"+JSON.stringify(myDATA[myKEYS] ) +"<BR>";
    }
      divRESULT.innerHTML= JSON.stringify(myDATAjson["ACCOUNT"]) +"<BR>"+
              Object.keys(myDATA)+"<BR>"+"<BR>"+mySTR;
         //     JSON.stringify(myDATA)+"<BR>";
             // +  JSON.stringify( evt.data);   


    };
    conn.onerror = function (evt) {
      console.error('an error occurred', evt.data);
    };
            
        </script>
        <%
            
            %>
    </body>
</html>
