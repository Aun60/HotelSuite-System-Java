import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class Food implements Serializable
{
    int itemno;
    int quantity;   
    float price;
    
    Food(int itemno,int quantity)
    {
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*50;
                break;
            case 2:price=quantity*60;
                break;
            case 3:price=quantity*70;
                break;
            case 4:price=quantity*30;
                break;
        }
    }
}
class Singleroom implements Serializable
{
    String name;
    String contact;
    String gender;   
    ArrayList<Food> food =new ArrayList<>();

   
    Singleroom()
    {
        this.name="";
    }
    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}
class Doubleroom extends Singleroom implements Serializable
{ 
    String name2;
    String contact2;
    String gender2;  
    

    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
}
class database implements Serializable
{
    Doubleroom []MasterDoubleBedRoom=new Doubleroom[10];
    Doubleroom []DoubleBedRoom=new Doubleroom[20];
    Singleroom []MasterSingleBedRoom=new Singleroom[10];
    Singleroom []SingleBedRoom=new Singleroom[20];
}
class roomNotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return "Not Available !";
    }
}



class Hotel
{
    static database hotelData=new database();
    static Scanner sc = new Scanner(System.in);
    static void CustomerDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
        System.out.print("Enter second customer name: ");
        name2 = sc.next();
        System.out.print("Enter contact number: ");
        contact2=sc.next();
        System.out.print("Enter gender: ");
        gender2 = sc.next();
        }      
        
          switch (i) {
            case 1:hotelData.MasterDoubleBedRoom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:hotelData.DoubleBedRoom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:hotelData.MasterSingleBedRoom[rn]=new Singleroom(name,contact,gender);
                break;
            case 4:hotelData.SingleBedRoom[rn]=new Singleroom(name,contact,gender);
                break;
            default:System.out.println("Wrong option");
                break;
        }
    }
    
    static void bookroom(int i)
    {
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for(j=0;j<hotelData.MasterDoubleBedRoom.length;j++)
                {
                    if(hotelData.MasterDoubleBedRoom[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    System.out.flush();
                rn=sc.nextInt();
                rn--;
                if(hotelData.MasterDoubleBedRoom[rn]!=null)
                    throw new roomNotAvailable();
                CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                 for(j=0;j<hotelData.DoubleBedRoom.length;j++)
                {
                    if(hotelData.DoubleBedRoom[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    System.out.flush();
                rn=sc.nextInt();

                rn=rn-11;
                if(hotelData.DoubleBedRoom[rn]!=null)
                    throw new roomNotAvailable();
                CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                  for(j=0;j<hotelData.MasterSingleBedRoom.length;j++)
                {
                    if(hotelData.MasterSingleBedRoom[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    System.out.flush();
                rn=sc.nextInt();
                rn=rn-31;
                if(hotelData.MasterSingleBedRoom[rn]!=null)
                    throw new roomNotAvailable();
                CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                  for(j=0;j<hotelData.SingleBedRoom.length;j++)
                {
                    if(hotelData.SingleBedRoom[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    System.out.flush();
                rn=sc.nextInt();
                rn=rn-41;
                if(hotelData.SingleBedRoom[rn]!=null)
                    throw new roomNotAvailable();
                CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                   System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }
    
    static void features(int i)
    {
        switch (i) {
            case 1:System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
                break;
            case 2:System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
    
    static void availability(int i)
    {
      int j,count=0;
        switch (i) {
            case 1:
//                for(j=0;j<10;j++)
                for(j=0;j<hotelData.MasterDoubleBedRoom.length;j++)
                {
                    if(hotelData.MasterDoubleBedRoom[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0;j<hotelData.DoubleBedRoom.length;j++)
                {
                    if(hotelData.DoubleBedRoom[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0;j<hotelData.MasterSingleBedRoom.length;j++)
                {
                    if(hotelData.MasterSingleBedRoom[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0;j<hotelData.SingleBedRoom.length;j++)
                {
                    if(hotelData.SingleBedRoom[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }
    
    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Namak Paray","Nimko","Mirmirya","Lassi"};
        System.out.println("\n*******");
        System.out.println("\t\t\t\t--------------------FAST CROWN HOTELS------------------");
        System.out.println(" -------------------Bill----------------------");
        System.out.println("*******");
               
        switch(rtype)
        {
            case 1:
                amount+=4000;
                    System.out.println("\nRoom Charges - "+4000);
                    System.out.println("\n===============");
                    System.out.println("Food Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:hotelData.MasterDoubleBedRoom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    
                break;
            case 2:amount+=3000;
                    System.out.println("Room Charge - "+3000);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:hotelData.DoubleBedRoom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            case 3:amount+=2200;
                    System.out.println("Room Charge - "+2200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:hotelData.MasterSingleBedRoom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            case 4:amount+=1200;
                    System.out.println("Room Charge - "+1200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb: hotelData.SingleBedRoom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }
    
    static void removeRoom(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) {
            case 1:               
                if(hotelData.MasterDoubleBedRoom[rn]!=null)
                    System.out.println("Room used by "+hotelData.MasterDoubleBedRoom[rn].name);
                else 
                {    
                    System.out.println(" Room Empty Already");
                        return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                System.out.flush();
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotelData.MasterDoubleBedRoom[rn]=null;
                    System.out.println("Room deallocate successfully");
                }
                
                break;
            case 2:
                if(hotelData.DoubleBedRoom[rn]!=null)
                    System.out.println("Room used by "+hotelData.DoubleBedRoom[rn].name);
                else 
                {    
                    System.out.println(" Room Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                System.out.flush();
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotelData.DoubleBedRoom[rn]=null;
                    System.out.println("Room deallocate successfully");
                }
                 
                break;
            case 3:
                if(hotelData.MasterSingleBedRoom[rn]!=null)
                    System.out.println("Room used by "+hotelData.MasterSingleBedRoom[rn].name);
                else 
                 {    
                    System.out.println(" Room Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                System.out.flush();
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotelData.MasterSingleBedRoom[rn]=null;
                    System.out.println("Room deallocate successfully");
                }
                
                break;
            case 4:
                if(hotelData.SingleBedRoom[rn]!=null)
                    System.out.println("Room used by "+hotelData.SingleBedRoom[rn].name);
                else 
                 {    
                    System.out.println(" Room Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                System.out.flush();
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotelData.SingleBedRoom[rn]=null;
                    System.out.println("Room deallocate successfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }
    
    static void order(int rn,int rtype)
    {
        int i,q;
        char option;
         try{
             System.out.println("\n\t\t\t\t\t\t---------------------\t\t\t\t\t\n   Menu:  \n==========\n\n1.Namak paray\tRs.50\n2.Nimko\t\tRs.60\n3.Mirmirya\tRs.70\n4.Lassi\t\tRs.30\n");
        do
        {
            System.out.flush();
            i = sc.nextInt();
            System.out.print("Quantity- ");
            System.out.flush();
            q=sc.nextInt();
           
              switch(rtype){
            case 1: hotelData.MasterDoubleBedRoom[rn].food.add(new Food(i,q));
                break;
            case 2: hotelData.DoubleBedRoom[rn].food.add(new Food(i,q));
                break;
            case 3: hotelData.MasterSingleBedRoom[rn].food.add(new Food(i,q));
                break;
            case 4: hotelData.SingleBedRoom[rn].food.add(new Food(i,q));
                break;                                                 
        }
              System.out.println("Do you want to order anything else ? (y/n)");
            System.out.flush();
              option=sc.next().charAt(0);
        }while(option=='y'||option=='Y');
        }
         catch(NullPointerException e)
            {
                System.out.println("\nRoom not booked");
            }
         catch(Exception e)
         {
             System.out.println("Cannot be done");
         }
    }
}


class write implements Runnable
{
    database hotelData;
    write(database hotelData)
    {
        this.hotelData=hotelData;
    }
    @Override
    public void run() {
          try{
        FileOutputStream fout=new FileOutputStream("backup");
        ObjectOutputStream oos=new ObjectOutputStream(fout);
        oos.writeObject(hotelData);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }         
        
    }
    
}

public class Main {
    public static void clrScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args){

        try
        {           
        File f = new File("backup");
        if(f.exists())
        {
            FileInputStream fin=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fin);
            Hotel.hotelData=(database)ois.readObject();
        }
        Scanner sc = new Scanner(System.in);
        int ch,ch2;
        char option;
            System.out.println("\n\t\t------------------WELCOME TO FAST CROWN HOTELS------------------\n\n");
        x:
        do{

        System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
        ch = sc.nextInt();
        Main.clrScreen();
        switch(ch){
            case 1: System.out.println("\nChoose room type :\n1.Master Double Beds Room \n2.Double Beds Room \n3.Single Bed Room \n4.Master Single Bed Room\n");
                System.out.flush();
                    ch2 = sc.nextInt();
                    Main.clrScreen();
                    Hotel.features(ch2);
                break;
            case 2:System.out.println("\nChoose room type :\n1.Master Double Beds Room \n2. Double Beds Room \n3.Master Single Bed Room\n4.Single Bed Room\n");
                System.out.flush();
                 ch2 = sc.nextInt();
                 Main.clrScreen();
                     Hotel.availability(ch2);
                break;
            case 3:System.out.println("\nChoose room type :\n1.Master Double Beds Room \n2.Double Beds Room \n3.Master Single Bed Room\n4.Single Bed Room\n");
                System.out.flush();
                ch2 = sc.nextInt();
                Main.clrScreen();
                     Hotel.bookroom(ch2);                     
                break;
            case 4:
                 System.out.print("Room Number -");
                 System.out.flush();
                 ch2 = sc.nextInt();
                 Main.clrScreen();
                     if(ch2>60)
                         System.out.println("Room doesn't exist");
                     else if(ch2>40)
                         Hotel.order(ch2-41,4);
                     else if(ch2>30)
                         Hotel.order(ch2-31,3);
                     else if(ch2>10)
                         Hotel.order(ch2-11,2);
                     else if(ch2>0)
                         Hotel.order(ch2-1,1);
                     else
                         System.out.println("Room doesn't exist");
                     break;
            case 5:                 
                System.out.print("Room Number -");
                System.out.flush();
                ch2 = sc.nextInt();
                Main.clrScreen();
                     if(ch2>60)
                         System.out.println("Room doesn't exist");
                     else if(ch2>40)
                         Hotel.removeRoom(ch2-41,4);
                     else if(ch2>30)
                         Hotel.removeRoom(ch2-31,3);
                     else if(ch2>10)
                         Hotel.removeRoom(ch2-11,2);
                     else if(ch2>0)
                         Hotel.removeRoom(ch2-1,1);
                     else
                         System.out.println("Room doesn't exist");
                     break;
            case 6:break x;
                
        }
           
            System.out.println("\nContinue : (y/n)");
            System.out.flush();
            option=sc.next().charAt(0);
            Main.clrScreen();
            if(!(option=='y'||option=='Y'||option=='n'||option=='N'))
            {
                System.out.println("Invalid Option");
                System.out.println("\nContinue : (y/n)");
                System.out.flush();
                option=sc.next().charAt(0);
                Main.clrScreen();
            }
            
        }while(option=='y'||option=='Y');
        
        Thread t=new Thread(new write(Hotel.hotelData));
        t.start();
        }        
            catch(Exception e)
            {
                System.out.println("Not a valid input");
            }

    }
}
