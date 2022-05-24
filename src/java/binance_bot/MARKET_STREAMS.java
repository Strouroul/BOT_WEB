/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binance_bot;

   
import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.event.AccountUpdateEvent;
import com.binance.api.client.domain.event.AllMarketTickersEvent;
import com.binance.api.client.domain.event.OrderTradeUpdateEvent;
import com.binance.api.client.domain.event.UserDataUpdateEvent.UserDataUpdateEventType;
import java.io.BufferedReader;

  
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author RAMEZ
 */
public class MARKET_STREAMS extends Thread implements AutoCloseable {
    
    @Override
    public void close() throws Exception {
        System.out.println(" From Close -  AutoCloseable  ");
    }
    
    
   public static    Closeable onAllMarketTickersEvent=null;
     public static    Closeable WSuser=null;
  
     public static MARKET_STREAMS my_CLIENT =null;
     
     public static JSONObject coinsDATA  =new JSONObject();
     public static String coinsSTART="";
     public static JSONObject myCOINbinanceINFO=new JSONObject();
     
     
     public static BinanceApiWebSocketClient client =null;
       public static Thread client_THREAD=null;

     
       public static boolean botRUNNING=false;
       
         
        public static boolean botRUNINNG=false;
       
      
        
        
        
        public static JSONObject winnersBYCOUNTandTIME   =  new JSONObject();
         
       public static String API="nz3qvegcRSoIssmdoG6QGlwozRPIaPkgFbxppm7hsUKJP9VujEqhV144lRyAlVG9";
        public static String SECRET="dTKDi76RghJP4trBtURudet4QYwfNqrW7mploVlzM7nHurSQ5bZLIcJkv8BQBWgj";
      public static final long DEFAULT_RECEIVING_WINDOW = 5_000L;
        
        public static JSONObject myBALANCES   =  new JSONObject();
       
      
      
      
     public MARKET_STREAMS(){ //MARKET_STREAMS.myBOT=  new SHARED_DATA();
     
     System.out.println("STATUS : "+MARKET_STREAMS.isBOTrunning());
      
       
     }

     
   
    @Override
 public void run()  
    {   
         try{
                  my_CLIENT=this;

                  String[] args=new String[1];
                   my_CLIENT.main(args);
               //   my_CLIENT. STARTCLIENT();
                   
                    
                 } catch(Exception ex){System.out.println("ERROR STARTING CLIENT INSTANCE");}
       // System.out.println("Thread is running...");    
    }  

 
 public static void STARTCLIENT(){
 
    
      client = BinanceApiClientFactory.newInstance().newWebSocketClient();
 Date myTIMEnow=new Date();
    coinsSTART= String.valueOf(myTIMEnow.getTime()  );
     System.out.println("STARTED ");
 onAllMarketTickersEvent= client.onAllMarketTickersEvent( (List<AllMarketTickersEvent> response) -> {           //(List<AllMarketTickersEvent> response) -> {
      try{
            botRUNNING=true;
               showHTML(response);
         } catch(Exception ex){System.out.println( ex.getMessage());botRUNNING=false;
              try{ onAllMarketTickersEvent.close();
                   }
              catch(Exception exx){System.out.println( exx.getMessage());}
             
           }    
            
         
            
        }
                /* {  } */
        );

 
   
   WSuser =   client.onUserDataUpdateEvent(API, response -> {
            System.out.println(response);
    if (response.getEventType() == UserDataUpdateEventType.ACCOUNT_UPDATE) {
        AccountUpdateEvent accountUpdateEvent = response.getAccountUpdateEvent();
        // Print new balances of every available asset
       // System.out.println(accountUpdateEvent.getBalances()); 
        List<AssetBalance> myBALANCESNOWHERE=accountUpdateEvent.getBalances();
        //System.out.println(account.getBalances());
        for(int x=0;x<myBALANCESNOWHERE.size();x++){
            AssetBalance thisASSET=(AssetBalance) myBALANCESNOWHERE.get(x);
          //  System.out.println(thisASSET);

            if(
                    (Float.parseFloat(thisASSET.getFree())>0  ) || 
                    (Float.parseFloat(thisASSET.getLocked())>0)
               ){

                JSONObject thisASSESjson=new JSONObject();
                thisASSESjson.put("ASSETT", thisASSET.getAsset());
                thisASSESjson.put("FREE", thisASSET.getFree());
                thisASSESjson.put("LOCKED", thisASSET.getLocked());

                myBALANCES.put(thisASSET.getAsset(), thisASSESjson);
          //  System.out.println("ASSETT : "+thisASSET.getAsset());
        //    System.out.println("FREE : "+thisASSET.getFree());
          //  System.out.println("LOCKED : "+thisASSET.getLocked());
            }else{
                if(myBALANCES!=null){
                    if(myBALANCES.has(thisASSET.getAsset())){
                        myBALANCES.remove(thisASSET.getAsset());
                    }
                }
            }
        }
        System.out.println("myBALANCES : "+myBALANCES );
      } else {
        OrderTradeUpdateEvent orderTradeUpdateEvent = response.getOrderTradeUpdateEvent();

        // Print details about an order/trade
        System.out.println(orderTradeUpdateEvent);

        // Print original quantity
        System.out.println(orderTradeUpdateEvent.getOriginalQuantity());

        // Or price
        System.out.println(orderTradeUpdateEvent.getPrice());
      }
    });

 
 
 
 }
 public static void sendGETbinanceJSON() throws IOException {
           String USER_AGENT = "Mozilla/5.0";
          String GET_URL =  "https://api.binance.com/api/v3/exchangeInfo";
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			//System.out.println(response.toString());
                        String myRESP=null;
                        if( response.toString()!=null){
                        JSONObject cleanRESPONSEjson=null;
                       myRESP= response.toString();
                      
                       JSONObject allCOINSinfo =new JSONObject(myRESP);
                       for(int x=0;x<allCOINSinfo.getJSONArray("symbols").length();x++){
                           String thisSYMBOL=allCOINSinfo.getJSONArray("symbols").getJSONObject(x).getString("baseAsset");
                           if(myCOINbinanceINFO.has(thisSYMBOL)){
                            JSONArray thisQUTOES=myCOINbinanceINFO.getJSONArray(thisSYMBOL);
                           thisQUTOES.put(allCOINSinfo.getJSONArray("symbols").getJSONObject(x).getString("quoteAsset"));
                             myCOINbinanceINFO.put(thisSYMBOL, thisQUTOES);
                           }
                           else{
                           
                               
                               JSONArray thisQUTOES=new JSONArray();
                               thisQUTOES.put(allCOINSinfo.getJSONArray("symbols").getJSONObject(x).getString("quoteAsset"));
                             myCOINbinanceINFO.put(thisSYMBOL, thisQUTOES);
                             
                           }
                       }
                        
                        
                       
                       
                      
                        }
                         
                        //System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	} 
 public static JSONObject getBALANCE(){
  JSONObject thisBALANCES=new JSONObject();
    BinanceApiClientFactory factoryNOW = BinanceApiClientFactory.newInstance(API, SECRET);
    BinanceApiRestClient clientNOW = factoryNOW.newRestClient(); 
       // First, we obtain a listenKey which is required to interact with the user data stream
  //  String listenKey = clientNOW.startUserDataStream();

    // Then, we open a new web socket client, and provide a callback that is called on every update
    //BinanceApiWebSocketClient webSocketClient = factory.newWebSocketClient();

    
    // Get account balances
    Account account = clientNOW.getAccount(DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
    
    List<AssetBalance> myBALANCESNOW=new ArrayList<>();
    
    myBALANCESNOW=account.getBalances();
    //System.out.println(account.getBalances());
    for(int x=0;x<myBALANCESNOW.size();x++){
        AssetBalance thisASSET=(AssetBalance) myBALANCESNOW.get(x);
      //  System.out.println(thisASSET);
        
        if(
                (Float.parseFloat(thisASSET.getFree())>0  ) || 
                (Float.parseFloat(thisASSET.getLocked())>0)
           ){
            
            JSONObject thisASSESjson=new JSONObject();
            thisASSESjson.put("ASSETT", thisASSET.getAsset());
            thisASSESjson.put("FREE", thisASSET.getFree());
            thisASSESjson.put("LOCKED", thisASSET.getLocked());
            
            thisBALANCES.put(thisASSET.getAsset(), thisASSESjson);
      //  System.out.println("ASSETT : "+thisASSET.getAsset());
    //    System.out.println("FREE : "+thisASSET.getFree());
      //  System.out.println("LOCKED : "+thisASSET.getLocked());
        }
    }
  
  return thisBALANCES;
 }
 
     public static void main(String[] args)  throws InterruptedException, IOException {
       
         MARKET_STREAMS thisBOT=new MARKET_STREAMS();
      MARKET_STREAMS.myBALANCES=   getBALANCE();
      try{
       sendGETbinanceJSON();
      }
      catch(Exception ex){
      }
     
        if(thisBOT.isBOTrunning()){System.out.println("RUNNING");}
     else{System.out.println("NOT RUNNING");
         STARTCLIENT();
        } 

}
     
   
      
      
     public static void showHTML(List<AllMarketTickersEvent> myRESPONSE) {    //AllMarketTickersEvent   TickerEvent
      // myBALANCES=getBALANCE();
       // System.out.println(thisBAL);
         try{
            for(int x=0;x<myRESPONSE.size();x++){
            // myRESPONSE.get(x).
                
               boolean toCHECKcoin=false;
               String cleanSYMBOL=null;
               AllMarketTickersEvent thisCOIN=(AllMarketTickersEvent) myRESPONSE.get(x);
               
               if(thisCOIN.getSymbol().toLowerCase().contains("usdt"))
                {toCHECKcoin=true;
                    cleanSYMBOL=thisCOIN.getSymbol().toLowerCase().replace("usdt","").toUpperCase();}
             
                    if(toCHECKcoin){

                        if( coinsDATA.has(cleanSYMBOL)){
                            COIN thisCOINtoUPDATE=(COIN)  coinsDATA.get(cleanSYMBOL);
                            thisCOINtoUPDATE.UPDATE_COIN(thisCOIN);
                            coinsDATA.put(cleanSYMBOL, thisCOINtoUPDATE);
                        }
                        else{
                            //   System.out.println("getBestAskPrice  :"+thisTICKERevents.getBestAskPrice());
                            //   System.out.println("getBestBidPrice  :"+thisTICKERevents.getBestBidPrice());
                            //    System.out.println("getPriceChange  :"+thisTICKERevents.getPriceChange());
                            coinsDATA.put(cleanSYMBOL,new COIN(thisCOIN));
                        }
                        COIN thisCOINtoUPDATE=(COIN) coinsDATA.get(cleanSYMBOL);
                      
                        
                        /*System.out.println("SYMBOL : "+thisCOINtoUPDATE.Symbol +"   " //+thisCOINtoUPDATE.NowPrice
                        +thisCOINtoUPDATE.STATS
                        +thisCOINtoUPDATE.INTERVALS
                        );*/
                    }

                    }  
        
         }
         catch(Exception ex){
         System.out.println("SOME KINDA ERROR");
         }
        








// BinanceApiCallback myBINAPI =new BinanceApiCallback(myRESPONSE);
       //MARKET_STREAMS myBOTnow =  new MARKET_STREAMS();
     /*
     if(coinsDATA !=null){
         for(int x=0;x<myRESPONSE.size();x++){
             
             // myRESPONSE.get(x).
             TickerEvent thisCOIN=(TickerEvent) myRESPONSE.get(x);
             if(thisCOIN.getSymbol().toLowerCase().contains("usdt")){
                 String cleanSYMBOL=thisCOIN.getSymbol().toLowerCase().replace("usdt","").toUpperCase();
                // AllMarketTickersEvent thisTICKERevents=myRESPONSE.get(x); 
                  
                 if( coinsDATA.has(cleanSYMBOL)){
                     COIN thisCOINtoUPDATE=(COIN)  coinsDATA.get(cleanSYMBOL);
                       thisCOINtoUPDATE.UPDATE_COIN(thisCOIN);
                            coinsDATA.put(cleanSYMBOL, thisCOINtoUPDATE);
                 }
                 else{
          
             //   System.out.println("getBestAskPrice  :"+thisTICKERevents.getBestAskPrice());
              //   System.out.println("getBestBidPrice  :"+thisTICKERevents.getBestBidPrice());
                //    System.out.println("getPriceChange  :"+thisTICKERevents.getPriceChange());
                     coinsDATA.put(cleanSYMBOL,new COIN(thisCOIN));
                 }
                 
                 COIN thisCOINtoUPDATE=(COIN) coinsDATA.get(cleanSYMBOL);
                 System.out.println("SYMBOL : "+thisCOINtoUPDATE.Symbol +"   " //+thisCOINtoUPDATE.NowPrice
                         +thisCOINtoUPDATE.STATS 
                        +thisCOINtoUPDATE.INTERVALS  
                                 );   
                   
                   // System.out.println("JSON : "+thisCOINtoUPDATE.STATS);   
             
             }
             
        
        
         }
     }else{
     System.out.println("COINS DATA ??????????????");
     }
     */
         
       //  List<String> coinsLIST = new ArrayList<String>(coinsDATA.keySet());
        //   System.out.println("DATA : "+coinsLIST);
         //   System.out.println("LEN : "+coinsLIST.size());
          
     
        
     }
     
     
     
      public static boolean isBOTrunning(){
       boolean mySTATUS=botRUNNING;
       
       if(botRUNNING){
                if(client_THREAD!=null){
                    mySTATUS=true;
                }
         }
           return mySTATUS;
       }
       
       
       public  static void STOPnow(){
    if(botRUNNING){
        System.out.println("SWITCH OFF");
         botRUNNING=false;
    } 
               botRUNNING=false;
 //MARKET_STREAMS.client.close();
   try{
   MARKET_STREAMS.client.close();
                   MARKET_STREAMS.client=null;
                      System.out.println("SWITCH OFF  CLIENT RUNNING");  
   }catch(Exception ex){System.out.println("ALREADY CLOSED CLIENT ????");}
    
  
    try{
     System.out.println("SWITCH OFF  THREAD RUNNING");  
                    client_THREAD.interrupt();
                   client_THREAD.stop();
                   client_THREAD=null; 
                    System.out.println("SWITCH OFF  THREAD RUNNING"); 
    }
    catch(Exception ex){System.out.println("ALREADY CLOSED THREAD ????");}
    
            if(client_THREAD!=null){ 
                   
            }else{
                  System.out.println("THREAD ALREADY OFF  THREAD  ");
            }
   
            
            if(my_CLIENT!=null){
                   System.out.println("SWITCH OFF  CLASS");
                  my_CLIENT=null;
            }
            
            
      
   my_CLIENT=null;
   
   
   if(onAllMarketTickersEvent!=null){
   try{
    onAllMarketTickersEvent.close();
    onAllMarketTickersEvent=null;
   }
   catch(Exception ex){ System.out.println(ex.getMessage());}
   }else{
   System.out.println("WS ALREADY CLOSED ??");
   }
  
  
  //System.exit(0);
        }
}
