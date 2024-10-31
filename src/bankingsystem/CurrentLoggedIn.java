/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author ACER
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import net.proteanit.sql.DbUtils;

import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class CurrentLoggedIn extends javax.swing.JFrame {

    private static boolean isBalanceVisible = true; 
    private static String actualBalance = "";
    
   File selectedFile;
   
   private Connection connection;
    ResultSet rs;   
    Connection conn;
    PreparedStatement pstmt;


    
   
      public void setTextInEdtun(String value) {
        edtun.setText(value); 
    }
      
        public void setTextInedtfn(String value) {
        edtfn.setText(value); 
    }
         public void setTextInedtdob(String value) {
        edtdob.setText(value); 
    }
          public void setTextInedtem(String value) {
        edtem.setText(value); 
    }
          public void setTextInedtcn(String value) {
        edtcn.setText(value); 
    }
           public void setTextInedtads(String value) {
        edtads.setText(value); 
    }
            public void setTextInedtpn(String value) {
        edtpn.setText(value); 
    }
            public void setTextInedtan(String value) {
        edtan.setText(value); 
    }
             public void setTextInedtai(String value) {
        edtai.setText(value); 
    }
             public void setTextInedtaccn(String value) {
        edtaccn.setText(value);
        edtaccn2.setText(value);
         edtaccn3.setText(value);
    }
             
              public void setTextInedtlblun(String value) {
        lblusername.setText(value); 
    }        
             public void setTextInedtaccn2(String value) {
        edtaccn2.setText(value); 
    }
            public void setTextInedtgst(String value) {
        edtgst.setText(value); 
    } 
            public void setTextInedtaccn3(String value) {
        edtaccn3.setText(value); 
    }
            
            public void setProfileImageIcon(ImageIcon icon) {
        edtSet1.setIcon(icon);
    }

             
         
    public CurrentLoggedIn() {
    initComponents();
        setLocation(150,5);
        setSize(1060,750);
        setTitle("SavingsLoggedIn");
        currentdateTime1();
        balanceLabel.setText("ACCOUNT BALANCE: XXXX.XX" );
//         loadAccountBalance();
//        loadProfileImage(edtun.getText());

    }
//       private void loadProfileImage(String username) {
//        String sql12 = "SELECT image FROM tr WHERE username = ?";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "Bank@123");
//
//            PreparedStatement ps = conn.prepareStatement(sql12);
//            ps.setString(1, username);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                Blob blob = rs.getBlob("image");
//
//                InputStream inputStream = blob.getBinaryStream();
//                BufferedImage bufferedImage = ImageIO.read(inputStream);
//
//                if (bufferedImage != null) {
//                    Image img = bufferedImage.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
//                    ImageIcon icon = new ImageIcon(img);
//
//                    // Set the image on edtSet1 (the JLabel in this page)
//                    edtSet1.setIcon(icon);
//                } else {
//                    JOptionPane.showMessageDialog(this, "Could not load the image.");
//                }
//
//                inputStream.close();
//            }
////            } else {
////                JOptionPane.showMessageDialog(this, "No image found for the specified username.");
////            }
//
//            rs.close();
//            ps.close();
//            conn.close();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//       }
    
//      private void loadAccountBalance() {
//        String accNumText = edtaccn.getText().trim(); // Get the account number and trim whitespace
//        int accountNumber;
//        System.out.println("Input Account Number: " + accNumText);
//        
//        try {
//        accountNumber = Integer.parseInt(accNumText); // Attempt to convert to int
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(null, "Invalid account number format. Please enter a valid number.");
//        return; // Exit the method early if parsing fails
//    }
//
//        try {
//            accountNumber = Integer.parseInt(accNumText); 
//            String sql = "SELECT account_balance FROM deposit WHERE account_number = ?";
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "Bank@123");
//
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, accountNumber); 
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                double balance = rs.getDouble("account_balance");
//                balanceLabel.setText("Account Balance: " + balance);
//            } else {
//                JOptionPane.showMessageDialog(this, "No account found for the specified account number.");
//            }
//
//            rs.close();
//            ps.close();
//            conn.close();
//
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Invalid account number format.");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//    }
//      
      
     public void currentdateTime1() {
         
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss ");
     LocalDateTime now = LocalDateTime.now();
     edtdatetime.setText(dtf.format(now));
     edtdatetime3.setText(dtf.format(now));
     }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        edtaccn = new javax.swing.JTextField();
        edtfn = new javax.swing.JTextField();
        edtdob = new javax.swing.JTextField();
        edtem = new javax.swing.JTextField();
        edtcn = new javax.swing.JTextField();
        edtads = new javax.swing.JTextField();
        edtpn = new javax.swing.JTextField();
        edtan = new javax.swing.JTextField();
        edtai = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        edtSet1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        edtun = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        edtgst = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        edtdatetime3 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        edtaccn2 = new javax.swing.JTextField();
        edtamount = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        edtdatetime = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        balanceLabel = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        edtbenaccount = new javax.swing.JTextField();
        amt = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        edtacbn = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        edtname = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        edtaccn3 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        chkShowPassword = new javax.swing.JCheckBox();
        lboldpass = new javax.swing.JPasswordField();
        txtnewpass = new javax.swing.JPasswordField();
        lblcnfpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(37, 44, 55));
        jPanel3.setPreferredSize(new java.awt.Dimension(1060, 462));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("USERNAME");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 47, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("FULLNAME");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 117, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DATE OF BIRTH");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 263, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("EMAIL ID");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 343, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ADDRESS");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CONTACT NO.");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 419, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("PAN NUMBER");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 504, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("AADHAR NUMBER");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 267, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ANNUAL INCOME");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 343, -1, -1));

        edtaccn.setEditable(false);
        edtaccn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        edtaccn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtaccnActionPerformed(evt);
            }
        });
        jPanel3.add(edtaccn, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 190, 311, -1));

        edtfn.setEditable(false);
        edtfn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtfnActionPerformed(evt);
            }
        });
        jPanel3.add(edtfn, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 113, 250, 30));

        edtdob.setEditable(false);
        edtdob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtdobActionPerformed(evt);
            }
        });
        jPanel3.add(edtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 263, 250, 30));

        edtem.setEditable(false);
        edtem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtemActionPerformed(evt);
            }
        });
        jPanel3.add(edtem, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 339, 250, 30));

        edtcn.setEditable(false);
        edtcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtcnActionPerformed(evt);
            }
        });
        jPanel3.add(edtcn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 415, 250, 30));

        edtads.setEditable(false);
        edtads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtadsActionPerformed(evt);
            }
        });
        jPanel3.add(edtads, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 250, 97));

        edtpn.setEditable(false);
        edtpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtpnActionPerformed(evt);
            }
        });
        jPanel3.add(edtpn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 250, 30));

        edtan.setEditable(false);
        edtan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtanActionPerformed(evt);
            }
        });
        jPanel3.add(edtan, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 263, 250, 30));

        edtai.setEditable(false);
        edtai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtaiActionPerformed(evt);
            }
        });
        jPanel3.add(edtai, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 339, 250, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 614, 90, 30));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 614, 90, 30));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Log Out");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1001, 0, 60, 30));

        edtSet1.setBackground(new java.awt.Color(255, 255, 255));
        edtSet1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(248, 198, 23)));
        edtSet1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edtSet1MouseClicked(evt);
            }
        });
        jPanel3.add(edtSet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 135, 135));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ACCOUNT NUMBER");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 196, 230, 30));

        edtun.setEditable(false);
        edtun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtunActionPerformed(evt);
            }
        });
        jPanel3.add(edtun, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 43, 250, 30));

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setText("Edit");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, -1));

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton10.setText("Upload");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 50, -1));

        edtgst.setEditable(false);
        jPanel3.add(edtgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, 250, 40));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Date and Time");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("GSTIN");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 100, 30));

        edtdatetime3.setEditable(false);
        edtdatetime3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        edtdatetime3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtdatetime3ActionPerformed(evt);
            }
        });
        jPanel3.add(edtdatetime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 240, -1));

        jTabbedPane1.addTab("PROFILE ", jPanel3);

        jPanel11.setBackground(new java.awt.Color(37, 44, 55));
        jPanel11.setLayout(null);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Account number");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(20, 170, 159, 37);

        edtaccn2.setEditable(false);
        edtaccn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtaccn2ActionPerformed(evt);
            }
        });
        jPanel11.add(edtaccn2);
        edtaccn2.setBounds(230, 170, 250, 30);
        jPanel11.add(edtamount);
        edtamount.setBounds(230, 270, 250, 30);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Deposit Amount");
        jPanel11.add(jLabel38);
        jLabel38.setBounds(20, 270, 161, 29);

        jButton12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton12.setText("Deposit");
        jButton12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton12);
        jButton12.setBounds(310, 340, 80, 30);

        edtdatetime.setEditable(false);
        edtdatetime.setBackground(new java.awt.Color(255, 255, 255));
        edtdatetime.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jPanel11.add(edtdatetime);
        edtdatetime.setBounds(230, 80, 250, 30);

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Date and Time");
        jPanel11.add(jLabel39);
        jLabel39.setBounds(20, 80, 160, 29);

        balanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        balanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        balanceLabel.setText("                  ACCOUNT BALANCE");
        balanceLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(248, 198, 23)));
        balanceLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                balanceLabelMouseClicked(evt);
            }
        });
        jPanel11.add(balanceLabel);
        balanceLabel.setBounds(560, 140, 340, 80);

        jToggleButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jToggleButton1.setText("Show Balance");
        jToggleButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel11.add(jToggleButton1);
        jToggleButton1.setBounds(680, 240, 130, 30);

        jTabbedPane1.addTab("DEPOSIT", jPanel11);

        jPanel8.setBackground(new java.awt.Color(37, 44, 55));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Account Balance");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Account number");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Enter Amount");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 30));

        edtbenaccount.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.add(edtbenaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 250, 30));

        amt.setBackground(new java.awt.Color(204, 204, 204));
        amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtActionPerformed(evt);
            }
        });
        jPanel8.add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 250, 30));

        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton11.setText("Submit");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, -1, 30));

        edtacbn.setEditable(false);
        jPanel8.add(edtacbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 250, 30));

        jButton13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton13.setText("Check");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 81, 30));

        edtname.setEditable(false);
        edtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtnameActionPerformed(evt);
            }
        });
        jPanel8.add(edtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 250, 30));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Name");
        jPanel8.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 119, 31));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Your Account Number");
        jPanel8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, 26));

        edtaccn3.setEditable(false);
        jPanel8.add(edtaccn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 250, 30));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("FUND TRNASFER");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("FUND TRANSFER", jPanel6);

        jPanel7.setPreferredSize(new java.awt.Dimension(1060, 700));

        jPanel4.setBackground(new java.awt.Color(37, 44, 55));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_data.setBackground(new java.awt.Color(248, 198, 23));
        tbl_data.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Acccount Number", "Transaction DateTime", "Name", "Crdet/Debit", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 900, 472));

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setText("Load");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton8.setText("Download PDF");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("TRANSACTION", jPanel7);

        jPanel5.setBackground(new java.awt.Color(37, 44, 55));

        lblusername.setEditable(false);
        lblusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblusernameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Old Password");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Password");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Password");

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton6.setText("CHANGE PASSWORD");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CHANGE PASSWORD");

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton7.setText("RESET");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        chkShowPassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        chkShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        chkShowPassword.setText("Show Password");
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        lboldpass.setBackground(new java.awt.Color(204, 204, 204));

        txtnewpass.setBackground(new java.awt.Color(204, 204, 204));

        lblcnfpass.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lboldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnewpass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(42, 42, 42)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkShowPassword)
                                    .addComponent(lblcnfpass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(171, 374, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48)
                                .addComponent(lboldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnewpass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(60, 60, 60)
                        .addComponent(lblcnfpass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addComponent(chkShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CHANGE PASSWORD", jPanel2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        lboldpass.setText("");
        txtnewpass.setText("");
        lblcnfpass.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String username = lblusername.getText();
        String oldpass = lboldpass.getText();
        String newpass = txtnewpass.getText();
        String cnfpass = lblcnfpass.getText();

        // Validate if fields are empty
        if (username.isEmpty() || oldpass.isEmpty() || newpass.isEmpty() || cnfpass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        if (!newpass.equals(cnfpass)) {
            JOptionPane.showMessageDialog(null, "Confirm password does not match.");
            lblcnfpass.requestFocus();
            return;
        }

        // SQL queries

        try {
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

            // Prepare the SQL query to check if the username and old password are correct
            String sql = "SELECT * FROM current WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, oldpass);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Old password matches, proceed to change the password
                String updateSql = "UPDATE current SET password = ? WHERE username = ?";
                pstmt = conn.prepareStatement(updateSql);
                pstmt.setString(1, newpass);
                pstmt.setString(2, username);
                pstmt.executeUpdate(); // Execute the update

                JOptionPane.showMessageDialog(this, "Password changed successfully!");

                lboldpass.setText("");
                txtnewpass.setText("");
                lblcnfpass.setText("");
            } else {
                // If no match for username and old password
                JOptionPane.showMessageDialog(this, "Invalid username or old password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            // Ensure resources are closed after execution
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lblusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblusernameActionPerformed

    private void edtunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtunActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MainLogin obj=new MainLogin();
        obj.show();
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        edtfn.setEditable(true);
        edtdob.setEditable(true);
        edtem.setEditable(true);
        edtcn.setEditable(true);
        edtads.setEditable(true);
        edtpn.setEditable(true);
        edtan.setEditable(true);     
        edtai.setEditable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void edtaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtaiActionPerformed

    private void edtanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtanActionPerformed

    private void edtpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtpnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtpnActionPerformed

    private void edtadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtadsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtadsActionPerformed

    private void edtcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtcnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtcnActionPerformed

    private void edtemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtemActionPerformed

    private void edtdobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtdobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtdobActionPerformed

    private void edtfnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtfnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtfnActionPerformed

    private void edtaccnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtaccnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtaccnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
String sql = "SELECT account_number, transaction_date, name, cd, amount FROM deposit WHERE account_number=? ORDER BY transaction_date ASC";


try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/bank";
    String sqlusername = "root"; 
    String sqlpassword = "root"; 
    String accnum = edtaccn2.getText();  
    int AccNum = Integer.parseInt(accnum); 

    try (Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, AccNum);  
        
        try (ResultSet rs = pst.executeQuery()) {

            tbl_data.setModel(DbUtils.resultSetToTableModel(rs));
            
            tbl_data.getColumnModel().getColumn(0).setHeaderValue("Account Number");
            tbl_data.getColumnModel().getColumn(1).setHeaderValue("Transaction Date");
            tbl_data.getColumnModel().getColumn(2).setHeaderValue("Name");
            tbl_data.getColumnModel().getColumn(3).setHeaderValue("Credit/Debit");
            tbl_data.getColumnModel().getColumn(4).setHeaderValue("Amount");
            
            tbl_data.repaint();
        }
    }

} catch (ClassNotFoundException e) {
    JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found: " + e.getMessage());
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid account number format: " + e.getMessage());
}

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
String dateTimeStr = edtdatetime.getText();
String Amount = amt.getText();
double AmountDouble = Double.parseDouble(Amount);
String benAccStr = edtbenaccount.getText();
int benaccount = Integer.parseInt(benAccStr);
String payerAccStr = edtaccn3.getText();
int payerAccount = Integer.parseInt(payerAccStr);

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

    String sqlPayerName = "SELECT fullname FROM current WHERE account_number=?";
    PreparedStatement pstPayerName = conn.prepareStatement(sqlPayerName);
    pstPayerName.setInt(1, payerAccount);
    ResultSet rsPayerName = pstPayerName.executeQuery();
    
    String payerName = "";
    if (rsPayerName.next()) {
        payerName = rsPayerName.getString("fullname");
    }

    String sqlBenName = "SELECT fullname FROM current WHERE account_number=?";
    PreparedStatement pstBenName = conn.prepareStatement(sqlBenName);
    pstBenName.setInt(1, benaccount);
    ResultSet rsBenName = pstBenName.executeQuery();
    
    String beneficiaryName = "";
    if (rsBenName.next()) {
        beneficiaryName = rsBenName.getString("fullname");
    }

    String sql1 = "SELECT account_balance FROM deposit WHERE account_number=?";
    PreparedStatement pst1 = conn.prepareStatement(sql1);
    pst1.setInt(1, payerAccount);
    ResultSet rs1 = pst1.executeQuery();

    if (rs1.next()) {
        double currentPayerBalance = rs1.getDouble("account_balance");

        if (currentPayerBalance >= AmountDouble) {
            double newPayerBalance = currentPayerBalance - AmountDouble;

            String sql2 = "UPDATE deposit SET account_balance=? WHERE account_number=?";
            PreparedStatement ptmt1 = conn.prepareStatement(sql2);
            ptmt1.setDouble(1, newPayerBalance);
            ptmt1.setInt(2, payerAccount);
            ptmt1.executeUpdate();
            ptmt1.close();

            String sql3 = "INSERT INTO deposit (transaction_date, name, amount, cd, account_number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ptmt3 = conn.prepareStatement(sql3);
            ptmt3.setString(1, dateTimeStr);
            ptmt3.setString(2, beneficiaryName);
            ptmt3.setDouble(3, AmountDouble);
            ptmt3.setString(4, "debit");
            ptmt3.setInt(5, payerAccount);
            ptmt3.executeUpdate();
            ptmt3.close();

            String sql4 = "SELECT account_balance FROM deposit WHERE account_number=?";
            PreparedStatement pst2 = conn.prepareStatement(sql4);
            pst2.setInt(1, benaccount);
            ResultSet rs2 = pst2.executeQuery();

            if (rs2.next()) {
                double currentBeneficiaryBalance = rs2.getDouble("account_balance");
                double newBeneficiaryBalance = currentBeneficiaryBalance + AmountDouble;

                String sql5 = "UPDATE deposit SET account_balance=? WHERE account_number=?";
                PreparedStatement ptmt2 = conn.prepareStatement(sql5);
                ptmt2.setDouble(1, newBeneficiaryBalance);
                ptmt2.setInt(2, benaccount);
                ptmt2.executeUpdate();
                ptmt2.close();

                String sql6 = "INSERT INTO deposit (transaction_date, name, amount, cd, account_number) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ptmt4 = conn.prepareStatement(sql6);
                ptmt4.setString(1, dateTimeStr);
                ptmt4.setString(2, payerName);
                ptmt4.setDouble(3, AmountDouble);
                ptmt4.setString(4, "credit");
                ptmt4.setInt(5, benaccount);
                ptmt4.executeUpdate();
                ptmt4.close();

                JOptionPane.showMessageDialog(null, "Amount debited from " + payerName + " and credited to " + beneficiaryName + ".");
            } else {
                JOptionPane.showMessageDialog(null, "Beneficiary account not found.");
            }

            rs2.close();
            pst2.close();
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds in " + payerName + "'s account.");
        }

        rs1.close();
        pst1.close();
    } else {
        JOptionPane.showMessageDialog(null, "Payer account not found.");
    }

    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
}


    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String username1 = edtun.getText();
        String name = edtfn.getText();
        String dob = edtdob.getText();
        String email = edtem.getText();
        String contact = edtcn.getText();
        String pan = edtpn.getText();
        String aadhar = edtan.getText();
        String income = edtai.getText();
        String gst = edtgst.getText();
        String address = edtads.getText();

        try {
            String updateSql = "UPDATE current SET fullname = ?, dob = ?, email = ?, contact = ?, pan=?,aadhar = ?,income = ?,gst=?,address=?  WHERE username = ?";            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            PreparedStatement pstmt = conn.prepareStatement(updateSql);
          
               
                pstmt.setString(1, name);
                pstmt.setString(2, dob);
                pstmt.setString(3, email);
                pstmt.setString(4, contact);
                pstmt.setString(5, pan);     
                pstmt.setString(6, aadhar);
                pstmt.setString(7, income);
                pstmt.setString(8, gst);
                pstmt.setString(9, address);
                pstmt.setString(10, username1);                  
                
                
                pstmt.executeUpdate(); 
                
                JOptionPane.showMessageDialog(this, "Details updated successfully!");
                
                edtfn.setEditable(false);
                edtdob.setEditable(false);
                edtem.setEditable(false);
                edtcn.setEditable(false);
                edtpn.setEditable(false);
                edtan.setEditable(false);
                edtai.setEditable(false);            
                edtads.setEditable(false);
   

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
String cd = "Deposited";
String name=edtfn.getText();
String accnum = edtaccn.getText(); 
int AccNum = Integer.parseInt(accnum); 

String AmountStr = edtamount.getText();

if (AmountStr.isEmpty()) {
    throw new IllegalArgumentException("Amount cannot be empty.");
}

Double Amountdoub;
try {
    Amountdoub = Double.parseDouble(AmountStr);
} catch (NumberFormatException e) {
    throw new IllegalArgumentException("Invalid amount format. It must be a number.");
}

String dateTimeStr = edtdatetime.getText();

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

    Double currentAccountBalance = null;
    String balanceQuery = "SELECT account_balance FROM deposit WHERE account_number = ?";

    try (PreparedStatement balanceStmt = conn.prepareStatement(balanceQuery)) {
        balanceStmt.setInt(1, AccNum);
        ResultSet rs = balanceStmt.executeQuery();

        if (rs.next()) {
            currentAccountBalance = rs.getDouble("account_balance");
        }

        if (currentAccountBalance == null) {
            currentAccountBalance = 0.0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error fetching current account balance.");
    }

    Double newAccountBalance = currentAccountBalance + Amountdoub;

    String sql1 = "INSERT INTO deposit (account_number, transaction_date, cd, amount, account_balance,name) VALUES (?,?, ?, ?, ?, ?)";
    try (PreparedStatement pst1 = conn.prepareStatement(sql1)) {
        pst1.setInt(1, AccNum);
        pst1.setString(2, dateTimeStr);
        pst1.setString(3, cd);
        pst1.setDouble(4, Amountdoub);
        pst1.setDouble(5, newAccountBalance);
        pst1.setString(6, name);
        pst1.executeUpdate();
        System.out.println("Transaction inserted successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error executing the insert statement.");
    }

    String updateBalanceQuery = "UPDATE deposit SET account_balance = ? WHERE account_number = ?";
    try (PreparedStatement updateBalanceStmt = conn.prepareStatement(updateBalanceQuery)) {
        updateBalanceStmt.setDouble(1, newAccountBalance);
        updateBalanceStmt.setInt(2, AccNum);
        balanceLabel.setText("ACCOUNT BALANCE: " + String.format("%.2f", newAccountBalance));
        edtacbn.setText(String.format("%.2f", newAccountBalance));
        int rowsUpdated = updateBalanceStmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Account balance updated successfully for all records!");
            JOptionPane.showMessageDialog(null, "Amount Deposited Successfully");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error updating account balance.");
    }

} catch (ClassNotFoundException e) {
    e.printStackTrace();
    throw new RuntimeException("MySQL Driver not found.");
} catch (SQLException e) {
    e.printStackTrace();
    throw new RuntimeException("Database connection or SQL error.");
}

        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void edtSet1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtSet1MouseClicked
       
    }//GEN-LAST:event_edtSet1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a profile picture");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
        
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            
            try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                Image img = bufferedImage.getScaledInstance(135, 135, Image.SCALE_SMOOTH); 
                ImageIcon icon = new ImageIcon(img);
                edtSet1.setIcon(icon); 
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error loading image: " + ex.getMessage());
            }
        }
    

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
 
        if (selectedFile != null) {
            try {
                FileInputStream fis = new FileInputStream(selectedFile);
                String updateSql = "UPDATE tr SET image = ? WHERE username = ?";
                
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
                PreparedStatement pst = conn.prepareStatement(updateSql);
                
                pst.setBinaryStream(1, fis, (int) selectedFile.length());  
                pst.setString(2, edtun.getText()); 
                
                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Profile image updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error updating profile image.");
                }
                
                fis.close();
                pst.close();
                conn.close();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No image selected. Please choose an image first.");
        }
    

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        String acc = edtbenaccount.getText();
int check = Integer.parseInt(acc); 
String sql = "SELECT fullname FROM current WHERE account_number=?";
try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
    PreparedStatement pst=conn.prepareStatement(sql);
    
    pst.setInt(1, check);
    ResultSet rs = pst.executeQuery();
   
    if (rs.next()) {
        
        String username = rs.getString("fullname");
        edtname.setText(username); 
    } else {
        
        JOptionPane.showMessageDialog(null, "No user found with this account number.");
    }
    
 
    rs.close();
    pst.close();
    conn.close();
    
} catch (Exception e) {
   
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
}
        
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void balanceLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balanceLabelMouseClicked
        // TODO add your handling code here:
         

    }//GEN-LAST:event_balanceLabelMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    
         String payerAccStr = edtaccn3.getText();
int Accnum = Integer.parseInt(payerAccStr);

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

    String sql = "SELECT account_balance FROM deposit WHERE account_number = ?";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setInt(1, Accnum);
    ResultSet rs = pst.executeQuery(); 

    if (rs.next()) {
                        actualBalance = rs.getString("account_balance"); // Store actual balance
                        if (isBalanceVisible) {
                            balanceLabel.setText("ACCOUNT BALANCE: " + actualBalance);
                        } else {
                            balanceLabel.setText("ACCOUNT BALANCE: XXXX");
                        }
                        isBalanceVisible = !isBalanceVisible; // Toggle the visibility flag
                    } else {
                        balanceLabel.setText("Account not found");
                    }

                    rs.close();
                    pst.close();
                    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error while fetching details: " + e.getMessage());
}
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
        // TODO add your handling code here:
         if (chkShowPassword.isSelected()) {
                    lboldpass.setEchoChar((char) 0); 
                    txtnewpass.setEchoChar((char) 0); 
                    lblcnfpass.setEchoChar((char) 0);         
                } else {
                    lboldpass.setEchoChar('*'); 
                    txtnewpass.setEchoChar('*'); 
                    lblcnfpass.setEchoChar('*');         
                }
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    private void edtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtnameActionPerformed

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void edtdatetime3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtdatetime3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtdatetime3ActionPerformed

    private void edtaccn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtaccn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtaccn2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Document document = new Document();
    String name = edtfn.getText();  // Fetching the name from the text field
    String accnum = edtaccn2.getText();  // Fetching account number from the text field

    try {
        // Get the user's Downloads folder path
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + File.separator + "Downloads";

        // Dynamically create a PDF file name based on the account number in the Downloads folder
        String pdfFileName = downloadsPath + File.separator + "Account_Transaction_" + accnum + ".pdf";

        // Create the PDF file output stream
        FileOutputStream outputStream = new FileOutputStream(pdfFileName);
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Adding title to the document
        document.add(new Paragraph("Account Transaction of " + name));
        document.add(new Paragraph("Account Number: " + accnum));
        document.add(new Paragraph("Account Type: " + "current"));
        document.add(new Paragraph("\n"));

        // Create a PdfPTable with 5 columns
        PdfPTable table = new PdfPTable(5); // 5 columns

        // Add headers to the table
        table.addCell("Account Number");
        table.addCell("Transaction Date");
        table.addCell("Name");
        table.addCell("CD");
        table.addCell("Amount");

        // Database connection details
        String sql = "SELECT account_number, transaction_date, name, cd, amount FROM deposit WHERE account_number=? ORDER BY transaction_date ASC";
        String url = "jdbc:mysql://localhost:3306/bank";
        String sqlusername = "root";
        String sqlpassword = "root";

        int accNum = Integer.parseInt(accnum); // Directly parsing account number

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
                 PreparedStatement pst = conn.prepareStatement(sql)) {

                pst.setInt(1, accNum);

                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        table.addCell(rs.getString("account_number"));
                        table.addCell(rs.getString("transaction_date"));
                        table.addCell(rs.getString("name"));
                        table.addCell(rs.getString("cd"));
                        table.addCell(rs.getString("amount"));
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found: " + e.getMessage());
        }

        // Add the table to the document
        document.add(table);
        JOptionPane.showMessageDialog(null, "PDF created successfully for Account: " + accnum + " in Downloads folder");
    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error creating PDF: " + e.getMessage());
    } finally {
        // Ensure the document is closed in all cases
        document.close();
    }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(CurrentLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new CurrentLoggedIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amt;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JLabel edtSet1;
    private javax.swing.JTextField edtacbn;
    private javax.swing.JTextField edtaccn;
    private javax.swing.JTextField edtaccn2;
    private javax.swing.JTextField edtaccn3;
    private javax.swing.JTextField edtads;
    private javax.swing.JTextField edtai;
    private javax.swing.JTextField edtamount;
    private javax.swing.JTextField edtan;
    private javax.swing.JTextField edtbenaccount;
    private javax.swing.JTextField edtcn;
    private javax.swing.JTextField edtdatetime;
    private javax.swing.JTextField edtdatetime3;
    private javax.swing.JTextField edtdob;
    private javax.swing.JTextField edtem;
    private javax.swing.JTextField edtfn;
    private javax.swing.JTextField edtgst;
    private javax.swing.JTextField edtname;
    private javax.swing.JTextField edtpn;
    private javax.swing.JTextField edtun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPasswordField lblcnfpass;
    private javax.swing.JTextField lblusername;
    private javax.swing.JPasswordField lboldpass;
    private javax.swing.JTable tbl_data;
    private javax.swing.JPasswordField txtnewpass;
    // End of variables declaration//GEN-END:variables
}
