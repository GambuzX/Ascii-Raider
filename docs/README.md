 # LPOO_710 ASCII RIDER

This project is a puzzle game based on 'Crypt Raider', where your objective in each level is to push one or more 'keys' to the 'exit door'. In order to travel through the different chambers, you must push boulders along the map, escape all the enemies and avoid the explosions that may be triggered by interacting with explosive elements.
 Think fast, think smart, and try to beat the timer to gain more points in each completed level.

 Developed by [Manuel Coutinho](https://github.com/ManelCoutinho "ManelCoutinho") and [Mário Gil](https://github.com/GambuzX "GambuzX").

## Table of contents
1. [Implemented Features](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#implemented-features)
    1. [Elements](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs#elements)
    	1. [Generic Behaviours](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs#generic-behaviours)
    	2. [Specific Elements](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs#specific-elements)
    2. [Level Builder](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs#level-builder)
    3. [Screenshots](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs#screenshots)
2. [Planned Features](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#planned-features)
3. [Design](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#design)
    1. [LevelFacade](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#levelfacade)
    	1. [Problem in Context](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#problem-in-context) 
    	2. [The Pattern](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#the-pattern) 
    	3. [Implementation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#implementation)
    	4. [Consequences](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#consequences)
    2. [MovementStrategy with Factory](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#movementstrategy-with-factory)
    	1. [Problem in Context](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#problem-in-context-1) 
    	2. [The Pattern](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#the-pattern-1) 
    	3. [Implementation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#implementation-1)
    	4. [Consequences](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#consequences-1)
    3. [Observers - I get an observer. You get an observer. Everyone gets an observer](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#user-content-observers---i-get-an-observer-you-get-an-observer-everyone-gets-an-observer)
    	1. [Problem in Context](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#problem-in-context-2) 
    	2. [The Pattern](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#the-pattern-2) 
    	3. [Implementation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#implementation-2)
    	4. [Consequences](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#consequences-2)
    4. [ViewFactory and ViewComposite](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#viewfactory-and-viewcomposite)
    	1. [Problem in Context](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#problem-in-context-3) 
    	2. [The Pattern](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#the-pattern-3) 
    	3. [Implementation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#implementation-3)
    	4. [Consequences](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#consequences-3)
    5. [State (your business T***)](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#user-content-state-your-business-t)
    	1. [Problem in Context](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#problem-in-context-4) 
    	2. [The Pattern](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#the-pattern-4) 
    	3. [Implementation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#implementation-4)
    	4. [Consequences](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#consequences-4)
    6. [ButtonCommand](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#buttoncommand)
    	1. [Problem in Context](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#problem-in-context-5) 
    	2. [The Pattern](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#the-pattern-5) 
    	3. [Implementation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#implementation-5)
    	4. [Consequences](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#consequences-5)
    7. [(Do not) Interact](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#user-content-do-not-interact)
    	1. [Problem in Context](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#problem-in-context-6) 
    	2. [The Pattern](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#the-pattern-6) 
    	3. [Implementation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#implementation-6)
    	4. [Consequences](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#consequences-6)
	
4. [Known Code Smells and Refactoring Suggestions](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#known-code-smells-and-refactoring-suggestions)
    1. [Large Class](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#large-class)
    2. [Switch Statement](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#switch-statement)
    3. [Data Class](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#data-class)
    4. [Refused Bequest](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#refused-bequest)
    5. [Dead Code](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#dead-code)

5. [Additional Topics](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#additional-topics)
    1. [Data Class Smell and MVC](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#data-class-smell-and-mvc)
    2. [Save Data in Model and Efficiency](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/README.md#save-data-in-model-and-efficiency)
    3. [Multiple Threads vs Two Threads with Count](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#multiple-threads-vs-two-threads-with-count)
    4. [Builder Pattern vs Read From File](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#builder-pattern-vs-read-from-file)
    5. [Architectural Pattern - The Design Pattern Killer](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#architectural-pattern---the-design-pattern-killer)
6. [Testing Results](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#testing-results)
7. [Self-Evaluation](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/tree/master/docs#self-evaluation)


## Implemented Features

We already implemented the majority of the different kind of elements and its corresponding behaviors and interactions:

### Elements
#### Generic Behaviours

 - Destructible Elements - all the elements that can be destroyed by an explosion.
 - Physics Elements - all the non static elements (aside from the player and enemy) are affected by gravity and fall down when there's no ground under them. They can also be pushed along the map by the player. These include Boulders, Level Keys and TNT;
 - Movable Elements - elements that can move.
 - Explosive Elements - elements that can explode, destroying elements around it.
 - Animated Elements - elements which possess an animation, changing image through time.
 
#### Specific Elements

 - Wall - the wall is a static element without any behaviour or interaction that can not be destroyed.
 - Stone Block - this is a static element that differs from the walls in that they can be destroyed by explosions.
 - Boulder - element that has physics behaviour, used to fill in holes or kill enemies.
 - SkullEnemy - enemy with random movement that explodes when something falls on top of him. It also causes the player to die when they collide.
 - MummyEnemy - smarter enemy that "follows" the player instead of moving randomly.
 - Sand - static elements that can be dug by the player, disappearing when you visit their position;
 - TNT - this element generates an explosion in its neighbor cells when it hits the ground, some other element falls on top of it or fired by a nearby explosion;
 - Door - static element that must appear together with a Door Key. The player can't go through it until it catches the key, making this element disappear.
 - Door Key - static element that, when picked up, unlocks the Door on the same level.
 - Level Key - elements that must be pushed by the player to the exit door in order to unlock it and allow the level to be finished. Destroying them with explosions makes the level unwinnable.
 - Exit Door - this is the level exit door, meaning you must go through it to go the next level. However, this door only opens when all the level keys have already been put in there.
 - Explosion - animated element that is instanciated whenever an Explosive explodes, destroying Destructible elements caught in its range until the animation finishes.

### Level Builder

We created a LevelBuilder class that decodes .lvl files in order to create a new level, allowing us to quickly generate new ones. These files contain the levels drawn with ASCII symbols, with each type of element having a specific symbol assigned.

### Game States

We added a Game over screen that shows the user score for 5 seconds and then proceeds to exit the game (if the user presses some key he/she is taken back to the main menu) and also the main menu where we can chose between exit the game and play it.

### Timer

We implemented level timers as promised that makes the game harder by setting a time limit to solve a certain level.

### Life System

There is a life system in place that keeps track of how many lifes the player has left and decrements it when the user dies or restarts the game.

### Swing Version

We made a new prettier version of the game using the swing interface from Java. The user can choose between this and the lanterna version using the terminal and passing "lanterna" or "swing" as arguments.

### InfoBar

Lastly we also added a bar on the top of the screen in the play state with relevant information about the status of the game.


### Screenshots

![Lanterna Menu](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/LanternaMenu.png) *Lanterna Menu*

![Lanterna Level Example 1](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/LanternaLevel6.png) *Example from level 6 in Lanterna*

![Lanterna Level Example 2](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/LanternaLevel12.png) *Example from level 12 in Lanterna*

![Lanterna Game Over](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/LanternaGameOver.png) *Lanterna Game Over*

![Swing Menu](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/SwingMenu.png) *Swing Menu*

![Swing Level Example 1](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/SwingLevel6.png) *Example from level 6 in Swing*

![Swing Level Example 2](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/SwingLevel12.png) *Example from level 12 in Swing*

![Swing Game Over](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/SwingGameOver.png) *Swing Game Over*


## Planned Features

There are many features yet to be implemented:

 - [x] Main Menu: where the user may choose between begin a new game from scratch (level 1), go directly to a certain level or view the highscores ranking;
 - [x] Score: in order to implement the highscore ranking, we will have to create a score that will be based on the cumulative time that the player needs to complete the different levels;
 - [x] Information Bar: we want to add a bar to the top of the screen with different information: 
	 - [x] Time: a counter with the remaining time to finish the current level, which will be used to calculate the score;
	 - [x] Score: a number representing the current score that the player has already accumulated;
	 - [x] Level Number: parameter with information concerning the current level;
	 - [x] Number of Lifes: we will allow the player to die or restart levels two times (3 lifes) before completely loosing the game;
	 - [x] Progress Bar: indicates the number of level keys already put in the exit door and how many are missing;
	 - [x] Restart button: button or indication of the key that you have to press in order to restart a level. When you perform this action, you will loose one life.
- [ ] New Enemies: 
	- [ ] Improve the way the current enemy moves;
	- [x] Add another kind of enemy, which follows the player;
- [x] Improved Lives system: add two other ways of loosing a life:
	- [x] Time: when the time counter reaches 0;
	- [x] Restart: when the user chooses to restart a level.
- [x] Improved Explosions: Make the explosion have some kind of animation that lasts some time and doesn't just remove the surrounding elements, allowing elements to be destroyed by going through the explosion moments after it happens;
- [x] Swing compatibility: add a swing version of the game.
- [ ] Level Selector: Sub Menu that allows you to choose a level
- [ ] Highscores Ranking: Ranking with the highest Scores

![Info Bar Prototype](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/info_bar.png)*Info Bar Prototype*


## Design

### LevelFacade
#### Problem in Context
After dividing our code into Model, View and Controller following the Architectural Pattern suggested by the regent of the discipline, one of our problems was that the LevelModel knew too much information about his own data, such as: knewing that if there was one key, it must also have a door; knewing which lists of elements represented PhysicsElements, reorganizing and putting them together when asked about them.
#### The Pattern
To solve this problem we used the Facade Pattern.
#### Implementation
To implement this pattern, we created a new class that takes a LevelModel as an argument in its constructor and has all the methods that you would need to interact with it: find an element, return a group of elements of a specified superclass after regrouping them, remove an element of a specified superclass. We then added it to the Controller package.

The following diagram illustrates how this pattern was implemented: 
![Level Facade](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/LevelFacade.png) *Level Facade*
These classes can be found in the following files:

- [LevelFacade](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/level/LevelFacade.java)
- [LevelModel](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/level/LevelModel.java)

#### Consequences
This class serves as the medium of communication between any other class (except the LevelBuilder, because it's him who builds the LevelModel, so it makes sense to make it interact directly with the Model), be it Controller, View or Model, making the interaction easier and more intelligible. This pattern allowed us to keep the Level Model as a place to only store data, adding to it a beautiful dress to make it a more pleasant experience to interact with.

### MovementStrategy with Factory
#### Problem in Context
Hard coding the movement  in the Enemy class had two problems: the first one was that the model (the enemy element) would have to know too much about the logic of the game which is a controller property not a model one; the second one was that it would make the modulation difficult, that is, creating a new enemy that only differed from the first one in one parameter (the movement logic) would became a problem more complex than it needed to be.
#### The Pattern
To solve this problem we used the Strategy Pattern. This pattern allows us to isolate the algorithms into one class away from the object, making them interchangeable. This was exactly what we pretended: separating the movement algorithm from the enemy object so we can easily switch their behaviors. We had to implement also a factory method so that each object could create the correct MovementStrategy.

#### Implementation

The following diagram illustrates how this pattern was implemented: 
![Movement Strategy](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/MovementStrategy.png) *Movement Strategy*


These classes can be found in the following files:

-   [MovementStrategy](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/movestrategy/MovementStrategy.java)
-   [FollowMovementStrategy](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/movestrategy/FollowMovementStrategy.java)
-   [RandomMovementStrategy](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/movestrategy/RandomMovementStrategy.java)
-   [Enemy](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/element/Enemy.java)
-   [SkullEnemy](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/element/SkullEnemy.java)
-   [MummyEnemy](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/element/MummyEnemy.java)

#### Consequences
This pattern allowed to keep the model as dumb as possible and we don’t need to have a set of conditional if or switch statements in the controller associated with the different movements; instead, polimorphism is used to activate the right movement. The factory allows the sub classes to instantiate the correct movement without the upper class knowing anything about which enemy has which type of movement.


### Observers - I get an observer. You get an observer. Everyone gets an observer
#### Problem in Context
We had a problem almost since the first day in the controller class. It was becoming to much a god class and it was its job to moderate and keep all the logic of the game. Making all the classes to dependent on him. We could simple make the controller inform the different classes that it could possible had reach the end/the player had died or there was some key progress, making all of them responsible for the verification, however this solution is not good because it could lead to unsynchronized data floating around the program. There was too much class dependency and the code was hard to maintain.
#### The Pattern
Starting with a simple interface that we use to all our observers-controllers we implemented not one, not two, but three Observer pattern that not only allows us to keep all the observers of each event tightly together, but also notify them when that same event happens.
#### Implementation
##### LevelCompletedObserver
The following diagram represents our implementation of this pattern applied to the event representing when a level reaches his end:![LevelCompletedObserverUML](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/LevelCompletedObserver.png)*Level Completed Observer UML*


The above classes are in the following files:
-   [EventSubject](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/observer/EventSubject.java)
-   [LevelProgressionController](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/level/LevelProgressionController.java)
-   [LevelController](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/level/LevelController.java)
-   [LevelCompletedObserver](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/observer/LevelCompletedObserver.java)
-   [InfoBarModel](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/infobar/InfoBarModel.java)
-   [LevelTimeAlarm](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/level/LevelTimeAlarm.java)

##### LevelKeyObserver
The following diagram represents our implementation of this pattern applied to the event that represents some level key reaching the final door:![LevelkeyObserverUML](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/LevelKeyObserver.png)*Level Key Observer UML*

The above classes are in the following files:
-   [EventSubject](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/observer/EventSubject.java)
-   [LevelKeyController](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/LevelKeyController.java)
-   [LevelController](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/level/LevelController.java)
-   [LevelKeyObserver](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/observer/LevelKeyObserver.java)
-   [InfoBarModel](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/infobar/InfoBarModel.java)
-   [LevelManager](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/level/LevelManager.java)

##### PlayerDeathObserver
The following diagram represents our implementation of this pattern applied to the event that represents the death of the player:![PlayerDeathObserverUML](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/PlayerDeathObserver.png)*Player Death Observer UML*

The above classes are in the following files:
-   [EventSubject](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/observer/EventSubject.java)
-   [LifeController](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/life/LifeController.java)
-   [LevelController](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/level/LevelController.java)
-   [PlayerDeathObserver](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/observer/PlayerDeathObserver.java)
-   [InfoBarModel](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/infobar/InfoBarModel.java)
-   [LevelTimeAlarm](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/level/LevelTimeAlarm.java)
-   [LifeManager](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/life/LifeManager.java)
-   [LevelManager](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/level/LevelManager.java)

#### Consequences
The main consequence of this solution is that it uncouples the classes previously strongly dependent which is precisely what we needed. It also facilitates the addition of a new element that has to know when a certain event happens. Our implementation had a few problems, namely the limitation of parameters to be passed to the observers. But this little setback was not relevant when in comparison with the dependencies between classes that we solve, not only with the controller but also between themselves.

### ViewFactory and ViewComposite
#### Problem in Context
Having decided we would make our game compatible with both Lanterna and Swing, we found ourselves in a situation where we had to create a similar set of Views for each platform. Both Lanterna and Swing options would require a MenuView, a LevelView and a GameOverView, with identical behaviours.

In addition, for Lanterna we noticed that it would make sense to divide the highest level Views in smaller more specific classes, such as ElementView and ButtonView, while keeping the same behaviour through all of them.

#### The Pattern
To solve the first problem we implemented an Abstract Factory pattern which, depending on the target platform, creates Views specific for it.

The second problem was solved with a Composite Pattern, creating Views which are composed of other Views.

#### Implementation
To implement the Abstract Factory we created an interface, ViewFactory, that specifies what each concrete factory must be able to create. Then, 2 concrete factories that implement this interface were created, LanternaFactory and SwingFactory. When the application starts, based on the target platform specified, the correct concrete factory is instanciated and used throughout the rest of the program, not having to worry with the specific type in use.

The composite pattern was achieved by creating an abstract class *View*, with an abstract method *draw*. We then composed our Lanterna classes in a tree structure where both high level views, such as *LanternaLevelGroupView*, and more specific views, such as *LanternaElementView*, extend *View* and specify how to draw themselves. These higher level views are then composed of other Views and, when asked to draw themselves, call *draw* in each of their parts.

The following diagram represents how the mentioned patterns were implemented:![ViewFactoryAndComposite](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/ViewFactory.png)*View Factory and Composite UML*

The above classes are in the following files:
-   [ViewFactory](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/ViewFactory.java)
-   [LanternaFactory](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/LanternaFactory.java)
-   [SwingFactory](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/swing/SwingFactory.java)
-   [View](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/View.java)
-   [ViewState](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/ViewState.java)
-   [LanternaStateView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/LanternaStateView.java)
-   [LanternaLevelGroupView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/game/LanternaLevelGroupView.java)
-   [LanternaGameOverView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/gameover/LanternaGameOverView.java)
-   [LanternaMenuView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/menu/LanternaMenuView.java)
-   [LanternaLevelComponent](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/game/LanternaLevelComponent.java)
-   [LanternaInfoBarComponent](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/game/LanternaInfoBarComponent.java)
-   [LanternaElementView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/game/LanternaElementView.java)
-   [LanternaButtonView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/lanterna/utilities/LanternaButtonView.java)
-   [SwingStateView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/swing/SwingStateView.java)
-   [SwingLevelGroupView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/swing/game/SwingLevelGroupView.java)
-   [SwingGameOverView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/swing/gameover/SwingGameOverView.java)
-   [SwingMenuView](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/view/swing/menu/SwingMenuView.java)


#### Consequences
By using the Abstract Factory, each target platform has its own isolated concrete class, which can be implemented differently. As an example is the Composite pattern we used only in our Lanterna views. In Swing we had a completely different approach, using JPanels. In addition, it makes exchanging view target very easy, only needing to call a diferent constructor at the start of the program, since they implement the same interface.

The composite pattern allowed us to compose simple Views in more complex ones, effectively creating new View objects that use them in different ways. Besides this, the program itself does not need to worry whether it is a simple or a composed view, only having to call *draw* at all times.


### State (your business T***)

#### Problem in Context

It was advised to use this pattern MVC-style to create the various states of the game (Menu, Playing, GameOver...) so we didn't reach the point of having a problem. What we needed was an elegant way of switching between the different stages that would allow us enough flexibility to add or remove a new stage as the development of the game progressed.

#### The Pattern

To implement the different states of a game we used the State Pattern. 
> This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass).
> - André Restivo
######
We could not have put it better.
#### Implementation

The following diagram illustrates how this pattern was implemented:

![Game State UML](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/GameState.png)*Game Sate UML*

These classes can be found in the following files:

-   [Game](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/Game.java)
-   [State](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/state/State.java)
-   [MenuState](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/state/MenuState.java)
-   [PlayState](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/state/PlayState.java)
-   [GameOverState](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/state/GameOverState.java)

#### Consequences
This pattern not only respects the Open - Closed Principle but also allows to easily add more stages to a game or quickly change the implementation of one state. Because each state is in the MVC Architectural Pattern, the flexibility is even higher allowing us to change the View of the GameOverState very easily if we weren't happy with it.

### ButtonCommand
#### Problem in Context
When implementing the Menu, we found ourselves in a situation where the MenuController had to interact with the buttons in the Model and somehow change the Game state. However, neither the Models nor the View Controllers should know how to handle Game states.

#### The Pattern
To solve this problem we implemented the Command pattern, encapsulating the Game state changes in the Buttons themselves.


#### Implementation
This pattern was conceived by creating an abstract class *ButtonCommand* that receives a *Game* instance and operates on it. This class has a method *execute* that is implemented by each concrete ButtonCommand and is called to perform the defined operation. We defined 3 commands, Start, Restart and Exit. These are called by the View Controllers to change the Game State accordingly, without having to know how they are implemented and what they do.

The following diagram represents how the mentioned pattern was implemented:![ButtonCommand](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/ButtonsCommand.png)*View Factory and Composite UML*

The above classes are in the following files:
-   [ButtonCommand](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/command/ButtonCommand.java)
-   [StartCommand](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/command/StartCommand.java)
-   [RestartCommand](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/command/RestartCommand.java)
-   [ExitCommand](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/command/ExitCommand.java)
-   [Game](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/Game.java)
-   [MenuController](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/menu/MenuController.java)
-   [MenuModel](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/menu/MenuModel.java)
-   [Button](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/utilities/Button.java)

#### Consequences
With the Command pattern we effectively decouple the View Controllers, which invoke the operations, from the objects that know how to perform them. We can easily add new Button Commands to our views, with the defined behaviour encapsulated inside them, without having to change anything in the View Controllers.


### (Do not) Interact

#### Problem in Context

The problem that we had was that each time a player would make a move there were lots of if statements to assert whether the player had collided with another element and if so, which type of element it was so it could call another function in the LevelController class (same problem again - LevelController becoming a God Class).

#### The Pattern

To solve this problem we used the Command Pattern. This pattern normally encapsulates one behavior into a stand alone object allowing to parametrize clients (the other elements in our case) with different interactions.  

#### Implementation

The following diagram illustrates how this pattern was implemented: 
![Interactions UML](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/InteractionCommand.png) *Interaction Command UML*
These classes can be found in the following files:

-   [Interaction](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/interaction/Interaction.java)
-   [SandInteraction](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/interaction/SandInteraction.java)
-   [PushInteraction](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/interaction/PushInteraction.java)
-   [BarrierInteraction](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/interaction/BarrierInteraction.java)
-   [DeathInteraction](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/interaction/DeathInteraction.java)
-   [DoorKeyInteraction](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/element/interaction/DoorKeyInteraction.java)
-   [Element](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/model/element/Element.java)
-   [LevelController](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/project/src/main/java/com/asciiraider/g710/controller/level/LevelController.java)

#### Consequences
With this pattern we kept all the elements as dumb as possible, by making them not know how these interactions are processed and we clean up our could by making full use of polymorphism capacities. This also lead to more classes but the SOLID principles were respected.


## Known Code Smells and Refactoring Suggestions

### Large Class
This is a code smell present in our LevelController that also results in a violation of the first of the SOLID principles: the LevelController class does too much and although we could argue that it "only" controls the Level, we should refactor it and divide the code into smaller classes with less responsibilities.


### Switch Statement
Our removeDestructibleElement method in LevelFacade has a complex sequence of if statements with similar behaviours. This happens because almost every element is a Destructible Element and we need to check all the lists inside the levelModel in order to find and delete it. The sequence of if statements to determine a specific element type is, in the way we are devising our project, unavoidable, because we are storing each element type in its own list. 

To solve this problem we would have to restructure our Elements in a different way, but for reasons discussed below in the 'Additional Topics' section, we opted for this architecture. 

A possible improvement would be to create a method to, given an element, get its corresponding list from the model. This would allow us to unify the similar behaviour in the removeDestructibleElement, but the complex if statements would remain in the new method.

### Data Class
By following the MVC structure, our classes that represent the Models end up being Data Classes, which are a code smell. Since this topic is deeply related to the MVC architecture, we decided to include it in the 'Additional Topics' section, and so it is further developed there.

However, apart from the MVC Model, we decided to create a data class *GlobalConfigs* to store all relevant information for the application in general, such as the name of the game or the size of each level. This was made due to the fact that we had many similar values spread throughout the program and were, at times, chaining values too deeply through classes so that one of them could get the information it needed. By using this data class we ensure that all information is consistent throughout the game and, in the case of needing to change any value, we only have to do it once at this specific place.

### Refused Bequest

This is recurrent problem is present when some class only uses some of the properties, methods or capabilities inherited from his father. One simple example is some observers (LevelCompletedObserver, i.e.) don't make use of the arguments in the functions that called them. To solve this we would have to divide them into other class. This "solution" is not great at all because it would obligate to build a new observer system to only one Class, leaving the other with also an unitary observer. The amount of classes that would appear just to solve this small problem is not worth it. 
There is another place where one could argue that this problem is present: the movable object has methods to move in the various directions but only the Player uses all of them (the other objects only use some). Our choice of living it like it is was due to more flexibility when someone wants to implement a new feature and because it didn't make much sense the Movable class only having moveDown (for example) because all the elements until know only move downwards. There is nothing that prevents the developer of adding a new element that moves left with the current solution.

### Dead Code
We have some methods that are not currently in use (removeObservers and some levellFacade functions). Our theory is: we have to thing in the long plan. Although the final delivery is the 2nd of June, the project doesn't have to end here and there is always room for improvement. This functions are fully tested so they are ready to be used. Furthermore, this classes are interfaces with some kind of object (LevelFacade with LevelModel and ObserverControllers with the list of observers), so the presence of this functions is fully justified (just because we aren't using it know it doesn't mean that we won't need to use it in the future unlike methods for the logic of the game that once are of no use, hardly regain its value).

## Additional Topics

This is an extra chapter filled with topics that we considered relevant, not only to justify certain decisions in our code but also to discuss problems that didn't seem to fit in any other chapter.

### Data Class Smell and MVC

This discussion could easily fit in the code smell section but, because we are in doubt whether it really is a smell or a consequence of the architectural pattern, we decided to put it here.
By strictly following the MVC structure and listening to the advices from our professor, the Model, in our case the LevelModel class, should be kept as dumb as possible, making the Controller the responsible for knowing how the data is transformed and modeled.
This causes a code smell known as Data Class, where a class is simply a place where you put data in with the correct getters and setters.
The almost antagonistic paradoxical pressure between the two ideas left us a bit lost and confuse.
 
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

This was other permutation that our code suffered and the reason why the LevelBuilder is called that way. We had first implemented a #Builder #Pattern in order to build the different levels, with a parent class with methods to create every kind of element. Each level would have a class extending the LevelBuilder, that would know how to build it.

However, due to the simplicity of the creation process of another solution we considered, we adopted a different strategy: loading a level directly from a file. This solution allowed us to create levels and tests-levels much faster than the way we were doing before (it also reduced significantly the number of classes - we would need one for each level).

### Architectural Pattern - The Design Pattern Killer

One other problem that we found was the difficulty to make the design patterns fit the chosen Architectural Pattern in its purest form. We already touched lightly on the dilemma of where to put the LevelFacade, but there are other Design Patterns that became almost invalid.

We could use the Command Pattern to make a Drawable Interface that each Element would implement, allowing each one to know how to draw itself (like the solution for the SOLID exercises) and the LevelView would know how to draw a Level as a whole, but as noted, by our professor, this would destroy partially the MVC architecture, making this pattern unusable in this case (there were other similar cases where this could be implemented but the result was the same: the Model class knowing too much about itself and its behavior).

Other interesting example was the Strategy Pattern. We used different strategies to implement the distinct movements that enemies can make (follow the player, random, in "circles"...). However, at first thought this would have to be a function in an element subclass, and we would run the risk of the Model gaining more knowledge over the Controller.

There were other examples, some more flagrant than the ones mentioned but, to keep this brief, we will wrap up this sub-chapter here.

## Testing Results

We made an effort to fully cover our code with Unit Tests. Besides the *Application* class, which is ruining our results, we were able to achieve a high test and mutation coverage. The results can be seen below:

![Pitest results](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/TestResults.PNG)*Final test results*

 [Link to test reports](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/tests)

## Self-evaluation

The work was divided properly between both of us, meaning that each one did 50% of the work with 100% of the effort!!
