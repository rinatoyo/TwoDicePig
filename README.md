# TwoDicePig
Two Dice Pig Game written in Java.
Original assignment link here: http://courses.ics.hawaii.edu/ReviewICS111/morea/070.objects-classes/experience-H07.html
Make sure you have Java and eclipse installed to run this program.

Instructions:

1) Fork and clone this repository into eclipse.
2) Run the program.
3) Enter the number of players into the console when prompted.
4) Enter 1 to roll the dice and 2 to hold and move on to the next player.


Assignment:

1) Write a program that allows players to play the game Two-Dice Pig.

The rules of Two-Dice Pig are:

- Each turn, a player repeatedly rolls two dice until a 1 is rolled or the player decides to “hold”:
- If a single 1 is rolled, the player scores nothing and the turn ends.
- If two 1s are rolled, the player’s entire score is lost, and the turn ends.
- If the player rolls any other number, it is added to their turn total and the player’s turn continues.
- If a double is rolled, the point total is added to the turn total as with any roll but the player is obligated to roll again.
- If a player chooses to “hold”, their turn total is added to their score, and it becomes the next player’s turn.
- The first player to 100 or more points wins.
- The program should ask for the number of players, then create an array of Players. The Player class should have a name instance variable and a score instance variable. Once the players are initialized the program should start playing the game by giving each player a turn.
- The program should have a function named playerTurn that allows the player to decide when to “hold”. The function must return the score for the player’s turn.
- The program should use an instance of the class PairOfDice to do the rolling of the dice. 
