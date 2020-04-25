import java.util.NoSuchElementException;

class Stack<T>{
    protected Node<T> top;
    protected int size;

    public Stack(){
        top = null;
        size = 0;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public int getSize(){
        return size;
    }

    public void push(T data){
        Node<T> newNode = new Node<T>(data);
        
        if(isEmpty()){
            top = newNode;
        }
        else{
            newNode.setNext(top);
            top = newNode;
        }

        size++;
    }

    public T pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Underflow Exception");
        }
        else{
            Node<T> popped = top;
            top = top.getNext();
            size--;
            return popped.getData();
        }
    }
}