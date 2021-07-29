# Alphabet-Lotto
Stack data structure in Java
Two people play this game with:
- alphabet-cards  
- bags including letters  

Each card consists of 8 English letters. The first 4 ones are ranged from A to N, while the others are ranged from O to Z. 
At the beginning of the game, each card (stack) should be randomly filled with distinct values. So, the letters in one stack should be different from each other.

There is a bag1 (stack) that initially includes all English letters. The program selects a letter from this bag randomly and removes it from the bag1. Each player deletes that letter from his/her stack. Selected letters are added to another bag (stack), named bag2, so the next letter is selected from the remaining letters. 

When a person deletes the first or last 4 letters, he/she gets the award $10. (“birinci çinko”)
When a person deletes all letters from the stack, he/she wins the game lotto and gets $30. 
If both players delete their last letter at the same time, they game is over without any winner (tie) and they share the money.
