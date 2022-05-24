/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binance_bot;

import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author RAMEZ
 */
public class INTERVAL {
    public String INTERVAL_NAME=null;
    public String INTERVAL_SYMBOL=null;
    
    public float INTERVAL_START_PRICE=0;
      public float INTERVAL_OLD_PRICE=0;
     public float INTERVAL_NOW_PRICE=0;
    public float INTERVAL_END_PRICE=0;
    
    public Date INTERVAL_START_TIME=null;
    public Date INTERVAL_END_TIME=null;
    
       public float INTERVAL_CHANGE=0;
       
       
       
        public float INTERVAL_HIGH_POINT=0; 
        
         public float INTERVAL_LOW_POINT=0;
         
         
         
    public int INTERVAL_UPS=0;
    public int INTERVAL_DOWNS=0;
    public int INTERVAL_NOCHANGE=0;
    
           public int INTERVAL_TOTAL_UPS=0;
          public int INTERVAL_TOTAL_DOWNS=0;
          public int INTERVAL_TOTAL_NOCHANGE=0;
          
     public String INTERVAL_STATUS="";
               
    public float[] INTERVAL_DATA=null;
    
    
    public INTERVAL(String thisSYMBOLINTERVAL,String thisSYMBOL,float thisPRICE){
    this.INTERVAL_NAME=thisSYMBOLINTERVAL;
    this.INTERVAL_SYMBOL=thisSYMBOL;
    
    this.INTERVAL_START_TIME=new Date();
    
    this.INTERVAL_STATUS="START";
   
     int myINTnow=Integer.parseInt(thisSYMBOLINTERVAL.replace("_SEC", ""));
     
     Calendar now = Calendar.getInstance();
    /*System.out.println("Current time : " + now.get(Calendar.HOUR_OF_DAY) + ":"
        + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND));*/
   
    now.add(Calendar.SECOND,myINTnow );
    //System.out.println("MADE NEW    "+myINTnow+" seconds : " + now.get(Calendar.HOUR_OF_DAY) + ":"
    //    + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND));
    this.INTERVAL_END_TIME=  now.getTime();
   //   System.out.println("INTERVAL ENC : "+this.INTERVAL_END_TIME.getTime());
     
     
    this.INTERVAL_START_PRICE=thisPRICE;
    this.INTERVAL_OLD_PRICE=thisPRICE;
     this.INTERVAL_NOW_PRICE=thisPRICE;
     
    this.INTERVAL_HIGH_POINT=thisPRICE;
    this.INTERVAL_LOW_POINT=thisPRICE;
    
    
     this.INTERVAL_UPS=0;
      this.INTERVAL_DOWNS=0;
      this.INTERVAL_NOCHANGE=0;
     
       this.INTERVAL_TOTAL_UPS=0;
      this.INTERVAL_TOTAL_DOWNS=0;
      this.INTERVAL_TOTAL_NOCHANGE=0;
     
      this.INTERVAL_DATA=new float[1];
      
      this.INTERVAL_DATA[0]=thisPRICE;
      
    
    }
    
    public String GET_INTERVAL_STATUS(){
    if(this.INTERVAL_NOW_PRICE > this.INTERVAL_START_PRICE){
    this.INTERVAL_STATUS="UP";
    }else{
    this.INTERVAL_STATUS="DOWN";
    
    }
    
    return this.INTERVAL_STATUS;
    }
    
    public void UPDATE_INTERVAL(float newPRICE){
           this.INTERVAL_OLD_PRICE=this.INTERVAL_NOW_PRICE;
          this.INTERVAL_NOW_PRICE=newPRICE;
          
         
        
          
        if( this.INTERVAL_NOW_PRICE<this.INTERVAL_OLD_PRICE){
            this.INTERVAL_DOWNS++;
       } //LOSING
      
       
       if( this.INTERVAL_NOW_PRICE>this.INTERVAL_OLD_PRICE){
       this.INTERVAL_UPS++;
       } //WINNER
      
       if( this.INTERVAL_NOW_PRICE==this.INTERVAL_OLD_PRICE){
         this.INTERVAL_NOCHANGE++;
       } //NOCHANGE
       
        
       this.INTERVAL_CHANGE= this.INTERVAL_NOW_PRICE-this.INTERVAL_START_PRICE;
       
          
          Date myTIMEnow=new Date();
            if(myTIMEnow.getTime() > this.INTERVAL_END_TIME.getTime()){
                this.INTERVAL_END_PRICE=this.INTERVAL_NOW_PRICE;
                 if( (this.INTERVAL_START_PRICE< this.INTERVAL_END_PRICE) && (this.INTERVAL_CHANGE>0) //&& ( this.INTERVAL_UPS>this.INTERVAL_DOWNS) 
                         &&  (this.INTERVAL_NOW_PRICE< this.INTERVAL_END_PRICE)){
                 this.INTERVAL_TOTAL_UPS++;
                 }
                  if( (this.INTERVAL_START_PRICE> this.INTERVAL_END_PRICE) && ( this.INTERVAL_UPS<this.INTERVAL_DOWNS) &&
                          (this.INTERVAL_NOW_PRICE> this.INTERVAL_END_PRICE) && (this.INTERVAL_CHANGE<0)){
                 this.INTERVAL_TOTAL_DOWNS++;
                 }
                  
                   if( (this.INTERVAL_START_PRICE== this.INTERVAL_END_PRICE) &&
                          (this.INTERVAL_NOW_PRICE == this.INTERVAL_END_PRICE)){
                 this.INTERVAL_TOTAL_NOCHANGE++;
                 }
                  this.INTERVAL_UPS=0;
                     this.INTERVAL_DOWNS=0;
                       this.INTERVAL_NOCHANGE=0;
                    
                        this.INTERVAL_CHANGE=0;
              //   System.out.println("NEW INT FOR :"+this.INTERVAL_SYMBOL + " INT NAME : "+ this.INTERVAL_NAME);
                 int myINTnow=Integer.parseInt( this.INTERVAL_NAME.replace("_SEC", ""));
                Calendar ENDTIME = Calendar.getInstance();
                  ENDTIME.add(Calendar.SECOND,myINTnow );
                   this.INTERVAL_START_TIME=myTIMEnow;
                    this.INTERVAL_END_TIME=  ENDTIME.getTime();
                    this.INTERVAL_START_PRICE=newPRICE;
                   /*System.out.println("Current time : " + now.get(Calendar.HOUR_OF_DAY) + ":"
                       + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND));*/

                  
                 
                 /*  System.out.println("New time after adding "+this.INTERVAL_NAME+": " + now.get(Calendar.HOUR_OF_DAY) + ":"
                       + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND));*/
                   this.INTERVAL_HIGH_POINT=newPRICE;
                   this.INTERVAL_LOW_POINT=newPRICE;
      
            }else{
                if(newPRICE>this.INTERVAL_HIGH_POINT){
                  this.INTERVAL_HIGH_POINT=newPRICE;
                }
               if(newPRICE<this.INTERVAL_LOW_POINT){
                     this.INTERVAL_LOW_POINT=newPRICE;
                }
            } 
            
   
          
          
         // System.out.println(this.INTERVAL_SYMBOL+ "   "+this.INTERVAL_NOW_PRICE+ "  "+this.INTERVAL_NAME);
    }
     public String GET_CHANGE_SINCE_START(){
        
         float myWIN= (this.INTERVAL_NOW_PRICE-this.INTERVAL_START_PRICE );
                               
    String myRETURN=String.format(java.util.Locale.US,"%.10f",myWIN);
    
    return myRETURN;
    } 
    public JSONObject toJSON() throws JSONException{
    
        JSONObject myRETURN=new JSONObject();
         myRETURN.put("INTERVAL_NAME",this.INTERVAL_NAME) ;
           myRETURN.put("INTERVAL_SYMBOL",this.INTERVAL_SYMBOL) ;
             myRETURN.put("INTERVAL_START_PRICE",this.INTERVAL_START_PRICE) ;
               myRETURN.put("INTERVAL_OLD_PRICE",this.INTERVAL_OLD_PRICE) ;
                 myRETURN.put("INTERVAL_NOW_PRICE",this.INTERVAL_NOW_PRICE) ;
                   myRETURN.put("INTERVAL_END_PRICE",this.INTERVAL_END_PRICE) ;
                   
                     myRETURN.put("INTERVAL_START_TIME",this.INTERVAL_START_TIME.getTime()) ;
                       myRETURN.put("INTERVAL_END_TIME",this.INTERVAL_END_TIME.getTime()) ;
                       
                         myRETURN.put("INTERVAL_UPS",this.INTERVAL_UPS) ;
                           myRETURN.put("INTERVAL_DOWNS",this.INTERVAL_DOWNS) ;
                             myRETURN.put("INTERVAL_NOCHANGE",this.INTERVAL_NOCHANGE) ;
                             
                               myRETURN.put("INTERVAL_TOTAL_UPS",this.INTERVAL_TOTAL_UPS) ;
                                 myRETURN.put("INTERVAL_TOTAL_DOWNS",this.INTERVAL_TOTAL_DOWNS) ;
                                   myRETURN.put("INTERVAL_TOTAL_NOCHANGE",this.INTERVAL_TOTAL_NOCHANGE) ;
                                     
            
                                   
                                   return myRETURN;
      
    }
    
     public String toString(){
    
        JSONObject myRETURN=new JSONObject();
        try{
          myRETURN.put("INTERVAL_NAME",this.INTERVAL_NAME) ;
           myRETURN.put("INTERVAL_SYMBOL",this.INTERVAL_SYMBOL) ;
             myRETURN.put("INTERVAL_START_PRICE",this.INTERVAL_START_PRICE) ;
               myRETURN.put("INTERVAL_OLD_PRICE",this.INTERVAL_OLD_PRICE) ;
                 myRETURN.put("INTERVAL_NOW_PRICE",this.INTERVAL_NOW_PRICE) ;
                   myRETURN.put("INTERVAL_END_PRICE",this.INTERVAL_END_PRICE) ;
                   
                     myRETURN.put("INTERVAL_START_TIME",this.INTERVAL_START_TIME.getTime()) ;
                       myRETURN.put("INTERVAL_END_TIME",this.INTERVAL_END_TIME.getTime()) ;
                       
                         myRETURN.put("INTERVAL_UPS",this.INTERVAL_UPS) ;
                           myRETURN.put("INTERVAL_DOWNS",this.INTERVAL_DOWNS) ;
                             myRETURN.put("INTERVAL_NOCHANGE",this.INTERVAL_NOCHANGE) ;
                             
                               myRETURN.put("INTERVAL_TOTAL_UPS",this.INTERVAL_TOTAL_UPS) ;
                                 myRETURN.put("INTERVAL_TOTAL_DOWNS",this.INTERVAL_TOTAL_DOWNS) ;
                                   myRETURN.put("INTERVAL_TOTAL_NOCHANGE",this.INTERVAL_TOTAL_NOCHANGE) ;
        }
        catch(Exception ex){}
       
                                     
            
                 return myRETURN.toString();
      
    }
}
