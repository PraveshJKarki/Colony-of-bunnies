
/**
 * Programer = Pravesh Jung Karki
 * CSC 205 = Programming Assignment - 2
 * Description = This application will calculate how fast
 * the colony of bunnies
 * is growing over a period of time. The program will first
 * ask the user the carrying
 * capacity of the farm , birth and death rate of bunnies ,
 * initial population and total
 * number of month that the user would like to calculate
 * for. Then after we will do the
 * necessary calculation and provide the user if they want
 * to see the results of each month
 * in a table . And after all it will again ask the user if
 * they would like to calculate
 * with another data for the same farm and also for the
 * other farm with different carrying capacity.
 */

import java.util.Scanner;

public class Program2 {

   // creating scanner object for user input.
   public static Scanner keyboard = new Scanner( System.in );

   public static void main(String[] args) {
      //DECLARING NECESSARY VARIABLES
      char graph;       // hold table
      char sameFarm;    // hold for same farm
      char otherFarm;   // hold for different farm
      boolean table = false; // to get table
      int capacity;       // to hold carrying capacity
      int intPopln;       // to hold initial population
      int month;          // to hold total month.
      double birthRate;   // to hold birthRate.
      double deathRate;   // to hold deathRate
      double growthRate;  // bunnies per bunny per month.
      int totalBunnies;   // total number bunnies 
      
      System.out.print("This application will calculate ");
      System.out.println( "how fast your colony of bunnies " );
      System.out.println( "is growing over a period of time. " );
      System.out.print( "After you are done answering necessary " );
      System.out.println( "questions it will ask you if you would " );
      System.out.println( "like to do it again for the same farm " );
      System.out.print("as well as for a different ");
      System.out.println( "farm with different data.\n" );
      System.out.println( "Press ENTER to begin. " );
      keyboard.nextLine();
      do {
         System.out.println();
         // calling carryingCapacity method .
         capacity = getCarryingCapacity();

         do {
            System.out.println();
            // calling initialPopulation method.
            intPopln = getInitialPopulation();
            System.out.println();
            // calling totalMonth method.
            month = getTotalMonth();
            System.out.println();
            // calling getBirthRate method.
            birthRate = getBirthRate();
            System.out.println();
            // calling getDeathRate method.
            deathRate = getDeathRate();
            System.out.println();
            //calculating growthRate
            growthRate = birthRate - deathRate;
             
            System.out.println(
                  "Do you like to display the monthly growth in a table ?" );
            System.out.print( "ENTER 'Y' for \"YES\" and 'N' for \"NO\":" );
            graph = keyboard.next().toLowerCase().charAt(0);
            while (graph != 'y'&& graph != 'n'){
            System.out.println("ERROR! Not a valid input ");
            System.out.println("Please ENTER 'y' for \"YES\" and 'n' for \"NO\":");
            graph = keyboard.next().toLowerCase().charAt(0);

            }

            if ( graph ==  'y' ) {
               table = true;
            }
            else {
            
               table = false;
            }

            // calling getBunnies method.
           totalBunnies =  getBunnies( capacity, intPopln, month, growthRate,
                  table );
            System.out.println();
            System.out.print( "The total number of bunnies after" );
            System.out.printf( " %d month is: %d.\n", month, totalBunnies );
            System.out.println();
            System.out.println(
                  "Do you like to ask other questions about the same farm ? " );
            System.out.print( "ENTER 'Y' for \"YES\" and 'N' for \"NO\":" );
            
            sameFarm = keyboard.next().toLowerCase().charAt(0);
            while (sameFarm != 'y'&& sameFarm != 'n'){
            System.out.println("ERROR! Not a valid input ");
            System.out.println("Please ENTER 'y' for \"YES\" and 'n' for \"NO\":");
            sameFarm = keyboard.next().toLowerCase().charAt(0);

            }
            
         } while ( sameFarm == 'y' );
            System.out.println();
            System.out.println(
                  "Do you like to ask other questions about the different farm ? " );
            System.out.print( "ENTER 'y' for \"YES\" and 'n' for \"NO\":" );
            otherFarm = keyboard.next().toLowerCase().charAt(0);
            while (otherFarm != 'y'&& otherFarm != 'n'){
            System.out.println("ERROR! Not a valid input ");
            System.out.println("Please ENTER 'y' for \"YES\" and 'n' for \"NO\":");
            otherFarm = keyboard.next().toLowerCase().charAt(0);
         }
       } while ( otherFarm == 'y' );

   
   }
   

   /**
    * The method below does not take anything
    * as a parameter and will ask the user for the
    * number of bunnies that their farm can
    * comfortably support. It is simply the
    * carrying capacity of the farm. It will
    * return the carrying capacity.
    */
   public static int getCarryingCapacity() {
      int capacity;

      System.out.println( "Enter the positive number of bunnies" );
      System.out.print(
            "that your farm support comfortably (Carrying capacity) : " );
      while ( !keyboard.hasNextInt() ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         keyboard.next();
      }
      capacity = keyboard.nextInt();
      if ( capacity <= 0 ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         capacity = keyboard.nextInt();
      }

      return capacity;

   }

   /**
    * The method below does not take anything
    * as a parameter and it will ask the user for the
    * initial population . It means how much bunnies
    * we start with. It will return the initial population.
    */
   public static int getInitialPopulation() {
      int intPopln;

      System.out.println( "Enter the positive number of bunnies" );
      System.out.print( "that you start with (Initial Population) : " );
      while ( !keyboard.hasNextInt() ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         keyboard.next();
      }
      intPopln = keyboard.nextInt();
      if ( intPopln <= 0 ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         intPopln = keyboard.nextInt();

      }

      return intPopln;

   }

   /**
    * The method below does not take anything
    * as a parameterand it will ask the user for how
    * many month they would like to calculate
    * the total number of bunnies. The method returns
    * the total number of month.
    */
   public static int getTotalMonth() {
      int totalMonth;

      System.out.println( "Enter the total positive number of month" );
      System.out.print( "that you would like to calculate (Month): " );
      while ( !keyboard.hasNextInt() ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         keyboard.next();
      }
      totalMonth = keyboard.nextInt();
      if ( totalMonth <= 0 ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         totalMonth = keyboard.nextInt();
      }
      return totalMonth;

   }

   /**
    * The method below does not take anything
    * as a parameterand it will ask the user for
    * the birth rate of the bunnies. It returns
    * the birth rate .
    */
   public static double getBirthRate() {
      double birthRate;

      System.out.println( "Enter the birth rate of the bunnies ,  " );
      System.out.print( "non-negative (positive or zero ) : " );
      while ( !keyboard.hasNextDouble() ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         keyboard.next();
      }
      birthRate = keyboard.nextDouble();
      if ( birthRate < 0 ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         birthRate = keyboard.nextDouble();

      }

      return birthRate;

   }

   /**
    * The method below does not take anything
    * as a parameter and it will ask the user for
    * the death rate of the bunnies.The method
    * returns the death rate of bunnies.
    */
   public static double getDeathRate() {
      double deathRate;

      System.out.println( "Enter the death rate of the bunnies. " );
      System.out.print( "The number must be between 0 and 1 inclusive.  : " );
      while ( !keyboard.hasNextDouble() ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         keyboard.next();
      }
      deathRate = keyboard.nextDouble();
      if ( deathRate < 0 || deathRate > 1 ) {
         System.out.println( "ERROR: not a valid input " );
         System.out.print( "Please ENTER a valid number : " );
         deathRate = keyboard.nextDouble();
      }
      return deathRate;

   }

   /**
    * The method below will take capcacity , intPopln ,
    * month ,
    * growthRate and a table as a parameter .
    * It helps to calculate the total number of bunnies
    * by the end of requested month. It does the necessary
    * calculation
    * and display table as per user request.
    * It will return the total number of bunnies by the end
    * of the requested month.
    * 
    */
   public static int getBunnies(int capacity , int intPopln , int month ,
         double growthRate , boolean table) {

      // DECLARING NECESSARRY VARRAIBALES
      double bOld;// relative population of bunnies
                  // by the beginning of the month
      double bNew;// relative population of bunnnies
                  // by the end of the month.
      int pNew = 0 ; // initializing pNew to new population.
      int pOld = intPopln; // initializing initial
                           // population
                           // to pOld.
      

      if ( table ) {
         System.out.println( "------------------------" );
         System.out.println( "Month \t\t Population " );
         System.out.println( "------------------------" );
         System.out.println( "0 \t\t\t\t   " + intPopln );
      }

      for ( int i = 0; i < month; i++ ) {

         bOld = (double) pOld / capacity;
         bNew = bOld + growthRate * bOld * (1 - bOld);
         pNew = (int) Math.round( bNew * capacity );
         // setting pNew to pOld.
         pOld = pNew;

         if ( table ) {
            System.out.println( (i + 1) + "\t\t\t\t\t" + pNew );
         }

      }
       return pNew;
   }

}
