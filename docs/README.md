 # LPOO_710 ASCII RIDER

> Include here one or two paragraphs explaining the main idea of the project, followed by a sentence identifying who the authors are.  

This project is a puzzle game based on 'Crypt Raider', where your objective in each level is to push one or more 'keys' to the 'exit door'. In order to travel through the different chambers, you must escape all the enemies and avoid the explosions you may cause by pushing explosive elements.
 Think fast and try to beat the timer to gain more points in each completed level.

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
5. [Important Discussions](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#importan-discussions)
    1. [Save Data in Model and Efficiency](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#levelfacade)
    2. [Multiple Threads vs Two Threads with Count](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#levelfacade)
    3. [Builder Pattern vs Read From File](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#levelfacade)
    4. [Architectural Pattern - The Design Pattern Killer](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#levelfacade)
6. [Testing Results](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#testing-results)
7. [Self-Evaluation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#self-evaluation)


## Implemented Features

> This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three screenshots that illustrate the most important features.

We already implemented the majority of the different kind of elements and its corresponding behaviors:

 - Physics Elements - all the non static elements (aside from the player and enemy) have gravity and fall down when there's no ground under them;
 - TNT - this element generates an explosion in its neighbor cells when it hits the ground, some other element falls on top of it or fired by a nearby explosion; 
 - Key and Door Key - when there's a door in a certain level, you must first pick up the key in other to go through the door;
 - Walls and Stones - the wall element differs from the stone element in that the first one doesn't get destroyed by an explosion while the second does;
 - Enemy - There is already one enemy with random movement that explodes when some kind of stone falls on top of him. It also causes the player to dye when they collide;
 - Sand  - dug by the player, the piece of sand disappears when you visit its previous place; 
 - Exit Door - This door only opens, allowing the player to finish the level, when all the level keys have already been put in there.

There is a level builder that decodes .lvl files in order to create a new level, allowing us to quickly generate new ones.

![Level Example 1](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/implemented1.png) *Example from level 2*

![Level Example 2](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/implemented2.png) *Example from level 3*


## Planned Features

> This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should include GUI mock-ups for the planned features.

There are many features yet to be implemented:

 - [ ] Main Menu: where the user may choose between begin a new game from scratch (level 1), go directly to a certain level or view the highscores ranking;
 - [ ] Score: in order to implement the highscore ranking, we will have to create a score that will be based on the cumulative time that the player needs to complete the different levels;
 - [ ] Information Bar: we want to add a bar to the top of the screen with different information: 
	 - [ ] Time: a counter with the remaining time that will be used to calculate the score;
	 - [ ] Score: a number representing the current score that the player has already accumulated;
	 - [ ] Level Number: parameter with information concerning the current level ;
	 - [ ] Number of Lifes: we will allow the user two die 2 or restart levels two times (3 lifes) before completely loosing the game;
	 - [ ] Progress Bar: indicates the number of level keys already put in the exit door and how many are missing;
	 - [ ] Restart button: button or indication of the key that you have to press in order to restart a level. When you perform this action, you will loose one life.
- [ ] Enemy movements: 
	- [ ] Improve the way the current enemy moves;
	- [ ] Add another kind of movement, making the enemy follow the player,
- [ ] Loosing Life: adding two ways of loosing life:
	- [ ] Time: when the #TimesUp;
	- [ ] Restart: when the user chooses to restart a level.
- [ ] Improve Explosions: Make the explosion have some kind of animation that lasts some time and doesn't just remove the surrounding elements, allowing deaths by going through the explosion moments after it happens;
- [ ] Swing compatibility: Finally we want to add a swing version of the game.

![Info Bar Prototype](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/info_bar.png)*Info Bar Prototype*


## Design

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts: "Problem in Context", "The Pattern", "Implementation" and "Consequences".

>TODO: Not that sure about what it is to write in the different parts of each chapter. 

### LevelFacade
#### Problem in Context
After dividing our code into Model, View and Controller following the Architectural Pattern suggested by the regent of the discipline, one of our problems was that the LevelModel new to much about his own data: the level knew that if there was one key, it must also have a door or which lists were PhysicsElements  that it should reorganize and put together when asked about them.
#### The Pattern
To solve this problem we used the Facade Pattern.
#### Implementation
To implement this pattern, we created a knew class that takes a LevelModel as an argument to its constructor and has all the methods that you would need to interact with it: find some element, return a group of elements after regrouping them as instructed or removing some kind of this basic entity. We then added it to the Controller package. 
#### Consequences
This class serves as the medium of communicating between any other class (except the LevelBuilder, because it's him who builds the LevelModel, so it makes sense to make it interact directly with the Model) like the Controller or the View and the Model, making the interaction easier and more intelligible. With this class we kept the Model as a place to only store data and added a beautiful dress to make it a more pleasant experience when messing with it.

## Known Code Smells and Refactoring Suggestions

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.


## Important Discussions

This is an extra chapter filled with discussions that we think that are relevant, not only to justify certain decisions in our code but also to discuss problems that didn't seem to fit in any other chapter.
 
### Save Data in Model and Efficiency
One  of the first problems that we had was how to save data in the LevelModel. Our basic unit was the Element and so our first solution was to save all the different derived elements in only **one list**.
This had solution had some problems:

 - First we would need to cycle through all the elements every time an update to the Model data was made, even if it was only a player moving we would need to update the position of every object (walls included!!) in every cycle;
 - The second part of the problem was that, in order to take advantage of the subclass structure every object would need every command that would culminate in lots of empty functions dangling around.
 
Then we tried to divide into **different list** depending of the type of object: one for the walls, one for the enemies, one for the level keys... This solution still had a problem that in order to find some object in a certain position (to verify if the player's new position is valid for example), we had to iterate through every element to find the matching position. This problem is all the worse when we have a explosion and have to know the elements in the 8 adjacent cells of the central object. One could argue that this could still be done in one cycle, and you would be correct but when we add to this a falling object, an enemy and a player movement, it wouldn't be a trivial task to make a generic enough function that would allow us to test all the different cases in one iteration through all elements only.

In this current solution we have not only the **different lists** but also a **grid** with the map dimension and the different elements in the correct places, making the find access time constant.

### Multiple Threads vs Two Threads with Count

One other problem that we're still debating is the number of threads that we should use. We began by using one thread for each type of element that need to be updated - one for the PhysicsElements, other for the Enemies, other waiting for user input and a final one to draw the Model -, allowing them to have different periodicity. 
We think that this may more easily arise synchronicity problems and we were banking/betting on the hope that the CPU would make a good enough distribution of its resources, making the multiple threads worth it.
Our new solution is one similar to the implementation done on LCOM last semester: one thread with user input and the other as multiple counters that when reached a predefined number the Physics/Enemy movement/whatever it is, is handled allowing us to do everything in only 2 threads and making the code more compact.

### Builder Pattern vs Read From File

This was other permutation that our code suffered and the reason why the LevelBuilder is called that way. We had first implemented a Builder Pattern in order to Build the different levels, however due to its simplicity in the creation process we adopt a different strategy: loading a level directly from a file. This solution allowed us to create levels and tests-levels much faster than the way we were doing before (it also reduced significantly the number of classes - we would need one for each level).

### Architectural Pattern - The Design Pattern Killer

One other problem that we found was the difficulty to make the design patterns fit the chosen Architectural Pattern in its purest form. We already touched lightly on the dilemma of where to put the LevelFacade, but there are other Design Patterns that became almost invalid.
We could use the Command Pattern to make an Drawable Interface that each Element would implement allowing each one to know how to draw itself (like the solution for the SOLID exercises) and the LevelView would know how to draw a Level as a whole, but as noted, by our professor, this would destroy partially the MVC distribution, making this pattern useless in this case (there were other similar cases where this could be implemented but the result was the same: the Model class knowing to much about itself and its behavior).
Other interesting example was the Strategy Pattern. We would like to use different strategies to the distinct movements that enemies could make (follow the player, random, in "circles"...), however this would be a function in an element subclass, and we would run the risk of the Model gaining more knowledge over the Controller.
There were other examples, some more flagrant than the ones mentioned but, to keep this brief, we will wrap up this sub-chapter here.

## Testing Results

> This section should contain screenshots of the main results of both the test coverage and mutation testing reports. It should also contain links to those reports in HTML format (you can copy the reports to the docs folder).


We soon realize that making final tests for the classes we working in was not a smart idea due to the high volatility of our code and the constant changing of approach and solution for the same problem.
Therefore, the only classes fully tested that it is worth mentioning are the low-level ones, those in the model.utilities package that we consider to be final.
We achieve 100% line and mutation coverage in every one of them as shown in the following picture.

![First pitest results](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/PITest1.png)*Preliminary test results*

## Self-evaluation

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.
