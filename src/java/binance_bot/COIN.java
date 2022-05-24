/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binance_bot;

  
import static binance_bot.MARKET_STREAMS.winnersBYCOUNTandTIME;
import com.binance.api.client.domain.event.AllMarketTickersEvent;
import java.util.Date;
 
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author RAMEZ
 */
public class COIN {
       public String Symbol=null;
    public float BestAskPrice=0;
    public float BestBidPrice=0;
    public float PriceChange=0;
   
    
    public float NowPrice=0;
    public float OldPrice=0;
 
       public float StartPrice=0;
       
           public String STATUS=null;
       
    public JSONObject STATS=null;
 
      public JSONObject INTERVALS=null;
      
      
    public COIN(AllMarketTickersEvent thisCOINnow) throws JSONException{   // TickerEvent                            
        
     this.Symbol= thisCOINnow.getSymbol().toLowerCase().replace("usdt", "").toUpperCase();
        this.BestAskPrice=Float.valueOf( thisCOINnow.getBestAskPrice());
           this.BestBidPrice=Float.valueOf( thisCOINnow.getBestAskPrice());
              this.PriceChange=Float.valueOf( thisCOINnow.getPriceChange());
              
                 this.StartPrice=Float.valueOf( thisCOINnow.getOpenPrice());
                 this.NowPrice=Float.valueOf( thisCOINnow.getOpenPrice());
                  this.OldPrice= Float.valueOf(thisCOINnow.getOpenPrice());
                  this.STATUS="START";
                 this.STATS=new JSONObject();
                  this.STATS.put("UP", 0);
                  this.STATS.put("DOWN", 0);
                  this.STATS.put("NOCHANGE", 0);
                  
                     this.INTERVALS=new JSONObject();
                    this.INTERVALS.put("3_SEC", new INTERVAL("3_SEC",this.Symbol,  this.StartPrice) );
                      this.INTERVALS.put("5_SEC", new INTERVAL("5_SEC",this.Symbol,  this.StartPrice) );
                   this.INTERVALS.put("7_SEC", new INTERVAL("7_SEC",this.Symbol,  this.StartPrice) );
                   this.INTERVALS.put("11_SEC", new INTERVAL("11_SEC",this.Symbol,  this.StartPrice) );
                    
                   // this.STATS.put("3_SEC", new JSONObject () );
                 // this.STATS.put("5_SEC", new JSONObject());
                 // this.STATS.put("7_SEC", new JSONObject());
                //   this.STATS.put("11_SEC", new JSONObject());
                  //this.STATS.put("13_SEC", new JSONObject());
                 // this.STATS.put("17_SEC", new JSONObject());
                 //  this.STATS.put("19_SEC", new JSONObject());
                //  this.STATS.put("25_SEC", new JSONObject());
    }
    
    
    public void UPDATE_COIN(AllMarketTickersEvent thisCOINnow) throws JSONException{     // TickerEvent                   
    float newPRICE=Float.valueOf( thisCOINnow.getOpenPrice()); 
    
    JSONObject WINNERwinnerCHICKENdinner=new JSONObject();
    WINNERwinnerCHICKENdinner.put("3_SEC", false);
    WINNERwinnerCHICKENdinner.put("5_SEC", false);
    WINNERwinnerCHICKENdinner.put("7_SEC", false);
    WINNERwinnerCHICKENdinner.put("11_SEC", false);
    
       JSONObject toADDwinner=new JSONObject();  
     toADDwinner.put("SYMBOL", this.Symbol);
    
     try{
    INTERVAL this3SEC=(INTERVAL)this.INTERVALS.get("3_SEC"); 
    this3SEC.UPDATE_INTERVAL(newPRICE); 
          if(( Float.parseFloat( this3SEC.GET_CHANGE_SINCE_START()) >0 )
                  &&(this3SEC.INTERVAL_UPS>this3SEC.INTERVAL_DOWNS)
                  
                  ){
              toADDwinner.put("HIGH", this3SEC.INTERVAL_HIGH_POINT);
               toADDwinner.put("LOW", this3SEC.INTERVAL_LOW_POINT);
        WINNERwinnerCHICKENdinner.put("3_SEC", true);
          } 
    }
    catch(Exception ex){
        System.out.println("ERROR UPDATING INTERVAL "+ex.getMessage());
    }
      try{
    INTERVAL this5SEC=(INTERVAL)this.INTERVALS.get("5_SEC"); 
    this5SEC.UPDATE_INTERVAL(newPRICE); 
     if(( Float.parseFloat( this5SEC.GET_CHANGE_SINCE_START()) >0 )
               &&(this5SEC.INTERVAL_UPS>this5SEC.INTERVAL_DOWNS)){
           WINNERwinnerCHICKENdinner.put("5_SEC", true);
          } 
    }
    catch(Exception ex){
        System.out.println("ERROR UPDATING INTERVAL "+ex.getMessage());
    } 
      try{
     INTERVAL this7SEC=(INTERVAL)this.INTERVALS.get("7_SEC"); 
    this7SEC.UPDATE_INTERVAL(newPRICE);
     if( Float.parseFloat( this7SEC.GET_CHANGE_SINCE_START()) >0 ){
          WINNERwinnerCHICKENdinner.put("7_SEC", true);
          } 
     
   
    }
    catch(Exception ex){
        System.out.println("ERROR UPDATING INTERVAL "+ex.getMessage());
    } 
         
           try{
    
      INTERVAL this11SEC=(INTERVAL)this.INTERVALS.get("11_SEC"); 
    this11SEC.UPDATE_INTERVAL(newPRICE);
     if( Float.parseFloat( this11SEC.GET_CHANGE_SINCE_START()) >0 ){
         WINNERwinnerCHICKENdinner.put("11_SEC", true);
          }  
    }
    catch(Exception ex){
        System.out.println("ERROR UPDATING INTERVAL "+ex.getMessage());
    } 
           
       Date myTIMEocc=new Date();     
       toADDwinner.put("NOW",String.format(java.util.Locale.US,"%.10f",newPRICE) );
           if( WINNERwinnerCHICKENdinner.getBoolean("3_SEC")
                  /*  &&  WINNERwinnerCHICKENdinner.getBoolean("5_SEC")
                  &&   WINNERwinnerCHICKENdinner.getBoolean("7_SEC")
                   &&  WINNERwinnerCHICKENdinner.getBoolean("11_SEC")
                   */
                   
                   
                   ){
                  
                  
                    if(winnersBYCOUNTandTIME.has(this.Symbol)){
                        JSONObject thisWINNERtoUPDATE=winnersBYCOUNTandTIME.getJSONObject(this.Symbol);
                        toADDwinner.put("LAST_COUNT", thisWINNERtoUPDATE.getInt("COUNT") );
                    toADDwinner.put("COUNT", (thisWINNERtoUPDATE.getInt("COUNT")+1));
                    toADDwinner.put("TIME", myTIMEocc.getTime());
                     toADDwinner.put("LAST_TIME", thisWINNERtoUPDATE.getLong("TIME") );
                      winnersBYCOUNTandTIME.put(this.Symbol, toADDwinner);
                    }
                    else{
                     toADDwinner.put("LAST_COUNT", 1);
                    toADDwinner.put("COUNT", 1);
                    toADDwinner.put("TIME", myTIMEocc.getTime());
                       toADDwinner.put("LAST_TIME", myTIMEocc.getTime());
                    winnersBYCOUNTandTIME.put(this.Symbol, toADDwinner);
                    
                    }
                 
           }else{
              if(winnersBYCOUNTandTIME.has(this.Symbol)){
                    JSONObject thisWINNERtoUPDATE=winnersBYCOUNTandTIME.getJSONObject(this.Symbol);
                     if((thisWINNERtoUPDATE.getInt("COUNT")-2)<=0){
                     winnersBYCOUNTandTIME.remove(this.Symbol);
                     }
                     else{
                      toADDwinner.put("LAST_COUNT", thisWINNERtoUPDATE.getInt("COUNT") );
                    toADDwinner.put("COUNT", (thisWINNERtoUPDATE.getInt("COUNT")-2));
                    toADDwinner.put("TIME", myTIMEocc.getTime());
                         toADDwinner.put("LAST_TIME", thisWINNERtoUPDATE.getLong("TIME") );
                      winnersBYCOUNTandTIME.put(this.Symbol, toADDwinner);
                     }
                      
                   }
           }
     
    //
     
       if( this.NowPrice>newPRICE){
            this.STATS.put("DOWN",  (this.STATS.getInt("DOWN")+1) );
       } //LOSING
      
       
       if( this.NowPrice<newPRICE){
       this.STATS.put("UP",  (this.STATS.getInt("UP")+1) );
       } //WINNER
      
       if( this.NowPrice==newPRICE){
         this.STATS.put("NOCHANGE",  (this.STATS.getInt("NOCHANGE")+1) );
       } //NOCHANGE
       
          this.OldPrice=this.NowPrice;
          this.NowPrice=newPRICE;
    }
    
    
    
    public JSONObject toJSON() throws JSONException{
    
    JSONObject thisRETURN=new JSONObject();
    thisRETURN.put("SYMBOL", this.Symbol);
    thisRETURN.put("BestAskPrice", this.BestAskPrice);
    thisRETURN.put("BestBidPrice", this.BestBidPrice);
    thisRETURN.put("PriceChange", this.PriceChange);
    thisRETURN.put("NowPrice", this.NowPrice);
    thisRETURN.put("OldPrice", this.OldPrice);
    //thisRETURN.put("STATS", this.STATS);
    
    
    return thisRETURN;
    }
    
    
    public String GET_CHANGE_SINCE_START(){
        
         float myWIN= (this.NowPrice-this.StartPrice );
                               
    String myRETURN=String.format(java.util.Locale.US,"%.10f",myWIN);
    
    return myRETURN;
    }
}
