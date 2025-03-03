# Java Threads Lab

## Objective
Learn how to create and run multiple threads in Java using different approaches: 
1. Implementing the `Runnable` interface
2. Extending the `Thread` class
3. Using an inline lambda expression

## Instructions

### Task 1: Implement a Thread using `Runnable`
- Create a class that implements the `Runnable` interface.
- Inside the `run()` method, print numbers from 1 to 5 with a small delay.
- Start the thread using a `Thread` object.

### Task 2: Implement a Thread by Extending `Thread` Class
- Create a class that extends `Thread`.
- Override the `run()` method to print letters from 'A' to 'E' with a small delay.
- Start the thread using the `start()` method.

### Task 3: Create a Thread using Lambda Expression
- Use a lambda expression to define a thread that prints the names of five different fruits.
- Start the thread immediately after defining it.

### Task 4 (Bonus Challenge): Run All Threads Concurrently
- Modify your program so that all three threads run at the same time.
- Observe how their outputs interleave.

## Expected Output
The output should show numbers, letters, and fruit names printed in an interleaved fashion, demonstrating concurrent execution.

## Submission
- Submit your `.java` file(s) containing the implemented threads.
- Add comments explaining your approach.
- Answer this question in a comment: _"Why do we use threads in Java?"_

Happy coding! 🚀
