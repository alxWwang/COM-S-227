
public class NumberSearch {
   public static void findNumber(int number, int lowVal, int highVal) {
      int midVal;

      midVal = (highVal + lowVal) / 2;
      System.out.print(number);
      System.out.print(" ");
      System.out.print(midVal);

      if (number == midVal) {
         System.out.println(" g");
      }
      else {
         if (number < midVal) {
            System.out.println(" h");
            findNumber(number, lowVal, midVal);
         }
         else {
            System.out.println(" i");
            findNumber(number, midVal + 1, highVal);
         }
      }
   }

   public static void main(String[] args) {
      findNumber(8, 0, 12);
   }
}