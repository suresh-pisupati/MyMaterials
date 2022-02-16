public class EachWordReverse {
 
  public String eachWordReverse(String givenString) {
    
    String[] strArray = givenString.split(" ");
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < strArray.length(); i++) {
      builder.append(reverseOf(strArray(i))).append(" ");
    }
  }
  
  private String reverseOf(String str) {
    
    char[] chArray = str.toCharArray();
    int left = 0;
    int right = chArray.length - 1;
    while(left <= right) {
      char temp = chArray[left];
      chArray[left] = chArray[right];
      chArray[right] = temp;
      left++;
      right--;
    }
    return new String(chArray.toString());
  }
  
  public static void main(String[] args) {
    
    EachWordReverse obj = new EachWordReverse();
    System.out.println(obj.eachWordReverse( "Good  Morning!" ));
  }
}
  
