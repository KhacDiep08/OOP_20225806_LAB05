package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame implements ActionListener {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Biến lưu trữ tổng

    // Constructor để khởi tạo giao diện và sự kiện
    public AWTAccumulator() {
        // Thiết lập bố cục cho cửa sổ
        setLayout(new GridLayout(2, 2));

        // Tạo nhãn và ô văn bản để nhập số
        add(new Label("Enter an Integer:"));
        tfInput = new TextField(10);
        add(tfInput);
        // Khi người dùng nhập xong và nhấn Enter, sự kiện sẽ được xử lý
        tfInput.addActionListener(this);

        // Tạo nhãn và ô văn bản để hiển thị tổng
        add(new Label("The Accumulated Sum is:"));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false); // Không cho phép chỉnh sửa ô này
        add(tfOutput);

        // Thiết lập các thuộc tính của cửa sổ
        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    // Phương thức xử lý sự kiện khi người dùng nhập số
    public void actionPerformed(ActionEvent evt) {
        // Lấy giá trị từ ô nhập và chuyển thành số nguyên
        int numberIn = Integer.parseInt(tfInput.getText());
        // Cộng vào tổng hiện tại
        sum += numberIn;
        // Cập nhật giá trị của ô hiển thị tổng
        tfOutput.setText(Integer.toString(sum));
        // Xóa nội dung trong ô nhập để chuẩn bị cho lần nhập tiếp theo
        tfInput.setText("");
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}