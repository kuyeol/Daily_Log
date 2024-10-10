// Fig. 7.17: fig07_17.c
// Using operator sizeof to determine standard data type sizes.
#include <stdio.h>

int main(void)
{ 
   char c;           
   short s;         
   int i;       
   long l;         
   long long ll;         
   float f;        
   double d;         
   long double ld;   
   int array[20]; // create array of 20 int elements
   int *ptr = array; // create pointer to array

   printf("     sizeof c = %u\tsizeof(char)  = %u"   
          "\n     sizeof s = %u\tsizeof(short) = %u"   
          "\n     sizeof i = %u\tsizeof(int) = %u"   
          "\n     sizeof l = %u\tsizeof(long) = %u"   
          "\n    sizeof ll = %u\tsizeof(long long) = %u"   
          "\n     sizeof f = %u\tsizeof(float) = %u"   
          "\n     sizeof d = %u\tsizeof(double) = %u"   
          "\n    sizeof ld = %u\tsizeof(long double) = %u"   
          "\n sizeof array = %u"   
          "\n   sizeof ptr = %u\n",    
          sizeof c, sizeof(char), sizeof s, sizeof(short), sizeof i,
          sizeof(int), sizeof l, sizeof(long), sizeof ll,           
          sizeof(long long), sizeof f, sizeof(float), sizeof d,     
          sizeof(double), sizeof ld, sizeof(long double),           
          sizeof array, sizeof ptr);                                   
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


