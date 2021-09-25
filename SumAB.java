import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SumAB {
	public static void main(String[] args) {
		Frame fr = new Frame("Tong 2 so a b: ");
		fr.setSize(600, 400);
		fr.setLocationRelativeTo(null);
		fr.setLayout(null);
		fr.setResizable(false);
		
		Label lblA = new Label("A: ");
		Label lblB = new Label("B: ");
		Label lblKQ = new Label("Ket Qua: ");
		
		TextField txtA = new TextField();
		TextField txtB = new TextField();
		TextField txtKQ = new TextField();
		
		txtKQ.setEditable(false);
		
		Button btnCong = new Button("Tinh Tong: ");
		
		fr.add(lblA); fr.add(txtA);
		fr.add(lblB); fr.add(txtB);
		fr.add(lblKQ); fr.add(txtKQ);
		fr.add(btnCong);
		
		lblA.setLocation(200, 80);
		lblA.setSize(20, 20);
		txtA.setLocation(230, 80);
		txtA.setSize(160, 20);

		lblB.setLocation(200, 140);
		lblB.setSize(20, 20);
		txtB.setLocation(230, 140);
		txtB.setSize(160, 20);

		btnCong.setLocation(275, 220);
		btnCong.setSize(80, 30);

		lblKQ.setLocation(160, 300);
		lblKQ.setSize(50, 20);
		txtKQ.setLocation(230, 300);
		txtKQ.setSize(160, 20);

		ActionListener bolangnghe = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code xu li
				//1. Lay a, b
				String strA = txtA.getText();
				String strB = txtB.getText();
				//Doi sang con so de tinh toan
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);
				//Tinh Tong
				int c = a+b;
				//Xuat KQ
				txtKQ.setText(String.valueOf(c));
			}
		};
		btnCong.addActionListener(bolangnghe);
		
		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		fr.setVisible(true);
	}
}
