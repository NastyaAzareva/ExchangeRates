package space.test.exchangerates.model;

import java.util.ArrayList;

public class Rates {
    private ArrayList<Rate> rates = new ArrayList<Rate>();

    @Override
    public String toString() {
        return "Rates{" +
                "rates=" + rates +
                '}';
    }

    public Rate getRateByIndex(int index) {
        return rates.get(index);
    }

    public int getLength() {
        return rates.size();
    }
}
