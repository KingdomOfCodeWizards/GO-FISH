public class DoublyLinkedList {
    private Node_DLL head;
    private Node_DLL tail;

    public DoublyLinkedList()
    {
        head=null;
        tail=null;
    }

    public void add(Object data)
    {
     if(head==null&&tail==null)
     {
         Node_DLL newNode = new Node_DLL(data);
         head=newNode;
         tail=newNode;
     }
     else
     {
             Node_DLL temp=head;
             while(temp.getNext()!=null)
             {
                 temp=temp.getNext();
             }
             Node_DLL newNode = new Node_DLL(data);
             temp.setNext(newNode);
     }
    }


    public int  size()
    {
        if(head==null)
        {
            return 0;
        }
        else
        {
           Node_DLL temp=head;
           int count=0;
           while(temp!=null)
           {
              temp=temp.getNext();
              count++;
           }
           return count;
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
           Node_DLL temp=head;
           while(temp!=null)
           {
               System.out.print(temp.getData()+"  ");
               temp=temp.getNext();
           }
            System.out.println();
        }
    }



    public Object getElement(int data)
    {
        Node_DLL temp =head;
        int count=0;
        while(temp!=null)
        {
            if(data==count)
            {
                break;
            }
           temp=temp.getNext();
           count++;
        }
        if(!(temp.getData().equals(null)))
        {return temp.getData();}
        else
        {return -99;}
    }

    public Object GetElement(int index)
    {
       int border=(int)this.size();
       if(index<0||index>border)
       {
           System.out.println("At this index there is nothing");
           return null;
       }
       else
       {
           Node_DLL temp=head;
           int countIndex=0;
           while(countIndex<index-1)
           {
               temp=temp.getNext();
               countIndex++;
           }
           return temp.getData();
       }
    }



    public void delete(Object data) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        Node_DLL current = head;

        // İlk düğümde silinecek veri varsa
        if (current.getData().equals(data)) {
            head = current.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
            return;
        }

        // Orta veya son düğümlerde silinecek veri varsa
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                Node_DLL nextNode = current.getNext().getNext();
                current.setNext(nextNode);
                if (nextNode != null) {
                    nextNode.setPrev(current);
                } else {
                    tail = current;
                }
                return;
            }
            current = current.getNext();
        }

        // Veri bulunamadı
        System.out.println("Data not found in the list");
    }

}
