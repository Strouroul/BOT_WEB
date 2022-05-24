/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binance_bot;

import java.util.Comparator;
import org.json.JSONObject;

/**
 *
 * @author RAMEZ
 */
public class MyJSONComparator implements Comparator<JSONObject> {

@Override
public int compare(JSONObject o1, JSONObject o2) {
    Integer v1 =Integer.valueOf( o1.getInt("COUNT") );
    Integer v3 =Integer.valueOf( o2.getInt("COUNT") );
    
    return v3.compareTo(v1);
}
}
