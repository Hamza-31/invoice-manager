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
        searchButton.addActionListener(new ActionListener() { // An event listener that calls the searchInvoice() method when the button is clicked.
            @Override
            public void actionPerformed(ActionEvent e) {
                searchInvoice();
            }
        });
        JPanel searchPanel = new JPanel(); // Creates a panel for the search form
        searchPanel.add(searchField); // Adds the text field to the panel
        searchPanel.add(searchButton); // Adds the search button to the panel.
        panel.add(searchPanel, BorderLayout.NORTH); // Adds the button to the top part of the panel.

        JButton addButton = new JButton("Add Invoice"); // Creates a button
        addButton.addActionListener(new ActionListener() { // An event listener that calls the addInvoice() method when the button is clicked.
            @Override
            public void actionPerformed(ActionEvent e) {
                addInvoice();
            }
        });
        panel.add(addButton, BorderLayout.SOUTH); // Adds the button to the bottom part of the panel.

        getContentPane().add(panel); // Adds the panel to the window.

    }
    // The addInvoice() method is called when the user clicks the "Add Invoice" button.
    private void addInvoice() {
        // The method uses dialog boxes (JOptionPane) to collect information for the new invoice: number, client, date, and amount
        String number = JOptionPane.showInputDialog("Invoice Number:"); // Adds the invoice number.
        String client = JOptionPane.showInputDialog("Client's Name:"); // Adds the client's name.
        String date = JOptionPane.showInputDialog("Invoice Date:"); // Adds an invoice date.
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Total Amount:")); // Adds the amount.

        Invoice invoice = new Invoice(number, client, date, amount); // Creates an Invoice instance and assigns the values (number, client name, date, amount) to the invoice
        invoices.add(invoice); // Adds the created invoice to the list of invoices

        showInvoices(); // Displays all invoices
    }
    // The showInvoices() method updates the textArea to display the list of invoices.
    private void showInvoices() {
        // Before displaying new data, the method clears the current content of the text area.
        textArea.setText("");
        // The method iterates through the invoices list and adds the details of each invoice to the text area.
        for (Invoice invoice : invoices) {
            textArea.append("Number: " + invoice.number + "\n"); // Displays the invoice number.
            textArea.append("Client: " + invoice.client + "\n"); // Displays the client's name.
            textArea.append("Date: " + invoice.date + "\n"); // Displays the invoice date.
            textArea.append("Amount: " + invoice.amount + "\n\n"); // Displays the invoice amount.
        }
    }
    private void searchInvoice() {
        String search = searchField.getText(); // Retrieves the user's query.
        textArea.setText(""); // Clears the current content
        boolean found = false; // A boolean variable used to indicate if an invoice with the search number has been found in the list of invoices.
        // The method iterates through the list of invoices and displays the invoice details if found.
        for (Invoice invoice : invoices) {
            if (invoice.number.equals(search)) {
                textArea.append("Number: " + invoice.number + "\n");
                textArea.append("Client: " + invoice.client + "\n");
                textArea.append("Date: " + invoice.date + "\n");
                textArea.append("Amount: " + invoice.amount + "\n\n");
                found = true;
                break; // Exits the loop after finding the invoice
            }
        }
        // If no invoice is found, an appropriate message is displayed in the text area.
        if (!found) {
            textArea.append("No invoice found with this number.");
        }
    }
}
