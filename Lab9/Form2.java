import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Form2 {
    public Form2(){
        JFrame j = new JFrame("Login");
        Container cp = j.getContentPane();
        cp.setLayout(null);

        JLabel L1 = new JLabel("Name :");
        L1.setBounds(50, 50, 100, 30);
        cp.add(L1);

        JLabel L2 = new JLabel("Car license :");
        L2.setBounds(50, 100, 100, 30);
        cp.add(L2);

        JLabel L3 = new JLabel("Province :");
        L3.setBounds(50, 150, 100, 30);
        cp.add(L3);

        JLabel L4 = new JLabel("Car Type :");
        L4.setBounds(50, 200, 100, 30);
        cp.add(L4);

        JRadioButton r1 = new JRadioButton("Car");
        r1.setBounds(150, 200, 70, 30);
        cp.add(r1);

        JRadioButton r2 = new JRadioButton("Bike");
        r2.setBounds(230, 200, 70, 30);
        cp.add(r2);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        JTextField tfName = new JTextField();
        tfName.setBounds(150, 50, 150, 30);
        cp.add(tfName);
        
        JTextField tfCarLicense = new JTextField();
        tfCarLicense.setBounds(150, 100, 150, 30);
        cp.add(tfCarLicense);

        JComboBox<String> provinceComboBox = new JComboBox<>(getProvinces());
        provinceComboBox.setBounds(150, 150, 150, 30);
        cp.add(provinceComboBox);

        

        JButton loginButton = new JButton("OK");
        loginButton.setBounds(150, 250, 100, 30);
        cp.add(loginButton);  

        // loginButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //     }
        // });
        
        // j.setSize(350, 320);
        // j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // j.setLocationRelativeTo(null);
        // j.setVisible(true);
    }

    // ฟังก์ชันสำหรับอ่านข้อมูลจังหวัดจากไฟล์ CSV
    private String[] getProvinces() {
        List<String> provinces = new ArrayList<>();
        String csvFile = "Thailand_PRV.csv"; // ชื่อไฟล์ CSV ที่เก็บข้อมูลจังหวัด
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length > 1) {
                    provinces.add(data[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return provinces.toArray(new String[0]);
    }
}
