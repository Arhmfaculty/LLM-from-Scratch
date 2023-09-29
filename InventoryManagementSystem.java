import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryManagementSystem extends JFrame implements ActionListener, InventoryManagementSyste {
    private JPanel panel;
    private JLabel userLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signUpButton, createAccountButton;
    private JLabel statusLabel;

    private JTextField newUsernameField, newPasswordField, confirmNewPasswordField;
    private JLabel newUsernameLabel, newPasswordLabel, confirmNewPasswordLabel;
    private JButton addButton, removeButton, updateButton, displayButton;
    private JTextField productNameField, productPriceField;
    private JLabel usernameLabel, productNameLabel, productPriceLabel, messageLabel;
    private static JPanel loginPanel;
    private JPanel signUpPanel;
    private JPanel inventoryPanel;
    private CardLayout cardLayout;

    public InventoryManagementSystem(JPanel loginPanel) {
        this.loginPanel = loginPanel;
        setTitle("Inventory Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 100, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        signUpButton = new JButton("Sign up");
        signUpButton.setBounds(180, 100, 80, 25);
        signUpButton.addActionListener(this);
        panel.add(signUpButton);

        statusLabel = new JLabel("");
        statusLabel.setBounds(10, 150, 300, 25);
        panel.add(statusLabel);

        // Sign up panel
        newUsernameLabel = new JLabel("New username");
        newUsernameLabel.setBounds(10, 20, 100, 25);

        newUsernameField = new JTextField();
        newUsernameField.setBounds(120, 20, 165, 25);

        newPasswordLabel = new JLabel("New password");
        newPasswordLabel.setBounds(10, 50, 100, 25);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(120, 50, 165, 25);

        confirmNewPasswordLabel = new JLabel("Confirm password");
        confirmNewPasswordLabel.setBounds(10, 80, 120, 25);

        confirmNewPasswordField = new JPasswordField();
        confirmNewPasswordField.setBounds(120, 80, 165, 25);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(10, 120, 120, 25);
        createAccountButton.addActionListener(this);

        panel.add(newUsernameLabel);
        panel.add(newUsernameField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(confirmNewPasswordLabel);
        panel.add(confirmNewPasswordField);
        panel.add(createAccountButton);

        // Hide the sign up panel by default
        newUsernameLabel.setVisible(false);
        newUsernameField.setVisible(false);
        newPasswordLabel.setVisible(false);
        newPasswordField.setVisible(false);
        confirmNewPasswordLabel.setVisible(false);
        confirmNewPasswordField.setVisible(false);
        createAccountButton.setVisible(false);
        // Inventory panel
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(null);
        usernameLabel = new JLabel("Welcome, admin!");
        usernameLabel.setBounds(10, 10, 150, 25);
        inventoryPanel.add(usernameLabel);

        addButton = new JButton("Add Product");
        addButton.setBounds(10, 50, 120, 25);
        addButton.addActionListener(this);
        inventoryPanel.add(addButton);

        removeButton = new JButton("Remove Product");
        removeButton.setBounds(140, 50, 120, 25);
        removeButton.addActionListener(this);
        inventoryPanel.add(removeButton);

        updateButton = new JButton("Update Price");
        updateButton.setBounds(270, 50, 120, 25);
        updateButton.addActionListener(this);
        inventoryPanel.add(updateButton);

        displayButton = new JButton("Display Products");
        displayButton.setBounds(10, 90, 120, 25);
        displayButton.addActionListener(this);
        inventoryPanel.add(displayButton);

        messageLabel = new JLabel("");
        messageLabel.setBounds(10, 130, 300, 25);
        inventoryPanel.add(messageLabel);

        // Add product panel
        JPanel addProductPanel = new JPanel();
        addProductPanel.setLayout(null);

        productNameLabel = new JLabel("Product Name:");
        productNameLabel.setBounds(10, 10, 120, 25);
        addProductPanel.add(productNameLabel);

        productNameField = new JTextField();
        productNameField.setBounds(130, 10, 150, 25);
        addProductPanel.add(productNameField);

        productPriceLabel = new JLabel("Price:");
        productPriceLabel.setBounds(10, 40, 120, 25);
        addProductPanel.add(productPriceLabel);

        productPriceField = new JTextField();
        productPriceField.setBounds(130, 40, 150, 25);
        addProductPanel.add(productPriceField);

        JButton addProductBtn = new JButton("Add Product");
        addProductBtn.setBounds(10, 80, 120, 25);
        addProductBtn.addActionListener(this);
        addProductPanel.add(addProductBtn);

        JButton backBtn1 = new JButton("Back");
        backBtn1.setBounds(140, 80, 120, 25);
        backBtn1.addActionListener(this);
        addProductPanel.add(backBtn1);

        // Remove product panel
        JPanel removeProductPanel = new JPanel();
        removeProductPanel.setLayout(null);

        JLabel removeProductNameLabel = new JLabel("Product Name:");
        removeProductNameLabel.setBounds(10, 10, 120, 25);
        removeProductPanel.add(removeProductNameLabel);

        JTextField removeProductNameField = new JTextField();
        removeProductNameField.setBounds(130, 10, 150, 25);
        removeProductPanel.add(removeProductNameField);

        JButton removeProductBtn = new JButton("Remove Product");
        removeProductBtn.setBounds(10, 50, 120, 25);
        removeProductBtn.addActionListener(this);
        removeProductPanel.add(removeProductBtn);

        JButton backBtn2 = new JButton("Back");
        backBtn2.setBounds(140, 50, 120, 25);
        backBtn2.addActionListener(this);
        removeProductPanel.add(backBtn2);

        // Update price panel
        JPanel updatePricePanel = new JPanel();
        updatePricePanel.setLayout(null);

        JLabel updateProductNameLabel = new JLabel("Product Name:");
        updateProductNameLabel.setBounds(10, 10, 120, 25);
        updatePricePanel.add(updateProductNameLabel);

        JTextField updateProductNameField = new JTextField();
        updateProductNameField.setBounds(130, 10, 150, 25);
        updatePricePanel.add(updateProductNameField);

        // Display products panel
        JPanel displayProductsPanel = new JPanel();
        displayProductsPanel.setLayout(new BorderLayout());
        JTextArea displayProductsTextArea = new JTextArea();
        displayProductsTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayProductsTextArea);

        displayProductsPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panels to the card layout
        inventoryPanel.add(addProductPanel, "addProductPanel");
        inventoryPanel.add(removeProductPanel, "removeProductPanel");
        inventoryPanel.add(updatePricePanel, "updatePricePanel");
        inventoryPanel.add(displayProductsPanel, "displayProductsPanel");

        // Add the inventory panel to the card layout
        cardLayout.addLayoutComponent(inventoryPanel, "inventoryPanel");

        // Create a panel for the buttons to switch between panels
        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add product");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        removeButton = new JButton("Remove product");
        removeButton.addActionListener(this);
        buttonPanel.add(removeButton);

        updateButton = new JButton("Update price");
        updateButton.addActionListener(this);
        buttonPanel.add(updateButton);

        displayButton = new JButton("Display products");
        displayButton.addActionListener(this);
        buttonPanel.add(displayButton);

        // Add the button panel to the frame
        this.add(buttonPanel, BorderLayout.NORTH);

        // Add the card layout to the frame
        this.add(cardLayout, BorderLayout.CENTER);

        // Set the initial panel to be displayed
        cardLayout.show(inventoryPanel, "addProductPanel");
    }

    private void add(CardLayout cardLayout, String center) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            // Show the sign up panel
            cardLayout.show(panel, "signUpPanel");

            // Reset the status label
            statusLabel.setText("");
        } else if (e.getSource() == createAccountButton) {
            // Get the new username and passwords from the text fields
            String newUsername = newUsernameField.getText();
            String newPassword = new String(String.valueOf(newPasswordField.getCursor()));
            String confirmedPassword = new String(String.valueOf(confirmNewPasswordField.getCursor()));

            // Check if the passwords match
            if (!newPassword.equals(confirmedPassword)) {
                statusLabel.setText("Passwords do not match. Please try again.");
                return;
            }

            // TODO: Add code to create a new user account

            // Show the login panel
            cardLayout.show(panel, "loginPanel");

            // Reset the sign up form
            newUsernameField.setText("");
            newPasswordField.setText("");
            confirmNewPasswordField.setText("");

            // Reset the status label
            statusLabel.setText("Account created successfully. Please log in.");
        } else if (e.getSource() == loginButton) {
            // Get the username and password from the text fields
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Check if the username and password are valid
            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(null, "Login Successful!");

                // Enable the buttons for product management
                addButton.setEnabled(true);
                removeButton.setEnabled(true);
                updateButton.setEnabled(true);
                displayButton.setEnabled(true);

                // Disable the login button and text fields
                loginButton.setEnabled(false);
                usernameField.setEnabled(false);
                passwordField.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            }
        } else if (e.getSource() == addButton) {
            cardLayout.show(inventoryPanel, "addProductPanel");
        } else if (e.getSource() == removeButton) {
            cardLayout.show(inventoryPanel, "removeProductPanel");
        } else if (e.getSource() == updateButton) ;
        //disable the login button and text fields
        loginButton.setEnabled(false);
        usernameField.setEnabled(false);
        passwordField.setEnabled(false);
    }

    @Override
    public void actioPerformed(ActionEvent e) {
        Object addProductBtn = null;
        Boolean removeProductBtn = null;
        Boolean updatePriceBtn = null;
        Boolean displayProductsBtn = null;
        Inventories inventory = null;
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

// Check if the username and password are valid
            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(null, "Login Successful!");

                // enable the buttons for product management
                addProductBtn.equals(true);
                removeProductBtn.equals(true);
                updatePriceBtn.equals(true);
                displayProductsBtn.equals(true);

                // disable the login button and text fields
                loginButton.setEnabled(false);
                usernameField.setEnabled(false);
                passwordField.setEnabled(false);

                // show the inventory panel
                cardLayout.show(panel, "inventoryPanel");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            }
        } else if (e.getSource() == signUpButton) {
            // show the sign up panel
            cardLayout.show(panel, "signUpPanel");
        } else if (e.getSource() == createAccountButton) {
            // Get the values from the sign up form fields
            String newUsername = newUsernameField.getText();
            String newPassword = new String(String.valueOf(newPasswordField.getCursor()));
            String confirmPassword = new String(String.valueOf(confirmNewPasswordField.getCursor()));

            // Validate the sign up form fields
            if (newUsername.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
                newPasswordField.setText("");
                confirmNewPasswordField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Account created successfully!");
                // hide the sign up panel
                cardLayout.show(panel, "loginPanel");
            }
        } else if (e.getSource() == addProductBtn) {
            // show the add product panel
            cardLayout.show(panel, "addProductPanel");
        } else if (e.getSource() == removeProductBtn) {
            // show the remove product panel
            cardLayout.show(panel, "removeProductPanel");
        } else if (e.getSource() == updatePriceBtn) {
            // show the update price panel
            cardLayout.show(panel, "updatePricePanel");
        } else if (e.getSource() == displayProductsBtn) {
            // show the display products panel
            cardLayout.show(panel, "displayProductsPanel");
        } else if (e.getSource() == addButton) {
            // Get the values from the add product form fields
            String productName = productNameField.getText();
            String productPriceStr = productPriceField.getText();

            // Validate the add product form fields
            if (productName.isEmpty() || productPriceStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else {
                try {
                    // Try to parse the product price as a double
                    double productPrice = Double.parseDouble(productPriceStr);

                    // Add the product to the inventory
                    inventory.addProduct(new Stock(productName, productPrice));

                    // Clear the form fields
                    productNameField.setText("");
                    productPriceField.setText("");

                    JOptionPane.showMessageDialog(null, "Product added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid product price. Please enter a valid number.");
                }
            }
        } else if (e.getSource() == removeButton) {
            // Get the value from the remove product form field
            String productName = productNameField.getText();

            // Validate the remove product form field
            if (productName.isEmpty()) {
                int errorMessage = JOptionPane.ERROR_MESSAGE;
                removeProductBtn.booleanValue();
            }
        }
    }

}









