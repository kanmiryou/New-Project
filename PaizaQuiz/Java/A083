
import java.util.*;
public class Main {
    
    static int maxPrice = 0;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        // 商品をすべてリストに追加する
        List<Integer> items = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int price = sc.nextInt();
            if (price == 10000) {
                System.out.println(Integer.toString(maxPrice));
                return ; 
            }
            items.add(price);
        }
        getMaxPrice(items, N);
    }

　　// 最大金額を求める処理
　　// 商品リストを全bit探索することによりすべての組み合わせを求める
    // 最大金額10000円の組み合わせがあった場合、処理を終了する
    static void getMaxPrice(List<Integer> items, int N) {

        // 商品数の2乗分、ループを回す
        for (int i = 0; i < 1 << N; i++) {
            int tmp = 0;

            // 全bit探索の処理
            for (int j = 0; j < N; j++) {
                if ((1&i>>j) == 1) {
                    tmp += items.get(j);
                }
            }

            // 10000円が出た時点で処理を終了する
            if (tmp == 10000) {
                System.out.println(Integer.toString(tmp));
                return;

            // それ以外の場合、最大金額を更新していく
            } else if( tmp < 10000 && tmp > maxPrice) {
                maxPrice = tmp;
            }
        }
        System.out.println(Integer.toString(maxPrice));
    }
    
}
