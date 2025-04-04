# User Authentication System

This Java Swing-based application provides a user authentication system, allowing users to register and log in. It uses a simple GUI with two panels: one for registration and the other for login. The system checks the complexity of the username and password during registration to ensure security.

## Features:
1. **Registration:**
   - Users can create an account by entering their **Username**, **Password**, **First Name**, and **Last Name**.
   - The system checks the username and password validity during registration.
     - **Username:** Should be a maximum of 5 characters long and must contain an underscore (`_`).
     - **Password:** Should be at least 8 characters long, contain an uppercase letter, a digit, and a special character.
   - Upon successful registration, the system stores the user credentials.

2. **Login:**
   - Users can log in by providing their **Username** and **Password**.
   - If the entered credentials match the registered details, a success message is displayed, welcoming the user by their first and last name.

3. **UI Design:**
   - Clean and simple interface with a **Registration Panel** and a **Login Panel**.
   - The application automatically switches between the registration and login panels based on user actions (e.g., "Already have an account? Login" or "Create an account").
   
4. **Error Handling:**
   - Provides feedback on invalid username or password during registration and login attempts.
   - If the credentials are incorrect, an error message is shown.

## Requirements:
- **Java 8 or higher** for running the program.
- **Swing library** for creating the graphical user interface.

## Installation:
1. Download or clone the repository.
2. Compile the Java file using the following command:
   ```bash
   javac Solution.java
   ```
3. Run the application using:
   ```bash
   java Solution
   ```

## Code Structure:
- **Solution.java**: Main application class that handles both user registration and login functionality, as well as the GUI design and event handling.
- **UI Components:**
   - **JPanel:** For arranging UI components like text fields, labels, and buttons.
   - **JTextField & JPasswordField:** For accepting username, first name, last name, and password inputs.
   - **JButton:** For actions like registration and login.
   - **JLabel:** For showing status and messages.

## Example Screenshots:
*Registration Panel:*
- A text field for **Username**, **Password**, **First Name**, and **Last Name**.
- A button to submit the registration and a link to switch to the login screen.

*Login Panel:*
- A text field for **Username** and **Password**.
- A button to log in and a link to switch to the registration screen.

## How It Works:
1. **Registration Flow:**
   - The user enters a username, password, first name, and last name.
   - The application checks the validity of the username and password.
   - Upon successful registration, the user receives a success message.

2. **Login Flow:**
   - The user enters the registered username and password.
   - If the credentials are correct, a welcome message is displayed.

## Usage:

1. **Registering a New Account:**
   - Click on "Register" after entering the required details in the registration panel.
   - You will be informed whether your username or password is valid.
   
2. **Logging In:**
   - If you already have an account, you can log in by entering your username and password.
   - Upon successful login, a welcome message will be shown.

3. **Switching Between Panels:**
   - You can switch between the **Login** and **Registration** panels using the buttons provided.

## Notes:
- **Username Validation**: The username must be no longer than 5 characters and include an underscore (`_`).
- **Password Complexity**: The password must be at least 8 characters long and include at least one uppercase letter, one number, and one special character.
  
---

### Example:

#### Registration:

- **Username**: `john_`
- **Password**: `Secure123!`
- **First Name**: `John`
- **Last Name**: `Doe`

#### Login:

- **Username**: `john_`
- **Password**: `Secure123!`

### Sample Output:
- **On Successful Registration:** "✅ Registration Successful!"
- **On Successful Login:** "Welcome John Doe!"
- **On Failed Login:** "Incorrect Username or Password"

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---
