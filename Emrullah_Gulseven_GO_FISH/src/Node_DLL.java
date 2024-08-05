public class Node_DLL {
    private Object data;
    private Node_DLL prev;
    private Node_DLL next;

    public Node_DLL(Object data)
    {
        this.data=data;
        prev=null;
        next=null;
    }
    public Object getData(){
        return  data;
    }
    public void setData(Object data){
        this.data=data;
    }
    public Node_DLL getPrev(){
        return prev;
    }
    public void setPrev(Node_DLL prev){
        this.prev=prev;
    }
    public Node_DLL getNext(){
        return next;
    }
    public void setNext(Node_DLL next){
        this.next=next;
    }
}
