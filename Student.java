// Student
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Student
{
  private String firstName, lastName, year, courses, studentID;
  private int tuitionBalance = 0;
  private static int courseCost = 600;
  private static int id = 1000;

  //Constructor that will prompt user to enter student name and year
  public Student()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the student's first name:");
    firstName = in.nextLine();

    Scanner in2 = new Scanner(System.in);
    System.out.println("Please enter the student's last name:");
    lastName = in2.nextLine();

    Scanner in3 = new Scanner(System.in);
    System.out.println("If the student is a freshmen, enter 1:\nIf the student is a sophomore, enter 2:\nIf the student is a junior, enter 3:\nIf the student is a senior, enter 4:");
    year = in3.nextLine();

    setStudentID();
  }
  //Generate ID w/ students first digits as grade
  private void setStudentID()
  {
    id++; //whenever another student is created, this id car will increase by one each time.
    studentID = year + "" + String.valueOf(id);
  }
  //Enroll in courses
  public void enroll()
  {
    //Go into a loop to ask how many of the available courses student would like to take, 0 to quit
    do{
      System.out.print("Enter a course to enroll in, enter 'Q' if you would like to quit:");
      Scanner in = new Scanner(System.in);
      String course = in.nextLine();
      if(!course.toUpperCase().equals("Q"))
      {
        courses += ", " + course;
        tuitionBalance += courseCost;
      }
      else {break;}
    } while(1 != 0);
    courses = courses.substring(6, courses.length());
  }
  //View balance and pay tuition
  public void money()
  {
    System.out.println("Good evening " + firstName + " " + lastName +", your current tuition balance is $" + tuitionBalance +". Would you like to make a payment now?");
    Scanner in = new Scanner(System.in);
    String opt = in.nextLine();
    if(opt.toLowerCase().equals("yes"))
    {
      System.out.println("Please enter amount you would like to pay as of now");
      int amnt = in.nextInt();
      tuitionBalance -= amnt;
    }
    if(tuitionBalance > 0){System.out.println("Your money due is $" + tuitionBalance);}
    else{System.out.println("Congrats, you now owe nothing!");}
  }

  //show status 26.5
  public String toString()
  {
    return "Student name: " + firstName + " " + lastName + " in year " + year + "\nYou ID is " + studentID + "\nEnrolled Courses: " + courses + "\nTuition Due: $" + tuitionBalance;
  }
}
