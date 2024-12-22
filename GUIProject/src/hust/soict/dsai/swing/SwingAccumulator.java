package hust.soict.dsai.swing;

import javax.swing.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Khai báo các thành phần giao diện
    private JTextField tfInput;  // Ô nhập liệu
    private JTextField tfOutput; // Ô hiển thị kết quả
    private int sum = 0;        // Biến lưu trữ tổng

    // Hàm khởi tạo giao diện
    public SwingAccumulator() {
        // Tạo một container để chứa các thành phần
        Container cp = getContentPane();
        // Thiết lập bố cục cho container
        cp.setLayout(new GridLayout(2, 2));

        // Tạo nhãn và ô nhập liệu
        cp.add(new JLabel("Nhập một số nguyên: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);
        // Thêm một listener để lắng nghe sự kiện khi người dùng nhập số
        tfInput.addActionListener(new TFInputListener());

        // Tạo nhãn và ô hiển thị kết quả
        cp.add(new JLabel("Tổng các số là: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); // Không cho phép chỉnh sửa ô này
        cp.add(tfOutput);

        // Thiết lập tiêu đề, kích thước và hiển thị cửa sổ
        setTitle("Tính tổng");
        setSize(350, 120);
        setVisible(true);
    }

    // Lớp lắng nghe sự kiện khi người dùng nhập số
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Lấy giá trị từ ô nhập liệu và chuyển đổi thành số nguyên
            int numberIn = Integer.parseInt(tfInput.getText());

            // Cộng giá trị vừa nhập vào tổng
            sum += numberIn;

            // Xóa nội dung ô nhập liệu và cập nhật kết quả vào ô hiển thị
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }

    // Phương thức main để khởi chạy chương trình
    public static void main(String[] args) {
        new SwingAccumulator();
    }
}
