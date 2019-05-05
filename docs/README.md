 # LPOO_710 ASCII RIDER

> Include here one or two paragraphs explaining the main idea of the project, followed by a sentence identifying who the authors are.  

This project is a puzzle game based on 'Crypt Raider', where your objective in each level is to push one or more 'keys' to the 'exit door'. In order to travel through the different chambers, you must push boulders along the map, escape all the enemies and avoid the explosions that may be triggered by interacting with explosive elements.
 Think fast, think smart, and try to beat the timer to gain more points in each completed level.

 Developed by [Manuel Coutinho](https://github.com/ManelCoutinho "ManelCoutinho") and [Mário Gil](https://github.com/GambuzX "GambuzX").

## Table of contents
1. [Implemented Features](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#implemented-features)
2. [Planned Features](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#planned-features)
3. [Design](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#design)
    1. [LevelFacade](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#levelfacade)
    	1. [Problem in Context](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#problem-in-context) 
    	2. [The Pattern](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#the-pattern) 
    	3. [Implementation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#implementation)
    	4. [Consequences](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#consequences) 
4. [Known Code Smells and Refactoring Suggestions](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#known-code-smells-and-refactoring-suggestions)
5. [Important Discussions](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#important-discussions)
    1. [Save Data in Model and Efficiency](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#save-data-in-model-and-efficiency)
    2. [Multiple Threads vs Two Threads with Count](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#multiple-threads-vs-two-threads-with-count)
    3. [Builder Pattern vs Read From File](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#builder-pattern-vs-read-from-file)
    4. [Architectural Pattern - The Design Pattern Killer](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#architectural-pattern---the-design-pattern-killer)
6. [Testing Results](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#testing-results)
7. [Self-Evaluation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#self-evaluation)


## Implemented Features

> This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three screenshots that illustrate the most important features.

We already implemented the majority of the different kind of elements and its corresponding behaviors and interactions:

 - Physics Elements - all the non static elements (aside from the player and enemy) are affected by gravity and fall down when there's no ground under them. They can also be pushed along the map by the player. These include Boulders, Level Keys and TNT;
 - Key and Door Key - when there's a door in a certain level, you must first pick up the key in order to unlock and go through the door;
 - Wall - the wall is a static element without any behaviour or interaction that can not be destroyed.
 - Stone Block - this is a static element that differs from the walls in that they can be destroyed by explosions.
 - Enemy - there is already one enemy with random movement that explodes when some kind of stone falls on top of him. It also causes the player to die when they collide;
 - Sand  - dug by the player, the blocks of sand disappear when you visit their position;
 - TNT - this element generates an explosion in its neighbor cells when it hits the ground, some other element falls on top of it or fired by a nearby explosion; 
 - Level Key - elements that must be pushed by the player to the exit door in order to unlock it and allow the level to be finished. Destroying them with explosions makes the level unwinnable.
 - Exit Door - this is the level exit door, meaning you must go through it to go the next level. However, this door only opens when all the level keys have already been put in there.

There is a level builder that decodes .lvl files in order to create a new level, allowing us to quickly generate new ones.

![Level Example 1](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/implemented1.png) *Example from level 2*

![Level Example 2](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/implemented2.png) *Example from level 3*


## Planned Features

> This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should include GUI mock-ups for the planned features.

There are many features yet to be implemented:

 - [ ] Main Menu: where the user may choose between begin a new game from scratch (level 1), go directly to a certain level or view the highscores ranking;
 - [ ] Score: in order to implement the highscore ranking, we will have to create a score that will be based on the cumulative time that the player needs to complete the different levels;
 - [ ] Information Bar: we want to add a bar to the top of the screen with different information: 
	 - [ ] Time: a counter with the remaining time to finish the current level, which will be used to calculate the score;
	 - [ ] Score: a number representing the current score that the player has already accumulated;
	 - [ ] Level Number: parameter with information concerning the current level;
	 - [ ] Number of Lifes: we will allow the player to die or restart levels two times (3 lifes) before completely loosing the game;
	 - [ ] Progress Bar: indicates the number of level keys already put in the exit door and how many are missing;
	 - [ ] Restart button: button or indication of the key that you have to press in order to restart a level. When you perform this action, you will loose one life.
- [ ] New Enemies: 
	- [ ] Improve the way the current enemy moves;
	- [ ] Add another kind of enemy, which follows the player;
- [ ] Improved Lives system: add two other ways of loosing a life:
	- [ ] Time: when the time counter reaches 0;
	- [ ] Restart: when the user chooses to restart a level.
- [ ] Improved Explosions: Make the explosion have some kind of animation that lasts some time and doesn't just remove the surrounding elements, allowing elements to be destroyed by going through the explosion moments after it happens;
- [ ] Swing compatibility: add a swing version of the game.

![Info Bar Prototype](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/info_bar.png)*Info Bar Prototype*


## Design

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts: "Problem in Context", "The Pattern", "Implementation" and "Consequences".

>TODO: Not that sure about what it is to write in the different parts of each chapter. 

### LevelFacade
#### Problem in Context
After dividing our code into Model, View and Controller following the Architectural Pattern suggested by the regent of the discipline, one of our problems was that the LevelModel knew too much information about his own data, such as: knewing that if there was one key, it must also have a door; knewing which lists of elements represented PhysicsElements, reorganizing and putting them together when asked about them.
#### The Pattern
To solve this problem we used the Facade Pattern.
#### Implementation
To implement this pattern, we created a new class that takes a LevelModel as an argument in its constructor and has all the methods that you would need to interact with it: find an element, return a group of elements of a specified superclass after regrouping them, remove an element of a specified superclass. We then added it to the Controller package. 
#### Consequences
This class serves as the medium of communication between any other class (except the LevelBuilder, because it's him who builds the LevelModel, so it makes sense to make it interact directly with the Model), be it Controller, View or Model, making the interaction easier and more intelligible. This pattern allowed us to keep the Level Model as a place to only store data, adding to it a beautiful dress to make it a more pleasant experience to interact with.

## Known Code Smells and Refactoring Suggestions

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

### LevelController
This is not as much a code smell but more a violation of the first of the SOLID principles: the LevelController class does to much and although we could argue that it "only" controls the Level, we should refactor it and divide the code into smaller classes with less responsibilities.


## Important Discussions

This is an extra chapter filled with discussions that we think that are relevant, not only to justify certain decisions in our code but also to discuss problems that didn't seem to fit in any other chapter.
 
### Save Data in Model and Efficiency
One  of the first problems that we had was how to save data in the LevelModel. Our basic unit was the Element and so our first solution was to save all the different derived elements in only **one list**.
This had solution had some problems:

 - First we would need to cycle through all the elements every time an update to the Model data was made, even if it was only a player moving we would need to update the position of every object (walls included!!) in every cycle;
 - The second part of the problem was that, in order to take advantage of the hierarchical subclass structure and make it possible for the controller not to know which type of Element it was dealing with, every object would need to know what to do in every interaction (player moving for example), which would culminate in many empty functions dangling around.
 
Then we tried to divide into **different lists** depending of the specific type of object: one for the walls, one for the enemies, one for the level keys... This solution still had the problem that in order to find some object in a certain position (to verify if the player's new position is valid for example), we had to iterate through every element to find the matching position. This problem is all the worse when we have a explosion and have to know the elements in the 8 adjacent cells of the central object. One could argue that this could still be done in one cycle, and you would be correct, but when we add to this a falling object, an enemy and a player moving, it wouldn't be a trivial task to make a generic enough function that would allow us to test all the different cases in one iteration through all elements only.

In the **current solution** we have not only the **different lists** but also a **two-dimensional array** of the map dimensions. The elements are placed according to its Position, in coordinates [x][y]. This allows us to find elements by its position in constant time, solving most of the problems we were having with multiple finds that would require to go through the entire list of elements (for example the case of an explosion, where we had to search for 8 elements in adjacent cells). Since Java stores elements as references, we are effectively accessing the element which is also in the lists. On one hand this is positive, since we can find and update elements in constant time. However, when deleting an element, we must have the extra care of deleting it from both the lists and the grid.

### Multiple Threads vs Two Threads with Count

One other problem that we're still debating is the number of threads that we should use. We began by using one thread for each type of element that needed to be updated - one for the PhysicsElements, other for the Enemies, other waiting for User Input and a final one to draw the Model, allowing them to have different periodicity. 
However, we were concerned about synchronicity problems that could arise because of the resources distribution of the CPU. Since we could not control the slice of time each thread would actually be allowed to run, we were in doubt the multiple threads were worth it.
For this reason, in trying to avoid increasing the number of threads when not strictly required, we came up with a new solution, based on a methodology used last semester in LCOM.
Our program is composed by two threads, one for the user input and another to deal with the elements drawing / physics / interactions. This last one possesses multiple counters to control each different kind of event that, when reached a predefined number, allows that event to occur (be it physics, enemy movement, ...).
This method allows us to do everything in only 2 threads, makes the code more compact and prevents synchronicity problems.

### Builder Pattern vs Read From File

This was other permutation that our code suffered and the reason why the LevelBuilder is called that way. We had first implemented a Builder Pattern in order to Build the different levels, however due to its simplicity in the creation process we adopt a different strategy: loading a level directly from a file. This solution allowed us to create levels and tests-levels much faster than the way we were doing before (it also reduced significantly the number of classes - we would need one for each level).

### Architectural Pattern - The Design Pattern Killer

One other problem that we found was the difficulty to make the design patterns fit the chosen Architectural Pattern in its purest form. We already touched lightly on the dilemma of where to put the LevelFacade, but there are other Design Patterns that became almost invalid.
We could use the Command Pattern to make a Drawable Interface that each Element would implement, allowing each one to know how to draw itself (like the solution for the SOLID exercises) and the LevelView would know how to draw a Level as a whole, but as noted, by our professor, this would destroy partially the MVC architecture, making this pattern unusable in this case (there were other similar cases where this could be implemented but the result was the same: the Model class knowing too much about itself and its behavior).

Other interesting example was the Strategy Pattern. We would like to use different strategies to implement the distinct movements that enemies could make (follow the player, random, in "circles"...). However, this would have to be a function in an element subclass, and we would run the risk of the Model gaining more knowledge over the Controller.
There were other examples, some more flagrant than the ones mentioned but, to keep this brief, we will wrap up this sub-chapter here.

## Testing Results

> This section should contain screenshots of the main results of both the test coverage and mutation testing reports. It should also contain links to those reports in HTML format (you can copy the reports to the docs folder).


We realized soon that making final tests for the classes we were working in was not a smart idea, due to the high volatility of our code and the constant changing of approach and solution for the same problem.
Therefore, the only classes fully tested that it is worth mentioning are the low-level ones, those in the model.utilities package that we consider to be final.
We achieve 100% line and mutation coverage in every one of them, as shown in the following picture.

![First pitest results](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/PITest1.png)*Preliminary test results*

## Self-evaluation

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.
