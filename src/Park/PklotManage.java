package Park;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PklotManage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PklotManage frame = new PklotManage();
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
	public PklotManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.setBounds(760, 472, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.setBounds(651, 472, 97, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 42, 845, 390);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("14");
		btnNewButton_2.setBounds(261, 241, 71, 102);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("10");
		btnNewButton_4.setBounds(759, 66, 71, 102);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("11");
		btnNewButton_5.setBounds(12, 241, 71, 102);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("12");
		btnNewButton_6.setBounds(95, 241, 71, 102);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("13");
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\\uC548\uC9C0\uD6C8\\Downloads\\NicePng_car-icon-vector-png_3010676 (1) (1).png"));
		btnNewButton_7.setBounds(178, 241, 71, 102);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("15");
		btnNewButton_8.setBounds(344, 241, 71, 102);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("16");
		btnNewButton_9.setBounds(427, 241, 71, 102);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("17");
		btnNewButton_10.setBounds(510, 241, 71, 102);
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("18");
		btnNewButton_11.setIcon(new ImageIcon("C:\\Users\\\uC548\uC9C0\uD6C8\\Downloads\\NicePng_car-icon-vector-png_3010676 (1) (1).png"));
		btnNewButton_11.setBounds(593, 241, 71, 102);
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_11_1 = new JButton("9");
		btnNewButton_11_1.setIcon(new ImageIcon("C:\\Users\\\uC548\uC9C0\uD6C8\\Downloads\\NicePng_car-icon-vector-png_3010676 (1) (1).png"));
		btnNewButton_11_1.setBounds(676, 66, 71, 102);
		panel_1.add(btnNewButton_11_1);
		
		JButton btnNewButton_10_1 = new JButton("8");
		btnNewButton_10_1.setBounds(593, 66, 71, 102);
		panel_1.add(btnNewButton_10_1);
		
		JButton btnNewButton_9_1 = new JButton("7");
		btnNewButton_9_1.setBounds(510, 66, 71, 102);
		panel_1.add(btnNewButton_9_1);
		
		JButton btnNewButton_8_1 = new JButton("6");
		btnNewButton_8_1.setBounds(427, 66, 71, 102);
		panel_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_2_1 = new JButton("5");
		btnNewButton_2_1.setBounds(344, 66, 71, 102);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_7_1 = new JButton("4");
		btnNewButton_7_1.setBounds(261, 66, 71, 102);
		panel_1.add(btnNewButton_7_1);
		
		JButton btnNewButton_6_1 = new JButton("3");
		btnNewButton_6_1.setBounds(178, 66, 71, 102);
		panel_1.add(btnNewButton_6_1);
		
		JButton btnNewButton_5_1 = new JButton("2");
		btnNewButton_5_1.setBounds(95, 66, 71, 102);
		panel_1.add(btnNewButton_5_1);
		
		JButton btnNewButton_4_1 = new JButton("1");
		btnNewButton_4_1.setBounds(12, 66, 71, 102);
		panel_1.add(btnNewButton_4_1);
		
		JButton btnNewButton_11_2 = new JButton("20");
		btnNewButton_11_2.setBounds(759, 241, 71, 102);
		panel_1.add(btnNewButton_11_2);
		
		JButton btnNewButton_10_2 = new JButton("19");
		btnNewButton_10_2.setBackground(Color.WHITE);
		btnNewButton_10_2.setBounds(676, 241, 71, 102);
		panel_1.add(btnNewButton_10_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 10, 845, 22);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uCC28\uC7A5 \uAD00\uB9AC - 1\uCE35");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 290, 22);
		panel_2.add(lblNewLabel);
		
		JButton button = new JButton("\uB2E4\uC74C \uCE35 \u25B6");
		button.setBounds(748, 0, 97, 23);
		panel_2.add(button);
		
		JButton btnNewButton_3 = new JButton("\u25C0 \uC774\uC804 \uCE35");
		btnNewButton_3.setBounds(639, 0, 97, 23);
		panel_2.add(btnNewButton_3);
	}
}
