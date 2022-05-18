/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCOUNTS;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.event.AggTradeEvent;
import com.binance.api.client.domain.market.CandlestickInterval;

import java.io.IOException;
import java.util.Objects;

/**
 * Market data stream endpoints examples.
 *
 * It illustrates how to create a stream to obtain updates on market data such as executed trades.
 */
public class MarketDataStreamExample {

  public static void main(String[] args) throws InterruptedException, IOException {
    BinanceApiWebSocketClient client = BinanceApiClientFactory.newInstance().newWebSocketClient();

    // Listen for aggregated trade events for ETH/BTC
   // client.onAggTradeEvent("ethbtc", response -> System.out.println(response));

    // Listen for changes in the order book in ETH/BTC
   // client.onDepthEvent("ethbtc", response -> System.out.println(response));

    // Obtain 1m candlesticks in real-time for ETH/BTC
   // client.onCandlestickEvent("ethusdt", CandlestickInterval.ONE_MINUTE, response -> System.out.println(response));
   
   // client.onCandlestickEvent("ethusdt", CandlestickInterval.ONE_MINUTE, response -> System.out.println(response));

    client.onAggTradeEvent("ethbtc,ethusdt", new BinanceApiCallback<AggTradeEvent>() {
    @Override
    public void onResponse(final AggTradeEvent response) {
        System.out.println(response);
    }

    @Override
    public void onFailure(final Throwable cause) {
        System.err.println("Web socket failed");
        cause.printStackTrace(System.err);
    }
});
   
   
   
   
   
   
   
   /*
   
   
   
    
    client.onAggTradeEvent("ethbtc,ethusdt", (AggTradeEvent response) -> {
        
       
      
  if (Objects.equals(response.getSymbol().toLowerCase(),"ethbtc")) {
      // handle ethbtc event
     //  System.out.println(response);
  } else if(Objects.equals(response.getSymbol().toLowerCase(),"ethusdt")) {
      // handle ethusdt event
     System.out.println(response.getSymbol());
          System.out.println(  response.getPrice() );
  }else{
  // System.out.println(response);
  }
});
    
    */
    
    
    
  }
}