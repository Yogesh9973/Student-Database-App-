/*Basic criteria:-

1) Ask how many new students will be added to datatbase.
2) The user should be prompted to enter the name and year for each student.
3) The student should have 5- Digit unique id, with the first number should be grade level.
4) A student can enroll in following courses:
 History 101
 Mathematics 101
 English 101
 Chemistry 101
 Computer Science 101
 5) Each course cost Rs.600 to enroll.
 6) The student should be able to view the balance and pay the tuition.
 7) To see the status of student , we should see their name , ID, courses enrolled, and balance.

*/


package StudentDatabaseApp;
import java.util.*;
import java.io.*;

public class Student {
    //constructor : prompt user to enter name and year
  private String firstName;
  private String lastName;
  private String gradeYear;
  private String studentID;
  private String courses=" ";
  private int tuitionBalance =0;
  private static int costOfCourse=600;
  private static int id=1000;
 
  public Student (){
  Scanner sc= new Scanner(System.in);
  System.out.print("Enter Student FirstName : ");
  this.firstName= sc.nextLine();
  
  System.out.print("Enter Student LastName : ");
  this.lastName= sc.nextLine();

  System.out.print(" 1- Fresher \n 2- Second Year \n 3- Third Year \n 4- Final Year \n Enter Student Grade Year : ");
  this.gradeYear= sc.nextLine();
  setStudentID();

   }
 // Generate ID 
 private void setStudentID(){
 //Grade level + ID
 id++;
  this.studentID= gradeYear + "" + id;
 
 }
   // Enroll courses
   public void enroll(){
       // Get inside a loop, user hits Q
           
       do{
           System.out.print("Enter course to enroll (Q to quit): ");
            Scanner sc= new Scanner(System.in);
            String course= sc.nextLine();
            if(!course.equals ("Q")){
                courses = courses +"\n " + course;
                tuitionBalance = tuitionBalance +costOfCourse;
            }
            else{
                break;
            }
        }
        while(1!=0);

   }
   //view balance 
   public  void viewBalance(){
       System.out.println("Your Balance is Rs "+ tuitionBalance+"\n");
   }
   // pay tuition
   public void payTuition(){
       viewBalance();
       System.out.print("Enter Your Payment Rs ");
       Scanner sc= new Scanner(System.in);
       int payment= sc.nextInt();
       tuitionBalance= tuitionBalance - payment;
       System.out.println("Thank You for your Payment of Rs "+ payment);
       viewBalance();
   }
   //Show status
   public String toString(){
       return "Name:" + firstName+" "+ lastName+
       "\nGrade Year:"+" "+gradeYear+
       "\nStudent ID:"+" "+studentID+
       "\nCourses Enrolled:"+ courses +
       "\nBalance: Rs "+ tuitionBalance;
   }
  }
 class Main{
     public static void main (String [] args)
     {
      
       // Ask how many student we want to add
       System.out.println("Enter number of students to enroll: ");
       Scanner sc= new Scanner(System.in);
       int numOfStudents= sc.nextInt();
       Student[] students = new Student[numOfStudents];
       // create number of new students
       for (int i=0; i< numOfStudents;i++)
       {
        students[i]= new Student();
        students[i].enroll();
        students[i].payTuition();
       }
       for (int i=0; i< numOfStudents;i++)
       {
         System.out.println(students[i].toString());
       }
     }
 }
