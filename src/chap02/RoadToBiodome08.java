package chap02;

import java.util.Arrays;

// 입력 형식 100 200 150 50 300
public class RoadToBiodome08 {
    public static void main(String[] args) {
        System.out.println("입력 : " + Arrays.toString(args));
        if (args.length < 1 || args.length > 100) {
            System.out.println("가능한 입력 개수는 1 ~ 100입니다.");
            return;
        }

        CustomQueue queue = new CustomQueue();
        for (int i = 0; i < args.length; i++) {
            queue.enqueue(Integer.parseInt(args[i]));
        }

        while (!queue.isEmpty()) {
            int pop = queue.dequeue();
            System.out.println("자원 " + pop + "을 제공했습니다.");
            if (queue.isEmpty()) {
                System.out.println("모든 요청이 처리되었습니다.");
            }
        }

        System.out.println("----------------------보너스-----------------------");
        int[] bonusInput = {12, 14, 7, 6, 8, 10, 23, 14, 12, 11, 20, 3};
        System.out.println("보너스 문제 입력 : " + Arrays.toString(bonusInput));

        // 보너스
        CustomBonusQueue customBonusQueue = new CustomBonusQueue();

        for (int i = 0; i < bonusInput.length; i++) {
            customBonusQueue.enqueue(bonusInput[i]);
        }

        while (!customBonusQueue.isEmpty()) {
            int poll = customBonusQueue.dequeue();
            System.out.println("자원 " + poll + "을 제공했습니다.");
            if (customBonusQueue.isEmpty()) {
                System.out.println("모든 요청이 처리되었습니다.");
            }
        }
    }

    static class CustomQueue {
        private static int CAPACITY = 100;
        private int[] elements;
        private int front;
        private int tail;
        private int size;

        public CustomQueue() {
            this.elements = new int[CAPACITY];
            this.front = 0;
            this.tail = CAPACITY - 1;
            this.size = 0;
        }

        public void enqueue(int element) {
            if (isFull()) {
                throw new IllegalArgumentException("Queue is Full");
            }
            tail = (tail + 1) % elements.length;
            elements[tail] = element;
            size++;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Queue is Empty");
            }

            int poll = elements[front];
            elements[front] = 0;
            front = (front + 1) % elements.length;
            size--;
            return poll;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private boolean isFull() {
            return size == elements.length;
        }
    }

    static class CustomBonusQueue {
        private static int CAPACITY = 10;
        private int[] elements;
        private int front;
        private int tail;
        private int size;

        public CustomBonusQueue() {
            this.elements = new int[CAPACITY];
            this.front = 0;
            this.tail = CAPACITY - 1;
            this.size = 0;
        }

        public void enqueue(int element) {
            if (isFull()) {
                resize();
            }
            tail = (tail + 1) % elements.length;
            elements[tail] = element;
            size++;
        }

        public int dequeue() {
            int poll = elements[front];
            elements[front] = 0;
            front = (front + 1) % elements.length;
            size--;
            return poll;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private boolean isFull() {
            return size == elements.length;
        }

        private void resize() {
            int newLength = elements.length + 10;
            int[] newElements = new int[newLength];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(front + i) % elements.length];
            }
            elements = newElements;
            front = 0;
            tail = size - 1;
            System.out.println("Queue의 크기가 " + newLength + "으로 늘어났습니다.");
        }
    }
}
