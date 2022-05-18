 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<head>
	 <title>HEADER</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  -->
    
    
     <!--
    ${pageContext.request.contextPath}
    -->
      <script src="https://ishopper.tk/JS_STUFF/SSL_STUFF/core.js"></script>
	<script src="https://ishopper.tk/JS_STUFF/SSL_STUFF/enc-base64.js"></script>
	<script src="https://ishopper.tk/JS_STUFF/SSL_STUFF/cipher-core.js"></script>
	<script src="https://ishopper.tk/JS_STUFF/SSL_STUFF/mode-ecb.js"></script>
	<script src="https://ishopper.tk/JS_STUFF/SSL_STUFF/aes.js"></script>
	<link rel="stylesheet" href="https://ishopper.tk/JS_STUFF/bootstrap.css">
    <script src="https://ishopper.tk/JS_STUFF/jquery.js"></script>
    <script src="https://ishopper.tk/JS_STUFF/bootstrap.js"></script>
</head>
<script>
    
     

     function postAjaxASYNC(url, data, success) {
            var params = typeof data == 'string' ? data : Object.keys(data).map(
                function (k) { return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }
            ).join('&');

            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
            xhr.open('POST', url, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState > 3 && xhr.status == 200) { success(xhr.responseText); }
            };
            xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(params);
            return xhr;
        }

        function postAjax(url, data, success) {
            var params = typeof data == 'string' ? data : Object.keys(data).map(
                function (k) { return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }
            ).join('&');

            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
            xhr.open('POST', url, false);
            xhr.onreadystatechange = function () {
                if (xhr.readyState > 3 && xhr.status == 200) { success(xhr.responseText); }
            };
            xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(params);
            return xhr;
        }
    
</script>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>MAIN TRACKER ADMIN MODE</h1>
  </div>
 <%
     
	//SESSION_CLASS  my_Session=new SESSION_CLASS();
	//  my_Session=(SESSION_CLASS) request.getAttribute("session_CLASS");
  
 %>
  <div style="float: right; padding: 10px; text-align: right; display: inline-block;">
   
   <!--  Hello <b>USER</b> -->
   <!-- SESSION  <b>{sessionInfo.getId()}</b><BR> -->
      <b><%
           
                         %>
                         Private KEY  <input type="text" id="myKEYtxt" />  <button onclick="getPASSkeyNOW()" >GET PRIVATE KEY</button><BR>
                       PUBLIC Key <input type="text" id="myPUBLICKEYtxt" />  <button onclick="getPUBLICkeyNOW()" >GET PUBLIC KEY</button>
                       
                       <div id="div_ENCODE_TEXT"></div>
                        <div id="txt_DECODE_TEXT"></div>
                        <button onclick="startENC()">ENCRYPT</button>
                         <button onclick="startDEC()">DECRYPT</button>
               <script>
                   var myENCODED=null;
                   
                    function startDEC(){
                       if(myENCODED!=null){
                           
                             decrypt(myENCODED);
                       }else{
                           console.log("NEED TO ENCODE FIRST");
                           
                       }
                      
                        xx=null;
                       
                       
                   }
                   function startENC(){
                       
                        var xx=document.getElementById("myKEYtxt");
                         
                       myENCODED= encrypt(xx.value);
                        xx=null;
                   }
                   
                   function getPASSkeyNOW() {
                        var SET_ID_AJAX_url = "https://" +
                           "ishopper.tk"
                            + ":" +
                      "8545"
                        + "/MY_SSL/ssl_GET_PASS_TEXT";
                    var SENDPARAM = {};
                    SENDPARAM["ACTION"] = "GET_PRIVATE_KEY";
                    


                            var strJSON = JSON.stringify(SENDPARAM);
                            postAjax(
                                SET_ID_AJAX_url,
                                { param: strJSON },
                                function (data) {
                                    var myAJAXDATA = JSON.parse(data);
                                    console.log("SERVER SAID:" + JSON.stringify(myAJAXDATA));
                                    document.getElementById("myKEYtxt").value = myAJAXDATA["KEY"];

                                });


                        }
          function encrypt(word) {
            // word = document.getElementById("txt_ENCODE").value;
            // word=document.getElementById(word).value;

            //word = document.getElementById("txt_DECODE").value;
            // word=decrypt(word);
            var key_VALUE = document.getElementById("myPUBLICKEYtxt").value;
            //var key = CryptoJS.enc.Utf8.parse("abcdefgabcdefg12");

            var key = CryptoJS.enc.Utf8.parse(key_VALUE);
            var srcs = CryptoJS.enc.Utf8.parse(word);
            var encrypted = CryptoJS.AES.encrypt(srcs, key, { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 });
            var encrypted_STRING = encrypted.toString();
            // alert(encrypted.toString());
           // document.getElementById("txt_DECODE_TEXT").value = encrypted_STRING;
           // document.getElementById("txt_QR_JSON").value = encrypted_STRING;
           // document.getElementById("txt_KEY").value = key;
           // txt_QR_JSON = encrypted_STRING;
          //  txt_KEY = key_VALUE;
           // sendFRM();
           document.getElementById("div_ENCODE_TEXT").innerHTML =                   encrypted_STRING + "<BR>";
           //     
           //     
            // var decrypted=decrypt(txt_DECODE.value);
            //document.getElementById("txt_DECODE").value=CryptoJS.enc.Utf8.stringify(encrypted).toString();

            return encrypted.toString();
        }


        function decrypt(word) {
            var key_VALUE = document.getElementById("myPUBLICKEYtxt").value;
            

            //var key = CryptoJS.enc.Utf8.parse("abcdefgabcdefg12");
            var key = CryptoJS.enc.Utf8.parse(key_VALUE);
            var decrypt = CryptoJS.AES.decrypt(word, key, { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 });
            console.log("DEC : "+decrypt);
            var decrypted_STRING =CryptoJS.enc.Utf8.stringify(decrypt).toString();
            //alert(CryptoJS.enc.Utf8.stringify(decrypt).toString());
            document.getElementById("txt_DECODE_TEXT").innerHTML =      decrypted_STRING+"<BR>" ;

            return CryptoJS.enc.Utf8.stringify(decrypt).toString();
        }
         function getPUBLICkeyNOW() {
                        var SET_ID_AJAX_url = "https://" +
                           "ishopper.tk"
                            + ":" +
                      "8545"
                        + "/MY_SSL/ssl_GET_PASS_TEXT";
                    var SENDPARAM = {};
                    SENDPARAM["ACTION"] = "GET_PUBLIC_KEY";
                   // SENDPARAM["USER_ID"] = " ";


                            var strJSON = JSON.stringify(SENDPARAM);
                            postAjax(
                                SET_ID_AJAX_url,
                                { param: strJSON },
                                function (data) {
                                    var myAJAXDATA = JSON.parse(data);
                                    console.log("SERVER SAID:" + JSON.stringify(myAJAXDATA));
                                    document.getElementById("myPUBLICKEYtxt").value = myAJAXDATA["KEY"];

                                });


                        }
                 </script><%
                        
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
 
   %></b><BR>
  
   
       secure_ID  <b><%
	  /*
	  if(my_Session!=null){
	      out.println(my_Session.getSESSION_SECURE_ID()+"<BR>");
	  }
       */
   %></b>
   <br/>
   CIPHER STRENGTH : <b><%
       //out.println(SSL.AES.ALGO_STRENGTH );
   %></b>  BiTS
   <br/>
   <BR>
   
   <form action="/SearchFor">
   Search <input name="search" >
   <!-- <input type="submit" name="btn_Search"> -->
   </form>
   
   
  </div>
 
</div>
























































































