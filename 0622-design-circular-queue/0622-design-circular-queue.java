class MyCircularQueue {
    int k = 0, front = -1, rear = -1, tick = 0;
    Integer[] arr = null;

    public MyCircularQueue(int k) {
        this.k = k;
        arr=new Integer[k];
        Arrays.fill(arr,null);
    }
    public boolean enQueue(int value) {
        if(!isFull()){
            rear = (rear + 1) % k;
            arr[rear] = value;
            if(tick == 0){
                front = rear;
                tick = 1;
            }
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()){
            arr[front] = null;
            front = (front + 1) % k;
            return true;
        }
        return false;
    }

    public int Front() {
        if(front == -1 || arr[front] == null)
            return -1;
        return arr[front];
    }

    public int Rear() {
        if(rear == -1 || arr[rear] == null){
            return -1;
        }
        return arr[rear];
    }

    public boolean isEmpty() {
        if(rear == -1 || (front == (rear + 1) % k && arr[front] == null && arr[rear] == null))
            return true;
        return false;
    }
    public boolean isFull() {
        if(front == (rear + 1) % k && arr[front] != null && arr[rear] != null)
            return true;
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