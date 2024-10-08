
import java.util.*;

// A083:商品券の有効活用の回答
public class Main {
    
    static int maxPrice = 0;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 標準入力から整数Nを取得
        int N = sc.nextInt();

        // 商品をすべてリストに追加する
        List<Integer> items = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int price = sc.nextInt();

            // 10000円の商品があった場合、最大金額を表示し処理を終了する
            if (price == 10000) {
                System.out.println(Integer.toString(maxPrice));
                return ; 
            }
            items.add(price);
        }

        // 最大金額計算処理を実行する
        getMaxPrice(items, N);
    }

    
　　/** 最大金額計算処理
    * 商品リストを全bit探索することによりすべての組み合わせを求める
    * 最大金額10000円の組み合わせがあった場合、処理を終了する
    * @param List<Integer> items 商品リスト
    * @param int N 商品数
    */
    static void getMaxPrice(List<Integer> items, int N) {

        // 商品数の2乗分、ループを回す
        for (int i = 0; i < 1 << N; i++) {
            int tmp = 0;

            // 全bit探索の処理
            for (int j = 0; j < N; j++) {
                if ((1&i>>j) == 1) {
                    // 商品を購入する場合、金額を足す
                    tmp += items.get(j);
                }
            }

            // 10000円が出た場合
            if (tmp == 10000) {

                // 処理を終了する
                System.out.println(Integer.toString(tmp));
                return;

            // 金額が1000円より低い、かつ最大金額より高い場合
            } else if( tmp < 10000 && tmp > maxPrice) {

                // 最大金額を更新する
                maxPrice = tmp;
            }
        }

        // 最大金額を表示する
        System.out.println(Integer.toString(maxPrice));
    }
    
}
