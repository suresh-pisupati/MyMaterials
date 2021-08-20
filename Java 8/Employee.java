import java.io.Serializable;

public class Employee implements Serializable {

   private static final long serialVersionUID = 1L;

   private int sNo, age;
   private String sex, firstName, lastName;

   // Default Constructor
   public Employee() {

   }

   public Employee(int sNo, int age, String sex, String firstName, String lastName) {

      this.sNo = sNo;
      this.age = age;
      this.sex = sex;
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public int getsNo() {

      return sNo;
   }

   public void setsNo(int sNo) {

      this.sNo = sNo;
   }

   public int getAge() {

      return age;
   }

   public void setAge(int age) {

      this.age = age;
   }

   public String getSex() {

      return sex;
   }

   public void setSex(String sex) {

      this.sex = sex;
   }

   public String getFirstName() {

      return firstName;
   }

   public void setFirstName(String firstName) {

      this.firstName = firstName;
   }

   public String getLastName() {

      return lastName;
   }

   public void setLastName(String lastName) {

      this.lastName = lastName;
   }

   @Override
   public String toString() {

      return getLastName() + " " + getFirstName() + "  " + getAge() + "    " + getSex();
   }
}
