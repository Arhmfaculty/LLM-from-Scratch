import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineShop extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton loginButton;
    private Inventories inventories;

    public OnlineShop() {
        inventories = new Inventories();

        setTitle("Online Shop");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPanel panel = new JPanel();
        //panel.setLayout(new BorderLayout());

        // Create the components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(5);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField(5);

        loginButton = new JButton("Login");
        //loginButton.addActionListener((ActionListener) this);


        // Add the components to the frame
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        add(panel);

        //setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayHomePage();
            }
        });

    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword());


        // Check if the login is successful
        if (isValidLogin(username, password)) {
            // Open the inventory GUI
            new InventoryGUI();
            // Close the login GUI
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Dummy method for checking the username and password
    private boolean isValidLogin(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }


    private void displayHomePage() {
        JFrame sellerFrame = new JFrame();
        sellerFrame.setTitle("Home Page");
        sellerFrame.setSize(400, 300);
        sellerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton sellerButton = new JButton("Seller");
        JButton buyerButton = new JButton("Buyer");

        panel.add(sellerButton, BorderLayout.WEST);
        panel.add(buyerButton, BorderLayout.EAST);

        add(panel);

        sellerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySellerActions();
            }
        });

        buyerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBuyerActions();
            }
        });
    }

        private void displaySellerActions () {
            JFrame sellerFrame = new JFrame();
            sellerFrame.setTitle("Seller Actions");
            sellerFrame.setSize(400, 300);
            sellerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JTextArea outputTextArea = new JTextArea();
            outputTextArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(outputTextArea);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(5, 1));

            JButton addProductsButton = new JButton("Add Products");
            JButton removeProductsButton = new JButton("Remove Products");
            JButton checkTransactionsButton = new JButton("Check Transactions");
            JButton displayProductsButton = new JButton("Display Available Products");
            JButton quitButton = new JButton("Quit");

            buttonPanel.add(addProductsButton);
            buttonPanel.add(removeProductsButton);
            buttonPanel.add(checkTransactionsButton);
            buttonPanel.add(displayProductsButton);
            buttonPanel.add(quitButton);

            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(buttonPanel, BorderLayout.WEST);

            sellerFrame.add(panel);
            sellerFrame.setVisible(true);

            addProductsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String entryNumInput = JOptionPane.showInputDialog("Enter the number of products you want to add:");
                    int entryNum = Integer.parseInt(entryNumInput);

                    for (int n = 0; n < entryNum; n++) {
                        String name = JOptionPane.showInputDialog("Enter the product's name:");
                        String brand = JOptionPane.showInputDialog("Enter the brand:");
                        String priceInput = JOptionPane.showInputDialog("Enter the price:");
                        double price = Double.parseDouble(priceInput);
                        String quantityInput = JOptionPane.showInputDialog("Enter the quantity:");
                        int quantity = Integer.parseInt(quantityInput);

                        inventories.addProduct(name, brand, price, quantity);

                        outputTextArea.append("You have successfully added \"" + quantity + "pieces of " + name + "\" to your inventory.\n");
                    }
                }
            });

            removeProductsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String remove = JOptionPane.showInputDialog("Remove a product from your inventory (Yes or No):");

                    if (remove.equalsIgnoreCase("yes")) {
                        String removeName = JOptionPane.showInputDialog("Enter the name of the product you want to remove:");
                        String removeBrand = JOptionPane.showInputDialog("Enter the brand of the product:");

                        if (inventories.removeProduct(removeName, removeBrand)) {
                            outputTextArea.append("You have successfully removed \"" + removeName + "\" from your inventory.\n");
                        } else {
                            outputTextArea.append("\"" + removeName + "\" not found in your inventory.\n");
                        }
                    } else {
                        outputTextArea.append("Ok, nothing has been removed.\n");
                    }
                }
            });

            checkTransactionsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Implement checkTransactions functionality
                    // Display the transactions in the outputTextArea
                }
            });

            displayProductsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inventoryText = inventories.displayInventory();
                    outputTextArea.setText(inventoryText);
                }
            });

            quitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sellerFrame.dispose();
                }
            });
        }

        private void displayBuyerActions () {
            // Implement buyer actions
        }

        public static void main (String[]args){
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //InventoryGUI inventoryGUI = new InventoryGUI();
                    // inventoryGUI.setVisible(true);
                    OnlineShop onlineShop = new OnlineShop();
                    onlineShop.setVisible(true);

                }
            });
        }
    }
