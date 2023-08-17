package com.invoiceManager;
  // The Invoice class represents an invoice with its attributes such as the number, the client, the date, and the amount.
    public class Invoice {
        String number; // Invoice number
        String client; // Client's name
        String date; // Invoice date
        double amount; // Total amount of the invoice

        // Constructor used to initialize the values when creating an instance of Invoice.
        public Invoice(String number, String client, String date, double amount) {
            this.number = number;
            this.client = client;
            this.date = date;
            this.amount = amount;
        }
    }