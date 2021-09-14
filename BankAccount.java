import java.util.Scanner;
import java.util.Random;

public class BankAccount
{
  public static void main(String[] args)
  {
    System.out.println("Please enter your name:");
    Scanner n = new Scanner(System.in);
    String name = n.nextLine();
    String id = "";
    while(id.length() < 9)
    {
      id += String.valueOf(9 * Math.random());
    }
    BankAccount obj = new BankAccount(name, id);
    obj.showMenu();
  }

  private int balance;
  private int prevTransaction;
  private String customerName;
  private String customerID;

  BankAccount(String cname, String cid)
  {
    customerID = cid;
    customerName = cname;
  }
    //make functions for desposit, withdraw, getprevTransaction, and show menu
  public void desposit(int amount)
  {
    if(amount > 0)
    {
      balance += amount;
      prevTransaction = amount;
    }
  }
  public void withdraw(int amount)
  {
    if(amount > 0)
    {
      balance -= amount;
      prevTransaction = -amount;
    }
  }
  public void getPrevTransaction()
  {
    if(prevTransaction > 0)
    {
      System.out.println("You desposited $" +prevTransaction);
    }
    else if(prevTransaction < 0)
    {
      System.out.println("You withdrew $" + (-1*prevTransaction));
    }
    else {System.out.println("You did not do anything");}
  }
  public void showMenu()
  {
    System.out.println("Hello "+ customerName + ", your ID today is: " + customerID);
    System.out.println("\n");
    System.out.println("What would you like to do right now?");
    Scanner opt = new Scanner(System.in);
    System.out.println("Insert A if you would like to desposit money");
    System.out.println("Insert B if you would like to withdraw money");
    System.out.println("Insert C if you would like to see your previous transaction");
    System.out.println("Insert D if you would like to see your current balance");
    System.out.println("Insert E if you would like to leave for today" + "\n");
    String c = opt.nextLine();
    while(c.toUpperCase().equals("E") == false)
    {
      if(c.toUpperCase().equals("A"))
      {
        System.out.println("Please enter an amount to desposit:");
        Scanner num = new Scanner(System.in);
        int amnt = num.nextInt();
        desposit(amnt);
      }
      else if(c.toUpperCase().equals("B"))
      {
        System.out.println("Please enter an amount to withdraw:");
        Scanner num = new Scanner(System.in);
        int amnt = num.nextInt();
        withdraw(amnt);
      }
      else if(c.toUpperCase().equals("C"))
      {
        System.out.println("Your previous transaction was:");
        getPrevTransaction();
      }
      else if(c.toUpperCase().equals("D"))
      {
        System.out.println("You current balance is $" + balance);
      }

      System.out.println("Please Select another option if you would like:");
      System.out.println("Insert A if you would like to desposit money");
      System.out.println("Insert B if you would like to withdraw money");
      System.out.println("Insert C if you would like to see your previous transaction");
      System.out.println("Insert D if you would like to see your current balance");
      System.out.println("Insert E if you would like to leave for today" + "\n");
      c = opt.nextLine();
    }
  }
}
