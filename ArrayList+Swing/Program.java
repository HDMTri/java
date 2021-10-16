package ArrayListSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class Program {

	private JFrame mainFrame;
	private JTextField txtName;
	JLabel lblTypeName;
	JButton btnAddName;
	JTextArea textAreaNameList;
	JButton btnShow;
	JLabel lblStatusLabel;
	JButton btnDelete;

	ArrayList<String> nameList;
	
	private JLabel lblTimTen;
	private JTextField txtToSearch;
	private JButton btnTimTen;
	private JTextArea textAreaNameList_alt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("ArrayList Example");
		mainFrame.setBounds(100, 100, 805, 475);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);

		lblTypeName = new JLabel("Nhập Tên");
		lblTypeName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTypeName.setBounds(69, 26, 109, 25);
		mainFrame.getContentPane().add(lblTypeName);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblStatusLabel.setText("Entering name...");
				lblStatusLabel.setVisible(true);
			}
		});
		txtName.setBounds(204, 29, 396, 24);
		mainFrame.getContentPane().add(txtName);
		txtName.setColumns(10);

		nameList = new ArrayList<String>();

		btnAddName = new JButton("Thêm Tên");
		btnAddName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAddName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemVaoDS(nameList);
			}
		});
		btnAddName.setBounds(610, 21, 126, 35);
		mainFrame.getContentPane().add(btnAddName);

		textAreaNameList = new JTextArea();
		textAreaNameList.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaNameList.setBounds(69, 213, 297, 203);
		mainFrame.getContentPane().add(textAreaNameList);

		btnShow = new JButton("Hiển thị Danh Sách");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HienThiDS(nameList);
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnShow.setBounds(124, 151, 195, 41);
		mainFrame.getContentPane().add(btnShow);

		lblStatusLabel = new JLabel("Thanh Status");
		lblStatusLabel.setVisible(false);
		lblStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusLabel.setForeground(Color.BLUE);
		lblStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblStatusLabel.setBounds(467, 64, 126, 19);
		mainFrame.getContentPane().add(lblStatusLabel);

		btnDelete = new JButton("Xóa Danh Sách");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaDS(nameList);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDelete.setBounds(467, 151, 195, 41);
		mainFrame.getContentPane().add(btnDelete);

		lblTimTen = new JLabel("Tìm Tên");
		lblTimTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTimTen.setBounds(69, 99, 109, 25);
		mainFrame.getContentPane().add(lblTimTen);

		txtToSearch = new JTextField();
		txtToSearch.setColumns(10);
		txtToSearch.setBounds(204, 102, 396, 24);
		mainFrame.getContentPane().add(txtToSearch);

		btnTimTen = new JButton("Tìm Tên");
		btnTimTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimTen(nameList);
			}
		});
		btnTimTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnTimTen.setBounds(610, 94, 126, 35);
		mainFrame.getContentPane().add(btnTimTen);

		textAreaNameList_alt = new JTextArea();
		textAreaNameList_alt.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaNameList_alt.setBounds(413, 213, 306, 203);
		mainFrame.getContentPane().add(textAreaNameList_alt);
	}

	void ThemVaoDS(ArrayList<String> arr) {
		String name = txtName.getText();

		arr.add(name);
		txtName.setText("");

		lblStatusLabel.setText("Added successfully!");
		lblStatusLabel.setVisible(true);

		textAreaNameList_alt.setText("");

		for (int i = 0; i < arr.size(); i++) {
			String element = arr.get(i);

			textAreaNameList_alt.append(element + "\n");
		}
	}

	void HienThiDS(ArrayList<String> arr) {
		textAreaNameList.setText("");

		// For loop iteration
		for (int i = 0; i < arr.size(); i++) {
			String element = arr.get(i);

			textAreaNameList.append(element + "\n");
		}
	}



	void XoaDS(ArrayList<String> arr) {
		textAreaNameList.setText("");
		textAreaNameList_alt.setText("");
		arr.clear();
	}

	void TimTen(ArrayList<String> arr) {
		String toSearch = txtToSearch.getText();
		String nameFound = "";
		int count = 0;

		for (String element : arr) {
			if (element.contains(toSearch)) {
				nameFound += element + "\n";
				count++;
			}
		}

		if (count == 0)
			ThongBaoLoi("Name not found!", "Not found!", JOptionPane.ERROR_MESSAGE);
		else
			ThongBaoLoi(nameFound, count + " name(s) found!", JOptionPane.INFORMATION_MESSAGE);

	}
	
	void ThongBaoLoi(String msg, String title, int msgType) {
		JFrame frame = new JFrame("JDialog");
		JOptionPane.showMessageDialog(frame, msg, title, msgType);
	}
}