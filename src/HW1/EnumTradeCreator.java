package HW1;

import HW1.tradeTypes.BOND;
import HW1.tradeTypes.COMMODITY_SPOT;
import HW1.tradeTypes.FX_SPOT;
import HW1.tradeTypes.IR_SWAP;

public enum EnumTradeCreator {
    BOND{
        @Override
        public Trade createTrade(int price){
            System.out.println("BOND");
            return new BOND(price);
        }
    },
    COMMODITY_SPOT{
        @Override
        public Trade createTrade(int price){
            System.out.println("COMMODITY_SPOT");
            return new COMMODITY_SPOT(price);
        }
    },
    FX_SPOT{
        @Override
        public Trade createTrade(int price){
            System.out.println("FX_SPOT");
            return new FX_SPOT(price);
        }
    },
    IR_SWAP{
        @Override
        public Trade createTrade(int price){
            System.out.println("IR_SWAP");
            return new IR_SWAP(price);
        }
    };
    public abstract Trade createTrade(int price);
}
