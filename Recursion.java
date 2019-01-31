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
}
