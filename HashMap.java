import java.util.ArrayList;

class HashMap<K,V>{
    private ArrayList<HashNode<K,V>> array;
    private int capacity;
    private int size;

    public HashMap(int capacity){
        array = new ArrayList<>();
        this.capacity = capacity;
        size = 0;
        
        for(int i=0; i<capacity; i++){
            array.add(null);
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private int generateIndex(K key){
        int hashCode = key.hashCode();
        int index = hashCode % capacity;
        return index;
    }

    public V remove(K key){
        int index = generateIndex(key);
        HashNode<K,V> head = array.get(index);

        HashNode<K,V> prev = null;

        while(head!=null){
            if(head.key.equals(key)){
                break;
            }

            prev = head;
            head = head.next;
        }

        if(head==null){
            return null;
        }

        size--;

        if(prev!=null){
            prev.next = head.next;
        }
        else{
            array.set(index, head.next);
        }

        return head.value;
    }

    public void add(K key, V value){
        int index = generateIndex(key);
        HashNode<K,V> head = array.get(index);

        while(head!=null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;

        head = array.get(index);
        HashNode<K,V> newNode = new HashNode<K,V>(key, value);
        newNode.next = head;
        array.set(index, newNode);

        if((1.0*size)/capacity >= 0.7){
            ArrayList<HashNode<K,V>> temp = array;
            array = new ArrayList<>();
            capacity = capacity*2;
            size = 0;

            for(int i=0; i<capacity; i++){
                array.add(null);
            }

            for(HashNode<K,V> headNode : temp){
                while(headNode!=null){
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}