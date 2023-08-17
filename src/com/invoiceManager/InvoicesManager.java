package com.invoiceManager;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


// The InvoiceManager class inherits from the JFrame class, which is a GUI window that contains all the components of the application.
public class InvoicesManager extends JFrame {
    private List<Invoice> invoices; // The list that stores instances of Invoice.
    private JTextArea textArea; // A text area used to display invoice information.
    private JTextField searchField; // A text field that allows users to search for an invoice.
    // The InvoicesManager constructor initializes the window with a title, size, and configures the application to close when the window is closed.
    public InvoicesManager() {
        invoices = new ArrayList<>(); // Instance of the invoices list

        setTitle("Invoice Manager "); // Sets a title for the window.
        setSize(680, 420); // Sets the dimensions (width and height).
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Closes the window.

        JPanel panel = new JPanel(); // A panel to organize graphical elements.
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea(10, 30); // The text area is configured with a size and made non-editable, then added to the panel within a scrollable area (JScrollPane).
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        searchField = new JTextField(15); // The text field for search
        JButton searchButton = new JButton("Search Invoice"); // Creates a button
        // Add action listener for search button
        JPanel searchPanel = new JPanel(); // Creates a panel for the search form
        searchPanel.add(searchField); // Adds the text field to the panel
        searchPanel.add(searchButton); // Adds the search button to the panel.
        panel.add(searchPanel, BorderLayout.NORTH); // Adds the button to the top part of the panel.

        JButton addButton = new JButton("Add Invoice"); // Creates a button
        // Add action listener for adding invoice button
        panel.add(addButton, BorderLayout.SOUTH); // Adds the button to the bottom part of the panel.

        getContentPane().add(panel); // Adds the panel to the window.
    }
}
