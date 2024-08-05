public class Node_SLL {
     private Object data;
     private Node_SLL next;

     public Node_SLL(Object dataToAdd)
     {
         this.data=dataToAdd;
         next=null;
     }

    public Object getData(){
         return data;
}
public void setData(Object data)
{
    this.data=data;
}
public Node_SLL getNext(){
      return next;
}
public void setNext(Node_SLL next)
{
    this.next=next;
}
}
