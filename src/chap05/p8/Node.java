package chap05.p8;

public class Node {

    private String date;
    private EnvironmentData value;
    private Node left;
    private Node right;

    public Node(EnvironmentData value) {
        this.date = value.getDate().split(" ")[0];
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public EnvironmentData getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getDate() {
        return date;
    }

    public void updateValue(EnvironmentData value) {
        this.value = value;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }
}
