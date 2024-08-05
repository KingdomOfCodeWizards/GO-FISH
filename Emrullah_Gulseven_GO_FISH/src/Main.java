//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            Scanner scanner = new Scanner(System.in);
            Random random =new Random();
            SinglyLinkedList SLL1 = new SinglyLinkedList();               // insan oyuncu kartlarını tutan List
            SinglyLinkedList SLL2 = new SinglyLinkedList();               //computer kartlarını tutan list
            SinglyLinkedList SLL3 = new SinglyLinkedList();               // masadaki kartlaru tutan List

            DoublyLinkedList DLLname = new DoublyLinkedList();            // geçici olarak oyuncu isimlerini tutan List
            DoublyLinkedList DLLscore = new DoublyLinkedList();           //geçici olarak oyuncu skorlarını tutan List

            for(int i=1; i<=6; i++)
            {
                    for(int j=0; j<4; j++)
                    {                                                     // tüm kartları öncelikle SLL3 Listine aktar

                            SLL3.add(i);
                    }
            }
            int Computer_book=0,Human_book=0;
            while(SLL1.size()<7)
            {
                    int index =random.nextInt(0,SLL3.size()+1);
                    Object data=SLL3.getElement(index);                            //SLL3 Listinden SLL1 insan oyuncu Listine random 7 kartlar dağıt
                    SLL3.delete(data);
                    SLL1.addSorted(data);
            }
            int HumanjokerBook=0;
            for(int i=0;i<SLL1.size();i++)
            {
                    int indexElement=(int)SLL1.getElement(i);
                    if(SLL1.searchAmount(indexElement)==4)
                    {                                                              //SLL1 Listine aktarılan random kartlar arasında hazır
                            HumanjokerBook=indexElement;                           //bir book değeri var mı kontrol et
                            for(int j=0;j<4;j++)
                            {
                                    SLL1.delete(indexElement);
                            }
                            Human_book++;
                    }
            }

            while(SLL2.size()<7)
            {
                    int index =random.nextInt(0,SLL3.size());                 //SLL2 computer Listine random 7 kart dağıt
                    Object data=SLL3.getElement(index);
                    SLL3.delete(data);
                    SLL2.addSorted(data);
            }
            int ComputerjokerBook=0;
            for(int i=0;i<SLL2.size();i++)
            {                                                                       //SLL2 yani computer kartları içinde hazır bir book değeri var mı
                int indexElement=(int)SLL2.getElement(i);
                if(SLL2.searchAmount(indexElement)==4)
                {
                        ComputerjokerBook=indexElement;
                     for(int j=0;j<4;j++)
                     {
                         SLL2.delete(indexElement);
                     }
                     Computer_book++;
                }
            }
            boolean Humanflag;
            boolean Computerflag;
            int turn=1;
            boolean MainFlag=true;

            while(MainFlag==true)
            {

                    Humanflag=true;   Computerflag=true;
                    if(turn==1&&Human_book==1)            //insan oyuncunun daha ilk tutda elinde hazır book değeri varsa book değerini 1 den başlatır
                    {System.out.println("Your book started from 1 because of you had "+HumanjokerBook+" "+HumanjokerBook+" "+HumanjokerBook+" "+HumanjokerBook);}
                    if(turn==1&&Computer_book==1)         //Computer oyuncunun daha ilk tutda elinde hazır book değeri varsa book değerini 1 den başlatır
                    {System.out.println("Computer book started from 1 because of It had "+ComputerjokerBook+" "+ComputerjokerBook+" "+ComputerjokerBook+" "+ComputerjokerBook);}
                    int Humanchoice=0;   int Computerchoice=0;

                    while (Humanflag == true&&SLL1.size()!=0)             //insan oyuncunun hamle döngüsü
                    {
                            System.out.println("TURN: " + turn + "                                                                 TABLE");
                            System.out.print("You     : ");
                            SLL1.display();
                            System.out.print("               " + "book:" + Human_book + "                    ");
                            SLL3.display();
                            System.out.print("\nComputer: ");
//                            SLL2.display();
                            System.out.print("               " + "book:" + Computer_book);
                            System.out.println();
                            do {
                                    System.out.print("You ask: ");
                                    Humanchoice = scanner.nextInt();                  //girilen sayı bizde de var mı diye kontrol sağlar
                                    Humanflag = SLL2.isThere(Humanchoice);            //Humanflag girilen değere göre sonraki sefer sıranın
                            }                                                         //bizde mi Computer da mı olacağını belirler
                            while (!(SLL1.isThere(Humanchoice) == true));
                            int a = SLL2.searchAmount(Humanchoice);
                            for (int i = 0; i < a; i++) {
                                    SLL1.addSorted(Humanchoice);                      //girilen sayıyı computerdan silip insan oyuncu kartlarına atar
                                    SLL2.delete(Humanchoice);
                            }
                            if(SLL1.searchAmount(Humanchoice)==4)                     //girilen sayı book değeri oluşturduysa onu aşağı yazar
                            {
                                    System.out.println(Humanchoice+" "+Humanchoice+" "+Humanchoice+" "+Humanchoice);
                            }
                            Human_book = SLL1.Book(Humanchoice, Human_book);
                            turn++;
                            if (Humanflag == false) {
                                    System.out.println("Computer says Go Fish");
                                    System.out.println("    |                                   ");
                                    System.out.println("    |o     ooooooooo                    ");
                                    System.out.println("    | o  oo     MMM  o                  ");              // girilen sayı Computerda yoksa
                                    System.out.println("    |  oo       MMM    o                ");              //Go Fish cevabını vermesini sağlar.
                                    System.out.println("    |  oo            ooo                ");
                                    System.out.println("    | o  o        MMM                   ");
                                    System.out.println("    |o     oooooooo                     ");
                                    System.out.println("    |                                   ");
                                    int headOf =(int)SLL3.getElement(0);                                  //SLL3 ten yani masadan kart çekmemizi sağlayan kısım
                                    SLL1.addSorted(headOf);
                                    if(SLL1.searchAmount(headOf)==4)                                            //masadan çektiğimiz kart yeni bir book değeri oluşturuyor mu
                                    {System.out.println(headOf+" "+headOf+" "+headOf+" "+headOf);}
                                    SLL3.delete(headOf);
                                    int firstHuman_book=Human_book;                                             //öncelikle book değerini saklıyoruz
                                    Human_book = SLL1.Book(headOf, Human_book);                               // masadan çekilen karta göre Humanbook değerini güncelliyoruz
                                    if(firstHuman_book!=Human_book&&SLL1.size()!=0)
                                    {
                                            for(int i=0;i<4;i++)
                                            {
                                                    SLL1.delete(headOf);
                                            }
                                    }
                            }
                            System.out.println("___________________________________________________________________________________________________________________________________");
                            if(SLL2.size()==0||SLL1.size()==0)
                            {
                                    break;                                    // biz computerdan kart aldıktan sonra onda başka kart kalmamışsa oyunu bitir
                            }
                    }
                    if (SLL1.size() == 0) {
                            MainFlag = false;
                            System.out.println("TURN: " + turn + "                                                                 TABLE");
                            System.out.print("You     : "+Humanchoice+" "+Humanchoice+" "+Humanchoice+" "+Humanchoice);

                            System.out.print("               " + "book:" + Human_book + "                    ");
                            SLL3.display();                                                                               //insan oyuncunun kartları bitmişse son
                            System.out.print("\nComputer: ");                                                             //bilgilenirme tablosunu yazar oyunu bitirir
//                            SLL2.display();
                            System.out.print("               " + "book:" + Computer_book);
                            System.out.println();
                            break;
                    }

                    while (Computerflag == true&&SLL2.size()!=0)
                    {
                            System.out.println("TURN: " + turn + "                                                                 TABLE");
                            System.out.print("You     : ");
                            SLL1.display();
                            System.out.print("               " + "book:" + Human_book + "                    ");
                            SLL3.display();
                            System.out.print("\nComputer: ");
//                            SLL2.display();
                            System.out.print("               " + "book:" + Computer_book);
                            System.out.println();

                            System.out.print("Computer asks: ");
                            int Computerindex = random.nextInt( SLL2.size());                             // computer ın soracağı sayı için rastgele bir sayı belirleyip
                             Computerchoice = (int) SLL2.getElement(Computerindex);                       // bu sayının karşılık geleceği konumdaki sayıyı sorar
                            System.out.println(Computerchoice);
                            Computerflag = SLL1.isThere(Computerchoice);                          //Computerflag Computerin sorduğu sayının SLL1 olup olmadığını kontrol eder
                            int a = SLL1.searchAmount(Computerchoice);

                            for (int i = 0; i < a; i++) {
                                    SLL2.addSorted(Computerchoice);                                 //computerın sorduğu sayı SLL1'de varsa onların Computer'a geçmesini sağlar
                                    SLL1.delete(Computerchoice);
                            }
                            if(SLL2.searchAmount(Computerchoice)==4)                               //Computer'ın aldığı  kart book değeri oluşturuyorsa ekrana yaz
                            {
                                    System.out.println(Computerchoice+" "+Computerchoice+" "+Computerchoice+" "+Computerchoice);
                            }
                            Computer_book = SLL2.Book(Computerchoice, Computer_book);                      //Computer _book değerini günceller
                            turn++;
                            if (Computerflag == false) {
                                    System.out.println("You say Go Fish");
                                    System.out.println("    |                                   ");
                                    System.out.println("    |o     ooooooooo                    ");
                                    System.out.println("    |oo  oooooooMMMooo                  ");
                                    System.out.println("    |oooooooooooMMMooooo                ");              //Computer'ın sorduğu sayı insan oyuncu(SLL1) de yoksa
                                    System.out.println("    |ooooooooooooooooooo                ");              // Go Fısh demesini sağlar
                                    System.out.println("    |oo  oooooooooMMM                   ");
                                    System.out.println("    |o     oooooooo                     ");
                                    System.out.println("    |                                   ");
                                    int headOf =(int)SLL3.getElement(0);

                                    SLL2.addSorted(SLL3.getElement(0));                                   //Computer'ın masadan kart çekmesini sağlar
                                    if(SLL2.searchAmount(headOf)==4)                                            //Computer'ın masadan çektiği kart book değeri oluşturuyor mu
                                    {System.out.println(headOf+" "+headOf+" "+headOf+" "+headOf);}
                                    SLL3.delete(SLL3.getElement(0));
                                    int firstComputer_book=Computer_book;
                                    Computer_book = SLL2.Book(headOf, Computer_book);
                                    if(firstComputer_book!=Computer_book&&SLL2.size()!=0)                       //Computer'ın masadan çektiği kart book oluşturuyorsa
                                    {                                                                           // dörtlü kartı SLL2 dden siler.
                                            for(int i=0;i<4;i++)
                                            {
                                                    SLL2.delete(headOf);
                                            }
                                    }
                            }
                            System.out.println("___________________________________________________________________________________________________________________________________");
                            Thread.sleep(1000);
                            if(SLL2.size()==0||SLL1.size()==0)
                            {                                                      // computer insan oyuncudan kart aldıktan sonra onda başka kart kalmamışsa oyunu bitir
                                    break;
                            }
                    }
                    if (SLL2.size() == 0) {
                            MainFlag = false;
                            System.out.println("TURN: " + turn + "   " + "                                                              TABLE");
                            System.out.print("You     : ");
                            SLL1.display();
                            System.out.print("               " + "book:" + Human_book + "                    ");
                            SLL3.display();                                                                      //Computer'ın kartları bitmişse son tabloyu yazdırıp oyunu bitirir
                            System.out.print("\nComputer: ");
                            System.out.print(Computerchoice+" "+Computerchoice+" "+Computerchoice+" "+Computerchoice);
                            System.out.print("                " + "book:" + Computer_book);
                            System.out.println();
                            break;
                    }
            }

            System.out.println("Game is over");
            if(Human_book>Computer_book)
            {System.out.println("You win the game!");}
            else if(Human_book==Computer_book)
            {System.out.println("Your and Computer's score is equal");}
            else
            { System.out.println("Computer win the game!");}

            System.out.println("What is your name:");
            String name=scanner.next();



            try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\highscoretable.txt")))
            {
                    String line;
                    while((line=reader.readLine())!=null){
                       String [] datas =line.split(" ");
                       int playerScore=Integer.valueOf(datas[1]);               //Dosyadan önceden oynayan oyuncu isimlerini ve puanlarını okur
                       DLLname.add(datas[0]);
                       DLLscore.add(playerScore);
            }
            }catch (IOException e) {
                    System.err.println("Dosya okuma hatası: " + e.getMessage());
            }
            DLLname.add(name);                                                // DLLname'e oyuncu ismini atar.
            DLLscore.add(turn);                                               // DLLscore'a oyuncu skorunu atar.
            DoublyLinkedList DLLscorenew= new DoublyLinkedList();
            DoublyLinkedList DLLnamenew =new DoublyLinkedList();

            int border =DLLscore.size();
            for(int i=0;i<border;i++)
            {
                    int min=999;  String nameTo=null;                         // DLLscore'daki oyuncu skorlarına göre onları bir sıralamaya sokar.
                    for(int j=0;j<DLLscore.size();j++)
                    {
                         if((int)DLLscore.GetElement(j)<=min)
                         {
                                 min=(int)DLLscore.GetElement(j);
                                 nameTo=(String)DLLname.GetElement(j);
                         }
                    }
                    DLLscore.delete(min);   DLLscorenew.add(min);
                    DLLname.delete(nameTo); DLLnamenew.add(nameTo);
            }



          for(int i=0;i<DLLnamenew.size();i++)                                 // sıralanan puan ve isimleri ekrana küçükten büyüğe olacak şekilde yazdırır.
          {
            System.out.println((String)DLLnamenew.getElement(i)+" "+(int)DLLscorenew.getElement(i));
          }




    }
}