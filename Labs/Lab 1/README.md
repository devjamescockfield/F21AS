# Lab 01 - Errors & Exceptions, Debugger

## About
The app is to list the number of staff members and display their ID, name and hours worked. There is a simple GUI used to show the list and search of staff. You can use the command line to add (adds a staff member to the list), remove (removes a staff member from the list), list (lists all staff), list by name (searches the list for a given name), print (writes the list to a text file) and help (prints a list of commands that can be used).

- First I had to load project into an IDE, I choose IntelliJ, then understand the code.
- Next I had to make sure I could use the debugger before craring the NoMatchingIDException class. This Exception was made for the removeDetails method that gets thrown if you try and run the remove command and there is no matching ID.
- I then had to add my own bits to the code to make it more effective. For this part I added a check in the Staff Constructor to make sure the hours worked is within a valid range. Secondly, I added a format for the ID so that it is a letter followed by a number, e.g. A0. I also added a check to see if the ID is too long, To make sure the name only contains letters and lastly to check the name is not excessively long.
