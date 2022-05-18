/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCOUNTS;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.NewOrderResponseType;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.exception.BinanceApiException;

import java.util.List;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;
import static com.binance.api.client.domain.account.NewOrder.marketBuy;
import java.io.PrintWriter;
import org.json.JSONArray;

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
public class OrdersExample {

  public static void main(String[] args) {
      
      /* TODO output your page here. You may use following sample code. */
              BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(
            "nz3qvegcRSoIssmdoG6QGlwozRPIaPkgFbxppm7hsUKJP9VujEqhV144lRyAlVG9", 
            "dTKDi76RghJP4trBtURudet4QYwfNqrW7mploVlzM7nHurSQ5bZLIcJkv8BQBWgj");
                BinanceApiRestClient client = factory.newRestClient();

      
     try   {
            
                // Get account balances
                Account account = client.getAccount(60000L, System.currentTimeMillis());

                JSONArray thisBALANCEjsonARR=new JSONArray(account.getBalances());
               System.out.println("ALL ACCOUNT<BR>"+account.getBalances()+"<BR>");
               
     }catch(Exception ex){
           System.out.println(ex.getMessage());
     }
      
      /*  BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("nz3qvegcRSoIssmdoG6QGlwozRPIaPkgFbxppm7hsUKJP9VujEqhV144lRyAlVG9"
            ,
            "dTKDi76RghJP4trBtURudet4QYwfNqrW7mploVlzM7nHurSQ5bZLIcJkv8BQBWgj");
    BinanceApiRestClient client = factory.newRestClient();

    // Getting list of open orders
    List<Order> openOrders = client.getOpenOrders(new OrderRequest("LINKETH"));
    System.out.println(openOrders);

    
    
    /*
    // Getting list of all orders with a limit of 10
    List<Order> allOrders = client.getAllOrders(new AllOrdersRequest("LINKETH").limit(10));
    System.out.println(allOrders);

    // Get status of a particular order
    Order order = client.getOrderStatus(new OrderStatusRequest("LINKETH", 751698L));
    System.out.println(order);

    // Canceling an order
    try {
      CancelOrderResponse cancelOrderResponse = client.cancelOrder(new CancelOrderRequest("LINKETH", 756762l));
      System.out.println(cancelOrderResponse);
    } catch (BinanceApiException e) {
      System.out.println(e.getError().getMsg());
    }

    // Placing a test LIMIT order
    client.newOrderTest(limitBuy("LINKETH", TimeInForce.GTC, "1000", "0.0001"));

    // Placing a test MARKET order
    client.newOrderTest(marketBuy("LINKETH", "1000"));

    // Placing a real LIMIT order
    NewOrderResponse newOrderResponse = client.newOrder(limitBuy("LINKETH", TimeInForce.GTC, "1000", "0.0001").newOrderRespType(NewOrderResponseType.FULL));
    System.out.println(newOrderResponse);

*/
  }

}