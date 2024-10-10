// Fig. 9.19: fig09_19.c
// Reading input with floating-point conversion specifiers
#include <stdio.h>

// function main begins program execution
int main(void)
{ 
   double a;
   double b;
   double c;

   puts("Enter three floating-point numbers:");
   scanf("%le%lf%lg", &a, &b, &c);

   printf("\nHere are the numbers entered in plain");
   puts("floating-point notation:");
   printf("%f\n%f\n%f\n", a, b, c);
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
