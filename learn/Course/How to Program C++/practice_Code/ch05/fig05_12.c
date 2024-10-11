// Fig. 5.12: fig05_12.c
// Rolling a six-sided die 60,000,000 times.
#include <stdio.h>
#include <stdlib.h>

int main(void)
{ 
   unsigned int frequency1 = 0; // rolled 1 counter
   unsigned int frequency2 = 0; // rolled 2 counter
   unsigned int frequency3 = 0; // rolled 3 counter
   unsigned int frequency4 = 0; // rolled 4 counter
   unsigned int frequency5 = 0; // rolled 5 counter
   unsigned int frequency6 = 0; // rolled 6 counter

   // loop 60000000 times and summarize results
   for (unsigned int roll = 1; roll <= 60000000; ++roll) {
      int face = 1 + rand() % 6; // random number from 1 to 6

      // determine face value and increment appropriate counter
      switch (face) {

         case 1: // rolled 1
            ++frequency1;
            break;

         case 2: // rolled 2
            ++frequency2;
            break;
       
         case 3: // rolled 3
            ++frequency3;
            break;
         
         case 4: // rolled 4
            ++frequency4;
            break;
         
         case 5: // rolled 5
            ++frequency5;
            break;
         
         case 6: // rolled 6
            ++frequency6;
            break; // optional
      } 
   } 
   
   // display results in tabular format
   printf("%s%13s\n", "Face", "Frequency");
   printf("   1%13u\n", frequency1);
   printf("   2%13u\n", frequency2);
   printf("   3%13u\n", frequency3);
   printf("   4%13u\n", frequency4);
   printf("   5%13u\n", frequency5);
   printf("   6%13u\n", frequency6);
} 



/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
