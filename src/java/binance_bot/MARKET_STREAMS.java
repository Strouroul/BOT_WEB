/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binance_bot;

   
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.event.AllMarketTickersEvent;

  
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
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
    
     public static MARKET_STREAMS my_CLIENT =null;
     
     public static JSONObject coinsDATA  =new JSONObject();
     public static String coinsSTART="";
     
     public static BinanceApiWebSocketClient client =null;
       public static Thread client_THREAD=null;

     
       public static boolean botRUNNING=false;
       
         
        public static boolean botRUNINNG=false;
       
      
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
 
onAllMarketTickersEvent = client.onAllMarketTickersEvent((List<AllMarketTickersEvent> response) -> {
         
            //System.out.println(response.getClass());
           // System.out.println(response);
              try{
                     botRUNNING=true;
               showHTML(response);
              } catch(Exception ex){System.out.println( ex.getMessage());botRUNNING=false;
              try{ onAllMarketTickersEvent.close();
              }
              catch(Exception exx){System.out.println( exx.getMessage());}
             
           }
           if(botRUNNING){}
           else{
           
           }
            
           /*
            AllMarketTickersEvent   allMarketTickersEvent=null;
            try{
            //  showHTML(response);
            /////           TickerEvent        AllMarketTickersEvent
            for (Iterator iter = response.iterator(); iter.hasNext(); )  {
            ObjectMapper mapper = new ObjectMapper();
            allMarketTickersEvent  = mapper.convertValue(iter.next(), AllMarketTickersEvent.class);
            if(allMarketTickersEvent!=null){//System.out.println("GOOD");
            boolean toCHECKcoin=false;
            String cleanSYMBOL=null;
            if(allMarketTickersEvent.getSymbol().toLowerCase().contains("usdt"))
            {toCHECKcoin=true;
            cleanSYMBOL=allMarketTickersEvent.getSymbol().toLowerCase().replace("usdt","").toUpperCase();
            }
            
            
            
            
            if(toCHECKcoin){
            if( coinsDATA.has(cleanSYMBOL)){
            COIN thisCOINtoUPDATE=(COIN)  coinsDATA.get(cleanSYMBOL);
            thisCOINtoUPDATE.UPDATE_COIN((AllMarketTickersEvent)allMarketTickersEvent);
            coinsDATA.put(cleanSYMBOL, thisCOINtoUPDATE);
            }
            else{
            //   System.out.println("getBestAskPrice  :"+thisTICKERevents.getBestAskPrice());
            //   System.out.println("getBestBidPrice  :"+thisTICKERevents.getBestBidPrice());
            //    System.out.println("getPriceChange  :"+thisTICKERevents.getPriceChange());
            coinsDATA.put(cleanSYMBOL,new COIN((AllMarketTickersEvent)allMarketTickersEvent));
            }
            COIN thisCOINtoUPDATE=(COIN) coinsDATA.get(cleanSYMBOL);
            System.out.println("SYMBOL : "+thisCOINtoUPDATE.Symbol +"   " //+thisCOINtoUPDATE.NowPrice
            +thisCOINtoUPDATE.STATS
            +thisCOINtoUPDATE.INTERVALS
            );
            }
            
            }
            }
            
            
            
            
            
            }
            catch(Exception ex){ System.out.println(ex.getMessage());}
            
            */
            
         
            
        }
                /* {  } */
        );
 
    
 }
 
     public static void main(String[] args)  throws InterruptedException, IOException {
       
         MARKET_STREAMS thisBOT=new MARKET_STREAMS();
        if(thisBOT.isBOTrunning()){System.out.println("RUNNING");}
     else{System.out.println("NOT RUNNING");
         STARTCLIENT();
        } 

}
     
   
      
      
     public static void showHTML(List<AllMarketTickersEvent> myRESPONSE) {    //AllMarketTickersEvent   TickerEvent
        
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
