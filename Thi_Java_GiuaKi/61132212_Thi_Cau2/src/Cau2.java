import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cau2 extends JFrame {

	private JPanel contentPane;
	private JTextField textA;
	private JTextField textB;
	private JTextField textC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cau2 frame = new Cau2();
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
	public Cau2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitle = new JLabel("Tinh phuong trinh bac 2");
		lbltitle.setBounds(135, 28, 185, 25);
		contentPane.add(lbltitle);
		
		JLabel lblA = new JLabel("Nhap A");
		lblA.setBounds(60, 68, 46, 14);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("Nhap B");
		lblB.setBounds(60, 93, 46, 14);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("Nhap C");
		lblC.setBounds(60, 121, 46, 14);
		contentPane.add(lblC);
		
		textA = new JTextField();
		textA.setBounds(115, 64, 203, 20);
		contentPane.add(textA);
		textA.setColumns(10);
		
		textB = new JTextField();
		textB.setBounds(115, 92, 203, 20);
		contentPane.add(textB);
		textB.setColumns(10);
		
		textC = new JTextField();
		textC.setBounds(115, 118, 203, 20);
		contentPane.add(textC);
		textC.setColumns(10);
		
		
		JLabel lblKQ = new JLabel("Ket Qua");
		lblKQ.setBounds(60, 149, 46, 14);
		contentPane.add(lblKQ);
		
		JTextPane KQ = new JTextPane();
		KQ.setBounds(115, 143, 203, 20);
		contentPane.add(KQ);
		
		JTextPane X1 = new JTextPane();
		X1.setBounds(115, 168, 89, 20);
		contentPane.add(X1);
		
		JTextPane X2 = new JTextPane();
		X2.setBounds(115, 199, 89, 20);
		contentPane.add(X2);
		
		JButton btnTinh = new JButton("Tinh");
		btnTinh.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						String A = textA.getText();	
						String B = textB.getText();	
						String C = textC.getText();	
						
						int a,b,c;
						double kq,x1,x2;
						try
						{
							a = Integer.parseInt(A);
						}
						catch (Exception ex)
						{
							a = 0;
							textA.setText(String.valueOf(a));
						}
						try
						{
							b = Integer.parseInt(B);
						}
						catch (Exception ex)
						{
							b = 0;
							textB.setText(String.valueOf(b));
						}
						try
						{
							c = Integer.parseInt(C);
						}
						catch (Exception ex)
						{
							c = 0;
							textC.setText(String.valueOf(c));
						}
						kq = (b*b) - 4*a*c;
						if (a==0) 
						{
							X1.setText("Vo nghiem");
							X2.setText("Vo nghiem");
						}
						else
						{
							KQ.setText(String.valueOf(kq));
							if (kq<0)
							{
								X1.setText("Vo nghiem");
								X2.setText("Vo nghiem");
							}
							else if (kq==0)
							{
								x1= -(b/(2*a));
								x2= -(b/(2*a));
								X1.setText(String.valueOf(x1));
								X2.setText(String.valueOf(x2));
							}
							else
							{
								x1 = (-b + Math.sqrt(kq))/2*a;
								x2 = (-b - Math.sqrt(kq))/2*a;
								X1.setText(String.valueOf(x1));
								X2.setText(String.valueOf(x2));
							}
						}
					}		
				});
		btnTinh.setBounds(337, 63, 89, 23);
		contentPane.add(btnTinh);
		
		JLabel lblX1 = new JLabel("X1");
		lblX1.setBounds(73, 171, 49, 14);
		contentPane.add(lblX1);
		
		JLabel lblX2 = new JLabel("X2");
		lblX2.setBounds(73, 202, 49, 14);
		contentPane.add(lblX2);
	}
}