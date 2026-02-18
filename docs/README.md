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

2. Download the latest `.jar` file from [here](https://github.com/lemonishi/ip/releases).

3. Copy the file to the folder you want to use as the <i>home folder</i> for your YeetMan.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar yeetman.jar` command to run the application.
A GUI similar to the above should appear in a few seconds.

## Features
### Viewing help: `help`
Navigates to the help page within the GUI.<br />
Usage: `help`

### Adding ToDo tasks: `todo`
Adds ToDo tasks.<br />
Usage: `todo <TASK_NAME>`<br />
Examples:
- `todo sleep` returns the following output:
```
Added this task:
    [T][] sleep
You now have 1 tasks, Uce!
```

### Adding Deadline tasks: `deadline`
Add deadline tasks with a date format of d/M/yyyy HHmm.<br />
Usage: `deadline <TASK_NAME> /by <DUE_DATE>`<br />
Examples:
- `deadline homework /by 22/2/2022 2359` returns the following output:
```
Added this task:
    [D][] homework (by: Feb 22 2022 2359)
You now have 2 tasks, Uce!
```

### Adding Event tasks: `event`
Add Event tasks with a date format of d/M/yyyy HHmm for both start and end dates.<br />
Usage: `event <TASK_NAME> /from <START_DATE> /to <END_DATE>`<br />
Examples:
- `event project meeting /from 1/1/2020 1800 /to 1/1/2020 2000` returns the following output:
```
Added this task:
    [E][] project meeting (from: Jan 01 2020 1800 to: Jan 01 2020 2000)
You now have 3 tasks, Uce!
```

### Listing all tasks: `list`
Shows a list of all current tasks in the task list.<br />
Usage: `list`<br />
Example output:
```
Here are the tasks in your list, Uce! :
1. [T][] study
2. [T][] sleep
```

### Locating tasks by name: `find`
Finds tasks with names that contain any of the given keywords.<br />
Usage: `find <KEYWORD>`
- The search is case-sensitive. e.g `sleep` will not match `Sleep`
- The order of the keywords matters. e.g `meet John` will not match `John meet`
- Only the task name is searched.
- Partial wordings will be matched. e.g `study` will match `studying`

Examples:
- `find study` returns `study math` and `study Science`

### Marking a task as done: `mark`
Marks the specified task as done.<br />
Usage: `mark <TASK_INDEX>`
- `list` followed by `mark 1` marks the 1st task in the task list as done.

### Unmarking a task as done: `unmark`
Unmarks the specified task as done.<br />
Usage: `unmark <TASK_INDEX>`<br />
Examples:
- `list` followed by `unmark 2` unmarks the 2nd task in the task list as done.

### Deleting a task: `delete`
Deletes the specified task from the task list.<br />
Usage: `delete <TASK_INDEX>`
Examples:
- `list` followed by `delete 2` deletes the 2nd task in the task list. 

### Exiting the application: `bye`
Exits and terminates the application.<br />
Usage: `bye`