 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sharma computer care
 */
public class Purchase extends javax.swing.JFrame {

    /**
     * Creates new form Purchase
     */
    public Purchase() {
        initComponents();
        Connect();
        load();
    }
    Connection con;
    PreparedStatement pst,pstt;
    DefaultTableModel df;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/stockmgmt","root","");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(suppliers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(suppliers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateStock()
    {
        try {
            String product_id = txtproductid.getText();
            String product_name = txtproductname.getText();
            String unit = txtunit.getText();
            int quantity = Integer.parseInt(txtquantity.getText());
            float total_value = Float.valueOf(txttotalvalue.getText());

        
            float price_per_unit = total_value/Float.valueOf(quantity);
            
            pst = con.prepareStatement("insert into stock(product_id,product_name,unit,quantity,total_value,price_per_unit) values(?,?,?,?,?,?)");
            pst.setString(1,product_id);
            pst.setString(2,product_name);
            pst.setString(3,unit);
            pst.setInt(4,quantity);
            pst.setFloat(5,total_value);
            pst.setFloat(6,price_per_unit);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void load(){
        
        
        int a;
        try {
            pst = con.prepareStatement("select * from purchase");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            a = rd.getColumnCount();
            df =(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i =1;i<=a;i++){
                    v2.add(rs.getString("invoice_num"));
                    v2.add(rs.getString("product_id"));
                    v2.add(rs.getString("product_name"));
                    v2.add(rs.getString("supplier_name"));
                    v2.add(rs.getString("supplier_id"));
                    v2.add(rs.getString("GSTN"));
                    v2.add(rs.getString("unit"));
                    v2.add(rs.getString("quantity"));
                    v2.add(rs.getString("rate"));
                    v2.add(rs.getString("vat_num"));
                    v2.add(rs.getString("amount"));
                    v2.add(rs.getString("int_out"));
                    v2.add(rs.getString("gst_percent"));
                    v2.add(rs.getString("igst"));
                    v2.add(rs.getString("cgst"));
                    v2.add(rs.getString("sgst"));
                    v2.add(rs.getString("unloading"));
                    v2.add(rs.getString("freight"));
                    v2.add(rs.getString("vat_percent"));
                    v2.add(rs.getString("vat_value"));
                    v2.add(rs.getString("total_value"));
                    
                    
                }
                df.addRow(v2);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(suppliers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtproductid = new javax.swing.JTextField();
        txtproductname = new javax.swing.JTextField();
        txtsuppliername = new javax.swing.JTextField();
        txtvatnumber = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();
        txtunit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtgstn = new javax.swing.JTextField();
        txtinout = new javax.swing.JTextField();
        txttaxableamount = new javax.swing.JTextField();
        txtcgst = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtigst = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtsgst = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtunloading = new javax.swing.JTextField();
        txtfreight = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtgstpercent = new javax.swing.JTextField();
        txtvatpercent = new javax.swing.JTextField();
        txtvatvalue = new javax.swing.JTextField();
        txttotalvalue = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtinvoicenumber = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtsupplierid = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtrate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Product ID");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Product Name");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Supplier Name");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("GSTN");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Unit");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Quantity");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("VAT number");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Taxable Value");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Unloading");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("IGST");

        txtinout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinoutActionPerformed(evt);
            }
        });

        txttaxableamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttaxableamountFocusGained(evt);
            }
        });

        txtcgst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcgstFocusGained(evt);
            }
        });
        txtcgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcgstActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("SGST");

        txtigst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtigstFocusGained(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("CGST");

        txtsgst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsgstFocusGained(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("In/Out");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Freight");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("VAT Percent");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Total Value");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("VAT Value");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("GST Percent");

        txtgstpercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgstpercentActionPerformed(evt);
            }
        });

        txtvatvalue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtvatvalueFocusGained(evt);
            }
        });

        txttotalvalue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttotalvalueFocusGained(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Invoice Number");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Supplier Id");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Rate");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtsuppliername, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtproductid, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtgstn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtinvoicenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtsupplierid, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtquantity))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtinout, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtvatnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txttaxableamount, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtgstpercent, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtrate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txttotalvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtvatvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtvatpercent, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtfreight, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtunloading, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(txtigst, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtcgst, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)
                                    .addGap(22, 22, 22)
                                    .addComponent(txtsgst, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtinvoicenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproductid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsuppliername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsupplierid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgstn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvatnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtinout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgstpercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtigst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txttaxableamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtunloading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfreight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvatpercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvatvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice number", "Product ID", "Product Name", "Supplier Name", "Supplier ID", "GSTN", "Unit", "Quantity", "Rate", "VAT Number", "Taxable Amount", "IN/OUT", "GST Percent", "IGST", "CGST", "SGST", "Unloading", "Freight", "VAT Percent", "Vat Value", "Total Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 29)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Purchase Entry");

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Date");

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtinoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtinoutActionPerformed

    private void txtgstpercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgstpercentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgstpercentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        df = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow();
        int invoice = Integer.parseInt(df.getValueAt(selected,0).toString());
        
        try {
            pst = con.prepareStatement("delete from purchase where invoice_num=?");
            pst.setInt(1,invoice);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Purchase Deleted");
            
            txtinvoicenumber.setText("");
            txtproductid.setText("");
            txtproductname.setText("");
            txtsuppliername.setText("");
            txtsupplierid.setText("");
            txtgstn.setText("");
            txtunit.setText("");
            txtquantity.setText("");
            txtrate.setText("");
            txtvatnumber.setText("");
            txttaxableamount.setText("");
            txtinout.setText("");
            txtgstpercent.setText("");
            txtigst.setText("");
            txtcgst.setText("");
            txtsgst.setText("");
            txtunloading.setText("");
            txtfreight.setText("");
            txtvatpercent.setText("");
            txtvatvalue.setText("");
            txttotalvalue.setText("");
            
            
            txtinvoicenumber.requestFocus();
            load();
            jButton2.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        txtinvoicenumber.setText("");
            txtproductid.setText("");
            txtproductname.setText("");
            txtsuppliername.setText("");
            txtsupplierid.setText("");
            txtgstn.setText("");
            txtunit.setText("");
            txtquantity.setText("");
            txtrate.setText("");
            txtvatnumber.setText("");
            txttaxableamount.setText("");
            txtinout.setText("");
            txtgstpercent.setText("");
            txtigst.setText("");
            txtcgst.setText("");
            txtsgst.setText("");
            txtunloading.setText("");
            txtfreight.setText("");
            txtvatpercent.setText("");
            txtvatvalue.setText("");
            txttotalvalue.setText("");
            
            
            txtinvoicenumber.requestFocus();
            jButton2.setEnabled(true);
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtcgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        df = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow();
        int invoice = Integer.parseInt(df.getValueAt(selected,0).toString());
        
        try {
            
            
            int invoice_num = Integer.parseInt(txtinvoicenumber.getText());
            String product_id = txtproductid.getText();
            String product_name = txtproductname.getText();
            String supplier_name = txtsuppliername.getText();
            String supplier_id = txtsupplierid.getText();
            String gstn = txtgstn.getText();
            String unit = txtunit.getText();
            int quantity = Integer.parseInt(txtquantity.getText());
            float rate = Float.valueOf(txtrate.getText());
            String vat_num = txtvatnumber.getText();
            float amount = Float.valueOf(txttaxableamount.getText());
            String in_out = txtinout.getText();
            int gst_percent = Integer.parseInt(txtgstpercent.getText());
            float igst = Float.valueOf(txtigst.getText());
            float cgst = Float.valueOf(txtcgst.getText());
            float sgst = Float.valueOf(txtsgst.getText());
            int unloading = Integer.parseInt(txtunloading.getText());
            int freight = Integer.parseInt(txtfreight.getText());
            int vat_percent = Integer.parseInt(txtvatpercent.getText());
            float vat_value = Float.valueOf(txtvatvalue.getText());
            float total_value = Float.valueOf(txttotalvalue.getText());
            
            
            pst = con.prepareStatement("update purchase set invoice_num=?,product_id=?,product_name=?,supplier_name=?,supplier_id=?,GSTN=?,unit=?,quantity=?,rate=?,vat_num=?,amount=?,int_out=?,gst_percent=?,igst=?,cgst=?,sgst=?,unloading=?,freight=?,vat_percent=?,vat_value=?,total_value=? where invoice_num=?");
            pst.setInt(1,invoice_num);
            pst.setString(2,product_id);
            pst.setString(3,product_name);
            pst.setString(4,supplier_name);
            pst.setString(5,supplier_id);
            pst.setString(6,gstn);
            pst.setString(7,unit);
            pst.setInt(8,quantity);
            pst.setFloat(9,rate);
            pst.setString(10,vat_num);
            pst.setFloat(11,amount);
            pst.setString(12,in_out);
            pst.setInt(13,gst_percent);
            pst.setFloat(14,igst);
            pst.setFloat(15,cgst);
            pst.setFloat(16,sgst);
            pst.setInt(17,unloading);
            pst.setInt(18,freight);
            pst.setInt(19,vat_percent);
            pst.setFloat(20,vat_value);
            pst.setFloat(21,total_value);
            pst.setInt(22,invoice);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Purchase Updated");
            updateStock();
            txtinvoicenumber.setText("");
            txtproductid.setText("");
            txtproductname.setText("");
            txtsuppliername.setText("");
            txtsupplierid.setText("");
            txtgstn.setText("");
            txtunit.setText("");
            txtquantity.setText("");
            txtrate.setText("");
            txtvatnumber.setText("");
            txttaxableamount.setText("");
            txtinout.setText("");
            txtgstpercent.setText("");
            txtigst.setText("");
            txtcgst.setText("");
            txtsgst.setText("");
            txtunloading.setText("");
            txtfreight.setText("");
            txtvatpercent.setText("");
            txtvatvalue.setText("");
            txttotalvalue.setText("");
            
            
            txtinvoicenumber.requestFocus();
            load();
            jButton2.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(suppliers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            
            int invoice_num = Integer.parseInt(txtinvoicenumber.getText());
            String product_id = txtproductid.getText();
            String product_name = txtproductname.getText();
            String supplier_name = txtsuppliername.getText();
            String supplier_id = txtsupplierid.getText();
            String gstn = txtgstn.getText();
            String unit = txtunit.getText();
            int quantity = Integer.parseInt(txtquantity.getText());
            float rate = Float.valueOf(txtrate.getText());
            String vat_num = txtvatnumber.getText();
            float amount = Float.valueOf(txttaxableamount.getText());
            String in_out = txtinout.getText();
            int gst_percent = Integer.parseInt(txtgstpercent.getText());
            float igst = Float.valueOf(txtigst.getText());
            float cgst = Float.valueOf(txtcgst.getText());
            float sgst = Float.valueOf(txtsgst.getText());
            int unloading = Integer.parseInt(txtunloading.getText());
            int freight = Integer.parseInt(txtfreight.getText());
            int vat_percent = Integer.parseInt(txtvatpercent.getText());
            float vat_value = Float.valueOf(txtvatvalue.getText());
            float total_value = Float.valueOf(txttotalvalue.getText());
            
            pst = con.prepareStatement("insert into purchase(invoice_num,product_id,product_name,supplier_name,supplier_id,GSTN,unit,quantity,rate,vat_num,amount,int_out,gst_percent,igst,cgst,sgst,unloading,freight,vat_percent,vat_value,total_value) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setInt(1,invoice_num);
            pst.setString(2,product_id);
            pst.setString(3,product_name);
            pst.setString(4,supplier_name);
            pst.setString(5,supplier_id);
            pst.setString(6,gstn);
            pst.setString(7,unit);
            pst.setInt(8,quantity);
            pst.setFloat(9,rate);
            pst.setString(10,vat_num);
            pst.setFloat(11,amount);
            pst.setString(12,in_out);
            pst.setInt(13,gst_percent);
            pst.setFloat(14,igst);
            pst.setFloat(15,cgst);
            pst.setFloat(16,sgst);
            pst.setInt(17,unloading);
            pst.setInt(18,freight);
            pst.setInt(19,vat_percent);
            pst.setFloat(20,vat_value);
            pst.setFloat(21,total_value);
            
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,"Purchase Added");
            txtinvoicenumber.setText("");
            txtproductid.setText("");
            txtproductname.setText("");
            txtsuppliername.setText("");
            txtsupplierid.setText("");
            txtgstn.setText("");
            txtunit.setText("");
            txtquantity.setText("");
            txtrate.setText("");
            txtvatnumber.setText("");
            txttaxableamount.setText("");
            txtinout.setText("");
            txtgstpercent.setText("");
            txtigst.setText("");
            txtcgst.setText("");
            txtsgst.setText("");
            txtunloading.setText("");
            txtfreight.setText("");
            txtvatpercent.setText("");
            txtvatvalue.setText("");
            txttotalvalue.setText("");
            txtinvoicenumber.requestFocus();
            load(); 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(suppliers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
         
        df = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow();
        int invoice = Integer.parseInt(df.getValueAt(selected,0).toString());
        txtinvoicenumber.setText(df.getValueAt(selected,0).toString());
        txtproductid.setText(df.getValueAt(selected,1).toString());
            txtproductname.setText(df.getValueAt(selected,2).toString());
            txtsuppliername.setText(df.getValueAt(selected,3).toString());
            txtsupplierid.setText(df.getValueAt(selected,4).toString());
            txtgstn.setText(df.getValueAt(selected,5).toString());
            txtunit.setText(df.getValueAt(selected,6).toString());
            txtquantity.setText(df.getValueAt(selected,7).toString());
            txtrate.setText(df.getValueAt(selected,8).toString());
            txtvatnumber.setText(df.getValueAt(selected,9).toString());
            txttaxableamount.setText(df.getValueAt(selected,10).toString());
            txtinout.setText(df.getValueAt(selected,11).toString());
            txtgstpercent.setText(df.getValueAt(selected,12).toString());
            txtigst.setText(df.getValueAt(selected,13).toString());
            txtcgst.setText(df.getValueAt(selected,14).toString());
            txtsgst.setText(df.getValueAt(selected,15).toString());
            txtunloading.setText(df.getValueAt(selected,16).toString());
            txtfreight.setText(df.getValueAt(selected,17).toString());
            txtvatpercent.setText(df.getValueAt(selected,18).toString());
            txtvatvalue.setText(df.getValueAt(selected,19).toString());
            txttotalvalue.setText(df.getValueAt(selected,20).toString());
        
        
        jButton2.setEnabled(false);

    }//GEN-LAST:event_jTable1MouseClicked

    private void txttaxableamountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttaxableamountFocusGained
        try{
        float taxableamount = Integer.parseInt(txtquantity.getText()) * Float.valueOf(txtrate.getText());
        txttaxableamount.setText(String.valueOf(taxableamount));
        }
        catch(Exception e)
        {            
        }
    }//GEN-LAST:event_txttaxableamountFocusGained

    private void txtigstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtigstFocusGained
        try{
        String inout = txtinout.getText();
        if ("I".equals(inout)){
            txtigst.setText("0");
            
        }
        else if ("O".equals(inout)){
            float igst = Float.valueOf(txttaxableamount.getText()) * Float.valueOf(txtgstpercent.getText()) / 100 ;
            txtigst.setText(String.valueOf(igst));
        }
        }
        catch (Exception e){}
    }//GEN-LAST:event_txtigstFocusGained

    private void txtcgstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcgstFocusGained
        try{
        if ("O".equals(txtinout.getText())){
            txtcgst.setText("0");
            txtsgst.setText("0");
        }
        else if ("I".equals(txtinout.getText()))
        {
            float per = Float.valueOf(txtgstpercent.getText()) / 2;
            float cgst = Float.valueOf(txttaxableamount.getText()) * per / 100 ;
            txtcgst.setText(String.valueOf(cgst));
            txtsgst.setText(String.valueOf(cgst));
   
        }}
        catch (Exception e){}
    }//GEN-LAST:event_txtcgstFocusGained

    private void txtsgstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsgstFocusGained
        try{
        if ("O".equals(txtinout.getText())){
            txtsgst.setText("0");
            txtcgst.setText("0");
        }
        else if ("I".equals(txtinout.getText()))
        {
            float per2 = Float.valueOf(txtgstpercent.getText()) / 2;
            float sgst = Float.valueOf(txttaxableamount.getText()) * per2 / 100 ;
            txtsgst.setText(String.valueOf(sgst));
            txtcgst.setText(String.valueOf(sgst));
   
        }}
        catch (Exception e){}
    }//GEN-LAST:event_txtsgstFocusGained

    private void txtvatvalueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvatvalueFocusGained
        try{
        float per = Float.valueOf(txtvatpercent.getText());
        float vatvalue = Float.valueOf(txttaxableamount.getText()) * per /100;
        txtvatvalue.setText(String.valueOf(vatvalue));
        }
        catch(Exception e)
        {
        }
        
    }//GEN-LAST:event_txtvatvalueFocusGained

    private void txttotalvalueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttotalvalueFocusGained
        try{
            float total = Float.valueOf(txttaxableamount.getText()) + Float.valueOf(txtigst.getText()) + Float.valueOf(txtcgst.getText()) + Float.valueOf(txtsgst.getText()) + Float.valueOf(txtunloading.getText()) + Float.valueOf(txtfreight.getText()) + Float.valueOf(txtvatvalue.getText());
            txttotalvalue.setText(String.valueOf(total));
        }
        catch(Exception e)
        {            
        }
    }//GEN-LAST:event_txttotalvalueFocusGained
    
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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcgst;
    private javax.swing.JTextField txtfreight;
    private javax.swing.JTextField txtgstn;
    private javax.swing.JTextField txtgstpercent;
    private javax.swing.JTextField txtigst;
    private javax.swing.JTextField txtinout;
    private javax.swing.JTextField txtinvoicenumber;
    private javax.swing.JTextField txtproductid;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtquantity;
    private javax.swing.JTextField txtrate;
    private javax.swing.JTextField txtsgst;
    private javax.swing.JTextField txtsupplierid;
    private javax.swing.JTextField txtsuppliername;
    private javax.swing.JTextField txttaxableamount;
    private javax.swing.JTextField txttotalvalue;
    private javax.swing.JTextField txtunit;
    private javax.swing.JTextField txtunloading;
    private javax.swing.JTextField txtvatnumber;
    private javax.swing.JTextField txtvatpercent;
    private javax.swing.JTextField txtvatvalue;
    // End of variables declaration//GEN-END:variables
}
