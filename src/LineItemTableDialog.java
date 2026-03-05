import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LineItemTableDialog extends JDialog {
    private JTable lineItemTable;
    private DefaultTableModel tableModel;
    private Invoice invoiceModel;


    public LineItemTableDialog(JFrame parent, Invoice invoice) {
        super(parent, "Line Items for Invoice ", true);
        this.invoiceModel = invoice;
        setLayout(new BorderLayout());
        setSize(500, 400);
        setLocationRelativeTo(parent);

        // Create table model and populate with line items
        String[] columnNames = {"Product", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        lineItemTable = new JTable(tableModel);
        add(new JScrollPane(lineItemTable), BorderLayout.CENTER);

        // Populate the table with line items from the invoice
        JPanel buttonPnl = new JPanel();
        JButton addRowButton = new JButton("Add Line Item");
        addRowButton.addActionListener(e -> {
            tableModel.addRow(new Object[]{"", 1, 0.0});
        });
        JButton removeRowButton = new JButton("Remove Line Item");
        removeRowButton.addActionListener(e -> {
            int selectedRow = lineItemTable.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            }
        });
        JButton okButton = new JButton("Commit to Invoice");
        okButton.addActionListener(e -> {
            commitTableToInvoice();
            dispose();
        });
        buttonPnl.add(addRowButton);
        buttonPnl.add(removeRowButton);
        buttonPnl.add(okButton);
        add(buttonPnl, BorderLayout.SOUTH);
    }
    private void commitTableToInvoice() {
        // Here you would typically read the data from the table and update the invoice model accordingly
        if(lineItemTable.isEditing()){
            lineItemTable.getCellEditor().stopCellEditing();
        }

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String productName = (String) tableModel.getValueAt(i, 0);
            int quantity = Integer.parseInt(tableModel.getValueAt(i, 1).toString());
            double price = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
            // Here you would typically find the corresponding Product object based on the productName
            // and then create a LineItem and add it to the invoiceModel
            LineItem lineItem = new LineItem(new Product(productName, price), quantity);
            invoiceModel.addLineItem(lineItem);
        }

    }
}
