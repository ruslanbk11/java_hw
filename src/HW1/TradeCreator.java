package HW1;

import HW1.tradeTypes.BOND;
import HW1.tradeTypes.COMMODITY_SPOT;
import HW1.tradeTypes.FX_SPOT;
import HW1.tradeTypes.IR_SWAP;

public class TradeCreator {
    public static Trade create(String tradeType, int price){
        switch (tradeType) {
            case "BOND":
                return new BOND(price);
            case "FX_SPOT":
                return new FX_SPOT(price);
            case "COMMODITY_SPOT":
                return new COMMODITY_SPOT(price);
            case "IR_SWAP":
                return new IR_SWAP(price);
            default:
                return null;
        }
    }
}
