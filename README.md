# Task Scheduler

It creates a schedule for each task under a project plan. Each task has a name and a duration.

A sample interaction in the console:

How many projects do you intend to create?<br/>
2<br/>
What is the name of the project1?
Randy
How many tasks are there for this project?
2
Enter task name:
Task1
Enter task duration (in days):
3
How many dependencies for this task?
2
Enter name of dependency task1:
Dependency1
Duration (in days):
5
Enter name of dependency task2:
Dependency2
Duration (in days):
3
Enter task name:
Task2
Enter task duration (in days):
10
How many dependencies for this task?
3
Enter name of dependency task1:
Dependency3
Duration (in days):
4
Enter name of dependency task2:
Dependency4
Duration (in days):
2
Enter name of dependency task3:
Dependency5
Duration (in days):
2
Enter project start date (YYYY-MM-DD):
2024-11-12
Project start date:2024-11-12
Schedule for Project:Randy
Task Dependency1: Start Date = 2024-11-12, End Date = 2024-11-17, Duration 5
Task Dependency2: Start Date = 2024-11-18, End Date = 2024-11-21, Duration 3
Task Task1: Start Date = 2024-11-22, End Date = 2024-11-25, Duration 3
Task Dependency3: Start Date = 2024-11-26, End Date = 2024-11-30, Duration 4
Task Dependency4: Start Date = 2024-12-01, End Date = 2024-12-03, Duration 2
Task Dependency5: Start Date = 2024-12-04, End Date = 2024-12-06, Duration 2
Task Task2: Start Date = 2024-12-07, End Date = 2024-12-17, Duration 10
What is the name of the project2?
Vargas
How many tasks are there for this project?
1
Enter task name:
Task1
Enter task duration (in days):
4
How many dependencies for this task?
1
Enter name of dependency task1:
Dependency1
Duration (in days):
5
Enter project start date (YYYY-MM-DD):
2024-11-13
Project start date:2024-11-13
Schedule for Project:Vargas
Task Dependency1: Start Date = 2024-11-13, End Date = 2024-11-18, Duration 5
Task Task1: Start Date = 2024-11-19, End Date = 2024-11-23, Duration 4
