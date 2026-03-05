import javax.swing.*;
import java.awt.*;

public class InvoiceGeneratorFrame {
    private static JTextArea invoiceDisplayTA;
    private static JScrollPane invoiceScroller;
    private static Invoice invoiceModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            invoiceModel = new Invoice("Sample Invoice", null, null);

            JFrame frame = new JFrame("Invoice Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(25, 5));
            JComponent root = (JComponent) frame.getContentPane();
            root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            invoiceDisplayTA = new JTextArea(20, 20);
            invoiceDisplayTA.setMargin(new Insets(10, 10, 10, 10));
            invoiceDisplayTA.setEditable(false);
            invoiceScroller = new JScrollPane(invoiceDisplayTA);
            frame.add(invoiceScroller, BorderLayout.CENTER);
            JPanel buttonPnl = new JPanel();
            JButton generateBtn = new JButton("Generate Invoice");
            JButton quitBtn = new JButton("Quit");
            buttonPnl.add(generateBtn);
            buttonPnl.add(quitBtn);
            frame.add(buttonPnl, BorderLayout.SOUTH);
            quitBtn.addActionListener(e -> {
                System.exit(0);
            });
            generateBtn.addActionListener(e -> {
                AddressDialog addressDialog = new AddressDialog(frame, invoiceModel);
                LineItemTableDialog lineItemTableDialog = new LineItemTableDialog(frame, invoiceModel);
                lineItemTableDialog.setVisible(true);

                invoiceDisplayTA.setText(invoiceModel.print());


            });
            frame.setVisible(true);
        });

    }
}
