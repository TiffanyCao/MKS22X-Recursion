import java.util.*;

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

  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> sums = new ArrayList<Integer>();
    makeSumsH(n-1, n, 0, sums);
    return sums;
  }

  public static void makeSumsH(int n, int added, int notAdded, ArrayList<Integer> list){
    if(n == 0){
      list.add(added);
      list.add(notAdded);
    }else{
      makeSumsH(n-1, n+added, added, list);
      makeSumsH(n-1, n+notAdded, notAdded, list);
    }
  }
  public static void main(String[] args){

    System.out.println("---Testing Sqrt---");
    System.out.println("*testing sqrt(100, 0.001): should return 10*");
    System.out.println(sqrt(100, 0.001));
    System.out.println("*testing sqrt(25, 0.001): should return 5*");
    System.out.println(sqrt(25, 0.001));
    System.out.println("*testing sqrt(16, 0.001): should return 4*");
    System.out.println(sqrt(16, 0.001));
    System.out.println("*testing sqrt(169, 0.001): should return 13*");
    System.out.println(sqrt(169, 0.001));
    System.out.println("*testing sqrt(2, 0.001): should return 1.41421...*");
    System.out.println(sqrt(2, 0.001));
    System.out.println("*testing sqrt(10000, 0.001): should return 100*");
    System.out.println(sqrt(10000, 0.001));
    System.out.println("*testing sqrt(250000, 0.001): should return 500*");
    System.out.println(sqrt(250000, 0.001));
    System.out.println("*testing sqrt(25600001, 0.001): should return 5059.64435...*");
    System.out.println(sqrt(25600001, 0.001));

    System.out.println("\n---Testing Fibonacci---");
    System.out.println("*testing fibonacci(0): should return 0*");
    System.out.println(fib(0));
    System.out.println("*testing fibonacci(1): should return 1*");
    System.out.println(fib(1));
    System.out.println("*testing fibonacci(5): should return 5*");
    System.out.println(fib(5));
    System.out.println("*testing fibonacci(10): should return 55*");
    System.out.println(fib(10));
    System.out.println("*testing fibonacci(13): should return 233*");
    System.out.println(fib(13));
    System.out.println("*testing fibonacci(20): should return 6765*");
    System.out.println(fib(20));
    System.out.println("*testing fibonacci(25): should return 75025*");
    System.out.println(fib(25));
    System.out.println("*testing fibonacci(30): should return 832040*");
    System.out.println(fib(30));
    System.out.println("*testing fibonacci(40): should return 102334155*");
    System.out.println(fib(40));
    System.out.println("*testing fibonacci(45): should return 1134903170*");
    System.out.println(fib(45));

    System.out.println("\n---Testing makeAllSums---");
    System.out.println("*testing makeAllSums(3): should return [6, 5, 4, 3, 3, 2, 1, 0]");
    System.out.println(Arrays.toString(makeAllSums(3).toArray()));
  }
}
