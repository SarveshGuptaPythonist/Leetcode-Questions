class MyCircularQueue {
    int[] queue;
    int size;
    int capacity;
    int front;
    int rear;
    public MyCircularQueue(int k) {
        queue = new int[k];
        size = 0;
        capacity = k;
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity) return false;
        
        size++;
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0) return false;
        size--;
        // queue[front] = -1;
        front = (front + 1) % capacity;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return queue[(rear-1+capacity)%capacity];
    }
    
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(size == capacity) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
