# YeetMan User Guide

![ui](Ui.png)

YeetMan is a lightweight application for managing tasks, optimized for use via a Command Line Interface (CLI)
while still having the benefits of a graphical user interface (GUI).

## Table of contents
- [Setup](#Setup)
- [Features](#Features)

## Setup
1. Ensure you have Java `17` or above installed in your Computer.
Mac users: Ensure you have the precise JDK version prescribed here.

2. Download the latest `.jar` file from here.

3. Copy the file to the folder you want to use as the <i>home folder</i> for your YeetMan.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar yeetman.jar` command to run the application.
A GUI similar to the above should appear in a few seconds. Note how the app contains some sample data.

## Features
### Viewing help: `help`
Navigates to the help page within the GUI.<br />
Usage: `help`

### Adding ToDo tasks: `todo`
Adds ToDo tasks.<br />
Usage: `todo <TASK_NAME>`

### Adding Deadline tasks: `deadline`
Add deadline tasks with a date format of d/M/yyyy HHmm.<br />
Usage: `deadline <TASK_NAME> /by <DUE_DATE>`

### Adding Event tasks: `event`
Add Event tasks with a date format of d/M/yyyy HHmm for both start and end dates.<br />
Usage: `event <TASK_NAME> /from <START_DATE> /to <END_DATE>`

### Listing all tasks: `list`
Shows a list of all current tasks in the task list.<br />
Usage: `list`

### Locating tasks by name: `find`
Finds tasks with names that contain any of the given keywords.<br />
Usage: `find <KEYWORD>`

### Marking a task as done: `mark`
Marks the specified task as done.<br />
Usage: `mark <TASK_INDEX>`

### Unmarking a task as done: `unmark`
Unmarks the specified task as done.<br />
Usage: `unmark <TASK_INDEX>`

### Deleting a task: `delete`
Deletes the specified task from the task list.<br />
Usage: `delete <TASK_INDEX>`

### Exiting the application: `bye`
Exits and terminates the application.<br />
Usage: `bye`