package Park;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class CarList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarList frame = new CarList();
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
	public CarList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.setBounds(705, 486, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.setBounds(596, 486, 97, 23);
		panel.add(btnNewButton_1);
		
		String header[] = {"차량 번호", "위치", "입차 시간", "출차 시간"};
		String contents[][] = {{"37나8123", "1F9", "2022-01-01 01:24:00", "2022-01-01 12:04:03"},
							   {"45하6789", "1F13", "2022-01-01 05:11:31", "2022-01-01 06:32:21"},
							   {"12허6439", "1F18", "2022-01-01 02:41:21", "2022-01-01 06:11:51"}};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 790, 466);
		panel.add(scrollPane);
		
		table = new JTable(contents, header);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uCC28\uC7A5 \uD604\uD669");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
	}
}
