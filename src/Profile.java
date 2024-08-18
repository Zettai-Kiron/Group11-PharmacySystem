
import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

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


public class Profile extends javax.swing.JFrame {

    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";
    private String username = "";


    public Profile() {
        initComponents();
    }

    public Profile(String tempUsername) {
        initComponents();
        username = tempUsername;
        setLocationRelativeTo(null);
        
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Profile");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 16, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 16, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 78, 850, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 106, -1, -1));

        lblUsername.setText("Username");
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 212, -1, -1));

        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 106, -1, -1));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 128, 300, -1));

        jLabel5.setText("Mobile Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 168, -1, -1));
        getContentPane().add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 190, 300, -1));

        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 224, -1, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 246, 300, -1));


        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, -1, -1));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String name =  txtName.getText();
        String mobileNumber =  txtMobileNumber.getText();
        String email = txtEmail.getText();
        
        if(name.equals("")){
          JOptionPane.showMessageDialog(null, "Name field is required");
        }else if(mobileNumber.equals("")){
          JOptionPane.showMessageDialog(null, "Mobile Number field is required");
        }else if(!mobileNumber.matches(mobileNumberPattern)){
          JOptionPane.showMessageDialog(null, "Mobile Number field is invalid !");
        }else if(email.equals("")){
          JOptionPane.showMessageDialog(null, "Email field is required");
        }else if(!email.matches(emailPattern)){
          JOptionPane.showMessageDialog(null, "Email field is invalid");
        }
        else{
            try{
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update appuser set name=?, mobileNumber=?, email=?, address=? where username=?");
            ps.setString(1, name);
            ps.setString(2, mobileNumber);
            ps.setString(3, email);
            ps.setString(5, username);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Profile successfully updated");   
            setVisible(false);
            new Profile(username).setVisible(true);
            }
            catch(Exception e){
         JOptionPane.showMessageDialog(null, e);

            }
        }
        
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        try{
       Connection con = ConnectionProvider.getCon();
       Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select *from appuser where username ='" + username + "'");
             while(rs.next()){
                 txtName.setText(rs.getString("name"));
                 txtMobileNumber.setText(rs.getString("mobileNumber"));
                 txtEmail.setText(rs.getString("email"));
                 lblUsername.setText(username);

             }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtName;

}
