package space.test.exchangerates.model;

public class Rate {
    private int tp;
    private String name;
    private int from;
    private String currMnemFrom;
    private int to;
    private String currMnemTo;
    private int basic;
    private double buy;
    private double sale;
    private double deltaBuy;
    private double deltaSale;

    public String getName() {
        return name;
    }

    public String getBuy() {
        return String.valueOf(buy);
    }

    public String getSale() {
        return String.valueOf(sale);
    }

    public String getCodes() {
        return currMnemTo + "-" + currMnemFrom;
    }

    @Override
    public String toString() {

        return "Rate{" +
                "tp=" + tp +
                ", name='" + name + '\'' +
                ", from=" + from +
                ", currMnemFrom='" + currMnemFrom + '\'' +
                ", to=" + to +
                ", currMnemTo='" + currMnemTo + '\'' +
                ", basic=" + basic +
                ", buy=" + buy +
                ", sale=" + sale +
                ", deltaBuy=" + deltaBuy +
                ", deltaSale=" + deltaSale +
                '}' + "\n";
    }
}
