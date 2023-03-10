import java.io.*;
public class Main {
    static int[] arr = new int[100001]; // 0번째 인덱스는 안 쓸 거니까
    static int top = 0; // 힙의 크기

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
        // 1. 배열에 값을 추가
        arr[++top] = x;

        // 2. 부모 노드와 비교
        int idx = top;

        while (arr[idx/2] < arr[idx] && idx > 1) { // 부모 노드가 존재하는데 자식 노드보다 크면
            // 서로 자리 바꾸기
            int parent = arr[idx/2];
            arr[idx/2] = arr[idx];
            arr[idx] = parent;
            idx = idx / 2;
        }
    }

    public static int pop() {
        // 1. 배열에서 가장 큰 값을 출력
        int result = arr[1];

        // 2. 그 값을 배열에서 제거
        arr[1] = arr[top];
        arr[top--] = 0;

        // 3. 배열이 최대힙구조 유지할 수 있도록 재정렬
        for(int idx = 1; idx <= top/2;) {  // 자식 노드가 존재할 때
            if (arr[idx] >= Math.max(arr[2*idx], arr[2*idx+1])) {break;} // 부모가 자식보다 크면 탈출
            if (arr[2*idx] > arr[2*idx+1]) {
                int left = arr[2*idx];
                arr[2*idx] = arr[idx];
                arr[idx] = left;
                idx = 2 * idx;
            } else { // 그렇지 않으면
                int right = arr[2*idx+1];
                arr[2*idx+1] = arr[idx];
                arr[idx] = right;
                idx = 2 * idx + 1;
            }
        }
        return result;
    }
}