
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import dao.ConnectionProvider;
import dao.PharmacyUtils;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors  Jude Kiron Mensah - 10947803
Teye Elisha - 10940920
Kelvin Sasu - 10981962
Eyram Ampobi - 10977614
Gyamfi Caleb Jeff  - 10967054
Daniel Elijah Gyan - 10956566
Koomson Jojo Emeka - 10954302
 */
public class SellMedicine extends javax.swing.JFrame {

    public String numberPattern = "^[0-9]*$";
    private int finalTotalPrice = 0;
    private String billId = " ";
    private String username = "";


    public SellMedicine() {
        initComponents();
    }

    public SellMedicine(String tempUsername) {
        initComponents();
        username = tempUsername;
        setLocationRelativeTo(null);
    }

    private void medicineName(String nameOrUniqueId) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) medicinesTable.getModel();
        model.setRowCount(0);
       try{
           Connection con = ConnectionProvider.getCon();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select *from medicine where name like '"+nameOrUniqueId+"%' or uniqueId like'"+nameOrUniqueId+"%'");
           while(rs.next()){
               model.addRow(new Object[]{rs.getString("UniqueId")+"- "+rs.getString("name")});
               
       }}
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
           
           
           
           }
        
         private void clearMedicineFields(){
         txtUniqueId.setText("");
         txtName.setText("");
         txtCompanyName.setText("");
         txtPricePerUnit.setText("");
         txtNoOfUnits.setText("");
         txtTotalPrice.setText("");
         }

         public String getUniqueId(String prefix){
             return prefix + System.nanoTime();
         
         
         }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicinesTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtUniqueId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPricePerUnit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNoOfUnits = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sell Medicine");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 12, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 72, 1360, 10));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 100, -1, -1));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 122, 301, -1));

        medicinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicines"
            }
        ));
        medicinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicinesTableMouseClicked(evt);
            }
        });
        medicinesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                medicinesTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(medicinesTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 150, 301, 540));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Medicine ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 100, -1, -1));

        txtUniqueId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtUniqueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 134, 300, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 193, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 227, 300, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Company Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 277, -1, -1));

        txtCompanyName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 311, 300, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price Per Unit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, -1, -1));

        txtPricePerUnit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 134, 300, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No. Of Units");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 193, -1, -1));

        txtNoOfUnits.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNoOfUnits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoOfUnitsKeyReleased(evt);
            }
        });
        getContentPane().add(txtNoOfUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 227, 300, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 277, -1, -1));

        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 311, 300, -1));

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Name", "Company Name", "Price Per Unit", "No. Of Units", "Total Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 409, 684, 280));

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 351, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("GHC:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 710, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFinalTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblFinalTotalPrice.setText("OO");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 710, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        jButton3.setText("Purchase & Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 710, 250, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adminDashboardBackground.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1370, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        
        try {
            medicineName("");
        } catch (SQLException ex) {
            Logger.getLogger(SellMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtUniqueId.setEditable(false);
        txtName.setEditable(false);
        txtCompanyName.setEditable(false);
        txtPricePerUnit.setEditable(false);
        txtTotalPrice.setEditable(false);
        
    }

    private void medicinesTableKeyReleased(java.awt.event.KeyEvent evt) {
        int index = medicinesTable.getSelectedRow();
        TableModel model = medicinesTable.getModel();
        String nameOrUniqueId = model.getValueAt(index, 0).toString();
        
        String uniqueId[] = nameOrUniqueId.split("-",0);
        try{
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from medicine where uniqueId = '" + nameOrUniqueId + "'");
        while(rs.next()){
        txtUniqueId.setText(uniqueId[0]);
        txtName.setText(rs.getString("name"));
        txtCompanyName.setText(rs.getString("CompanyName"));
        txtPricePerUnit.setText(rs.getString("price"));
        txtNoOfUnits.setText("");
        txtTotalPrice.setText("");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
}
        
    }

    private void txtNoOfUnitsKeyReleased(java.awt.event.KeyEvent evt) {
        String noOfUnits = txtNoOfUnits.getText();
        if (!noOfUnits.equals("")){
        String price = txtPricePerUnit.getText();
        if(!noOfUnits.matches(numberPattern)){
        JOptionPane.showMessageDialog(null, "number of Units field is invalid.");
        }
        int totalPrice = Integer.parseInt(noOfUnits) * Integer.parseInt(price);
        txtTotalPrice.setText(String.valueOf(totalPrice));
        }
        else{
        txtTotalPrice.setText("");
        }
    }

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {
        String noOfUnits = txtNoOfUnits.getText();
        String uniqueId = txtUniqueId.getText();
        if(!noOfUnits.equals("") && !uniqueId.equals("")){
            String name = txtName.getText();
            String companyName = txtCompanyName.getText();
            String pricePerUnit = txtPricePerUnit.getText();
            String totalPrice = txtTotalPrice.getText();
            int checkStock = 0;
            int checkMedicineAlreadyExistInCart = 0;
            
            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select *from medicine where uniqueId="+uniqueId+"");
                while(rs.next()){
                    if(rs.getInt("quantity") >= Integer.parseInt(noOfUnits)){
                        checkStock = 1;
                    }else{
                        JOptionPane.showMessageDialog(null, "Medicine is out of stock. Only "+rs.getInt("quantity")+"Left");
                    }
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
           if (checkStock == 1) {
    DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
    if (cartTable.getRowCount() != 0) {
        for (int i = 0; i < cartTable.getRowCount(); i++) {
            Object value = dtm.getValueAt(i, 0);
            if (value != null && Integer.parseInt(value.toString()) == Integer.parseInt(uniqueId)) {
                checkMedicineAlreadyExistInCart = 1;
                JOptionPane.showMessageDialog(null, "Medicine already exists in cart");
                break; // Exit loop if medicine is found
            }
        }
    }
    if (checkMedicineAlreadyExistInCart == 0) {
        dtm.addRow(new Object[]{uniqueId, name, companyName, pricePerUnit, noOfUnits, totalPrice});
        finalTotalPrice += Integer.parseInt(totalPrice);
        lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
        JOptionPane.showMessageDialog(null, "Added Successfully");
    }
    clearMedicineFields();
}


            
        }else{
            JOptionPane.showMessageDialog(null, "NO of Units and Medicine ID field is required");
        }
    }

    
    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {
        int index = cartTable.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this medicine","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            TableModel model = cartTable.getModel();
            String total = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(total);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel)cartTable.getModel()).removeRow(index);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(finalTotalPrice !=0){
            billId = getUniqueId("Bill-");
            
            DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
             if (dtm == null) {
            JOptionPane.showMessageDialog(null, "Error: cartTable model is not initialized properly.");
            return;
        }

        if (cartTable == null) {
            JOptionPane.showMessageDialog(null, "Error: cartTable is not initialized properly.");
            return;
        }
            if(cartTable.getRowCount() !=0){
                for(int i=0;i<cartTable.getRowCount();i++){
                    try{
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        st.executeUpdate("update medicine set quantity=quantity-"+Integer.parseInt(dtm.getValueAt(i,4).toString())+ " where uniqueId="+Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                    }
                    catch(Exception e){
                            JOptionPane.showMessageDialog(null, e);
                        
                    }
                }
                    
            }
            try{
                SimpleDateFormat myFormat= new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into bill(billId,billDate,totalPaid,generatedBy) values(?,?,?,?)");
                ps.setString(1, billId);
                ps.setString(2,myFormat.format(cal.getTime()));
                ps.setInt(3, finalTotalPrice);
                ps.setString(4, username);
                ps.executeUpdate();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            
            //Create bill
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try{
                PdfWriter.getInstance(doc,new FileOutputStream(PharmacyUtils.billPath+""+billId+".pdf"));
                doc.open();
                Paragraph pharmacyName = new Paragraph("                    Pharmacy Management System\n"); 
                Paragraph starLine = new Paragraph("*****************************************");
                doc.add(starLine);
                Object billId = null;
                Paragraph details = new Paragraph("\tBill ID:  "+billId+"\nDate: "+ new Date()+"\nTotal Piad: "+finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                PdfPTable tbl = new PdfPtable(6);
                tbl.addCell("Medicine ID");
                tbl.addCell("Name");
                tbl.addCell("Company Name");
                tbl.addCell("Price Per Uunit");
                tbl.addCell("No of Units");
                tbl.addCell("Sub Total Price");
                for(int i=0;i<cartTable.getRowCount();i++){
                    String a=cartTable.getValueAt(i,0).toString();
                    String b=cartTable.getValueAt(i,1).toString();
                    String c=cartTable.getValueAt(i,2).toString();
                    String d=cartTable.getValueAt(i,3).toString();
                    String e=cartTable.getValueAt(i,4).toString();
                    String f=cartTable.getValueAt(i,5).toString();
                    tbl.addCell(a);
                    tbl.addCell(b);
                    tbl.addCell(c);
                    tbl.addCell(d);
                    tbl.addCell(e);
                    tbl.addCell(f);
                }
                doc.add(tbl);
                doc.add(starLine);
                Paragraph thanksMsg = new Paragraph("Thank you, Please Visit Again.");
                doc.add(thanksMsg);
                OpenPdf.openById(String.valueOf(billId));
                

                OpenPdf.openById(String.valueOf(billId));
                
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new SellMedicine(username).setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "Please add some medicine to cart"); 
       }
    }

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {
        String search = txtSearch.getText();
        try {
            medicineName(search);
        } catch (SQLException ex) {
            Logger.getLogger(SellMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void medicinesTableMouseClicked(java.awt.event.MouseEvent evt) {

        int index = medicinesTable.getSelectedRow();
    TableModel model = medicinesTable.getModel();
    String nameOrUniqueId = model.getValueAt(index, 0).toString();

    String[] uniqueId = nameOrUniqueId.split("-", 0);
    try {
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM medicine WHERE uniqueId='" + uniqueId[0] + "'");
        while (rs.next()) {
            txtUniqueId.setText(uniqueId[0]);
            txtName.setText(rs.getString("name"));
            txtCompanyName.setText(rs.getString("companyName"));
            txtPricePerUnit.setText(rs.getString("price"));
            txtNoOfUnits.setText("");
            txtTotalPrice.setText("");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAddToCart;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable medicinesTable;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNoOfUnits;
    private javax.swing.JTextField txtPricePerUnit;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUniqueId;

   

    private static class PdfPtable extends PdfPTable {

        public PdfPtable(int i) {
        }
    }

    private static class OpenPdf {

        private static void openById(String valueOf) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
