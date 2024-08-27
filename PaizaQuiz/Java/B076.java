import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 標準入力から値を取得してinput_lineに入れる
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] price = new int[N];
        int[] stock = new int[N];
        int[] tmpOrder = new int[N];
        for(int i=0; i<N; i++){
            price[i] = sc.nextInt();
            stock[i] = sc.nextInt();
        }
        for(int i=0; i<Q; i++){
            String action = sc.next();
            if(action.equals("bake")){
                for(int j=0; j<N; j++){
                    stock[j] += sc.nextInt();
                }
            }else if(action.equals("buy")){
                boolean muchOrder = false;
                for(int j=0; j<N; j++){
                    tmpOrder[j] = sc.nextInt();
                    if(stock[j] - tmpOrder[j] < 0){
                        muchOrder = true;
                    }
                }
                if(muchOrder){
                    System.out.println(-1);
                }else{
                    int sum = 0;
                    for(int j=0; j<N; j++){
                        stock[j] -= tmpOrder[j];
                        sum += price[j]*tmpOrder[j];
                    }
                    System.out.println(sum);
                }
            }
        }
    }
}
