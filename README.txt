CS4341 Assignment 1
Professor Joseph Beck
Lena Dias, Adam Yang, Roopsa Ghosh
1/31/2022


This project is to be run from astar.class via the command line or an IDE like IntelliJ. 
The instructions for either are included below:

-VIA COMMAND LINE-
Navigate to assignment_1\src
Open a command line (on Windows, this is shift+right click > "Open PowerShell window here")
Run astar.class using the following format:
java com.company.astar "[fileName.txt]" [heuristic number 0(no heuristic)-6]

Example input: java com.company.astar "assignment 1, sample board - 0.txt" 1


-VIA INTELLIJ-
Open the unzipped file as a new project in IntelliJ
Navigate to Run > "Edit Configurations..."
Press the + button at the top left
Select "Application"
Enter the following information:

Name: astartest
Version: java 17 version 17.0.1	
Main class: com.company.astar
Program arguments: "[fileName.txt]" [heuristic number 0(no heuristic)-6]

"assignment 1, sample board - 4.txt" 5