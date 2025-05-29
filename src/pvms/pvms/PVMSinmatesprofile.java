/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pvms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Homer
 */
public class PVMSinmatesprofile extends javax.swing.JFrame {

    private int InmateID;

    public PVMSinmatesprofile() {
        initComponents();
        updatetable();
    }

   

    public void updatetable() {
        int c;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pvms?zeroDateTimeBehavior=convertToNull", "root", "");

            insert = con.prepareStatement("SELECT * FROM pvmsinmate");
            rs = insert.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) inmatetable.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("fName"));
                    v2.add(rs.getString("Age"));
                    v2.add(rs.getString("Sex"));
                    v2.add(rs.getString("Address"));
                    v2.add(rs.getString("BirthDate"));
                    v2.add(rs.getString("CivilStatus"));
                    v2.add(rs.getString("Remarks"));
//                  

                }
                dft.addRow(v2);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PVMSinmatesprofile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PVMSinmatesprofile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbSex = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbCivilStatus = new javax.swing.JComboBox<String>();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        dtBirthDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        cbRemarks = new javax.swing.JComboBox<String>();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inmatetable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Name:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, 30));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel4.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 190, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Age: ");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 40, 30));

        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        jPanel4.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 100, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Address: ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 60, 30));

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel4.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 190, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Sex:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 40, 30));

        cbSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Male", "Female" }));
        jPanel4.add(cbSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 100, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Birth Date: ");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Civil Status: ");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 90, 30));

        cbCivilStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Single", "Married", "Widow", "Separated" }));
        jPanel4.add(cbCivilStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 110, 30));

        jPanel6.setBackground(new java.awt.Color(227, 115, 56));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Inmate's Details");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 30));
        jPanel4.add(dtBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 180, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Remarks: ");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 90, 30));

        cbRemarks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Detainee", "Free" }));
        jPanel4.add(cbRemarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 110, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 380, 440));

        jPanel9.setBackground(new java.awt.Color(227, 115, 56));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Inmates List ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(744, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 920, 30));

        btnClose.setText("CLOSE");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 650, 110, 50));

        btnAdd.setText("ADD");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 650, 110, 50));

        btnUpdate.setText("UPDATE");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 650, 110, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 10, 28, -1));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("INMATE'S INFORMATION PROFILE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 40));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pvms/BJMP1.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 110));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pvms/med1.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 40, 120, 130));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MEDELLIN DISTRICT JAIL");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 630, -1));

        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Medellin, Cebu, Philippines");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 310, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1380, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BUREAU OF JAIL MANAGEMENT AND PENOLOGY");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 860, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1380, 60));

        inmatetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Sex", "Address", "BirthDate", "CivilStatus", "Remarks"
            }
        ));
        inmatetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inmatetableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(inmatetable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 920, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    Connection con;
    PreparedStatement insert;
    ResultSet rs;
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        PVMShome home = new PVMShome();
        home.show();
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String name, age, sex, address, birthdate, civilstatus, remarks;

        name = txtName.getText();
        age = txtAge.getText();
        sex = cbSex.getSelectedItem().toString();
        address = txtAddress.getText();
        birthdate = dateFormat.format(dtBirthDate.getDate());
        civilstatus = cbCivilStatus.getSelectedItem().toString();
        remarks = cbRemarks.getSelectedItem().toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pvms?zeroDateTimeBehavior=convertToNull", "root", "");
            insert = con.prepareStatement("INSERT INTO pvmsinmate(fName, Age, Sex, Address, BirthDate, CivilStatus, Remarks) VALUES(?,?,?,?,?,?,?)");

            insert.setString(1, name);
            insert.setString(2, age);
            insert.setString(3, sex);
            insert.setString(4, address);
            insert.setString(5, birthdate);
            insert.setString(6, civilstatus);
            insert.setString(7, remarks);

            insert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added");

            txtName.setText("");
            txtAge.setText("");
            txtAddress.setText("");
            dtBirthDate.setCalendar(null);
//            txtLastName.setText("");

            updatetable();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PVMSinmatesprofile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PVMSinmatesprofile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
       
         DefaultTableModel df = (DefaultTableModel)inmatetable.getModel();
         SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        int selectedRow = inmatetable.getSelectedRow();
     
        int selectedIndex = inmatetable.getSelectedRow();
       
         try {  
        int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
        
         String name = txtName.getText();
         String age = txtAge.getText();
         String sex = cbSex.getSelectedItem().toString();
         String address = txtAddress.getText();
         String birthdate = date.format(dtBirthDate.getDate());
         df.setValueAt(birthdate, selectedRow, 0);
        String civilstatus = cbCivilStatus.getSelectedItem().toString();
        String remarks = cbRemarks.getSelectedItem().toString();
        
//         String id = txID.getText();
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pvms","root","");
          insert = con.prepareStatement("update pvmsinmate set fName= ?,Age= ?,Sex= ?,Address= ?,BirthDate= ?,CivilStatus= ?,Remarks= ? where id= ?");
//            insert = con.prepareStatement("select * from cafeinventory where item_id='" + id + "'");
           
            insert.setString(1, name);
            insert.setString(2, age);
            insert.setString(3, sex);
            insert.setString(4, address);
            insert.setString(5, birthdate);
            insert.setString(6, civilstatus);
            insert.setString(7, remarks);
           
             insert.setInt(8, id);
             
             
            insert.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"RECORD UPDATED");
//            update();
            updatetable();
           
         
//            txID.setText("");
            txtName.setText("");
            txtAge.setText("");
            cbSex.setSelectedItem("Select");
            txtAddress.setText("");
            dtBirthDate.setCalendar(null);
            cbCivilStatus.setSelectedItem("Select");
            cbRemarks.setSelectedItem("Select");
            txtName.requestFocus();
         
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PVMSinmatesprofile.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        


    }//GEN-LAST:event_btnUpdateMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void inmatetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inmatetableMouseClicked
        try {
            int i = inmatetable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) inmatetable.getModel();

            txtName.setText(model.getValueAt(i, 1).toString());
            txtAge.setText(model.getValueAt(i, 2).toString());
            String sex = model.getValueAt(i, 3).toString();
            switch (sex) {
                case "Select":
                    cbSex.setSelectedIndex(0);
                    break;
                case "Male":
                    cbSex.setSelectedIndex(1);
                    break;
                case "Female":
                    cbSex.setSelectedIndex(2);
                    break;
            }
            txtAddress.setText(model.getValueAt(i, 4).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(i, 5).toString());
            dtBirthDate.setDate(date);
            String status = model.getValueAt(i, 6).toString();
            switch (status) {
                case "Select":
                    cbCivilStatus.setSelectedIndex(0);
                    break;
                case "Single":
                    cbCivilStatus.setSelectedIndex(1);
                    break;
                case "Married":
                    cbCivilStatus.setSelectedIndex(2);
                    break;
                case "Widow":
                    cbCivilStatus.setSelectedIndex(3);
                    break;
                case "Separated":
                    cbCivilStatus.setSelectedIndex(4);
                    break;
            }
            String remarks = model.getValueAt(i, 7).toString();
            switch (remarks) {
                case "Select":
                    cbRemarks.setSelectedIndex(0);
                    break;
                case "Detainee":
                    cbRemarks.setSelectedIndex(1);
                    break;
                case "Free":
                    cbRemarks.setSelectedIndex(2);
                    break;
            }

        } catch (ParseException ex) {
            Logger.getLogger(PVMSinmatesprofile.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_inmatetableMouseClicked

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
            java.util.logging.Logger.getLogger(PVMSinmatesprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PVMSinmatesprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PVMSinmatesprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PVMSinmatesprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PVMSinmatesprofile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCivilStatus;
    private javax.swing.JComboBox<String> cbRemarks;
    private javax.swing.JComboBox<String> cbSex;
    private com.toedter.calendar.JDateChooser dtBirthDate;
    private javax.swing.JTable inmatetable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
