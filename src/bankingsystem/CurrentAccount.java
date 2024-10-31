/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bankingsystem;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikhil
 */
public class CurrentAccount extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    String path=null;
    String path2=null;
    public CurrentAccount() {
        initComponents();
        setLocation(150,5);
        setTitle("CURRENT ACCOUNT");
        setSize(1080,750);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtFullName = new javax.swing.JTextField();
        edtDob = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        edtContact = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        edtPan = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        edtAadhar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        edtIncome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtGst = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        edtUsername = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtAddress = new javax.swing.JTextArea();
        edtSet = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        edtPassword = new javax.swing.JPasswordField();
        edtaccn = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        chkShowPassword = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(830, 560));
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(37, 44, 55));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CURRENT ACCOUNT");
        panel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 360, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 80, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PERSONAL INFORMATION");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 57, 250, 33));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FULL NAME :");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 102, -1, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DATE OF BIRTH :");
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 152, -1, 30));

        edtFullName.setBackground(new java.awt.Color(204, 204, 204));
        edtFullName.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        panel1.add(edtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 104, 240, 30));

        edtDob.setBackground(new java.awt.Color(204, 204, 204));
        edtDob.setForeground(new java.awt.Color(153, 153, 153));
        edtDob.setText("YYYY-MM-DD");
        edtDob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtDobFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                edtDobFocusLost(evt);
            }
        });
        edtDob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edtDobMouseClicked(evt);
            }
        });
        panel1.add(edtDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 152, 240, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CONTACT INFORMATION");
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 205, 260, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EMAIL ADDRESS :");
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 248, 177, 30));

        edtEmail.setBackground(new java.awt.Color(204, 204, 204));
        edtEmail.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        edtEmail.setForeground(new java.awt.Color(153, 153, 153));
        edtEmail.setText("email@gmail.com");
        edtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                edtEmailFocusLost(evt);
            }
        });
        edtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtEmailActionPerformed(evt);
            }
        });
        panel1.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 249, 240, 31));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CONTACT NUMBER :");
        panel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 306, -1, -1));

        edtContact.setBackground(new java.awt.Color(204, 204, 204));
        edtContact.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        panel1.add(edtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 301, 240, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("FULL ADDRESS :");
        panel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 367, 150, 26));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("PAN NUMBER :");
        panel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 506, 150, 31));

        edtPan.setBackground(new java.awt.Color(204, 204, 204));
        edtPan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        panel1.add(edtPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 508, 240, 30));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("AADHAAR NUMBER :");
        panel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        edtAadhar.setBackground(new java.awt.Color(204, 204, 204));
        edtAadhar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        panel1.add(edtAadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 240, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ANNUAL INCOME :");
        panel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 588, -1, -1));

        edtIncome.setBackground(new java.awt.Color(204, 204, 204));
        edtIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIncomeActionPerformed(evt);
            }
        });
        panel1.add(edtIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 240, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GSTIN NUMBER :");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 170, 27));

        edtGst.setBackground(new java.awt.Color(204, 204, 204));
        panel1.add(edtGst, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 240, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("USERNAME : ");
        panel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 130, 30));

        edtUsername.setBackground(new java.awt.Color(204, 204, 204));
        panel1.add(edtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 240, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("PASSWORD :");
        panel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 120, 30));

        edtAddress.setBackground(new java.awt.Color(204, 204, 204));
        edtAddress.setColumns(20);
        edtAddress.setRows(5);
        jScrollPane1.setViewportView(edtAddress);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 367, 240, 95));

        edtSet.setBackground(new java.awt.Color(255, 255, 255));
        edtSet.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panel1.add(edtSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, 135, 135));

        jButton1.setBackground(new java.awt.Color(248, 198, 23));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(37, 44, 55));
        jButton1.setText("Browse");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 100, 30));

        edtPassword.setBackground(new java.awt.Color(204, 204, 204));
        panel1.add(edtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 238, 30));

        edtaccn.setEditable(false);
        edtaccn.setBackground(new java.awt.Color(204, 204, 204));
        panel1.add(edtaccn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 238, 30));

        jButton4.setBackground(new java.awt.Color(248, 198, 23));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(37, 44, 55));
        jButton4.setText("Generate");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 80, 25));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ACCOUNT NUMBER :");
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, -1, 34));

        jButton5.setBackground(new java.awt.Color(248, 198, 23));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(37, 44, 55));
        jButton5.setText("SUBMIT");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 645, 120, 30));

        jButton6.setBackground(new java.awt.Color(248, 198, 23));
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(37, 44, 55));
        jButton6.setText("Upload");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, 100, 30));

        chkShowPassword.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        chkShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        chkShowPassword.setText("SHOW PASSWORD");
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });
        panel1.add(chkShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 130, 20));

        jPanel1.setBackground(new java.awt.Color(248, 198, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1060, 5));

        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 1060, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        if (f != null) {
            path = f.getAbsolutePath();
            try {
                BufferedImage bi = ImageIO.read(new File(path));
                Image img = bi.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                edtSet.setIcon(icon);
                path2 = path;
            } catch (IOException ex) {
                Logger.getLogger(CurrentAccount.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error loading image.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No image selected.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         Random random = new Random();
        int accountNumber = 10000000 + random.nextInt(90000000); 
        edtaccn.setText(String.valueOf(accountNumber)); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
           try {
    // Load the database driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Establish the database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
   
    String sql = "INSERT INTO current (account_number, fullname, dob, email, contact, address, pan, aadhar, income, gst, username, password, usertype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
       PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setLong(1, Long.parseLong(edtaccn.getText()));  // Set the account_number
    pstmt.setString(2, edtFullName.getText());  // Set the fullname
    pstmt.setString(3, edtDob.getText());  // Set the date of birth
    pstmt.setString(4, edtEmail.getText());  // Set the email
    pstmt.setLong(5, Long.parseLong(edtContact.getText()));  // Set the contact number
    pstmt.setString(6, edtAddress.getText());  // Set the address
    pstmt.setString(7, edtPan.getText());  // Set the PAN
    pstmt.setLong(8, Long.parseLong(edtAadhar.getText()));  // Set the Aadhar number
    pstmt.setInt(9, Integer.parseInt(edtIncome.getText()));  // Set the income
    pstmt.setString(10, edtGst.getText());  // Set the GST number
    pstmt.setString(11, edtUsername.getText());  // Set the username
    pstmt.setString(12, edtPassword.getText());  // Set the password
    pstmt.setString(13, "current");  // Set the user type to "current" instead of "savings"
    
    if (path2 == null || path2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an image before uploading.");
            return;
        }
    pstmt.executeUpdate();

    // Notify the user that the form has been submitted successfully
    JOptionPane.showMessageDialog(null, "FORM SUBMITTED");
    
    MainLogin ml=new MainLogin();
            ml.show();
            dispose();

    // Close the database connection
    conn.close();

} catch (Exception e) {
    // Show an error message in case of an exception
    JOptionPane.showMessageDialog(null, e);
}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         if (path2 == null || path2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an image before uploading.");
            return;
        }

       String sql = "INSERT INTO tr(image, acc_number, usertype, username) VALUES (?, ?, ?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            PreparedStatement pst = conn.prepareStatement(sql);

            try (InputStream is = new FileInputStream(new File(path2))) {
                pst.setBlob(1, is);
                pst.setString(2,edtaccn.getText());
                pst.setString(3, "current");
                pst.setString(4,edtUsername.getText());

                pst.execute();

                JOptionPane.showMessageDialog(null, "Photo Successfully Uploaded");
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "MySQL Driver not found.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reading the image file.");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
        // TODO add your handling code here:
        if (chkShowPassword.isSelected()) {
                    edtPassword.setEchoChar((char) 0); // Show the password
                } else {
                    edtPassword.setEchoChar('*'); // Hide the password
                }
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    private void edtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtEmailActionPerformed
        // TODO add your handling code here:
//        String email = edtEmail.getText();
//
//if (email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".")) {
//   
//    JOptionPane.showMessageDialog(null, "Valid Email!", "Email Validation", JOptionPane.INFORMATION_MESSAGE);
//    
//} else {
//    JOptionPane.showMessageDialog(null, "Invalid Email!", "Email Validation", JOptionPane.ERROR_MESSAGE);
//    
//    return;  
//}

String email = edtEmail.getText();

if ((email.contains("@gmail.com") || email.contains("@yahoo.com")) && email.indexOf("@") < email.lastIndexOf(".")) {
    JOptionPane.showMessageDialog(null, "Valid Email!", "Email Validation", JOptionPane.INFORMATION_MESSAGE);
} else {
    JOptionPane.showMessageDialog(null, "Invalid Email!", "Email Validation", JOptionPane.ERROR_MESSAGE);
    return;
}

    }//GEN-LAST:event_edtEmailActionPerformed

    private void edtDobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtDobMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDobMouseClicked

    private void edtDobFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtDobFocusGained
        // TODO add your handling code here:
        if (edtDob.getText().equals("YYYY-MM-DD")) {
        edtDob.setText(""); 
        edtDob.setForeground(Color.BLACK);
         }
    }//GEN-LAST:event_edtDobFocusGained

    private void edtDobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtDobFocusLost
        // TODO add your handling code here:
        if(edtDob.getText().equals("")){
             edtDob.setText("YYYY-MM-DD");
        edtDob.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_edtDobFocusLost

    private void edtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtEmailFocusGained
        // TODO add your handling code here:
        if (edtEmail.getText().equals("email@gmail.com")) {
        edtEmail.setText(""); 
        edtEmail.setForeground(Color.BLACK);
         }
    }//GEN-LAST:event_edtEmailFocusGained

    private void edtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtEmailFocusLost
        // TODO add your handling code here:
         if(edtEmail.getText().equals("")){
             edtEmail.setText("email@gmail.com");
        edtEmail.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_edtEmailFocusLost

    private void edtIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtIncomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtIncomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CurrentAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrentAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JTextField edtAadhar;
    private javax.swing.JTextArea edtAddress;
    private javax.swing.JTextField edtContact;
    private javax.swing.JTextField edtDob;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtFullName;
    private javax.swing.JTextField edtGst;
    private javax.swing.JTextField edtIncome;
    private javax.swing.JTextField edtPan;
    private javax.swing.JPasswordField edtPassword;
    private javax.swing.JLabel edtSet;
    private javax.swing.JTextField edtUsername;
    private javax.swing.JTextField edtaccn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
