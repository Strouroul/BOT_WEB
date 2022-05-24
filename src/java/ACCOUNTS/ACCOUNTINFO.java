/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCOUNTS;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.event.AccountUpdateEvent;
import com.binance.api.client.domain.event.OrderTradeUpdateEvent;  
import com.binance.api.client.domain.event.UserDataUpdateEvent.UserDataUpdateEventType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RAMEZ
 */
public class ACCOUNTINFO {
    
        public static String API="nz3qvegcRSoIssmdoG6QGlwozRPIaPkgFbxppm7hsUKJP9VujEqhV144lRyAlVG9";
        public static String SECRET="dTKDi76RghJP4trBtURudet4QYwfNqrW7mploVlzM7nHurSQ5bZLIcJkv8BQBWgj";
      public static final long DEFAULT_RECEIVING_WINDOW = 5_000L;
    public static void main(String[] args){
         BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(API, SECRET);
    BinanceApiRestClient client = factory.newRestClient(); 
       // First, we obtain a listenKey which is required to interact with the user data stream
    String listenKey = client.startUserDataStream();

    // Then, we open a new web socket client, and provide a callback that is called on every update
    BinanceApiWebSocketClient webSocketClient = factory.newWebSocketClient();

    
    // Get account balances
    Account account = client.getAccount(DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
    
    List<AssetBalance> myBALANCES=new ArrayList<>();
    
    myBALANCES=account.getBalances();
    //System.out.println(account.getBalances());
    for(int x=0;x<myBALANCES.size();x++){
        AssetBalance thisASSET=(AssetBalance) myBALANCES.get(x);
      //  System.out.println(thisASSET);
        
        if(
                (Float.parseFloat(thisASSET.getFree())>0  ) || 
                (Float.parseFloat(thisASSET.getLocked())>0)
           ){
        System.out.println("ASSETT : "+thisASSET.getAsset());
        System.out.println("FREE : "+thisASSET.getFree());
        System.out.println("LOCKED : "+thisASSET.getLocked());
        }
    }
   // System.out.println(account.getAssetBalance("BUSD"));
    
    
   
   
   
   
   
   /*
    // Listen for changes in the account
    webSocketClient.onUserDataUpdateEvent(listenKey, response -> {
      if (response.getEventType() == UserDataUpdateEventType.ACCOUNT_UPDATE) {
        AccountUpdateEvent accountUpdateEvent =response.getAccountUpdateEvent();// response.getOutboundAccountPositionUpdateEvent();
        // Print new balances of every available asset
        System.out.println(accountUpdateEvent.getBalances());
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
    System.out.println("Waiting for events...");

    // We can keep alive the user data stream
     client.keepAliveUserDataStream(listenKey);

    // Or we can invalidate it, whenever it is no longer needed
    // client.closeUserDataStream(listenKey);
    */
    
   System.exit(0);
    
  }
     
}
