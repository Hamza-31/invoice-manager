package com.invoiceManager;

import javax.swing.SwingUtilities;

public class Main {
    // The main() method starts the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // InvokeLater is used to launch the graphical interface in a separate thread.
            public void run() {
                // A new instance of InvoicesManager is created and made visible.
                new InvoicesManager().setVisible(true);
            }
        });
    }
}