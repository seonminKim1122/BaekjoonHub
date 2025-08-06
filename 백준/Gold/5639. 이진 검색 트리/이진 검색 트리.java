import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 루트 노드
        input = br.readLine();
        int value = Integer.parseInt(input);
        Node root = new Node(value);
        while ((input = br.readLine()) != null)  {
            value = Integer.parseInt(input);
            Node node = new Node(value);
            root.addChild(node);
        }

        root.postOrder();
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        void addChild(Node node) {
            if (node.value < this.value) {
                addLeft(node);
            } else if (this.value < node.value) {
                addRight(node);
            }
        }

        void addLeft(Node node) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addChild(node);
            }
        }

        void addRight(Node node) {
            if (this.right == null) {
                right = node;
            } else {
                this.right.addChild(node);
            }
        }

        void postOrder() {
            if (left != null) {
                left.postOrder();
            }
            if (right != null) {
                right.postOrder();
            }
            System.out.println(value);
        }
    }
}