import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Main {

	private JFrame frame;
	private JTextField quantity_textField;
	private JTextField price_textField;
	private JTextField title_textField;
	private JTextField SKU_textField;
	private JButton add_button;
	private JButton remove_button;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();

		Inventory inventory = new Inventory();

		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int sku = Integer.parseInt(SKU_textField.getText());
				double price = Double.parseDouble(price_textField.getText());
				int quantity = Integer.parseInt(quantity_textField.getText());

				String name = title_textField.getText();

				inventory.output = "";
				inventory.addTB(sku);
				inventory.addName(name, sku);
				inventory.addPrice(price, sku);
				inventory.addQuantity(quantity, sku);
				inventory.traverseInventory(inventory.root);

				for (Integer num : inventory.list) {
					inventory.printBook(num);
				}

				SKU_textField.setText("");
				title_textField.setText("");
				price_textField.setText("");
				quantity_textField.setText("");

				textArea.setText(inventory.output);
			}
		});

		remove_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sku = Integer.parseInt(SKU_textField.getText());

				inventory.output = "";
				inventory.delete(sku);
				inventory.list.remove(sku);

				for (Integer num : inventory.list) {
					inventory.printBook(num);
				}

				SKU_textField.setText("");
				title_textField.setText("");
				price_textField.setText("");
				quantity_textField.setText("");

				textArea.setText(inventory.output);
			}
		});

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel HEADER_LABEL = new JLabel("INVeNTORY");
		HEADER_LABEL.setBounds(285, 6, 79, 16);
		frame.getContentPane().add(HEADER_LABEL);

		JLabel SKU_LABEL = new JLabel("SKU:");
		SKU_LABEL.setBounds(6, 40, 39, 16);
		frame.getContentPane().add(SKU_LABEL);

		JLabel TITLE_LABEL = new JLabel("TITLE:");
		TITLE_LABEL.setBounds(6, 66, 39, 16);
		frame.getContentPane().add(TITLE_LABEL);

		JLabel PRICE_LABEL = new JLabel("PRCIE:");
		PRICE_LABEL.setBounds(295, 40, 61, 16);
		frame.getContentPane().add(PRICE_LABEL);

		JLabel QUANTITY_LABEL = new JLabel("QUANTITY:");
		QUANTITY_LABEL.setBounds(294, 66, 70, 16);
		frame.getContentPane().add(QUANTITY_LABEL);

		quantity_textField = new JTextField();
		quantity_textField.setBounds(376, 61, 203, 26);
		frame.getContentPane().add(quantity_textField);
		quantity_textField.setColumns(10);

		price_textField = new JTextField();
		price_textField.setBounds(376, 35, 203, 26);
		frame.getContentPane().add(price_textField);
		price_textField.setColumns(10);

		title_textField = new JTextField();
		title_textField.setBounds(88, 61, 203, 26);
		frame.getContentPane().add(title_textField);
		title_textField.setColumns(10);

		SKU_textField = new JTextField();
		SKU_textField.setBounds(88, 35, 203, 26);
		frame.getContentPane().add(SKU_textField);
		SKU_textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 132, 663, 237);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel SKU_LABEL_HEADER = new JLabel("SKU");
		SKU_LABEL_HEADER.setBounds(20, 100, 61, 16);
		frame.getContentPane().add(SKU_LABEL_HEADER);

		JLabel TITLE_LABEL_HEADER = new JLabel("TITLE");
		TITLE_LABEL_HEADER.setBounds(120, 100, 61, 16);
		frame.getContentPane().add(TITLE_LABEL_HEADER);

		JLabel PRICE_LABEL_HEADER = new JLabel("PRICE");
		PRICE_LABEL_HEADER.setBounds(300, 100, 61, 16);
		frame.getContentPane().add(PRICE_LABEL_HEADER);

		JLabel QUANTITY_LABEL_HEADER = new JLabel("QUANTITY");
		QUANTITY_LABEL_HEADER.setBounds(558, 104, 79, 16);
		frame.getContentPane().add(QUANTITY_LABEL_HEADER);

		add_button = new JButton("add");
		add_button.setBounds(580, 35, 70, 26);
		frame.getContentPane().add(add_button);

		remove_button = new JButton("remove");
		remove_button.setBounds(600, 60, 80, 30);
		frame.getContentPane().add(remove_button);
	}
}