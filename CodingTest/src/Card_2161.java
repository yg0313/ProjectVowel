import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
 * 이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 * 예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고,
 * 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 버린 카드들은 순서대로 1 3 2가 되고, 남는 카드는 4가 된다.
 * N이 주어졌을 때, 버린 카드들을 순서대로 출력하고, 마지막에 남게 되는 카드를 출력하는 프로그램을 작성하시오.
 */
public class Card_2161 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
//            int n = scanner.nextInt();
            int size = n; // 전체 반복시킬 횟수
            int count = 1;  // 카드 고르는(?) 횟수
            Queue<Integer> card = new LinkedList<>();   // 처음 전체 카드
            Queue<Integer> deCard = new LinkedList<>(); // 최종 결과
            for(int i = 1; i<=n; i++){
                card.add(i);
            }

            do{
                for(int i = 1; i<=size; i++){
                    if (count % 2 == 1) {
                        deCard.add(card.poll());
                    }else{
                        card.add(card.poll());
                    }
                    count++;
                }
                size = card.size();
            }while(size != 1);     // size가 1이 아니면 계속해서 반복

            deCard.add(card.poll());
            for(int num : deCard){
                sb.append(num+ " ");
            }
            System.out.println(sb);
        } catch(Exception e) {

        }

    }
}