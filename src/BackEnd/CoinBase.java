/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Pedro
 */
public class CoinBase {

    public CoinBase() {
    }

    public Float getBitcoinPrice() throws MalformedURLException, IOException {

        URL url = new URL("https://api.coinbase.com/v2/prices/spot?currency=EUR");
        URLConnection http = url.openConnection();
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(http.getInputStream()));
        String reader;
        StringBuilder builder = new StringBuilder();

        while ((reader = rd.readLine()) != null) {
            builder.append(reader);
        }
        
        return Float.parseFloat(builder.substring(builder.lastIndexOf(":") + 2, builder.lastIndexOf("}") - 2));
    }
}
