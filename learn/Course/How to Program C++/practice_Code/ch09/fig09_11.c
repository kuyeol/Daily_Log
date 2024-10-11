// Fig 9.11: fig09_11.c
// Right justifying and left justifying values
#include <stdio.h>

int main(void)
{ 
   puts("1234567890123456789012345678901234567890\n");
   printf("%10s%10d%10c%10f\n\n", "hello", 7, 'a', 1.23);
   printf("%-10s%-10d%-10c%-10f\n", "hello", 7, 'a', 1.23);
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
