import java.util.ArrayList;
import java.util.List;
/**
 * CS 251: Data Structures and Algorithms
 * Project 3: Part 2
 * <p>
 *
 *
 * @author Shivam Bairoloya, Jordan Davis
 * @username sbairoli, davi1304
 * @sources -,
 */
public class AVL {

    public Node balance(Node n)
    {
        reheight(n);
        int bal = balanceFactor(n);
        if (bal < -1)
        {
            if ((n.right == null))
            {
                n = rightRotate(n);
            }
            else if (height(n.right.right) > height(n.right.left))
                n = rightRotate(n);
            else {
                n.right = leftRotate(n.right);
                n = rightRotate(n);
            }
        }
        else if (bal > 1)
        {
            if ((n.left == null))
            {
                n = leftRotate(n);
            }
            else if (height(n.left.left) > height(n.left.right)) {
                n = leftRotate(n);
            }
            else {
                n.left = rightRotate(n.left);
                n = leftRotate(n);
            }
        }
        return n;
    }
    public Node leftRotate(Node node)
    {
        Node a = node.left;
        Node b = a.right;
        a.right = node;
        node.left = b;
        reheight(node);
        reheight(a);
        return a;
    }
    public Node rightRotate(Node node)
    {
        Node a = node.right;
        Node b = a.left;
        a.left = node;
        node.right = b;
        reheight(node);
        reheight(a);
        return a;
    }
    /**
     * Insert a tuple in the tree
     *
     * @param node The root of the tree
     * @param tuple The data to be inserted
     * @return root of the tree
     */
    public Node insert(Node node, Tuple tuple) {
            if (node == null) {
                return new Node(tuple);
            } else {
                if (node.data.compareTo(tuple) == 0) {
                    return node;
                } else if (node.data.compareTo(tuple) < 0) {
                    node.right = insert(node.right, tuple);
                } else {
                    node.left = insert(node.left, tuple);
                }
            }
            return balance(node);
    }

    /**
     * Returns the height of a particular node
     * Returns -1 if the node is null
     *
     * @param node the node
     * @return the height
     */
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void reheight(Node n)
    {
        int a = height(n.left);
        int b = height(n.right);
        if (a > b)
        {
            n.height = a + 1;
        }
        else
        {
            n.height = b + 1;
        }
    }
    /**
     * Returns the balance factor of a particular node
     *
     * @param node
     * @return the balance factor
     */
    public int balanceFactor(Node node) {
        //assume node is not null
        return (height(node.left) - height(node.right));
    }

    /**
     * Returns the preorder traversal
     *
     * @param node
     * @return
     */
    public List<Node> preorder(Node node) {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(node);
        if (node.left != null) {
            nodes.addAll(preorder(node.left));
        }
        if (node.right != null) {
            nodes.addAll(preorder(node.right));
        }
        return nodes;
    }


    /**
     * Returns the inorder traversal
     *
     * @param node
     * @return
     */
    public List<Node> inorder(Node node) {
        List<Node> nodes = new ArrayList<Node>();
        if (node.left != null) {
            nodes.addAll(inorder(node.left));
        }
        nodes.add(node);
        if (node.right != null) {
            nodes.addAll(inorder(node.right));
        }
        return nodes;
    }

    /**
     * Returns the level order traversal
     *
     * @param node
     * @return
     */
    public String levelOrder(Node node) {
        int height = height(node);
        List<List<Node>> levels = new ArrayList<>();
        for (int i = 1; i <= height + 1; i++) {
            levels.add(levelOrderHelper(node, i));
        }
        StringBuilder out = new StringBuilder();
        int i = 0;
        for (List<Node> level : levels) {
            out.append("Level ").append(i).append(": ");
            for (Node x : level) {
                out.append("|").append(x).append("|");
            }
            out.append("\n");
            i++;
        }
        return out.toString();
    }

    /**
     * Recursive function to aid level order traversal
     *
     * @param curr
     * @param level
     * @return
     */
    private List<Node> levelOrderHelper(Node curr, int level) {
        List<Node> currLevel = new ArrayList<>();
        if (curr == null) {
            currLevel.add(null);
            return currLevel;
        }
        if (level == 1) {
            currLevel.add(curr);
            return currLevel;
        }

        currLevel.addAll(levelOrderHelper(curr.left, level - 1));
        currLevel.addAll(levelOrderHelper(curr.right, level - 1));
        return currLevel;
    }

    /**
     * For manual testing
     * @param args
     */
    public static void main(String[] args) {

    }
}