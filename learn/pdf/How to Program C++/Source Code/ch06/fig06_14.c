// Fig. 6.14: fig06_14.c
// Using the const type qualifier with arrays.
#include <stdio.h>

void tryToModifyArray(const int b[]); // function prototype

// function main begins program execution
int main(void)
{
   int a[] = { 10, 20, 30 }; // initialize array a

   tryToModifyArray(a);

   printf("%d %d %d\n", a[0], a[1], a[2]);
}

// in function tryToModifyArray, array b is const, so it cannot be
// used to modify its argument array in the caller.                
void tryToModifyArray(const int b[])                            
{                                                                 
   b[0] /= 2; // error                                    
   b[1] /= 2; // error                                    
   b[2] /= 2; // error                                    
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
