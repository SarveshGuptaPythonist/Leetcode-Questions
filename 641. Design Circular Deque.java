class MyCircularDeque {
    int[] arr;
    int size = 0;
    int front = 0, rear = 0;
    public MyCircularDeque(int k) {
        arr = new int[k];
    }
    
    public boolean insertFront(int value) {
        if(size == arr.length) return false;
        
        if(size == 0) front = rear = 0;
        else front = (front - 1 + arr.length) % arr.length;
        arr[front] = value;
        size++;
        return true;
        
    }
    
    public boolean insertLast(int value) {
        if(size == arr.length) return false;
        if(size == 0) front = rear = 0;
        else rear = (rear + 1) % arr.length;
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;
        front = (front + 1) % arr.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;
        rear = (rear - 1 + arr.length) % arr.length;
        size--;
        return true;
        
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(size == arr.length) return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
