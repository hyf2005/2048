package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


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


        JPasswordField password = new JPasswordField();
        password.setLocation(280, 185);
        password.setSize(250, 30);
        this.getContentPane().add(password);

        //登录
        JButton login = new JButton("登录");
        login.setLocation(180, 300);
        login.setSize(100, 50);
        this.getContentPane().add(login);
        login.addActionListener(e -> {
            System.out.println("login");
            String usernamestr = username.getText();
            String passwordstr = password.getText();
            login(usernamestr, passwordstr);
        });

        //注册
        JButton register = new JButton("注册");
        register.setLocation(330, 300);
        register.setSize(100, 50);
        this.getContentPane().add(register);
        register.addActionListener(e -> {
            System.out.println("register");
            register();
        });


        JButton guestLogin = new JButton("游客登录");
        guestLogin.setLocation(430,400);
        guestLogin.setSize(120,30);
        this.getContentPane().add(guestLogin);
        guestLogin.addActionListener(e -> {
            this.dispose();
            GameFrame gameFrame = new GameFrame(700, 500);
            gameFrame.setVisible(true);
        });

    }

    private void initJFrame() {
        this.setTitle("Login");
        this.setLayout(null);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
    }


    private void login(String usernamestr, String passwordstr) {
        File file = new File("C:\\Users\\94875\\IdeaProjects\\untitled4\\src\\userinfo.txt");
        ArrayList<String> list = readString(file);
        System.out.println(list);
        if (usernamestr.isEmpty() ){
            JOptionPane.showMessageDialog(this, "请输入用户名", "用户名", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (passwordstr.isEmpty() ){
            JOptionPane.showMessageDialog(this, "请输入密码" , "密码", JOptionPane.ERROR_MESSAGE);
            return;
        }
            for (int i = 0; i < list.size(); i++) {
                String[] strings = list.get(i).split("&");
                if (strings[0].equals(usernamestr) && strings[1].equals(passwordstr)) {
                    this.dispose();
                    GameFrame gameFrame = new GameFrame(700, 500);
                    gameFrame.setVisible(true);
                    return;
                }
            }
        JOptionPane.showMessageDialog(this, "用户名或密码错误", "用户名或密码错误", JOptionPane.ERROR_MESSAGE);


    }

    private void register() {
        this.dispose();
        RegisterFrame registerFrame = new RegisterFrame();
        registerFrame.setVisible(true);

    }

    public static ArrayList<String> readString(File file) {
        ArrayList<String> list = new ArrayList<>();
        try {
            // 构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            // 使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                list.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

