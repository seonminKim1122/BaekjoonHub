import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        MaxHeap maxHeap = new MaxHeap(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) {
                maxHeap.add(x);
            } else if (x == 0) {
                sb.append(maxHeap.pop()).append("\n");
            }
        }

        System.out.println(sb);
    }
}

class MaxHeap {
    int[] arr;
    int last = 0;

    MaxHeap(int n) {
        arr = new int[n+1];
    }

    void add(int x) {
        arr[++last] = x;

        int self = last;
        int parent = self / 2;

        while (arr[parent] < arr[self] && self > 1) {
            int temp = arr[parent];
            arr[parent] = arr[self];
            arr[self] = temp;

            self = parent;
            parent = self / 2;
        }
    }

    int pop() {
        if (last == 0) {
            return 0;
        }

        int result = arr[1];
        arr[1] = arr[last];
        arr[last--] = 0;

        int self = 1;
        int leftChild = 2 * self;
        int rightChild = 2 * self + 1;

        while (Math.max(arr[leftChild], arr[rightChild]) > arr[self]) {
            int temp = arr[self];
            if (arr[leftChild] < arr[rightChild]) {
                arr[self] = arr[rightChild];
                arr[rightChild] = temp;
                self = rightChild;
            } else {
                arr[self] = arr[leftChild];
                arr[leftChild] = temp;
                self = leftChild;
            }

            leftChild = 2 * self;
            rightChild = 2 * self + 1;

            if (leftChild > last) {
                break;
            }
        }

        return result;
    }
}