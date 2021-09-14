// Email Application
import java.util.Scanner;
import java.util.Random;
public class email
{
  public static void main(String[] args)
  {
    email em1 = new email("Erik", "P");

    //em1.setPassword();
    em1.toString();
  }

  private String firstName, lastName;
  //private String lastName;
  private String dprtName;
  private String password;
  private String fullEmail;
  private int mailBoxCapacity = 500;
  private String altEmail;
  private String compName = "company";

  //Constructors for names
  public email(String fname, String lname)
  {
    firstName = fname;
    lastName = lname;

    //Call method to set the department name
    dprtName = setDprt();

    //call method that will return the automated password
    password = genPass(20);
    System.out.println("P is" + password);

    //create the person's email
    fullEmail = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + dprtName + "." + compName + ".com";
  }

  //Ask for the department that the person is in
  private String setDprt()
  {
    System.out.println("Enter your department:");
    Scanner dprt = new Scanner(System.in);
    String dName = dprt.nextLine();
    return dName;
  }

  //Password generator that takes an inputted length and returns a string
  private String genPass(int len)
  {
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@!#$%^&*?";
    String randomPassword = "";
    int upperbound = chars.length()-1;
      //generate random values from 0-44
    while (randomPassword.length() <= len)
    {
      Random rand = new Random(); //instance of random class

      int int_random = rand.nextInt(upperbound);
      randomPassword += chars.substring(int_random, int_random+1);
    }
    return randomPassword;
  }
  public void setMailBoxCapacity(int capacity)
  {
    this.mailBoxCapacity = capacity;
  }
  public void setAltEmail(String altEmail)
  {
    this.altEmail = altEmail;
  }
  public void setPassword()
  {
    System.out.println("Hello, you have chosen to reset your password. In order to continue, you must provide your previous password:");
    Scanner obj = new Scanner(System.in);
    String prevPass = obj.nextLine();
    while(prevPass.equals(this.password) == false)
    {
      System.out.println("You've entered incorrectly, please try again");
      Scanner attempt = new Scanner(System.in);
      prevPass = attempt.nextLine();
    }
    System.out.println("You have successfully enter your previous password. Now enter your new password");
    Scanner obj2 = new Scanner(System.in);

    this.password = obj2.nextLine();
    System.out.println("New P is " + this.password);
  }
  public int getMailBoxCapacity() { return mailBoxCapacity;}
  public String getAltEmail() { return altEmail;}
  public String getPassword() { return password;}
  public String getFName() { return firstName;}
  public String getLName() { return lastName;}
  public String getDName() { return dprtName;}
  public String getFEmail() { return fullEmail;}
  public String getCName() { return compName;}

  public String toString()
  {
    String result = "Hello " + getFName() + " " + getLName() + ", welcome to " + getCName() + "!";
    result += " since you work at our " + getDName() + " department, your email will be " + getFEmail();
    result += ". Please let us know if you would let to change your email or password.";
    result += " PSST! your password is " + getPassword();
    System.out.println(result);
    return result;
  }




}
