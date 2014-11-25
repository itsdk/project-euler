/*
Project Euler Problem 4
Matthew Pepers
 
A palindromic number reads the same both ways. 
The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int isPalindrome(int);

int main() {
  int gPal = 0; //greatest palindromic number
  int tempGP = 0; //temporary greatest palindromic number
  int num1 = 0; //first 3-digit number
  int tNum1 = 0; //temporary first 3-digit number
  int num2 = 0; //second 3-digit number
  int tNum2 = 0; //temporary second 3-digit number
  int rc; //return code

  for (tNum1 = 999; tNum1 > 99; --tNum1) {
    for (tNum2 = 999; tNum2 > 99; --tNum2) {
      tempGP = tNum1 * tNum2;
      rc = isPalindrome(tempGP); //checks if a palindrome
      if (rc == 1) {
        if (tempGP > gPal) {
          gPal = tempGP;
          num1 = tNum1;
          num2 = tNum2;
        }
      }
    }
  }
  printf("The largest palindromic number made from the product of two 3-digit numbers is: %d = %d x %d",
     gPal, num1, num2); 
    
}

//checks if a palindrome or not
int isPalindrome(int p){
  int i; //counter
  char gPalStr[15]; //string version of greatest palindromic number

  sprintf(gPalStr, "%d", p); //convert to string
  int len = strlen(gPalStr); //determines length of potential palindrome 

  for (i = 0; i < len/2; i++) {
    if (gPalStr[i] != gPalStr[len-i-1]) {
      return 0; //not a palindrome
    }
  }
  return 1; //is a palindrome
}
