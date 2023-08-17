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

}
