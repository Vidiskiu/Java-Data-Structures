import java.util.NoSuchElementException;

class Queue<T>{
    protected Node<T> front;
    protected Node<T> rear;
    protected int size;

    public Queue(){
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty(){
        return front==null;
    }

    public void enqueue(T data){
        Node<T> newNode = new Node<T>(data);

        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }
        else{
            newNode.setNext(rear);
            rear = newNode;
        }

        size++;
    }

    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Underflow Exception");
        }
        else{
            Node<T> dequeued = front;
            Node<T> tempNode = rear;

            while(tempNode.next.next != null){
                tempNode = tempNode.getNext();
            }
            
            front = tempNode;
            front.setNext(null);
            size--;
            
            return dequeued.getData();
        }
    }
}