import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));
        while ((input = br.readLine()) != null && !input.equals("")) {
            int value = Integer.parseInt(input);
            root.addLeaf(new Node(value));
        }

        root.postOrder();
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node (int value) {
            this.value = value;
        }

        void addLeaf (Node node) {
            if (value > node.value) {
                if (left == null) left = node;
                else left.addLeaf(node);
            } else {
                if (right == null) right = node;
                else right.addLeaf(node);
            }
        }

        void postOrder() {
            if (left != null) left.postOrder();
            if (right != null) right.postOrder();
            System.out.println(value);
        }
    }
}