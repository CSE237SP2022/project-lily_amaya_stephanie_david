## Park Simulator
Simulates a Park and the locations within it.

# Iteration 1
We completed a main method that takes the user to the Park class. The park class asks the user which location they want to visit. We have four locations: a garden, a petting zoo, a basketball court, and a pool. These class inherit from the Location super class. Each location gives the user specific options for what they can do. 

We will fix up the errorsin our code, allowing the user to do things in each location properly. We also intend to expand the sub classes of Location (the garden, petting zoo, basketball court, and pool) to allow the user to do more things. 

Currently, not everything in each location works. The petting zoo and basketball court are functional, but the other locations will give errors if you try to do certain things.

# Iteration 2
We added additional functionality to each location, allowing the user to do more in each location, including playing minigames :D 
We also added more tests and fixed errors from the previous iteration.

Some of our code doesn't do exactly what we expect, so we will fix these issues in the next iteration. We will also expand the funcitonality of our classes to allow the user to do even more. We also plan on fixing/adding more tests that deal with user input. 

The code should not throw any errors, but it doesn't always do what we expect it to do.

# Iteration 3
All functionality in the Garden location is implemented. Do not insert any letters when you are prompted to input the number of flowers you want to pick/plant. Negative numbers should reprompt for valid integer. 12 tests for the garden test suite were added. Lots of focus on code cleanliness. 

The petting zoo is completely functional, letting the user pet and feed four animals. The code is clean, and there are 21 unit tests for the petting zoo. :)

The basketball court is finished, the user can play a basketball game (generates a random score) or play horse (input distances for shots). Added more tests for iteration 3.

The pool is completed, and the user can play a diving game with a UI made using JFrame, play a ring fetch minigame (text based), view a swimming simulator, and view pool information. More tests have been added in this iteration as well. Due to software limitations, the diving game doesn't work on WSL without external tools, so it prompts the user asking what OS they are using. All inputs are validated.

To run the code from the command line:
cd to the location project-lily_amaya_stephanie_david/src
run the script by typing: ./park_script.sh
(If something goes wrong with this, it may be necessary to change the permissions of the park_script.sh file)
