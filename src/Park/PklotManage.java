package Park;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PklotManage extends JFrame {

	private JPanel contentPane;
	public int f = 0;
    public int i = 0;
    public int j = 0;
	public ImageIcon icon = new ImageIcon("car_icon.png");
    public static String car;
	public CarManage frame = new CarManage(car);

    public static Connection getConnection() throws ClassNotFoundException, SQLException  {
        
        String url = "jdbc:mysql://localhost:3306/parking";
        String user = "root";
        String pwd = "aa9509481";	//1234
        Connection conn = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pwd);
            
        return conn;
    }

	public PklotManage() throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        String sql = "SELECT * FROM pklot";
        ResultSet rs = null;
        Statement stmt = null;
        String contents[][] = new String[20][4];
        String contents2[][] = new String[20][4];
        
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            contents[i][f] = rs.getString("pklotnum");
            contents2[i][f] = rs.getString("carnum");
            i += 1;
            j += 1;
        }
        
        if(rs != null) 
			rs.close();
        if(stmt != null) 
			stmt.close();
        if(conn != null) 
			conn.close();
        
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setBounds(760, 472, 97, 23);
		panel.add(cancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 42, 845, 390);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton slot_1 = new JButton("1");
		slot_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_1.getIcon() != null & contents2[0][f] != null) {
					try {
						frame = new CarManage(contents2[0][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_1.setBounds(12, 66, 71, 102);
		panel_1.add(slot_1);
		if(contents[0][f] != null & contents2[0][f] != null) slot_1.setIcon(icon);
		
		JButton slot_2 = new JButton("2");
		slot_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_2.getIcon() != null & contents2[1][f] != null) {
					try {
						frame = new CarManage(contents2[1][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_2.setBounds(95, 66, 71, 102);
		panel_1.add(slot_2);
		if(contents[1][f] != null & contents2[1][f] != null) slot_2.setIcon(icon);
		
		JButton slot_3 = new JButton("3");
		slot_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_3.getIcon() != null & contents2[2][f] != null) {
					try {
						frame = new CarManage(contents2[2][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_3.setBounds(178, 66, 71, 102);
		panel_1.add(slot_3);
		if(contents[2][f] != null & contents2[2][f] != null) slot_3.setIcon(icon);
		
		JButton slot_4 = new JButton("4");
		slot_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_4.getIcon() != null & contents2[3][f] != null) {
					try {
						frame = new CarManage(contents2[3][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_4.setBounds(261, 66, 71, 102);
		panel_1.add(slot_4);
		if(contents[3][f] != null & contents2[3][f] != null) slot_4.setIcon(icon);
		
		JButton slot_5 = new JButton("5");
		slot_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_5.getIcon() != null & contents2[4][f] != null) {
					try {
						frame = new CarManage(contents2[4][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_5.setBounds(344, 66, 71, 102);
		panel_1.add(slot_5);
		if(contents[4][f] != null & contents2[4][f] != null) slot_5.setIcon(icon);
		
		JButton slot_6 = new JButton("6");
		slot_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_6.getIcon() != null & contents2[5][f] != null) {
					try {
						frame = new CarManage(contents2[5][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_6.setBounds(427, 66, 71, 102);
		panel_1.add(slot_6);
		if(contents[5][f] != null & contents2[5][f] != null) slot_6.setIcon(icon);
		
		JButton slot_7 = new JButton("7");
		slot_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_7.getIcon() != null & contents2[6][f] != null) {
					try {
						frame = new CarManage(contents2[6][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_7.setBounds(510, 66, 71, 102);
		panel_1.add(slot_7);
		if(contents[6][f] != null & contents2[6][f] != null) slot_7.setIcon(icon);
		
		JButton slot_8 = new JButton("8");
		slot_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_8.getIcon() != null & contents2[7][f] != null) {
					try {
						frame = new CarManage(contents2[7][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_8.setBounds(593, 66, 71, 102);
		panel_1.add(slot_8);
		if(contents[7][f] != null & contents2[7][f] != null) slot_8.setIcon(icon);
		
		JButton slot_9 = new JButton("9");
		slot_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_1.getIcon() != null & contents2[8][f] != null) {
					try {
						frame = new CarManage(contents2[8][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_9.setBounds(676, 66, 71, 102);
		panel_1.add(slot_9);
		if(contents[8][f] != null & contents2[8][f] != null) slot_9.setIcon(icon);
		
		JButton slot_10 = new JButton("10");
		slot_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_10.getIcon() != null & contents2[9][f] != null) {
					try {
						frame = new CarManage(contents2[9][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_10.setBounds(759, 66, 71, 102);
		panel_1.add(slot_10);
		if(contents[9][f] != null & contents2[9][f] != null) slot_10.setIcon(icon);
		
		JButton slot_11 = new JButton("11");
		slot_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_11.getIcon() != null & contents2[10][f] != null) {
					try {
						frame = new CarManage(contents2[10][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_11.setBounds(12, 241, 71, 102);
		panel_1.add(slot_11);
		if(contents[10][f] != null & contents2[10][f] != null) slot_11.setIcon(icon);
		
		JButton slot_12 = new JButton("12");
		slot_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_12.getIcon() != null & contents2[11][f] != null) {
					try {
						frame = new CarManage(contents2[11][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_12.setBounds(95, 241, 71, 102);
		panel_1.add(slot_12);
		if(contents[11][f] != null & contents2[11][f] != null) slot_12.setIcon(icon);
		
		JButton slot_13 = new JButton("13");
		slot_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_13.getIcon() != null & contents2[12][f] != null) {
					try {
						frame = new CarManage(contents2[12][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_13.setBounds(178, 241, 71, 102);
		panel_1.add(slot_13);
		if(contents[12][f] != null & contents2[12][f] != null) slot_13.setIcon(icon);
		
		JButton slot_14 = new JButton("14");
		slot_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_14.getIcon() != null & contents2[13][f] != null) {
					try {
						frame = new CarManage(contents2[13][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_14.setBounds(261, 241, 71, 102);
		panel_1.add(slot_14);
		if(contents[13][f] != null & contents2[13][f] != null) slot_14.setIcon(icon);
		
		JButton slot_15 = new JButton("15");
		slot_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_15.getIcon() != null & contents2[14][f] != null) {
					try {
						frame = new CarManage(contents2[14][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_15.setBounds(344, 241, 71, 102);
		panel_1.add(slot_15);
		if(contents[14][f] != null & contents2[14][f] != null) slot_15.setIcon(icon);
		
		JButton slot_16 = new JButton("16");
		slot_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_16.getIcon() != null & contents2[15][f] != null) {
					try {
						frame = new CarManage(contents2[15][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_16.setBounds(427, 241, 71, 102);
		panel_1.add(slot_16);
		if(contents[15][f] != null & contents2[15][f] != null) slot_16.setIcon(icon);
		
		JButton slot_17 = new JButton("17");
		slot_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_17.getIcon() != null & contents2[16][f] != null) {
					try {
						frame = new CarManage(contents2[16][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_17.setBounds(510, 241, 71, 102);
		panel_1.add(slot_17);
		if(contents[16][f] != null & contents2[16][f] != null) slot_17.setIcon(icon);
		
		JButton slot_18 = new JButton("18");
		slot_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_18.getIcon() != null & contents2[17][f] != null) {
					try {
						frame = new CarManage(contents2[17][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_18.setBounds(593, 241, 71, 102);
		panel_1.add(slot_18);
		if(contents[17][f] != null & contents2[17][f] != null) slot_18.setIcon(icon);
		
		JButton slot_19 = new JButton("19");
		slot_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_19.getIcon() != null & contents2[18][f] != null) {
					try {
						frame = new CarManage(contents2[18][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_19.setBounds(676, 241, 71, 102);
		panel_1.add(slot_19);
		if(contents[18][f] != null & contents2[18][f] != null) slot_19.setIcon(icon);
		
		JButton slot_20 = new JButton("20");
		slot_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(slot_20.getIcon() != null & contents2[19][f] != null) {
					try {
						frame = new CarManage(contents2[19][f].toString());
						frame.setTitle("차량 관리");
						frame.setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		slot_20.setBounds(759, 241, 71, 102);
		panel_1.add(slot_20);
		if(contents[19][f] != null & contents2[19][f] != null) slot_20.setIcon(icon);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 10, 845, 22);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("주차장 관리 - " + (f + 1) + "층");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 290, 22);
		panel_2.add(lblNewLabel);
		
		JButton button = new JButton("\uB2E4\uC74C \uCE35 \u25B6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f < 3) {
					f += 1;
					lblNewLabel.setText("주차장 관리 - " + (f + 1) + "층");
					if(contents[0][f] != null & contents2[0][f] != null) slot_1.setIcon(icon);
					else if(contents[0][f] == null & contents2[0][f] == null) slot_1.setIcon(null);
					if(contents[1][f] != null & contents2[1][f] != null) slot_2.setIcon(icon);
					else if(contents[1][f] == null & contents2[1][f] == null) slot_2.setIcon(null);
					if(contents[2][f] != null & contents2[2][f] != null) slot_3.setIcon(icon);
					else if(contents[2][f] == null & contents2[2][f] == null) slot_3.setIcon(null);
					if(contents[3][f] != null & contents2[3][f] != null) slot_4.setIcon(icon);
					else if(contents[3][f] == null & contents2[3][f] == null) slot_4.setIcon(null);
					if(contents[4][f] != null & contents2[4][f] != null) slot_5.setIcon(icon);
					else if(contents[4][f] == null & contents2[4][f] == null) slot_5.setIcon(null);
					if(contents[5][f] != null & contents2[5][f] != null) slot_6.setIcon(icon);
					else if(contents[5][f] == null & contents2[5][f] == null) slot_6.setIcon(null);
					if(contents[6][f] != null & contents2[6][f] != null) slot_7.setIcon(icon);
					else if(contents[6][f] == null & contents2[6][f] == null) slot_7.setIcon(null);
					if(contents[7][f] != null & contents2[7][f] != null) slot_8.setIcon(icon);
					else if(contents[7][f] == null & contents2[7][f] == null) slot_8.setIcon(null);
					if(contents[8][f] != null & contents2[8][f] != null) slot_9.setIcon(icon);
					else if(contents[8][f] == null & contents2[8][f] == null) slot_9.setIcon(null);
					if(contents[9][f] != null & contents2[9][f] != null) slot_10.setIcon(icon);
					else if(contents[9][f] == null & contents2[9][f] == null) slot_10.setIcon(null);
					if(contents[10][f] != null & contents2[10][f] != null) slot_11.setIcon(icon);
					else if(contents[10][f] == null & contents2[10][f] == null) slot_11.setIcon(null);
					if(contents[11][f] != null & contents2[11][f] != null) slot_12.setIcon(icon);
					else if(contents[11][f] == null & contents2[11][f] == null) slot_12.setIcon(null);
					if(contents[12][f] != null & contents2[12][f] != null) slot_13.setIcon(icon);
					else if(contents[12][f] == null & contents2[12][f] == null) slot_13.setIcon(null);
					if(contents[13][f] != null & contents2[13][f] != null) slot_14.setIcon(icon);
					else if(contents[13][f] == null & contents2[13][f] == null) slot_14.setIcon(null);
					if(contents[14][f] != null & contents2[14][f] != null) slot_15.setIcon(icon);
					else if(contents[14][f] == null & contents2[14][f] == null) slot_15.setIcon(null);
					if(contents[15][f] != null & contents2[15][f] != null) slot_16.setIcon(icon);
					else if(contents[15][f] == null & contents2[15][f] == null) slot_16.setIcon(null);
					if(contents[16][f] != null & contents2[16][f] != null) slot_17.setIcon(icon);
					else if(contents[16][f] == null & contents2[16][f] == null) slot_17.setIcon(null);
					if(contents[17][f] != null & contents2[17][f] != null) slot_18.setIcon(icon);
					else if(contents[17][f] == null & contents2[17][f] == null) slot_18.setIcon(null);
					if(contents[18][f] != null & contents2[18][f] != null) slot_19.setIcon(icon);
					else if(contents[18][f] == null & contents2[18][f] == null) slot_19.setIcon(null);
					if(contents[19][f] != null & contents2[19][f] != null) slot_20.setIcon(icon);
					else if(contents[19][f] == null & contents2[19][f] == null) slot_20.setIcon(null);
				}
			}
		});
		button.setBounds(748, 0, 97, 23);
		panel_2.add(button);
		
		JButton btnNewButton_3 = new JButton("\u25C0 \uC774\uC804 \uCE35");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f >= 1) {
					f -= 1;
					lblNewLabel.setText("주차장 관리 - " + (f + 1) + "층");
					if(contents[0][f] != null & contents2[0][f] != null) slot_1.setIcon(icon);
					else if(contents[0][f] == null & contents2[0][f] == null) slot_1.setIcon(null);
					if(contents[1][f] != null & contents2[1][f] != null) slot_2.setIcon(icon);
					else if(contents[1][f] == null & contents2[1][f] == null) slot_2.setIcon(null);
					if(contents[2][f] != null & contents2[2][f] != null) slot_3.setIcon(icon);
					else if(contents[2][f] == null & contents2[2][f] == null) slot_3.setIcon(null);
					if(contents[3][f] != null & contents2[3][f] != null) slot_4.setIcon(icon);
					else if(contents[3][f] == null & contents2[3][f] == null) slot_4.setIcon(null);
					if(contents[4][f] != null & contents2[4][f] != null) slot_5.setIcon(icon);
					else if(contents[4][f] == null & contents2[4][f] == null) slot_5.setIcon(null);
					if(contents[5][f] != null & contents2[5][f] != null) slot_6.setIcon(icon);
					else if(contents[5][f] == null & contents2[5][f] == null) slot_6.setIcon(null);
					if(contents[6][f] != null & contents2[6][f] != null) slot_7.setIcon(icon);
					else if(contents[6][f] == null & contents2[6][f] == null) slot_7.setIcon(null);
					if(contents[7][f] != null & contents2[7][f] != null) slot_8.setIcon(icon);
					else if(contents[7][f] == null & contents2[7][f] == null) slot_8.setIcon(null);
					if(contents[8][f] != null & contents2[8][f] != null) slot_9.setIcon(icon);
					else if(contents[8][f] == null & contents2[8][f] == null) slot_9.setIcon(null);
					if(contents[9][f] != null & contents2[9][f] != null) slot_10.setIcon(icon);
					else if(contents[9][f] == null & contents2[9][f] == null) slot_10.setIcon(null);
					if(contents[10][f] != null & contents2[10][f] != null) slot_11.setIcon(icon);
					else if(contents[10][f] == null & contents2[10][f] == null) slot_11.setIcon(null);
					if(contents[11][f] != null & contents2[11][f] != null) slot_12.setIcon(icon);
					else if(contents[11][f] == null & contents2[11][f] == null) slot_12.setIcon(null);
					if(contents[12][f] != null & contents2[12][f] != null) slot_13.setIcon(icon);
					else if(contents[12][f] == null & contents2[12][f] == null) slot_13.setIcon(null);
					if(contents[13][f] != null & contents2[13][f] != null) slot_14.setIcon(icon);
					else if(contents[13][f] == null & contents2[13][f] == null) slot_14.setIcon(null);
					if(contents[14][f] != null & contents2[14][f] != null) slot_15.setIcon(icon);
					else if(contents[14][f] == null & contents2[14][f] == null) slot_15.setIcon(null);
					if(contents[15][f] != null & contents2[15][f] != null) slot_16.setIcon(icon);
					else if(contents[15][f] == null & contents2[15][f] == null) slot_16.setIcon(null);
					if(contents[16][f] != null & contents2[16][f] != null) slot_17.setIcon(icon);
					else if(contents[16][f] == null & contents2[16][f] == null) slot_17.setIcon(null);
					if(contents[17][f] != null & contents2[17][f] != null) slot_18.setIcon(icon);
					else if(contents[17][f] == null & contents2[17][f] == null) slot_18.setIcon(null);
					if(contents[18][f] != null & contents2[18][f] != null) slot_19.setIcon(icon);
					else if(contents[18][f] == null & contents2[18][f] == null) slot_19.setIcon(null);
					if(contents[19][f] != null & contents2[19][f] != null) slot_20.setIcon(icon);
					else if(contents[19][f] == null & contents2[19][f] == null) slot_20.setIcon(null);
				}
			}
		});
		btnNewButton_3.setBounds(639, 0, 97, 23);
		panel_2.add(btnNewButton_3);
	}
	
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
}
