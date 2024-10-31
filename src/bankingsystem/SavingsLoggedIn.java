/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author ACER
 * 
 **/
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Table;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import javax.imageio.ImageIO;
import java.time.format.DateTimeFormatter;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.proteanit.sql.DbUtils;


public class SavingsLoggedIn extends javax.swing.JFrame {

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
        payfrom.setText(value);
        edtaccount.setText(value);
        edtaccn2.setText(value);
    }
             
              public void setTextInedtlblun(String value) {
        lblusername.setText(value); 
    }        
             public void setTextInedtaccn2(String value) {
        edtaccn2.setText(value); 
    }
            public void setTextInedtaccn3(String value) {
         
    } 
            public void setTextInedtaccn4(String value) {
        edtaccount.setText(value); 
    }
            
            public void setProfileImageIcon(ImageIcon icon) {
        edtSet1.setIcon(icon);
    }

             
         
    public SavingsLoggedIn() {
    initComponents();
        setLocation(150,5);
        setSize(1072,750);
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
     edtdatetime1.setText(dtf.format(now));
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
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        edtbenaccount = new javax.swing.JTextField();
        amt = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        edtacbn = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        edtname = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        edtaccount = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        billername = new javax.swing.JTextField();
        payfrom = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        edtdatetime1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        btnDownloadPDF = new javax.swing.JButton();
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
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, -1, -1));

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
        jPanel3.add(edtads, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 250, 97));

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
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 614, 90, 30));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 614, 90, 30));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(37, 44, 55));
        jButton3.setText("Log Out");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 60, 30));

        edtSet1.setBackground(new java.awt.Color(255, 255, 255));
        edtSet1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(248, 198, 23)));
        edtSet1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                edtSet1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
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

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton4.setText("Edit");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, -1));

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton10.setText("Upload");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 50, -1));

        jTabbedPane1.addTab("PROFILE ", jPanel3);

        jPanel11.setBackground(new java.awt.Color(37, 44, 55));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Account Number");
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 177, 181, 37));

        edtaccn2.setEditable(false);
        jPanel11.add(edtaccn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 250, 30));
        jPanel11.add(edtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 250, 30));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Deposit Amount");
        jPanel11.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 38));

        jButton12.setText("Deposit");
        jButton12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 80, 30));

        edtdatetime.setEditable(false);
        edtdatetime.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.add(edtdatetime, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 250, 30));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Date and Time");
        jPanel11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 158, 38));

        balanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        balanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        balanceLabel.setText("               ACCOUNT BALANCE");
        balanceLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(248, 198, 23)));
        balanceLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                balanceLabelMouseClicked(evt);
            }
        });
        jPanel11.add(balanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 340, 80));

        jToggleButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jToggleButton1.setText(" Show Balance");
        jToggleButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel11.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 110, -1));

        jTabbedPane1.addTab("DEPOSIT", jPanel11);

        jPanel8.setBackground(new java.awt.Color(37, 44, 55));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Account Balance");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Account number");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Enter Amount");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Show Balance");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("PKR/=");

        balance.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 255, 255));
        balance.setText("0000");

        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton11.setText("Submit");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        edtacbn.setEditable(false);

        jButton13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton13.setText("Check");
        jButton13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        edtname.setEditable(false);
        edtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtnameActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Name");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Your Account Number");

        edtaccount.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtbenaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(edtname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(edtacbn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(edtaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtbenaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edtacbn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29))
                    .addComponent(jLabel30))
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton11))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(balance))))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("FUND TRANSFER", jPanel6);

        jPanel10.setBackground(new java.awt.Color(37, 44, 55));
        jPanel10.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BILL PAYMENTS");
        jPanel10.add(jLabel10);
        jLabel10.setBounds(408, 6, 280, 43);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Biller Name");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(60, 120, 114, 29);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Pay From");
        jPanel10.add(jLabel21);
        jLabel21.setBounds(60, 240, 94, 29);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Amount");
        jPanel10.add(jLabel22);
        jLabel22.setBounds(60, 330, 110, 29);

        billername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billernameActionPerformed(evt);
            }
        });
        jPanel10.add(billername);
        billername.setBounds(260, 117, 200, 30);

        payfrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payfromActionPerformed(evt);
            }
        });
        jPanel10.add(payfrom);
        payfrom.setBounds(260, 240, 200, 30);
        jPanel10.add(amount);
        amount.setBounds(260, 330, 200, 30);

        jButton8.setText("PAY");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton8);
        jButton8.setBounds(390, 390, 75, 23);

        jButton9.setText("CANCEL");
        jPanel10.add(jButton9);
        jButton9.setBounds(260, 390, 75, 23);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Electricity", "Gas", "Water", "Mobile" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox1);
        jComboBox1.setBounds(260, 170, 200, 30);

        edtdatetime1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        edtdatetime1.setForeground(new java.awt.Color(255, 255, 255));
        edtdatetime1.setText("DATE :");
        jPanel10.add(edtdatetime1);
        edtdatetime1.setBounds(40, 70, 310, 29);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("BILL PAYMENTS", jPanel9);

        jPanel7.setPreferredSize(new java.awt.Dimension(1060, 700));

        jPanel4.setBackground(new java.awt.Color(37, 44, 55));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_data.setBackground(new java.awt.Color(248, 198, 23));
        tbl_data.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Acccount Number", "Transaction DateTime", "Beneficiary", "Crdet/Debit", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_data.setGridColor(new java.awt.Color(0, 0, 0));
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

        btnDownloadPDF.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDownloadPDF.setText("Download PDF");
        btnDownloadPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadPDFActionPerformed(evt);
            }
        });
        jPanel4.add(btnDownloadPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("TRANSACTION", jPanel7);

        jPanel5.setBackground(new java.awt.Color(37, 44, 55));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblusername.setEditable(false);
        lblusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblusernameActionPerformed(evt);
            }
        });
        jPanel5.add(lblusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 250, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 126, 109, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Old Password");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 215, 150, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Password");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Password");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 190, -1));

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton6.setText("CHANGE PASSWORD");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 550, 150, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CHANGE PASSWORD");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton7.setText("RESET");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 550, 100, 30));

        chkShowPassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        chkShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        chkShowPassword.setText("Show Password");
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });
        jPanel5.add(chkShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));

        lboldpass.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.add(lboldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 250, 30));

        txtnewpass.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.add(txtnewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 250, 30));

        lblcnfpass.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.add(lblcnfpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 250, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            String sql = "SELECT * FROM savings WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, oldpass);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Old password matches, proceed to change the password
                String updateSql = "UPDATE savings SET password = ? WHERE username = ?";
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
            tbl_data.getColumnModel().getColumn(2).setHeaderValue("Beneficiary");
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

    private void billernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billernameActionPerformed

    }//GEN-LAST:event_billernameActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
       String cd="Debit";
       String accnum = payfrom.getText(); 
       int AccNum = Integer.parseInt(accnum);
       String dateTimeStr = edtdatetime1.getText();

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
    
    String amt = amount.getText();
    double amtDouble = Double.parseDouble(amt); 
    String billerName = billername.getText();
    
    String sql = "SELECT account_balance FROM deposit WHERE account_number=?";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setInt(1, AccNum);
    
    ResultSet rs = pst.executeQuery();
    
    if (rs.next()) {
//        acbalance.setText(rs.getString("account_balance"));
        String accbalance = rs.getString("account_balance");
        double accbalanceDouble = Double.parseDouble(accbalance); 
        
        if (accbalanceDouble >= amtDouble) {
            double leftover = accbalanceDouble - amtDouble; 
          
            String sql1 = "UPDATE deposit SET account_balance=? WHERE account_number=?";
            PreparedStatement pstm = conn.prepareStatement(sql1);
            pstm.setDouble(1, leftover);
            pstm.setInt(2, AccNum);
            pstm.executeUpdate();  
            
            String sql2 = "INSERT INTO deposit (transaction_date, name, amount,account_number,cd) VALUES (?, ?, ?,?,?)";
            PreparedStatement pts = conn.prepareStatement(sql2);
            pts.setString(1, dateTimeStr); 
            pts.setString(2, billerName); 
            pts.setDouble(3, amtDouble);
            pts.setDouble(4, AccNum);
            pts.setString(5, cd);
            pts.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Your " + billerName + " bill of amount " + amt + " has been paid.");
            amount.setText("");
            billername.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Your account balance is low, only " + accbalanceDouble + ", kindly recharge the account.");
        }
    } else {
//        acbalance.setText("");
        JOptionPane.showMessageDialog(null, "Account not found.");
    }
    
    
    rs.close();
    pst.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}


    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedValue = jComboBox1.getSelectedItem().toString();
        billername.setText(selectedValue); 
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
       
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
String dateTimeStr = edtdatetime1.getText();
String Amount = amt.getText();
double AmountDouble = Double.parseDouble(Amount);
String benAccStr = edtbenaccount.getText();
int benaccount = Integer.parseInt(benAccStr);
String payerAccStr = edtaccount.getText();
int payerAccount = Integer.parseInt(payerAccStr);

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

    String sqlPayerName = "SELECT fullname FROM savings WHERE account_number=?";
    PreparedStatement pstPayerName = conn.prepareStatement(sqlPayerName);
    pstPayerName.setInt(1, payerAccount);
    ResultSet rsPayerName = pstPayerName.executeQuery();
    
    String payerName = "";
    if (rsPayerName.next()) {
        payerName = rsPayerName.getString("fullname");
    }

    String sqlBenName = "SELECT fullname FROM savings WHERE account_number=?";
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
        String address = edtads.getText();

        try {
            String updateSql = "UPDATE savings SET fullname = ?, dob = ?, email = ?, contact = ?, pan=?,aadhar = ?,income = ?,address=?  WHERE username = ?";            
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
                pstmt.setString(8, address);
                pstmt.setString(9, username1);
                                 
                
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
String accnum = edtaccn2.getText(); 
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

    private void payfromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payfromActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_payfromActionPerformed

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
String sql = "SELECT fullname FROM savings WHERE account_number=?";
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
    
         String payerAccStr = edtaccount.getText();
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

    private void btnDownloadPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadPDFActionPerformed
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
        document.add(new Paragraph("Account Type: " + "savings"));
        document.add(new Paragraph("\n")); // Adding a blank paragraph for spacing

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
    }//GEN-LAST:event_btnDownloadPDFActionPerformed

    private void edtSet1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_edtSet1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSet1AncestorAdded

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
        String payerAccStr = edtaccount.getText();
        int Accnum = Integer.parseInt(payerAccStr);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");

            String sql = "select accountbalance from account where account_number = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,Accnum);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                balance.setText(rs.getString("accountbalance"));
            }
            else {
                balance.setText("");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error while fetching details");
        }
    }//GEN-LAST:event_jLabel33MouseClicked

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
            java.util.logging.Logger.getLogger(SavingsLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavingsLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavingsLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavingsLoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new SavingsLoggedIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JTextField amt;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JTextField billername;
    private javax.swing.JButton btnDownloadPDF;
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JLabel edtSet1;
    private javax.swing.JTextField edtacbn;
    private javax.swing.JTextField edtaccn;
    private javax.swing.JTextField edtaccn2;
    private javax.swing.JTextField edtaccount;
    private javax.swing.JTextField edtads;
    private javax.swing.JTextField edtai;
    private javax.swing.JTextField edtamount;
    private javax.swing.JTextField edtan;
    private javax.swing.JTextField edtbenaccount;
    private javax.swing.JTextField edtcn;
    private javax.swing.JTextField edtdatetime;
    private javax.swing.JLabel edtdatetime1;
    private javax.swing.JTextField edtdob;
    private javax.swing.JTextField edtem;
    private javax.swing.JTextField edtfn;
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
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPasswordField lblcnfpass;
    private javax.swing.JTextField lblusername;
    private javax.swing.JPasswordField lboldpass;
    private javax.swing.JTextField payfrom;
    private javax.swing.JTable tbl_data;
    private javax.swing.JPasswordField txtnewpass;
    // End of variables declaration//GEN-END:variables
}
