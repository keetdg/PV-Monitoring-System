/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pvms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Homer
 */
public class PVMSvisitorprofile extends javax.swing.JFrame {

    private int VisitorID;
    private String quax;
    
    public PVMSvisitorprofile() {
        initComponents();
        time();
        updatetable();
         inmateName.setVisible(true);     
//      
    }
    
    Connection con;
    PreparedStatement pst;
     ResultSet rs;
//
//   
//    
    
    Timer t;
    SimpleDateFormat st;
    
    public void time(){
       
        t = new Timer(0, new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Date dt = new Date();
            st = new SimpleDateFormat("hh:mm:ss a");
            String tt = st.format(dt);
            time.setText(tt);
            }
        });
        t.start();
    }
    
    public void updatetable(){
        int c;
        try{
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pvms?zeroDateTimeBehavior=convertToNull","root","");
            pst = con.prepareStatement("SELECT * FROM pvmsvisitor");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel)tableVisitorInfo.getModel();
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
            Logger.getLogger(PVMSvisitorprofile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PVMSvisitorprofile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)tableVisitorInfo.getModel();
        model.addRow(dataRow);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
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
        jLabel14 = new javax.swing.JLabel();
        txtRelationship = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbVisitType = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtHostName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        dtDateVisit = new com.toedter.calendar.JDateChooser();
        dtBirthDate = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        txtvisitorname = new javax.swing.JTextField();
        txtMiddleName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVisitorInfo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        inmateName = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 240, 190, 180));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Biometric Fingerprint");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 210, 200, 27));

        jPanel5.setBackground(new java.awt.Color(227, 115, 56));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Visitor Details");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(831, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1010, 30));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Visitor Name:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, 27));
        jPanel4.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 170, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("First Name:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Middle Name:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 90, 30));

        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyReleased(evt);
            }
        });
        jPanel4.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 220, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Age: ");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 40, 30));

        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        jPanel4.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 50, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Address: ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, 30));

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel4.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 450, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Sex:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 30));

        cbSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Male", "Female" }));
        jPanel4.add(cbSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 90, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Birth Date: ");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Contact Number:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 120, 30));

        cbCivilStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Single", "Married", "Widow", "Separated" }));
        jPanel4.add(cbCivilStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 80, 30));

        jPanel6.setBackground(new java.awt.Color(227, 115, 56));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Visitation Details");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(844, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1020, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Relationship to Host Name:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 170, 30));
        jPanel4.add(txtRelationship, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 170, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Date of Visit: ");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 90, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Visit Type:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 70, 30));

        cbVisitType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Personal", "Business" }));
        jPanel4.add(cbVisitType, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 190, 100, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Time:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 60, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Host Name: ");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 30));

        txtHostName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHostNameKeyPressed(evt);
            }
        });
        jPanel4.add(txtHostName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 320, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Civil Status: ");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 80, 30));

        time.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 130, 50));

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLastNameKeyReleased(evt);
            }
        });
        jPanel4.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 220, 30));
        jPanel4.add(dtDateVisit, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 170, 30));
        jPanel4.add(dtBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 220, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Last Name:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 27));

        txtvisitorname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvisitornameActionPerformed(evt);
            }
        });
        txtvisitorname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvisitornameKeyTyped(evt);
            }
        });
        jPanel4.add(txtvisitorname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 320, 30));

        txtMiddleName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMiddleNameKeyReleased(evt);
            }
        });
        jPanel4.add(txtMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 220, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1010, 280));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 10, 28, -1));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("INMATE'S VISITOR INFORMATION PROFILE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 40));

        jPanel3.setBackground(new java.awt.Color(227, 115, 56));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Visit History: ");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 130, 30));

        tableVisitorInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Visitor Name", "Host Name", "Date of Visit", "Visit Type", "Time In", "Time Out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableVisitorInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVisitorInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVisitorInfo);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1170, 190));

        inmateName.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        jScrollPane2.setViewportView(inmateName);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 240, 120));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 1170, 220));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pvms/BJMP1.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 110));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pvms/med1.png"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, -50, 190, 300));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 30)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("BUREAU OF JAIL MANAGEMENT AND PENOLOGY");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 860, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1370, 60));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 36)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("MEDELLIN DISTRICT JAIL");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 630, -1));

        jLabel26.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Medellin, Cebu, Philippines");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 310, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1370, 80));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 580, 130, 40));

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 640, 130, 40));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 204));
        jRadioButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jRadioButton1.setText("START SCAN");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 430, 110, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 204));
        jRadioButton2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jRadioButton2.setText("STOP SCAN");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 450, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        PVMShome home = new PVMShome();
        home.show();
        dispose();      
    }//GEN-LAST:event_btnCloseMouseClicked

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String lastname, firstname, middlename, age, sex, address, birthdate, civilstatus, contact;
        String visitorname, hostname, datevisit, visittype, relationship, timein, timeout; 
        
        lastname = txtLastName.getText();
        firstname = txtFirstName.getText();
        middlename = txtMiddleName.getText();
        age = txtAge.getText();
        sex = cbSex.getSelectedItem().toString();
        address = txtAddress.getText();
        birthdate = dateFormat.format(dtBirthDate.getDate());
        civilstatus = cbCivilStatus.getSelectedItem().toString();
        contact = txtContact.getText();
        visitorname = txtvisitorname.getText();
        hostname = txtHostName.getText();
        datevisit = dateFormat.format(dtDateVisit.getDate()); 
        DefaultTableModel model = (DefaultTableModel)tableVisitorInfo.getModel();
        model.addRow(new Object[]{datevisit});
        visittype = cbVisitType.getSelectedItem().toString();
        relationship = txtRelationship.getText();
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
            
            pst.setString(1, lastname);
            pst.setString(2, firstname);
            pst.setString(3, middlename);
            pst.setString(4, age);
            pst.setString(5, sex);
            pst.setString(6, address);
            pst.setString(7, birthdate);
            pst.setString(8, civilstatus);
            pst.setString(9, contact);
            pst.setString(10, visitorname);
            pst.setString(11, hostname);
            pst.setString(12, datevisit);
            pst.setString(13, visittype);
            pst.setString(14, relationship);
           // pst.setString(15, timein);
           // time();
//            pst.setString(15, timein);
//            pst.setString(16, timeout);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Saved");
            
            
            txtLastName.setText("");
            txtFirstName.setText("");
            txtMiddleName.setText("");
            txtAge.setText("");
            cbSex.setSelectedItem("Select");
            cbCivilStatus.setSelectedItem("Select");
            txtAddress.setText("");
            dtBirthDate.setCalendar(null);
            txtContact.setText("");
            txtvisitorname.setText("");
            txtHostName.setText("");
            dtDateVisit.setCalendar(null);
            cbVisitType.setSelectedItem("Select");
            txtRelationship.setText("");
             updatetable();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PVMSvisitorprofile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PVMSvisitorprofile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnSaveMouseClicked

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void tableVisitorInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVisitorInfoMouseClicked
        try {
            int i = tableVisitorInfo.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tableVisitorInfo.getModel();
            
            txtvisitorname.setText(model.getValueAt(i, 0).toString());
            txtHostName.setText(model.getValueAt(i, 1).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(i, 2).toString());
            dtDateVisit.setDate(date);
            String type = model.getValueAt(i, 3).toString();
            switch (type) {
                case "Select":
                    cbVisitType.setSelectedIndex(0);
                    break;
                case "Personal":
                    cbVisitType.setSelectedIndex(1);
                    break;
                case "Business":
                    cbVisitType.setSelectedIndex(2);
                    break;
            }

        } catch (ParseException ex) {
            Logger.getLogger(PVMSvisitorprofile.class.getName()).log(Level.SEVERE, null, ex);
        }
       
//            DefaultTableModel d1 = (DefaultTableModel)tableVisitorInfo.getModel();
//            int selectedIndex = tableVisitorInfo.getSelectedRow();
//           int selectedRow = tableVisitorInfo.getSelectedRow();
//            try {
//            VisitorID = Integer.parseInt(tableVisitorInfo.getValueAt(tableVisitorInfo.getSelectedRow (),0).toString());
//        
//        System.out.println("VisitorID"+VisitorID);
//        Statement stnt = con.createStatement();
//        rs = stnt.executeQuery("SELECT * FROM pvms WHERE VisitorID ="+VisitorID);
//        if(rs.next())
//        {  
//            
//            //String VisitorID = d1.getValueAt(SelectIndex, 0).toString();
//            
//            txtHostName.setText(d1.getValueAt(selectedIndex, 1).toString());
//            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)d1.getValueAt(selectedIndex, 2).toString());
//            dtDateVisit.setDate(date);
//            quax = rs.getInt(5)+ "";
//            String cb = d1.getValueAt(selectedIndex, 3).toString();
//            for (int i = 0; i < cbVisitType.getItemCount(); i++){
//                if (cbVisitType.getItemAt(i).toString().equalsIgnoreCase(cb)){
//                    cbVisitType.setSelectedIndex(i);
//                }
//            }
//        }
//            
//            
//        } catch (ParseException ex) {
//            Logger.getLogger(PVMSvisitorprofile.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(PVMSvisitorprofile.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_tableVisitorInfoMouseClicked

    private void txtLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyReleased
      //JTextField  testField = new JTextField(10);
     
       txtvisitorname.setText(txtLastName.getText() + ", " + txtFirstName.getText() + " " + txtMiddleName.getText());
    }//GEN-LAST:event_txtLastNameKeyReleased

    private void txtvisitornameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvisitornameKeyTyped
     
    }//GEN-LAST:event_txtvisitornameKeyTyped

    private void txtFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyReleased
       txtvisitorname.setText(txtLastName.getText() + ", " + txtFirstName.getText() + " " + txtMiddleName.getText());
    }//GEN-LAST:event_txtFirstNameKeyReleased

    private void txtMiddleNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMiddleNameKeyReleased
       txtvisitorname.setText(txtLastName.getText() + ", " + txtFirstName.getText() +" " + txtMiddleName.getText());
    }//GEN-LAST:event_txtMiddleNameKeyReleased

    private void txtvisitornameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvisitornameActionPerformed
        txtLastName.getText();
        txtFirstName.getText();
        txtMiddleName.getText();
    }//GEN-LAST:event_txtvisitornameActionPerformed

    private void txtHostNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHostNameKeyPressed
     inmateName.setVisible(true);   
     
    }//GEN-LAST:event_txtHostNameKeyPressed

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
            java.util.logging.Logger.getLogger(PVMSvisitorprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PVMSvisitorprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PVMSvisitorprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PVMSvisitorprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PVMSvisitorprofile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbCivilStatus;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JComboBox<String> cbVisitType;
    private com.toedter.calendar.JDateChooser dtBirthDate;
    private com.toedter.calendar.JDateChooser dtDateVisit;
    private javax.swing.JTable inmateName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JTable tableVisitorInfo;
    private javax.swing.JLabel time;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHostName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JTextField txtRelationship;
    private javax.swing.JTextField txtvisitorname;
    // End of variables declaration//GEN-END:variables
}
