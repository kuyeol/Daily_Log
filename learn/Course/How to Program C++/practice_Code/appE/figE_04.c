// Fig. E.4: figE_04.c
// Using designated initializers to initialize an array of structs in C99
#include <stdio.h>

struct twoInt // declare a struct of two integers
{
   int x;
   int y;
}; 

int main(void)
{
   // explicitly initialize elements of array a
   // then, explicitly initialize two elements 
   struct twoInt a[5] =
   {
      [0] = {.x = 1, .y = 2},
      [4] = {.x = 10, .y = 20}
   };

   // output array contents
   printf("x\ty\n");

   for (size_t i = 0; i < 5; ++i) {
      printf("%d\t%d\n", a[i].x, a[i].y);
   } 
}


 /*************************************************************************
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
