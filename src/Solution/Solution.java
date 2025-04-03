package Solution;

import javax.swing.*;
import java.awt.*;

/**
 * User Authentication System
 */
public class Solution extends JFrame
{
    private JTextField usernameField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField loginUsernameField;
    private JPasswordField passwordField;
    private JPasswordField loginPasswordField;
    private JLabel statusLabel;
    private JPanel registerPanel, loginPanel;

    private String registeredUsername;
    private String registeredPassword;
    private String registeredFirstName;
    private String registeredLastName;

    /**
     * Constructor - Builds the UI
     */
    public Solution()
    {
        setupMainFrame();
        setupRegistrationPanel();
        setupLoginPanel();
        setupEventListeners();
        switchToPanel(registerPanel);
    }

    private void setupMainFrame()
    {
        setTitle("Authentication System");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(240, 240, 240));
    }

    private void setupRegistrationPanel()
    {
        registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(new Color(250, 250, 250));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel title = new JLabel("Create Account", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(new Color(0, 122, 255));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        registerPanel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        addLabelAndField(registerPanel, "Username: ", usernameField = new JTextField(15), gbc);
        gbc.gridy++;
        addLabelAndField(registerPanel, "Password: ", passwordField = new JPasswordField(15), gbc);
        gbc.gridy++;
        addLabelAndField(registerPanel, "First Name: ", firstNameField = new JTextField(15), gbc);
        gbc.gridy++;
        addLabelAndField(registerPanel, "Last Name: ", lastNameField = new JTextField(15), gbc);

        gbc.gridy++;
        JButton registerButton = createButton("Register", new Color(0, 122, 255), Color.WHITE);
        registerPanel.add(registerButton, gbc);

        gbc.gridy++;
        JButton switchToLogin = createTransparentButton("Already have an account? Login");
        registerPanel.add(switchToLogin, gbc);

        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setForeground(new Color(255, 59, 48));

        gbc.gridy++;
        registerPanel.add(statusLabel, gbc);
    }

    private void setupLoginPanel()
    {
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(250, 250, 250));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel loginTitle = new JLabel("Sign In", SwingConstants.CENTER);
        loginTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        loginTitle.setForeground(new Color(0, 122, 255));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(loginTitle, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        addLabelAndField(loginPanel, "Username: ", loginUsernameField = new JTextField(15), gbc);
        gbc.gridy++;
        addLabelAndField(loginPanel, "Password: ", loginPasswordField = new JPasswordField(15), gbc);

        gbc.gridy++;
        JButton loginButton = createButton("Login", new Color(0, 122, 255), Color.WHITE);
        loginPanel.add(loginButton, gbc);

        gbc.gridy++;
        JButton switchToRegister = createTransparentButton("Create an account");
        loginPanel.add(switchToRegister, gbc);
    }

    private void setupEventListeners()
    {
        for (Component comp : registerPanel.getComponents())
        {
            if (comp instanceof JButton)
            {
                JButton button = (JButton) comp;
                if (button.getText().equals("Register"))
                {
                    button.addActionListener(e -> registerUser());
                }
                else if (button.getText().contains("Login"))
                {
                    button.addActionListener(e -> switchToPanel(loginPanel));
                }
            }
        }

        for (Component comp : loginPanel.getComponents())
        {
            if (comp instanceof JButton)
            {
                JButton button = (JButton) comp;
                if (button.getText().equals("Login"))
                {
                    button.addActionListener(e -> loginUser());
                }
                else if (button.getText().contains("Create"))
                {
                    button.addActionListener(e -> switchToPanel(registerPanel));
                }
            }
        }
    }

    private void addLabelAndField(JPanel panel, String labelText, JTextField field, GridBagConstraints gbc)
    {
        JLabel label = new JLabel(labelText);
        field.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        gbc.gridx = 0;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private JButton createButton(String text, Color bgColor, Color fgColor)
    {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    private JButton createTransparentButton(String text)
    {
        JButton button = new JButton(text);
        button.setForeground(new Color(0, 122, 255));
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    private void registerUser()
    {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        if (!checkUserName(username))
        {
            statusLabel.setText("❌ Invalid Username!");
            return;
        }

        if (!checkPasswordComplexity(password))
        {
            statusLabel.setText("❌ Invalid Password!");
            return;
        }

        registeredUsername = username;
        registeredPassword = password;
        registeredFirstName = firstName;
        registeredLastName = lastName;
        statusLabel.setText("✅ Registration Successful!");
    }

    private void loginUser()
    {
        String enteredUsername = loginUsernameField.getText();
        String enteredPassword = new String(loginPasswordField.getPassword());

        if (enteredUsername.equals(registeredUsername) && enteredPassword.equals(registeredPassword))
        {
            JOptionPane.showMessageDialog(this, "Welcome " + registeredFirstName + " " + registeredLastName + "!",
                    "Login Successful", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Incorrect Username or Password", "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void switchToPanel(JPanel panel)
    {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    private boolean checkUserName(String username)
    {
        return username.length() <= 5 && username.contains("_");
    }

    private boolean checkPasswordComplexity(String password)
    {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Solution().setVisible(true));
    }
}
