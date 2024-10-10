// Fig. 9.2: fig09_02.c
// Using the integer conversion specifiers
#include <stdio.h>

int main(void)
{ 
   printf("%d\n", 455);
   printf("%i\n", 455); // i same as d in printf, different in scanf
   printf("%d\n", +455); // plus sign does not print
   printf("%d\n", -455); // minus sign prints
   printf("%hd\n", 32000);
   printf("%ld\n", 2000000000L); // L suffix makes literal a long 
   printf("%o\n", 455); // octal
   printf("%u\n", 455);
   printf("%u\n", -455);
   printf("%x\n", 455); // hexadecimal with lowercase letters
   printf("%X\n", 455); // hexadecimal with uppercase letters
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