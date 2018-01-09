public class CoinSharing {
    public static void main(String[] args){
        int coins = 1740;
        System.out.println(shareCoins(coins,10));
        int i = 0;
        while(shareCoins(coins,i) >0 ){
            coins = shareCoins(coins,i);
            i++;
        }System.out.println(coins);

    }
    public static int shareCoins(int cash, int multiplier){
        if (cash - 3*multiplier > 0){
            cash = cash - 3*multiplier;
        }else {return -1;}
        return cash;
    }
}
