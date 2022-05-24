/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

  
import binance_bot.COIN;
import binance_bot.MARKET_STREAMS;
import binance_bot.MyJSONComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author RAMEZ
 */
@ServerEndpoint(
        value = "/BOT_WEB/{MAINworker}" 
        //value = "/WS_CONNECT_WORKER/{worker_JS_CLASS}/{js_ID}/{session_ID}/{secure_ID}" 
)
 

 
public class MAIN_WORKER {
    private Date MAINWORKERstart=new Date(); 
    public JSONObject  myWORKERS=new JSONObject ();
 public static ScheduledExecutorService executorWSPRICE =null;
  
   @OnOpen
    public void onOpen(Session session ,
             @PathParam("MAINworker") String MAINworker
            
             ) { 
        
      //  System.out.println("SYSTEM LOGIN GOT  : "+MAINworker);
    JSONObject my_USER_JSON=null;
     JSONObject thisSESSION=null;
    
    String cleanSTRnowforJSONobj="{"+MAINworker+"}";
 
    my_USER_JSON=new JSONObject(cleanSTRnowforJSONobj);
    System.out.println("SYSTEM LOGIN GOT  : "+my_USER_JSON);
         if(myWORKERS!=null){ 
             if(my_USER_JSON.optString("ID")!=null){
                 my_USER_JSON.put("WS", session);
                  
                   try
                { 
                      //////////////////////////////////////////////////////////////////////////
                Runnable helloRunnable = new Runnable() {
                   // private boolean stop=false;
                       
                    @Override
                     public void run() {
                          JSONObject toSENDnow=new JSONObject();
                            try {
                             
                               if(session !=null){
                                   if(session.isOpen()){
                                       try{
                                             toSENDnow.put("ACCOUNT", MARKET_STREAMS.myBALANCES);
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
                                     
                                        if(list!=null){
                                             //   out.println("ALL INTERVALS UP NOW NOW :  <BR><BR>");       
                                                 Collections.sort(list, new MyJSONComparator());
                                                        for (JSONObject obj : list) {
                                                          // out.println(obj.getString("SYMBOL") +"   :  "+obj+"<BR>");
                                                          if(MARKET_STREAMS.coinsDATA!=null){
                                                            if(!MARKET_STREAMS.coinsDATA.isEmpty()){
                                                          obj.put("DATA",((COIN)MARKET_STREAMS.coinsDATA.get( obj.getString("SYMBOL") )  ).toJSON());
                                                            }
                                                          }
                                                       toSENDnow.put(obj.getString("SYMBOL"), obj);
                                                        } 
                                          }
                                       
                               
                             }
                                   session.getBasicRemote().sendText(toSENDnow.toString());
                     }  catch(Exception ex){System.out.println("ERROR SENDING : "+ex.getMessage());}
                                   }
                               }
                                  Thread.sleep(100);
                            }catch(InterruptedException exe){
                                 //thread was 'stopped' here
                                 Thread.currentThread().interrupt(); //this is a MUST
                             //    stop=true;  
                                   System.out.println(" wsPRICE  THREAD STOPPER " );
                            } catch (Exception ex) {
                               System.out.println("ERROR : "+ex.getMessage());
                            }
                        }
                    };
                
                
                
               executorWSPRICE = Executors.newScheduledThreadPool(1);
                 executorWSPRICE.scheduleAtFixedRate(helloRunnable, 0, 100, TimeUnit.MILLISECONDS); 
                 
                 
                 my_USER_JSON.put("THREAD", executorWSPRICE);
                   myWORKERS.put(session.getId(), my_USER_JSON );
               
                         
                }
                catch (Exception ex){System.out.println(ex.getMessage());}
             } 
          } 
     
    }


    @OnMessage
    public String onMessage(String message, Session session) {
       // System.out.println(" message  STR   : " +message); 
        JSONObject workRECVJSON=new JSONObject(message); 
         
          String SESSIONID=session.getId(); 
            
       System.out.println("RECV MSG:"+workRECVJSON); 
          JSONObject toRETURN=new JSONObject();
          
          JSONObject myRETURNnow=null;//WS_PARSE_MESSAGE.PARSE_MESSAGE(workRECVJSON);
         ////////////////////////////////////////////////////////////////////////////////
      

    
        
          return workRECVJSON.toString();
    }
    
    
  
    
    @OnClose
    public void onClose(Session session) {
        JSONObject thisUSERTOREMOVE=new JSONObject();
             try{ 
            System.out.println("REMOVE SESSION ID : "  +"   "+session.getId());
            //System.out.println("remove_WORKER_SESSION : " +WS_UTILS.remove_WORKER_SESSION(session));
            
               executorWSPRICE= (ScheduledExecutorService) myWORKERS.getJSONObject(session.getId()).get("THREAD");
               if(executorWSPRICE!=null){
               executorWSPRICE.shutdown();
               }
                
                myWORKERS.remove(session.getId(  ));
               System.out.println("REMOVE SESSION : "  +"   "+session.getId());
            }
        catch(Exception ex){System.out.println("Error REMOVING SESSION FROM LIST");}
          
        
         
    }
    @OnError
    public void onError(Throwable exception, Session session) {
        JSONObject thisUSERTOREMOVE=new JSONObject();
           try{ 
               executorWSPRICE= (ScheduledExecutorService) myWORKERS.getJSONObject(session.getId()).get("THREAD");
               if(executorWSPRICE!=null){
               executorWSPRICE.shutdown();
               }
                
                myWORKERS.remove(session.getId(  ));
                 
            System.out.println("onError SESSION ID : "  +"   "+session.getId());
            //System.out.println("remove_WORKER_SESSION : " +WS_UTILS.remove_WORKER_SESSION(session));
                
               System.out.println("onError SESSION : "  +"   "+session.getId());
            }
        catch(Exception ex){System.out.println("Error onError SESSION FROM LIST");}
    }

    
}
 
