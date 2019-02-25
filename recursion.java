import java.util.*;

public class recursion{

  /**A method for recursively finding the approximate square root of a number using Newton's approximation
  *@param double n is the number that you want to the find the square root of
  *@param double tolerance is the allowed percentage error the sqaured answer is away from n
  *@return double the approximate square root
  *precondion: n is non-negative
  */
  public double sqrt(double n, double tolerance){
    if(n == 0.0) return 0.0;
    return sqrtH(n, n/2, tolerance); //call to helper function
  }

  /**A recursive helper method that makes guesses using Newton's Square Root Approximation and returns the first guess that is within the tolerance threshold
  *@param double n is the number that you want to the find the square root of
  *@param double guess is the square root guess obtained using Newton's algorithm
  *@param double tolerance is the allowed percentage error the sqaured answer is away from n
  *@return double the approximate square root that is within the tolerance percentage
  */
  private static double sqrtH(double n, double guess, double tolerance){
    if(Math.abs(((guess * guess) - n) / n) * 100 <= tolerance){ //if the value of the guess squared is close enough to the number, return the guess
      return guess;
    }else{ //otherwise, recursively call this function until a tolerable guess is made
      return sqrtH(n, (n / guess + guess) / 2, tolerance);  //a new guess is made each time using Newton's algorithm
    }
  }

  /**A method that checks if a guess is close enough to the actual square root
  *@param double a is the guess
  *@param double b is the correct (or expected) answer
  *@return boolean
  */
  public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed
  }

  /**A method for recursively finding the n'th Fibonacci number in linear time
  *@param int n is the n'th Fibonacci number you want to find
  *@return int the Fibonacci value
  *precondition: n is non-negative
  */
  public int fib(int n){
    return fibH(n, 0, 1, 0); //call to helper function
  }

  /**A recursive helper method that calculates the value of the n'th Fibonacci number
  *@param int n is the n'th Fibonacci number you want to find
  *@param int first is the Fibonacci value two places before the current Fibonacci value that is being calculated. It is always 0 in the beginning
  *@param int second is the Fibonacci value right before the current Fibonacci value that is being calculated. It is always 1 in the beginning
  *@param int count keeps track of which number in the Fibonacci sequence we are up to
  *@return int the Fibonacci value
  */
  private static int fibH(int n, int first, int second, int count){
    if(count == n){ //if we are up to the number in the Fibonacci sequence that we're looking for...
      return first; //return the Fibonacci value; the param first also represents the current Fibonacci value of the count number
    }else{ //if we are not up the number in the sequence that we're looking for...
      return fibH(n, second, first + second, count + 1); //call this function recursively until we reach the number
      //the param first stores the value of param second
      //the param second stores the sum of the previous two Fibonacci values
    }
  }

  /**A method for recursively finding all the possible sums using the numbers from 1 up to n inclusive
  *@param int n the largest number that can be used
  *@return ArrayList<Integer> of all subset totals of the numbers 1 to n inclusive
  */
  public ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> sums = new ArrayList<Integer>(); //create a new integer ArrayList
    makeSumsH(n-1, n, 0, sums); //a call to the helper function
    return sums; //return the list
  }

  /**A recursive helper method that calculates all the possible sums
  *@param int n is the current number to be added. At the start, it is the value of n-1.
  *@param int added is the temporary sum including the previous number. At the start, it is the value of n (as in n has been added to the initial sum of 0).
  *@param int notAdded is the temporary sum not including the previous number to be added. At the start, it is the value of 0 (as in n has not been added to the initial sum of 0).
  *@param ArrayList<Integer> list
  *the method doesn't have a return; it only modifies the ArrayList
  */
  public static void makeSumsH(int n, int added, int notAdded, ArrayList<Integer> list){
    if(n == 0){ //if there are no more numbers that could be added, add the two sums to the list
      list.add(added);
      list.add(notAdded);
    }else{ //otherwise, recursively call the method until all the numbers have been used
      makeSumsH(n-1, n+added, added, list); //add or don't add the current number to the sum that includes the previous number, the current number is decreased
      makeSumsH(n-1, n+notAdded, notAdded, list); //add or don't add the current number to the sum that does not include the previous number, the current number is decreased
    }
  }

  ///////////TESTING///////////
  //testcase must be a valid index of your input/output array
  public static void testFib(int testcase){
    recursion r = new recursion();
    int[] input = {0,1,2,3,5,30};
    int[] output ={0,1,1,2,5,832040};
    int max = input.length;
    if(testcase < input.length){
      int in = input[testcase];
      try{

        int ans = r.fib(in);
        int correct = output[testcase];
        if(ans == correct){
          System.out.println("PASS test fib "+in+". "+correct);
        }
        else{
          System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test fib"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }


  //testcase must be a valid index of your input/output array
  public static void testSqrt(int testcase){
    recursion r = new recursion();
    double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
    double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
    int max = input.length;
    if(testcase < input.length){
      double in = input[testcase];
      try{

        double ans = r.sqrt(in,.00001);
        double correct = Math.sqrt(in);
        if(closeEnough(ans,correct)){
          System.out.println("PASS test sqrt "+in+" "+ans);
        }
        else{
          System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }
  
  public static void main(String[] args){
/*
    System.out.println("---Testing Sqrt---");
    System.out.println("*testing sqrt(0, 0.001): should return 0*");
    System.out.println(sqrt(0, 0.001));
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
    System.out.println("*testing sqrt(25600001, 0.001): should return 5059.66833...*");
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
    System.out.println("*testing makeAllSums(3): should return [6, 5, 4, 3, 3, 2, 1, 0]*");
    System.out.println(Arrays.toString(makeAllSums(3).toArray()));
    System.out.println("*testing makeAllSums(2): should return [3, 2, 1, 0]");
    System.out.println(Arrays.toString(makeAllSums(2).toArray()));
    System.out.println("*testing makeAllSums(1): should return [1, 0]");
    System.out.println(Arrays.toString(makeAllSums(1).toArray()));
    System.out.println("*testing makeAllSums(4): should return [10, 9, 8, 7, 7, 6, 5, 4, 6, 5, 4, 3, 3, 2, 1, 0]");
    System.out.println(Arrays.toString(makeAllSums(4).toArray()));
    */

    for(int i = 0; i < 6; i++){
      testFib(i);
    }
    for(int i = 0; i < 5; i++){
      testSqrt(i);
    }
  }
}
