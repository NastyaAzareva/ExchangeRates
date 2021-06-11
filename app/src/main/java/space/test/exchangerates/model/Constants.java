package space.test.exchangerates.model;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static String URL = "https://alpha.as50464.net:29870/moby-pre-44/core?r=BEYkZbmV&d=563B4852-6D4B-49D6-A86E-B273DD520FD2&t=ExchangeRates&v=44";
    public static Map<String, String> HEADERS = new HashMap<String, String>();
    public static String REQUEST_BODY = "{\"uid\":\"563B4852-6D4B-49D6-A86E-B273DD520FD2\",\"type\":\"ExchangeRates\",\"rid\":\"BEYkZbmV\"}";
    public static int TIMEOUT = 60000;

    static {
        HEADERS.put("User-Agent", "Test GeekBrains iOS 3.0.0.182 (iPhone 11; iOS 14.4.1; Scale/2.00; Private)");
        HEADERS.put("Accept", "application/json");
        HEADERS.put("Content-Type", "application/json");
    }
}

