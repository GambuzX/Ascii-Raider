 # LPOO_710 ASCII RIDER

> Include here one or two paragraphs explaining the main idea of the project, followed by a sentence identifying who the authors are.  

This project is a puzzle game based on 'Crypt Raider', where your objective in each level is to push one or more 'keys' to the 'exit door'. In order to travel through the different chambers, you must escape all the enemies and avoid the explosions you may cause by pushing explosive elements.
 Think fast and try to beat the timer to gain more points in each completed level.

 Developed by [Manuel Coutinho](https://github.com/ManelCoutinho "ManelCoutinho") and [Mário Gil](https://github.com/GambuzX "GambuzX").

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

![Level Example 1](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/implemented1.png)

![Level Example 2](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_710/blob/master/docs/Images/implemented2.png)


## Planned Features

> This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should include GUI mock-ups for the planned features.

There are many features yet to be implemented:

 - Main Menu: where the user may choose between begin a new game from scratch (level 1), go directly to a certain level or view the highscores ranking;
 - Score: in order to implement the highscore ranking, we will have to create a score that will be based on the cumulative time that the player needs to complete the different levels;
 - Information Bar: we want to add a bar to the top of the screen with different information: 
	 -	Time: a counter with the remaining time that will be used to calculate the score;
	 -	Score: a number representing the current score that the player has already accumulated;
	 -	Level Number: parameter with information concerning the current level ;
	 -	Number of Lifes: we will allow the user two die 2 or restart levels two times (3 lifes) before completely loosing the game;
	 -	Progress Bar: indicates the number of level keys already put in the exit door and how many are missing;
	 -	Restart button: button or indication of the key that you have to press in order to restart a level. When you perform this action, you will loose one life.
- Enemy movements: 
	- Improve the way the current enemy moves;
	- Add another kind of movement, making the enemy follow the player,
- Loosing Life: adding two ways of loosing life:
	- Time: when the #TimesUp;
	- Restart: when the user chooses to restart a level.
- Improve Explosions: Make the explosion have some kind of animation that lasts some time and doesn't just remove the surrounding elements, allowing deaths by going through the explosion moments after it happens;
- Swing compatibility: Finally we want to add a swing version of the game.

## Design

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts: "Problem in Context", "The Pattern", "Implementation" and "Consequences".

### Facade
To keep the Model class as dumb as possible (namely the LevelModel) we added kind of a Facade class to organize the data as we want: objects in different lists may have similar traits but this Model should not have to know how to regroup them and their properties, it should only be a place to store the data about the Level. 

## Known Code Smells and Refactoring Suggestions

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

## Testing Results

> This section should contain screenshots of the main results of both the test coverage and mutation testing reports. It should also contain links to those reports in HTML format (you can copy the reports to the docs folder).

## Self-evaluation

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.
