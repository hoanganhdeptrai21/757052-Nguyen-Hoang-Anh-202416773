import javax.swing.JOptionPane;
public class HelloName{
	public static void main(String[] args){
		String result;
		result = JOptionPane.showInputDialog("Nhap ten: ");
		JOptionPane.showMessageDialog(null, "hi" + result + "!" );
		System.exit(0);
}
}