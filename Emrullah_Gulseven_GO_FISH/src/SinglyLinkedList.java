

public class SinglyLinkedList {
    Node_SLL head;

    public void add(Object data)
    {
        if(head==null)
        {
          Node_SLL newNode =new Node_SLL(data);
          head =newNode;
        }
        else
        {
            Node_SLL temp=head;
            while(temp.getNext()!=null)
            {
                temp=temp.getNext();
            }
            Node_SLL newNode = new Node_SLL(data);
            temp.setNext(newNode);
        }
    }



    public void addSorted(Object dataToAdd) {
        if(head == null){
            Node_SLL newnode = new Node_SLL((Integer)dataToAdd);
            head = newnode;
        }
        else if ((Integer)dataToAdd < (Integer) (head.getData())) {
            Node_SLL newnode = new Node_SLL((Integer)dataToAdd);
            newnode.setNext(head);
            head = newnode;
        }
        else {
            Node_SLL temp = head;
            Node_SLL previous = null;

            while (true) {
                previous = temp;
                temp = temp.getNext();

                if(temp == null) {
                    break;
                }
                if((Integer)dataToAdd <= (Integer)temp.getData()) {
                    break;
                }
            }

            Node_SLL newnode = new Node_SLL((Integer)dataToAdd);
            if(temp == null) {
                previous.setNext(newnode);
            }
            else {
                newnode.setNext(previous.getNext());
                previous.setNext(newnode);
            }
        }
    }
    public void display()
    {
        if(head==null)
        {
            System.out.println("Linked List is empty");
        }
        else
        {
            Node_SLL temp=head;
            while(temp!=null)
            {
                System.out.print(temp.getData()+"  ");
                temp=temp.getNext();
            }
        }
    }


    public int size()
    {
        Node_SLL temp =head;
        int count=0;
        while(temp!=null)
        {
            temp=temp.getNext();
            count++;
        }
        return count;
    }


    public Object getElement(int index)
    {
        int border=(int)this.size();
        if(index<0||index>border)
        {
            System.out.println("Linked List is Empty");
            return null;
        }
        else
        {
            Node_SLL temp= head;
            int countIndex=0;
            while(countIndex<index-1)
            {
                temp=temp.getNext();
                countIndex++;
            }
            return temp.getData();
        }
    }


    public void delete(Object data)
    {
       if(head==null)
       {
           System.out.println("Linked List is empty");
       }
       else
       {
           boolean flag=false;
           Node_SLL temp= head;
           Node_SLL previous=null;
           while(temp!=null&&!(temp.getData().equals(data)))
           {
                previous=temp;
                temp=temp.getNext();
           }
           if(temp!=null&&temp.getData().equals(data))
           {
               if(previous==null)
                   head=temp.getNext();
               else
                   previous.setNext(temp.getNext());
           }

       }
    }


    public int searchAmount(int data)
    {
        Node_SLL temp=head;
        int amount=0;
        while(temp!=null)
        {
            if((Integer)temp.getData()==data)
            {
               amount++;
            }
            temp=temp.getNext();
        }
        return amount;
    }


    public boolean isThere(Object data)
    {
        Node_SLL temp=head;
        boolean ThereIsData=false;
        while(temp!=null)
        {
            if(temp.getData().equals(data))
            {
               ThereIsData=true;
               break;
            }
            temp=temp.getNext();
        }
        return ThereIsData;
    }
    public int Book(int data,int humanbook)
    {
        int count=0;
        Node_SLL temp=head;
        while(temp!=null)
        {
            if((int)temp.getData()==(data))
            {
                count++;
            }
            temp=temp.getNext();
        }
        if(count==4)
        {
            for(int i=0;i<4;i++)
            {this.delete(data);}
            humanbook++;
        }
        return humanbook;
    }
}
