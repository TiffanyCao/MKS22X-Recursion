public class Recursion{

  public static double sqrt(double n, double tolerance){
    return sqrtH(n, n/2, tolerance);
  }

  public static double sqrtH(double n, double guess, double tolerance){
    if(Math.abs(((guess * guess) - n) / n) * 100 <= tolerance){
      return guess;
    }else{
      return sqrtH(n, (n / guess + guess) / 2, tolerance);
    }
  }

  public static int fib(int n){
    return fibH(n, 0, 1, 0);
  }

  public static int fibH(int n, int first, int second, int count){
    if(count == n){
      return first;
    }else{
      return fibH(n, second, first + second, count + 1);
    }
  }

  public static void main(String[] args){

    System.out.println("---Testing Sqrt---");
    System.out.println("*testing sqrt(100): should return 10*");
    System.out.println(sqrt(100, 0.001));
    System.out.println("*testing sqrt(25): should return 5*");
    System.out.println(sqrt(25, 0.001));
    System.out.println("*testing sqrt(16): should return 4*");
    System.out.println(sqrt(16, 0.001));
    System.out.println("*testing sqrt(169): should return 13*");
    System.out.println(sqrt(169, 0.001));
    System.out.println("*testing sqrt(2): should return 1.41421*");
    System.out.println(sqrt(2, 0.001));
  }
}
