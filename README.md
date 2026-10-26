# IT Help Desk Ticketing System

## Overview

A console-based Java application that manages IT support tickets using manually implemented sorting algorithms and a FIFO queue. Built procedurally (static methods, no custom classes). The queue controls processing order; sorting organizes the records without changing that order.

## Core Features

- Create tickets (name, issue, date) and add them to the support queue
- Display all tickets and the pending queue
- Process next ticket (dequeue) and peek at the next ticket
- Bubble Sort and Insertion Sort, showing records before and after
- Search for a ticket by number or requester name
- Input validation and clear messages for empty lists, empty queue, and missing tickets
- Proper program exit

## Technical Requirements Met

- Java console app with a menu-driven interface
- Two manual sorting algorithms (Bubble Sort, Insertion Sort), no built-in sort methods
- `Queue<Integer>` with `LinkedList`: enqueue, dequeue, peek, display, isEmpty
- FIFO behavior integrated into the main workflow
- Parallel ArrayLists with synchronized indexes
- No OOP: only `main` and static methods
- Search, input validation, and error messages

## System Screenshots

**Main Menu**
![Main menu](screenshots/main-menu.png)

**Adding and Displaying Records**
![Add and display records](screenshots/add-display-records.png)

**Queue Operations and FIFO Behavior**
![Queue operations](screenshots/queue-operations.png)

**Bubble Sort (Before and After)**
![Bubble Sort](screenshots/sorting-algorithm-1.png)

**Insertion Sort (Before and After)**
![Insertion Sort](screenshots/sorting-algorithm-2.png)

**Input Validation**
![Input validation](screenshots/input-validation.png)