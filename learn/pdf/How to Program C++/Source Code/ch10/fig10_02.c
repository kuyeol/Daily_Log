// Fig. 10.2: fig10_02.c
// Structure member operator and 
// structure pointer operator
#include <stdio.h>

// card structure definition            
struct card {                           
   char *face; // define pointer face   
   char *suit; // define pointer suit   
}; 

int main(void)
{ 
   struct card aCard; // define one struct card variable   

   // place strings into aCard
   aCard.face = "Ace";   
   aCard.suit = "Spades";

   struct card *cardPtr = &aCard; // assign address of aCard to cardPtr

   printf("%s%s%s\n%s%s%s\n%s%s%s\n", aCard.face, " of ", aCard.suit,
      cardPtr->face, " of ", cardPtr->suit,                           
      (*cardPtr).face, " of ", (*cardPtr).suit);                 
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
