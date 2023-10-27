import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node top = new Node('A');

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') Node.addLeft(top, root, left);
            if (right != '.') Node.addRight(top, root, right);
        }

        Tree.preOrder(top);
        System.out.println();
        Tree.inOrder(top);
        System.out.println();
        Tree.postOrder(top);
    }

    private static class Tree {

        static void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        static void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.data);
                inOrder(node.right);
            }
        }

        static void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data);
            }
        }
    }

    private static class Node {

        char data;
        Node left = null;
        Node right = null;

        Node(char data) {
            this.data = data;
        }

        static void addLeft(Node node, char root, char left) {
            if (node.data == root) {
                node.left = new Node(left);
            } else {
                if (node.left != null) {
                    addLeft(node.left, root, left);
                }

                if (node.right != null) {
                    addLeft(node.right, root, left);
                }
            }
        }

        static void addRight(Node node, char root, char right) {
            if (node.data == root) {
                node.right = new Node(right);
            } else {
                if (node.left != null) {
                    addRight(node.left, root, right);
                }

                if (node.right != null) {
                    addRight(node.right, root, right);
                }
            }
        }
    }
}