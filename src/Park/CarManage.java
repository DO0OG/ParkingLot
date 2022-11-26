package Park;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CarManage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarManage frame = new CarManage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CarManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		lblNewLabel_1.setBounds(12, 32, 81, 20);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(12, 64, 134, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uC785\uCC28 \uC2DC\uAC04");
		lblNewLabel_4.setBounds(12, 287, 57, 15);
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(165, 312, 134, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uCD9C\uCC28 \uC2DC\uAC04");
		lblNewLabel_5.setBounds(165, 287, 57, 15);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(12, 312, 134, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(354, 61, 210, 153);
		panel.add(panel_1);
		
		JLabel lblNewLabel_6 = new JLabel("\uC774\uBBF8\uC9C0");
		lblNewLabel_6.setBounds(438, 35, 50, 15);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("\uC218\uC815");
		btnNewButton_2.setBounds(354, 265, 91, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uCDE8\uC18C");
		btnNewButton_3.setBounds(473, 265, 91, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_7 = new JLabel("\uC2AC\uB86F");
		lblNewLabel_7.setBounds(12, 116, 50, 15);
		panel.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(12, 141, 134, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\uC694\uAE08");
		lblNewLabel_8.setBounds(165, 116, 50, 15);
		panel.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(165, 141, 134, 21);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\uB9C8\uC9C0\uB9C9 \uC774\uC6A9 \uB0A0\uC9DC");
		lblNewLabel_9.setBounds(165, 35, 104, 15);
		panel.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(165, 64, 134, 21);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uCC28\uB7C9 \uAD00\uB9AC");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
}
