# Assignment Title: "Buggy Software Simulator"
## Background:
In real-world applications, handling exceptions properly is crucial to maintaining the functionality and reliability of software systems. This assignment simulates a small business software system that includes user login, data retrieval, and data storage functionalities, with intentional bugs leading to exceptions.

## Objective:
Students will enhance a Java program by introducing and handling various common and checked exceptions. This exercise aims to give students practical experience in managing both runtime errors and exceptions related to file operations.

## System Description:
The simulator models a basic system with the following functionalities:

1. User Login: Accepts a username and password, validating them against stored credentials.
2. Data Retrieval: Fetches user details from a file based on a user ID.
3. Data Storage: Saves or updates user data to a file.
## Instructions:
1. Initial Setup:

- Create a Java class UserManager that includes methods for login, fetchUserData, and updateUserData.
- You may use an array to keep the user information, one line per user, after you read it from a file. You may save this array to a file, whenever some information is changed.
2. Introduce Intentional Bugs:

- NullPointerException: Attempt to access methods on a null object reference within login and fetchUserData.
- ArrayIndexOutOfBoundsException: Use an array to manage user sessions and attempt to access an out-of-range index.
- NumberFormatException: In fetchUserData, parse a string to number, where the string might not be properly formatted.
- IOException: In fetchUserData and updateUserData, handle file operations without proper exception handling initially.
3. Implement Exception Handling:

- NullPointerException and ArrayIndexOutOfBoundsException: Use try-catch blocks to catch these exceptions and provide a default behavior or error message that does not crash the program.
- NumberFormatException: Catch this exception during ID parsing and ask the user to re-enter a valid ID.
- IOException: As a checked exception, ensure all file operations (read, write) are handled with try-catch-finally blocks. In finally, check if file streams are not null and close them to avoid resource leaks.
4. Error Logging:

- Implement a simple logging to a separate file (error.log) for exceptions, detailing the error and the time it occurred.
5. Reporting:

- Report, using JavaDocs or comments, on how each type of exception was handled, the choice of strategy for handling these, and the implications on program stability and user experience.
## Deliverables:
Source code for the initial buggy version and the final handled version.
