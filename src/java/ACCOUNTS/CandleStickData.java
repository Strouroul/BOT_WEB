/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCOUNTS;

/**
 *
 * @author RAMEZ
 */
public class CandleStickData {
     /*   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private long id;
    private String coinPairName;
    
    /* Properties from Binance pojo */
    private String eventType;
    private long eventTime;
    private String symbol;
    private Long openTime;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private Long closeTime;
    private String intervalId;
    private Long firstTradeId;
    private Long lastTradeId;
    private String quoteAssetVolume;
    private Long numberOfTrades;
    private String takerBuyBaseAssetVolume;
    private String takerBuyQuoteAssetVolume;
    private Boolean isBarFinal;
}
