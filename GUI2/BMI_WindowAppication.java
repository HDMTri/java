package BMI;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class BMI {
	public static void main(String[] args) {
		Frame fr = new Frame("Chi So BMI: ");
		fr.setSize(600, 400);
		fr.setLocationRelativeTo(null);
		fr.setLayout(null);
		fr.setResizable(false);
		
		Label lblA = new Label("Chieu cao: ");
		Label lblB = new Label("Can nang: ");
		Label lblKQ = new Label("BMI: ");
		
		TextField txtA = new TextField();
		TextField txtB = new TextField();
		TextField txtKQ = new TextField();
		
		txtKQ.setEditable(false);
		
		Button btnCong = new Button("Tinh BMI: ");
		
		fr.add(lblA); fr.add(txtA);
		fr.add(lblB); fr.add(txtB);
		fr.add(lblKQ); fr.add(txtKQ);
		fr.add(btnCong);
		
		lblA.setLocation(140, 80);
		lblA.setSize(70, 20);
		txtA.setLocation(230, 80);
		txtA.setSize(160, 20);

		lblB.setLocation(140, 140);
		lblB.setSize(70, 20);
		txtB.setLocation(230, 140);
		txtB.setSize(160, 20);

		btnCong.setLocation(275, 220);
		btnCong.setSize(80, 30);

		lblKQ.setLocation(160, 300);
		lblKQ.setSize(50, 20);
		txtKQ.setLocation(230, 300);
		txtKQ.setSize(200, 20);

		ActionListener bolangnghe = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                
                double weight=Double.parseDouble(txtB.getText());
                double height=Double.parseDouble(txtA.getText());
                
                double bmi = weight / (height*height);
 
                 if (bmi < 18.5) {
                	 txtKQ.setText("Thieu Can - BMI : "+bmi);
                 } else if (bmi < 25) {
                	 txtKQ.setText("Binh Thuong - BMI : "+bmi);
                 } else if (bmi < 30) {
                	 txtKQ.setText("Thua Can - BMI : "+bmi);
                 } else {
                	 txtKQ.setText("Beo Phi - BMI : "+bmi);
                 }
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