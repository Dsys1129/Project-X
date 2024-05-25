package chap05.p8;

import java.util.*;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(EnvironmentData data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            addNode(root, newNode);
        }
    }

    public void updateNode(Node node, EnvironmentData value) {
        node.updateValue(value);
    }

    public Node search(String date) {
        return searchNode(root, date);
    }

    public List<EnvironmentData> searchRange(String startDate, String endDate) {
        List<EnvironmentData> result = new ArrayList<>();
        searchRange(root, startDate, endDate, result);
        return result;
    }

    private void searchRange(Node node, String startDate, String endDate, List<EnvironmentData> result) {
        if (node == null) {
            return;
        }

        if (node.getDate().compareTo(startDate) >= 0) {
            searchRange(node.getLeft(), startDate, endDate, result);
        }

        if (node.getDate().compareTo(startDate) >= 0 && node.getDate().compareTo(endDate) <= 0) {
            result.add(node.getValue());
        }

        if (node.getDate().compareTo(endDate) <= 0) {
            searchRange(node.getRight(), startDate, endDate, result);
        }
    }

    private Node addNode(Node node, Node newNode) {
        if (node == null) {
            return newNode;
        }

        if (newNode.getDate().compareTo(node.getDate()) < 0) {
            node.setLeft(addNode(node.getLeft(), newNode));
        } else {
            node.setRight(addNode(node.getRight(), newNode));
        }
        return node;
    }

    private Node searchNode(Node node, String date) {
        if (node == null) {
            System.out.println("해당 날짜의 데이터가 없습니다.");
            return null;
        }

        if (node.getDate().compareTo(date) == 0) {
            System.out.println("검색 결과 : " + node.getValue().getEnvironmentInfo());
            return node;
        } else if (node.getDate().compareTo(date) > 0) {
            return searchNode(node.getLeft(), date);
        } else {
            return searchNode(node.getRight(), date);
        }
    }
}
