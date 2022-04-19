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

To run the code from the command line:
cd to the location project-lily_amaya_stephanie_david/src
run the script by typing: ./park_script.sh
(If something goes wrong with this, it may be necessary to change the permissions of the park_script.sh file)

# Iteration 3
All functionality in the location Garden is implemented. The user must put an integer when they are prompted for the number of flowers to pick/prompt or an error will be thrown, which we are working on fixing. Lots of tests for the garden test suite were added. May not have an increased amount of functionality, but lots of focus on code cleanliness. 

