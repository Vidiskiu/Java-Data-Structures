class Node<T>{
    protected T data;
    protected Node<T> next;

    public Node(T data){
        this.data = data;
        next = null;
    }

    public Node(T data, Node<T> node){
        this.data = data;
        next = node;
    }

    public void setNext(Node<T> node){
        next = node;
    }

    public Node<T> getNext(){
        return next;
    }

    public T getData(){
        return data;
    }
}