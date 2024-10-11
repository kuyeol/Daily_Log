// Fig. 10.3: fig10_03.c
// Card shuffling and dealing program using structures
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define CARDS 52
#define FACES 13

// card structure definition                  
struct card {                                 
   const char *face; // define pointer face   
   const char *suit; // define pointer suit   
}; 

typedef struct card Card; // new type name for struct card   

// prototypes
void fillDeck(Card * const wDeck, const char * wFace[], 
   const char * wSuit[]);
void shuffle(Card * const wDeck);
void deal(const Card * const wDeck);

int main(void)
{ 
   Card deck[CARDS]; // define array of Cards

   // initialize array of pointers
   const char *face[] = { "Ace", "Deuce", "Three", "Four", "Five",
      "Six", "Seven", "Eight", "Nine", "Ten",
      "Jack", "Queen", "King"};

   // initialize array of pointers
   const char *suit[] = { "Hearts", "Diamonds", "Clubs", "Spades"};

   srand(time(NULL)); // randomize

   fillDeck(deck, face, suit); // load the deck with Cards
   shuffle(deck); // put Cards in random order
   deal(deck); // deal all 52 Cards
} 

// place strings into Card structures
void fillDeck(Card * const wDeck, const char * wFace[], 
   const char * wSuit[])
{ 
   // loop through wDeck
   for (size_t i = 0; i < CARDS; ++i) { 
      wDeck[i].face = wFace[i % FACES];
      wDeck[i].suit = wSuit[i / FACES];
   } 
} 

// shuffle cards
void shuffle(Card * const wDeck)
{ 
   // loop through wDeck randomly swapping Cards
   for (size_t i = 0; i < CARDS; ++i) { 
      size_t j = rand() % CARDS;
      Card temp = wDeck[i];      
      wDeck[i] = wDeck[j];
      wDeck[j] = temp;      
   } 
} 

// deal cards
void deal(const Card * const wDeck)
{ 
   // loop through wDeck
   for (size_t i = 0; i < CARDS; ++i) {
      printf("%5s of %-8s%s", wDeck[i].face, wDeck[i].suit,
         (i + 1) % 4 ? "  " : "\n");
   } 
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
