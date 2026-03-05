import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class AddressDialog extends JDialog {
    private JTextField nameTf, streetTf, cityTf, stateTf, zipTf;
    private JLabel nameLbl, streetLbl, cityLbl, stateLbl, zipLbl;
    private JButton doneBtn;
    private Invoice invoiceModel;

    public AddressDialog(JFrame parent, Invoice invoice) {
        super(parent, "Enter Address", true);
        setSize(300, 200);
        setLocationRelativeTo(null);
        nameLbl = new JLabel("Name:");
        nameTf = new JTextField(20);
        streetLbl = new JLabel("Street:");
        streetTf = new JTextField(20);
        cityLbl = new JLabel("City:");
        cityTf = new JTextField(20);
        stateLbl = new JLabel("State:");
        stateTf = new JTextField(20);
        zipLbl = new JLabel("Zip Code:");
        zipTf = new JTextField(20);

        doneBtn = new JButton("Done");
        doneBtn.addActionListener(e -> {
            invoice.setAddress(new Address(
                    nameTf.getText(),
                    streetTf.getText(),
                    cityTf.getText(),
                    stateTf.getText(),
                    zipTf.getText()
            ));
            dispose();
        });

        this.invoiceModel = invoice;

        JPanel contentPnl = new JPanel(new BorderLayout());
        contentPnl.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 10));


        JPanel formPanel = new JPanel(new GridLayout(5,2,10,8));
        formPanel.add(nameLbl);
        formPanel.add(nameTf);
        formPanel.add(streetLbl);
        formPanel.add(streetTf);
        formPanel.add(cityLbl);
        formPanel.add(cityTf);
        formPanel.add(stateLbl);
        formPanel.add(stateTf);
        formPanel.add(zipLbl);
        formPanel.add(zipTf);
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.add(doneBtn);

        contentPnl.add(formPanel, BorderLayout.CENTER);
        contentPnl.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPnl);

        setVisible(true);



    }

}
