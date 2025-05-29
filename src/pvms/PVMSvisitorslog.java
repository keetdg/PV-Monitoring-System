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
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Homer
 */
public class PVMSvisitorslog extends javax.swing.JFrame {
    private Object dtDateVisit;

    /**
     * Creates new form PVMSvisitorslog
     */
    public PVMSvisitorslog() {
        initComponents();
//      updatetable();
    
    }
    Connection con;
    PreparedStatement pst;
     ResultSet rs;
     public void updatetable(){
        int c = 0;
        try{
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pvms?zeroDateTimeBehavior=convertToNull","root","");
            pst = con.prepareStatement("INSERT INTO visitorslog(VisitorName, HostName, DateVisit, VisitType, TimeIn, TimeOut)"
                                     + "VALUES (?,?,?,?,?,?) "
                                     + "SELECT VisitorName, HostName, DateVisit, VisitType FROM pvmsvisitor WHERE LogID = 1");
            pst.setInt(1, c);
            pst.setInt(2, c);
            pst.setInt(3, c);
            pst.setInt(4, c);
           pst.setInt(5, c);
            pst.setInt(6, c);
           pst.executeUpdate();
           rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel)tblVisitorLog.getModel();
            dft.setRowCount(0);
            
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1; i<=c; i++){
//                    v2.add(rs.getString("LastName"));
//                    v2.add(rs.getString("FirstName"));
//                    v2.add(rs.getString("MiddleName"));
//                    v2.add(rs.getString("Age"));
//                    v2.add(rs.getString("Sex"));
//                    v2.add(rs.getString("Address"));
//                    v2.add(rs.getString("BirthDate"));
//                    v2.add(rs.getString("CivilStatus"));
//                    v2.add(rs.getString("Contact"));
                    v2.add(rs.getString("VisitorName"));
                    v2.add(rs.getString("HostName"));
                    v2.add(rs.getString("DateVisit"));
                    v2.add(rs.getString("VisitType"));
                   // v2.add(rs.getString("Relationship"));
                   // v2.add(rs.getString("TimeIn"));
//                    v2.add(rs.getString("ZipCode"));

                    
                    
                }
                dft.addRow(v2);
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PVMSvisitorslog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PVMSvisitorslog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Save(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String lastname, firstname, middlename, age, sex, address, birthdate, civilstatus, contact;
        String visitorname, hostname, datevisit, visittype, relationship, timein, timeout; 
        
//        lastname = txtLastName.getText();
//        firstname = txtFirstName.getText();
//        middlename = txtMiddleName.getText();
//        age = txtAge.getText();
//        sex = cbSex.getSelectedItem().toString();
//        address = txtAddress.getText();
//        birthdate = dateFormat.format(dtBirthDate.getDate());
//        civilstatus = cbCivilStatus.getSelectedItem().toString();
//        contact = txtContact.getText();
//        visitorname = txtvisitorname.getText();
//        hostname = txtHostName.getText();
//        datevisit = dateFormat.format(dtDateVisit.getDate()); 
//        DefaultTableModel model = (DefaultTableModel)tableVisitorInfo.getModel();
//        model.addRow(new Object[]{datevisit});
//        visittype = cbVisitType.getSelectedItem().toString();
//        relationship = txtRelationship.getText();
       // timein = time.getText();
        //zipcode = txtZipCode.getText();
       
//        timein = txtTimeIn.getText();
//        timeout = txtTimeOut.getText();
    
        try {
//           
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pvms?zeroDateTimeBehavior=convertToNull","root","");
             
            pst = con.prepareStatement("INSERT INTO pvmsvisitor(LastName, FirstName, MiddleName, Age, Sex, Address, BirthDate, CivilStatus, Contact,"
                    + "VisitorName, HostName, DateVisit, VisitType, Relationship) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
//            pst.setString(1, lastname);
//            pst.setString(2, firstname);
//            pst.setString(3, middlename);
//            pst.setString(4, age);
//            pst.setString(5, sex);
//            pst.setString(6, address);
//            pst.setString(7, birthdate);
//            pst.setString(8, civilstatus);
//            pst.setString(9, contact);
//            pst.setString(10, visitorname);
//            pst.setString(11, hostname);
//            pst.setString(12, datevisit);
//            pst.setString(13, visittype);
//            pst.setString(14, relationship);
           // pst.setString(15, timein);
           // time();
//            pst.setString(15, timein);
//            pst.setString(16, timeout);
            pst.executeUpdate();
//            JOptionPane.showMessageDialog(this, "Record Saved");
            
            
//            txtLastName.setText("");
//            txtFirstName.setText("");
//            txtMiddleName.setText("");
//            txtAge.setText("");
//            cbSex.setSelectedItem("Select");
//            cbCivilStatus.setSelectedItem("Select");
//            txtAddress.setText("");
//            dtBirthDate.setCalendar(null);
//            txtContact.setText("");
//            txtvisitorname.setText("");
//            txtHostName.setText("");
//            dtDateVisit.setCalendar(null);
//            cbVisitType.setSelectedItem("Select");
//            txtRelationship.setText("");
             updatetable();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PVMSvisitorslog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PVMSvisitorslog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Get_Data(){
      String sql="select VisitorName as 'Visitor Name', DoctorName as 'Doctor Name',FatherName as 'Father Name',Address,ContacNo as 'Contact No',Email as 'Email ID',Qualifications,Gender,BloodGroup as 'Blood Group',DateOfJoining as 'Joining Date' from Doctor order by DoctorName";        
      try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         tblVisitorLog.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        Close = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVisitorLog = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(227, 115, 56));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search Name: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        btnRefresh.setText("Refresh List");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel3.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 130, 30));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 470, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1380, 60));

        Close.setText("Close");
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
        });
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        jPanel1.add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 690, 110, 30));

        jButton2.setText("Print List");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, 120, 30));

        tblVisitorLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Visitor Name", "Host Name", "Date of Visit", "Visit Type", "Time In", "Time Out", "Action"
            }
        ));
        jScrollPane1.setViewportView(tblVisitorLog);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1380, 430));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pvms/BJMP1.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, 110));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pvms/med1.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 200, 110));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BUREAU OF JAIL MANAGEMENT AND PENOLOGY");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 860, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1380, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MEDELLIN DISTRICT JAIL");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 630, -1));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Medellin, Cebu, Philippines");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 310, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1380, 80));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("X");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 10, 28, -1));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("VISITOR'S LOG DETAILS");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
//       try{
//           //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Class.forName("com.mysql.cj.jdbc.Driver");
//             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pvms?zeroDateTimeBehavior=convertToNull","root","");            
//             int row= tblVisitorLog.getSelectedRow();
//            String table_click= tblVisitorLog.getModel().getValueAt(row, 0).toString();
//            String sql= "select VisitorName, HostName, DateVisit, VisitType FROM pvmsvisitor where VisitorID = '" + table_click + "'";
//            pst=con.prepareStatement(sql);
//            rs=  pst.executeQuery();
//            if(rs.next()){
//                this.hide();
//                PVMSvisitorprofile frm = new PVMSvisitorprofile();
//                frm.setVisible(false);
//                String add10=rs.getString("VisitorName");
//                frm.txtvisitorname.setText(add10);
//                String add11=rs.getString("HostName");
//                frm.txtHostName.setText(add11);
//                String add12=rs.getString("DateVisit");
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                frm.dateFormat.format(dtDateVisit.getDate(add12));
//                String add13=rs.getString("visittype");
//                frm.cbVisitType.setSelectedItem(add13);
               // String add14=rs.getString("VisitType");
//                frm.txtQ.setText(add6);
//                String add9=rs.getString("BloodGroup");
//                frm.cmbB.setSelectedItem(add9);
//                String add11=rs.getString("Gender");
//                frm.cmbG.setSelectedItem(add11);
//                String add14=rs.getString("DateOfJoining");
//                frm.txtD.setText(add14);
//                String add15=rs.getString("Address");
//                frm.txtAd.setText(add15);
//                String add16=rs.getString("ContacNo");
//                frm.txtC.setText(add16);
//                frm.btnUpdate.setEnabled(true);
//                frm.btnDelete.setEnabled(true);
//                frm.btnSave.setEnabled(false);
//             
//            }
//        }catch(Exception ex){
//            JOptionPane.showMessageDialog(this,ex);
//        }  
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
       PVMShome home = new PVMShome();
       home.show();
       dispose();
    }//GEN-LAST:event_CloseMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CloseActionPerformed

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
//          //  JFRAME_JTABLE.AddRowToJTable(new Object[]);
       // updatetable();
        //tblVisitorLog.setModel(DbUtils.resultSetToTableModel(rs)); 
//     
    }//GEN-LAST:event_btnRefreshMouseClicked

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
            java.util.logging.Logger.getLogger(PVMSvisitorslog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PVMSvisitorslog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PVMSvisitorslog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PVMSvisitorslog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PVMSvisitorslog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTable tblVisitorLog;
    // End of variables declaration//GEN-END:variables

    private void executeQuery(String select__from_pvmsvisitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
