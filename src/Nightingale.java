/*
 * Name: Lyanna Marie Z. Padillo
 * Date: March 10, 2022
 * Description: this program will serve as a personal checker, recorder, and reminder 
 * for its user. Using the program allows you to create a mini profile where users can 
 * provide their name, sex, and birthdate. Then, it will ask you about your prescription 
 * details which will help the program organize it better. This shall help you keep track 
 * of your medications and follow your doctor’s prescription until a specific period.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Nightingale {

    public static void main(String[] args) {
        ArrayList<String> mornpers = new ArrayList<String>();
        ArrayList<String> aftpers = new ArrayList<String>();
        ArrayList<String> evepers = new ArrayList<String>();

        //main frame
        JFrame frame = new JFrame("Nightingale");
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /////Name Text
        JLabel namelabel = new JLabel("Name", JLabel.CENTER);
        namelabel.setBounds(0,100,400,30);
        namelabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(namelabel);

        JLabel sexlabel = new JLabel("Sex", JLabel.CENTER);
        sexlabel.setBounds(0,180,400,30);
        sexlabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(sexlabel);

        JLabel bdatelabel = new JLabel("Birthdate", JLabel.CENTER);
        bdatelabel.setBounds(0,320,400,30);
        bdatelabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(bdatelabel);

        JLabel bdateformatlabel = new JLabel("MM/DD/YYYY", JLabel.CENTER);
        bdateformatlabel.setBounds(0,380,400,10);
        bdateformatlabel.setFont(new Font("Arial", Font.BOLD, 10));
        frame.add(bdateformatlabel);

        JTextField nametextField = new JTextField();
        nametextField.setBounds(100, 130, 200, 30);
        nametextField.setHorizontalAlignment(JTextField.CENTER);
        frame.add(nametextField);

        ButtonGroup sexBtng = new ButtonGroup();

        JRadioButton maleRbtn = new JRadioButton("Male");
        maleRbtn.setHorizontalAlignment(JRadioButton.CENTER);
        maleRbtn.setBounds(0, 210, 400, 30);
        sexBtng.add(maleRbtn);
        frame.add(maleRbtn);

        JRadioButton femaleRbtn = new JRadioButton("Female");
        femaleRbtn.setHorizontalAlignment(JRadioButton.CENTER);
        femaleRbtn.setBounds(0, 240, 400, 30);
        sexBtng.add(femaleRbtn);
        frame.add(femaleRbtn);

        JRadioButton nsRbtn = new JRadioButton("Others");
        nsRbtn.setHorizontalAlignment(JRadioButton.CENTER);
        nsRbtn.setBounds(0, 270, 400, 30);
        sexBtng.add(nsRbtn);
        frame.add(nsRbtn);

        JTextField bdatetextField = new JTextField();
        bdatetextField.setBounds(100, 350, 200, 30);
        bdatetextField.setHorizontalAlignment(JTextField.CENTER);
        frame.add(bdatetextField);

        JButton regBtn = new JButton("Register");
        regBtn.setBounds(125, 420, 150 , 50);
        regBtn.setBackground(Color.decode("#C0C0F2"));
        regBtn.setOpaque(true);
        regBtn.setBorderPainted(false);
        frame.add(regBtn);

        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String bdate = bdatetextField.getText();

                boolean isValid;

                //date checking
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                sdf.setLenient(false);
                try {
                    sdf.parse(bdate);
                    isValid = true;
                } catch (Exception e) {
                    isValid = false;
                }

                //input validation
                if(nametextField.getText().equals("") || bdatetextField.getText().equals("") || (!maleRbtn.isSelected() && !femaleRbtn.isSelected() && !nsRbtn.isSelected())){
                    JOptionPane.showMessageDialog(null, "Please fill up the necessary information");
                }else if(!isValid){
                    JOptionPane.showMessageDialog(null, "Invalid Birthdate");
                    bdatetextField.setText("");
                }else{
                    frame.dispose();

                    //new frame
                    JFrame frame1 = new JFrame("Nightingale");
                    frame1.setSize(400, 400);
                    frame1.setResizable(false);
                    frame1.setLocationRelativeTo(null);
                    frame1.setLayout(null);
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JLabel datelabel = new JLabel("Enter the Starting Date", JLabel.CENTER);
                    datelabel.setBounds(0,100,400,30);
                    datelabel.setFont(new Font("Arial", Font.BOLD, 20));
                    frame1.add(datelabel);

                    JTextField datetextField = new JTextField();
                    datetextField.setBounds(100, 150, 200, 30);
                    datetextField.setHorizontalAlignment(JTextField.CENTER);
                    frame1.add(datetextField);

                    JButton conBtn = new JButton("Continue");
                    conBtn.setBounds(125, 200, 150 , 50);
                    conBtn.setBackground(Color.decode("#C0C0F2"));
                    conBtn.setOpaque(true);
                    conBtn.setBorderPainted(false);
                    frame1.add(conBtn);

                    conBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {

                            boolean isValid;

                            //date validation
                            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                            sdf.setLenient(false);
                            try {
                                sdf.parse(datetextField.getText());
                                isValid = true;
                            } catch (Exception e) {
                                isValid = false;
                            }

                            //input validation and error messages
                            if(datetextField.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Please input the necessary information.");
                            }
                            else if(!isValid){
                                JOptionPane.showMessageDialog(null, "Invalid Date Input");
                            }else{
                                final boolean[] isDone = {true};


                                frame1.dispose();

                                //new frame
                                JFrame frame2 = new JFrame("Nightingale");
                                frame2.setSize(400, 400);
                                frame2.setResizable(false);
                                frame2.setLocationRelativeTo(null);
                                frame2.setLayout(null);
                                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                JLabel label = new JLabel("Enter Your Morning Prescription: ", JLabel.CENTER);
                                label.setBounds(0,100,400,30);
                                label.setFont(new Font("Arial", Font.BOLD, 20));
                                frame2.add(label);

                                JTextField prestextField = new JTextField();
                                prestextField.setBounds(100, 150, 200, 30);
                                prestextField.setHorizontalAlignment(JTextField.CENTER);
                                frame2.add(prestextField);

                                JButton addBtn = new JButton("Add");
                                addBtn.setBounds(85, 200, 100 , 50);
                                addBtn.setBackground(Color.decode("#C0C0F2"));
                                addBtn.setOpaque(true);
                                addBtn.setBorderPainted(false);
                                frame2.add(addBtn);

                                JButton canBtn = new JButton("Continue");
                                canBtn.setBounds(200, 200, 110 , 50);
                                canBtn.setBackground(Color.decode("#C0C0F2"));
                                canBtn.setOpaque(true);
                                canBtn.setBorderPainted(false);
                                frame2.add(canBtn);

                                addBtn.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        //add to arraylist
                                        mornpers.add(prestextField.getText());
                                        prestextField.setText("");
                                    }
                                });

                                canBtn.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        frame2.dispose();

                                        //new frame
                                        JFrame frame3 = new JFrame("Nightingale");
                                        frame3.setSize(400, 400);
                                        frame3.setResizable(false);
                                        frame3.setLocationRelativeTo(null);
                                        frame3.setLayout(null);
                                        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                        JLabel label = new JLabel("Enter Your Afternoon Prescription: ", JLabel.CENTER);
                                        label.setBounds(0,100,400,30);
                                        label.setFont(new Font("Arial", Font.BOLD, 20));
                                        frame3.add(label);

                                        JTextField prestextField = new JTextField();
                                        prestextField.setBounds(100, 150, 200, 30);
                                        prestextField.setHorizontalAlignment(JTextField.CENTER);
                                        frame3.add(prestextField);

                                        JButton addBtn = new JButton("Add");
                                        addBtn.setBounds(85, 200, 100 , 50);
                                        addBtn.setBackground(Color.decode("#C0C0F2"));
                                        addBtn.setOpaque(true);
                                        addBtn.setBorderPainted(false);
                                        frame3.add(addBtn);

                                        JButton canBtn = new JButton("Continue");
                                        canBtn.setBounds(200, 200, 110 , 50);
                                        canBtn.setBackground(Color.decode("#C0C0F2"));
                                        canBtn.setOpaque(true);
                                        canBtn.setBorderPainted(false);
                                        frame3.add(canBtn);

                                        addBtn.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                //add to arraylist
                                                aftpers.add(prestextField.getText());
                                                prestextField.setText("");
                                            }
                                        });

                                        canBtn.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                frame3.dispose();

                                                //new frame
                                                JFrame frame4 = new JFrame("Nightingale");
                                                frame4.setSize(400, 400);
                                                frame4.setResizable(false);
                                                frame4.setLocationRelativeTo(null);
                                                frame4.setLayout(null);
                                                frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                                JLabel label = new JLabel("Enter Your Evening Prescription: ", JLabel.CENTER);
                                                label.setBounds(0,100,400,30);
                                                label.setFont(new Font("Arial", Font.BOLD, 20));
                                                frame4.add(label);

                                                JTextField prestextField = new JTextField();
                                                prestextField.setBounds(100, 150, 200, 30);
                                                prestextField.setHorizontalAlignment(JTextField.CENTER);
                                                frame4.add(prestextField);

                                                JButton addBtn = new JButton("Add");
                                                addBtn.setBounds(85, 200, 100 , 50);
                                                addBtn.setBackground(Color.decode("#C0C0F2"));
                                                addBtn.setOpaque(true);
                                                addBtn.setBorderPainted(false);
                                                frame4.add(addBtn);

                                                JButton canBtn = new JButton("Continue");
                                                canBtn.setBounds(200, 200, 110 , 50);
                                                canBtn.setBackground(Color.decode("#C0C0F2"));
                                                canBtn.setOpaque(true);
                                                canBtn.setBorderPainted(false);
                                                frame4.add(canBtn);

                                                addBtn.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                        //add to arraylist
                                                        evepers.add(prestextField.getText());
                                                        prestextField.setText("");
                                                    }
                                                });

                                                canBtn.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                        frame4.dispose();

                                                        //new frame

                                                        JFrame frame5 = new JFrame("Nightingale");
                                                        frame5.setSize(600, 600);
                                                        frame5.setResizable(false);
                                                        frame5.setLocationRelativeTo(null);
                                                        frame5.setLayout(null);
                                                        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                                        JLabel datelabel = new JLabel("Enter the Date");
                                                        datelabel.setBounds(50,50,200,30);
                                                        datelabel.setFont(new Font("Arial", Font.BOLD, 20));
                                                        frame5.add(datelabel);

                                                        JTextField datetextField1 = new JTextField();
                                                        datetextField1.setBounds(300, 50, 200, 30);
                                                        datetextField1.setHorizontalAlignment(JTextField.CENTER);
                                                        frame5.add(datetextField1);

                                                        String[] languages ={"MORNING", "AFTERNOON", "EVENING"};
                                                        final JComboBox cb=new JComboBox(languages);
                                                        cb.setBounds(250,100,130,20);
                                                        cb.setSelectedItem("MORNING");
                                                        frame5.add(cb);

                                                        JButton regBtn = new JButton("View");
                                                        regBtn.setBounds(225, 150, 150 , 40);
                                                        regBtn.setBackground(Color.decode("#C0C0F2"));
                                                        regBtn.setOpaque(true);
                                                        regBtn.setBorderPainted(false);
                                                        frame5.add(regBtn);

                                                        JButton exBtn = new JButton("Exit");
                                                        exBtn.setBounds(225, 430, 150 , 50);
                                                        exBtn.setBackground(Color.decode("#9DB6CC"));
                                                        exBtn.setOpaque(true);
                                                        exBtn.setBorderPainted(false);
                                                        frame5.add(exBtn);

                                                        ///Table Set-up
                                                        JScrollPane sp = new JScrollPane();
                                                        sp.setBounds(140,205,300,200);
                                                        frame5.add(sp);

                                                        JTable table1 = new JTable();
                                                        DefaultTableModel model = new DefaultTableModel();

                                                        Object[] column = {"Prescriptions"}; 
                                                        Object[] row = new Object[1];
                                                        model.setColumnIdentifiers(column);
                                                        table1.setPreferredSize(new Dimension(500, 200));
                                                        table1.setModel(model);
                                                        sp.setViewportView(table1);
                                                        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                                                        regBtn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                                //date comparing
                                                                int result = datetextField1.getText().compareTo(datetextField.getText());
                                                                int rowCo = table1.getRowCount();

                                                                for(int i=0; i<rowCo; i++){
                                                                    model.removeRow(0);
                                                                }

                                                                //date validation
                                                                if(result < 0){
                                                                    row[0] = "No prescriptions";
                                                                    model.addRow(row);
                                                                }else{
                                                                    if(cb.getSelectedItem().equals("MORNING")) {
                                                                        //check if arraylist has element
                                                                        if (mornpers.size() <= 0) {
                                                                            row[0] = "No prescriptions";
                                                                            model.addRow(row);
                                                                        } else{
                                                                            //extract array elements and put it to table
                                                                            for (int i = 0; i < mornpers.size(); i++) {
                                                                                row[0] = mornpers.get(i);
                                                                                model.addRow(row);
                                                                            }
                                                                        }
                                                                    }else if(cb.getSelectedItem().equals("AFTERNOON")){
                                                                        //check if arraylist has element
                                                                        if (aftpers.size() <= 0) {
                                                                            row[0] = "No prescriptions";
                                                                            model.addRow(row);
                                                                        } else {
                                                                            //extract array elements and put it to table
                                                                            for (int i = 0; i < aftpers.size(); i++) {
                                                                                row[0] = aftpers.get(i);
                                                                                model.addRow(row);
                                                                            }
                                                                        }
                                                                    }else if(cb.getSelectedItem().equals("EVENING")){
                                                                        //check if arraylist has element
                                                                        if (evepers.size() <= 0) {
                                                                            row[0] = "No prescriptions";
                                                                            model.addRow(row);
                                                                        } else {
                                                                            //extract array elements and put it to table
                                                                            for (int i = 0; i < evepers.size(); i++) {
                                                                                row[0] = evepers.get(i);
                                                                                model.addRow(row);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        });
                                                        //exit button
                                                        exBtn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                                frame5.dispose();
                                                            }
                                                        });

                                                        frame5.setVisible(true);
                                                    }
                                                });

                                                frame4.setVisible(true);
                                            }
                                        });

                                        frame3.setVisible(true);
                                    }
                                });

                                frame2.setVisible(true);
                            }
                        }
                    });

                    frame1.setVisible(true);
                }
            }
        });

        frame.setVisible(true);
    }
}
