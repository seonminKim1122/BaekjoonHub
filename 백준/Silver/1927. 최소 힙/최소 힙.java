import java.io.*;
public class Main {
    static int[] heap = new int[100001]; // index = 0은 사용하지 않을 거라서
    static int top = 0; // heap의 현재 크기(++top)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {

                if (top == 0) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(pop() + "\n");
                }
            } else {
                push(x);
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void push(int x) {
        // 1. 마지막 노드에 값 넣기
        heap[++top] = x;
        int idx = top; // idx = 3

        // 2. 부모 노드와 비교하면서 자리 바꾸기(우리가 만든 heap의 루트 노드는 idx = 1)
        while (heap[idx / 2] > heap[idx] && idx > 1) {
            int parent = heap[idx / 2];

            // 자리를 바꿔주기
            heap[idx / 2] = heap[idx];
            heap[idx] = parent;
            idx = idx / 2;
        }
    }

    public static int pop() {
        // 1. 루트(1) 노드의 값 빼기(0으로 초기화시킨다)
        int result = heap[1];

        // 2. 루트 노드를 마지막 노드의 값으로 채우기
        heap[1] = heap[top];
        heap[top--] = 0;


        // 3. 자식 노드와 비교하면서 자리 바꾸기
        // 1번 조건 : idx < top(인덱스 힙의 최대 크기를 넘지 않는다 = 자식이 존재하는가?)
        for (int idx = 1; idx <= top / 2;) {
            int parent = heap[idx];
            // 한 쪽 자식 노드만 있는 경우를 예외 처리 해주자
            if (heap[2 * idx] * heap[2 * idx + 1] == 0) { // 자식이 한 쪽만 있고, 부모가 그 자식보다 크면 자리 교체
                if (heap[2 * idx] != 0 && heap[2 * idx] < heap[idx]) {
                    heap[idx] = heap[2 * idx];
                    heap[2 * idx] = parent;
                    idx = 2 * idx;
                } else if (heap[2 * idx + 1] != 0 && heap[2 * idx + 1] < heap[idx]){
                    heap[idx] = heap[2 * idx + 1];
                    heap[2 * idx + 1] = parent;
                    idx = 2 * idx + 1;
                } else {
                    break;
                }
            } else { // 자식이 양 쪽 다 있는 경우
                // 2번 조건 : heap ~~~(부모가 자식보다 클 때)
                if (heap[idx] < Math.min(heap[2 * idx], heap[2 * idx + 1])){break;}
                // 두 자식 중 뭐랑 바꿀지 결정()
                if (heap[2 * idx] < heap[2 * idx + 1]) {
                    heap[idx] = heap[idx * 2];
                    heap[idx * 2] = parent;
                    idx = idx * 2;
                } else {
                    heap[idx] = heap[idx * 2 + 1];
                    heap[idx * 2 + 1] = parent;
                    idx = idx * 2 + 1;
                }
            }
        }
        return result;
    }
}