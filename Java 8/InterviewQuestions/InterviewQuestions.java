package InterviewQuestions;

public class InterviewQuestions {

    private void checkCharValue() {
        System.out.println('j' + 'a' + 'v' + 'a'); //Prints the sum of ASCII values of each character  -> 418
    }

    private void checkIntegerValue() {

        Integer int1 = 20;
        Integer int2 = 20;
        Integer int3 = 128;
        Integer int4 = 128;
        Integer int5 = new Integer(20);
        Integer int6 = new Integer(20);

        if (int1 == int2) {//This is going to return true as the values falls in the range of -127 to 128
            System.out.println("Equal..........");
        } else {
            System.out.println("Not Equal..........");
        }
        if (int3 == int4) {//This is going to return false as it is falling outside the range of -128 to 128
            System.out.println("Equal..........");
        } else {
            System.out.println("Not Equal..........");
        }
        if (int5 == int6) {//This is going to return false as == compares the memory location when compared to actual value
            System.out.println("Equal..........");
        } else {
            System.out.println("Not Equal..........");
        }
    }

    private void checkStringValue() {

        String str1 = "suresh";
        String str2 = "suresh";
        String str3 = new String("suresh");
        String str4 = str2;
        String str5 = str3;
        if (str1 == str2) {//This is going to return true as the memory locations are going to be same
            System.out.println("Equal..........");
        } else {
            System.out.println("Not Equal..........");
        }

        if (str1.equals(str2)) {//This is going to return false as == compares the memory location when compared to actual value
            System.out.println("Equal..........");
        } else {
            System.out.println("Not Equal..........");
        }

        if (str4 == str2) {//This is going to return true as the memory locations are going to be same
            System.out.println("Equal..........");
        } else {
            System.out.println("Not Equal..........");
        }

        if (str2 == str3) {//This is going to return false as the memory locations are going to be same
            System.out.println("Equal..........");
        } else {
            System.out.println("Not Equal..........");
        }

        if (str3 == str4) {//This is going to return false as the memory locations are going to be same
            System.out.println("Equal....str3 and str4......");
        } else {
            System.out.println("Not Equal.......str3 and str4...");
        }

        if (str3 == str5) {//This is going to return true as the memory locations are going to be same
            System.out.println("Equal.....str3 and str5.....");
        } else {
            System.out.println("Not Equal....str3 and str5......");
        }
    }

    private void checkDoubleValue() {
        double double1 = 3.1489 * 2;
        double double2 = 3.1489 * 2;
        if (double1 == double2) {
            System.out.println("Double values are equal........");
        } else {
            System.out.println("Double values are not equal............");
        }
    }


    public static void main(String[] args) {

        InterviewQuestions obj = new InterviewQuestions();
        obj.checkIntegerValue();
        obj.checkStringValue();
        obj.checkDoubleValue();
    }
}
