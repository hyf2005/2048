package view;

import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {
    public LoginFrame() {
        initJFrame();
        initview();
    }

    private void initview() {
        JLabel usernameText = new JLabel("用户名");
        Font font1 = new Font("serif", Font.ITALIC, 22);
        usernameText.setFont(font1);
        usernameText.setLocation(180, 100);
        usernameText.setSize(100, 100);
        this.getContentPane().add(usernameText);

        JTextField username = new JTextField();
        username.setLocation(280, 138);
        username.setSize(250, 30);
        this.getContentPane().add(username);

        JLabel passwordText = new JLabel("密码");
        Font font2 = new Font("serif", Font.ITALIC, 22);
        passwordText.setFont(font2);
        passwordText.setLocation(180, 150);
        passwordText.setSize(100, 100);
        this.getContentPane().add(passwordText);

        JTextField password = new JTextField();
        password.setLocation(280, 185);
        password.setSize(250, 30);
        this.getContentPane().add(password);

        JButton login = new JButton("登录");
        login.setLocation(180, 300);
        login.setSize(100,50);
        this.getContentPane().add(login);

        JButton register = new JButton("注册");
        register.setLocation(330, 300);
        register.setSize(100,50);
        this.getContentPane().add(register);

    }

    private void initJFrame() {
        this.setTitle("Login");
        this.setLayout(null);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
    }
}
