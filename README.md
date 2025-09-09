# Cinema Room Manager

A simple Java console application to simulate the management of a cinema theatre. The program allows users to view the seating arrangement, buy tickets, and check statistics about ticket sales and income.

The project was built step by step in stages:

1. **Stage 1 - Print seats:**  
   Display the cinema seating arrangement in a grid format, showing rows and seats clearly.

2. **Stage 2 - Calculate the profit:**  
   Read the number of rows and seats per row, then calculate the total possible income using tiered ticket pricing:
    - If the total number of seats is 60 or fewer, all tickets cost $10.
    - Otherwise, tickets in the front half of rows cost $10 and tickets in the back half cost $8.

3. **Stage 3 - Set the ticket price:**  
   Let the user choose a seat and display the correct ticket price based on the cinema size and seat location.  
   Update the seating arrangement so that the chosen seat is marked as **B** for "booked".

4. **Stage 4 - Add menu to your application:**  
   Add a menu to let the user:
    - Show the seating arrangement.
    - Buy a ticket.
    - Exit the program.

5. **Stage 5 - Manage stats and make your app error-prone (Final):**  
   Add statistics to show:
    - Number of purchased tickets.
    - Percentage of tickets sold (rounded to 2 decimals).
    - Current income.
    - Total potential income.  
      Improve error handling so:
    - Already purchased seats cannot be bought again.
    - Out-of-bound seat coordinates show a **Wrong input!** message.

## Demo

<video width="1920" height="1080" align="center" src=""></video>

## Takeaway

This project gave me hands-on experience with building an interactive console-based application. I practiced handling two-dimensional arrays, validating user input, and updating state dynamically through loops and conditionals. Adding the statistics feature introduced me to calculating percentages, formatting numbers, and thinking carefully about edge cases like invalid seat selection. The final result feels like a real management tool, and it strengthened both my programming fundamentals and my ability to design user-friendly workflows in Java.
