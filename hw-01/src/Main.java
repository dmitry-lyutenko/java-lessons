import java.util.LinkedList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    int month = 10;
    System.out.printf("Month by number\nSrc: %s\nResult: %s\n\n",month,getMonth(month));

    String src_string = "Are you ready";
    System.out.printf("Reverse\nSrc: %s\nResult: %s\n\n",src_string, reverse(src_string));

    int[] array = {1,2,3,4,5,6};
    int find_value = 3;
    System.out.printf("Find value\nSrc: ");
    for (int i=0;i< array.length;i++) {
      System.out.printf("%s ", array[i]);
    }
    System.out.printf("\nResult: %s\n\n", findValue(array,find_value));

    int[] array1 = {2,3,4,5,6,1};
    int[] array2 = bubbleSort(array1);

    System.out.println("Bubble sort:");
    System.out.printf("%5s|%5s\n","Src","Res");
    for (int i = 0; i < array1.length; i++) {
      System.out.printf("%5s|%5s\n", array1[i], array2[i]);
    }


    int[] dec_values = {15,16,32,255,256,1024};
    System.out.println("\nFrom DEC to HEX");
    System.out.printf("%5s|%5s\n","DEC","HEX");
    for (int i = 0; i < dec_values.length; i++) {
      System.out.printf("%5s|%5s\n",dec_values[i],toHex(dec_values[i]));
    }
    System.out.println("\nFind perfect numbers from 1 to 1000");
    findPerfect(1, 1000);
  }

  public static void findPerfect(int min, int max) {
    List<Integer> divisors = new LinkedList<>();
    System.out.println("Perfect number  | Divisors");
    while (min % 2 !=0) { min += 1;}
    for (int i = min; i <= max; i += 2) {
      int m = i / 2;
      int sum = 0;
      for (int d = m; d > 0; d--) {
        if (i % d == 0) {
          sum += d;
          divisors.add(d);
        }
        if (sum > i) {
          break;
        }
      }
      if (sum == i) {
        System.out.printf("%8s      |", i);
        for (int index = divisors.size() - 1; index >= 0; index--) {
          System.out.printf(" %3d", divisors.get(index));
          if (index != 0) { System.out.print(","); }
        }
        System.out.println();
      }
      divisors.clear();
    }
  }

  public static String getMonth(int index) {
    String[] month = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    if (index >= 0 && index <= 12) {
      return month[index - 1];
    } else {
      return null;
    }
  }

  public static String reverse(String str) {
    char[] chars = new char[str.length()];
    for (int i = str.length() - 1; i >= 0; i--) {
      chars[i] = str.charAt(str.length() - i - 1);
    }
    return String.copyValueOf(chars);
  }

  public static int findValue(int[] array, int value) {
    int result = -1;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        result = i;
        break;
      }
    }
    return result;
  }

  public static int[] bubbleSort(int array[]) {
    boolean moved;
    int i = 0;
    int tmp = 0;
    int[] result = array.clone();

    do {
      moved = false;
      for (i = 1; i < result.length; i++) {
        if (result[i] < result[i - 1]) {
          tmp = result[i - 1];
          result[i - 1] = result[i];
          result[i] = tmp;
          moved = true;
        }
      }
    } while (moved);
    return result;
  }

  public static String toHex (int value) {
    char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    int d = 0;
    int i = 0;
    while (value > Math.pow(16,d)) {
      d += 1;
    }
    StringBuffer sb = new StringBuffer();
    while (value > 15) {
      sb.append(chars[value % 16]);
      i += 1;
      value = value / 16;
    }
    sb.append(chars[value]);
    return sb.reverse().toString();
  }
}
