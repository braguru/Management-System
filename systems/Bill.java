/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author guru
 */
public class Bill extends javax.swing.JFrame {

    /**
     * Creates new form Bill
     */
    public Bill() {
        initComponents();
        selectBill();
        selectBeverages();
        selectBread();
        selectBakingGoods();
        selectCannedGoods();
        selectDairy();
        GetCat();
    }
    
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    public void selectBill(){
        try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
        St = Con.createStatement();
        Rs = St.executeQuery("select * from Product");
        proTbl.setModel(DbUtils.resultSetToTableModel(Rs));
        
    }catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
    private void GetCat(){
        try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
        St = Con.createStatement();
        String query = "select * from Category";
        Rs = St.executeQuery(query);
        while(Rs.next()){
            String MyCat = Rs.getString("Name");
            selCat.addItem(MyCat);
        }
        
    }catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
    int prid, newQty;
    public void update(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
            String Query = "Update Product set ProductQty="+newQty+""+"where Id="+prid;
            Statement Add = Con.createStatement();
            Add.executeUpdate(Query);
            //JOptionPane.showMessageDialog(this, "Product updated");
            selectBill();
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
    }
    
    public void selectBeverages(){
        try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
        St = Con.createStatement();
        Rs = St.executeQuery("select * from Beverages");
        proTbl.setModel(DbUtils.resultSetToTableModel(Rs));
        } 
    catch(Exception e)
        {
        e.printStackTrace();
        
    }
    }
    
    /**
     *
     */
    public void selectBread(){
        try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
        St = Con.createStatement();
        Rs = St.executeQuery("select * from Bread");
        proTbl.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
     public void selectBakingGoods(){
        try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
        St = Con.createStatement();
        
        Rs = St.executeQuery("select * from BakingGoods");
        proTbl.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(Exception e)
        {
        e.printStackTrace();
        }
    }
     
    public void selectCannedGoods(){
        try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
        St = Con.createStatement();
        
        Rs = St.executeQuery("select * from CannedGoods");
        proTbl.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
    public void selectDairy(){
        try{
        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
        St = Con.createStatement();
        
        Rs = St.executeQuery("select * from Dairy");
        proTbl.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(Exception e)
        {
        e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BillId = new javax.swing.JLabel();
        billId = new javax.swing.JTextField();
        proQuantity = new javax.swing.JTextField();
        proPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        addToBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        proName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        proTbl = new javax.swing.JTable();
        selCat = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clearGrd = new javax.swing.JButton();
        Grd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(30, 3, 84));

        BillId.setForeground(new java.awt.Color(255, 255, 255));
        BillId.setText("Bill Id");

        billId.setBackground(new java.awt.Color(30, 3, 84));
        billId.setForeground(new java.awt.Color(255, 255, 255));
        billId.setToolTipText("enter Id");
        billId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        billId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billIdActionPerformed(evt);
            }
        });

        proQuantity.setBackground(new java.awt.Color(30, 3, 84));
        proQuantity.setForeground(new java.awt.Color(255, 255, 255));
        proQuantity.setToolTipText("enter Id");
        proQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        proQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proQuantityActionPerformed(evt);
            }
        });

        proPrice.setBackground(new java.awt.Color(30, 3, 84));
        proPrice.setForeground(new java.awt.Color(255, 255, 255));
        proPrice.setToolTipText("enter Id");
        proPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        proPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proPriceActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price");

        clearBtn.setText("Clear");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        addToBtn.setText("Add To Bill");
        addToBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addToBtnMouseClicked(evt);
            }
        });
        addToBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToBtnActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/arrow-96-32.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        proName.setBackground(new java.awt.Color(30, 3, 84));
        proName.setForeground(new java.awt.Color(255, 255, 255));
        proName.setToolTipText("enter Id");
        proName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        proName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proNameActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Product Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addToBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(proName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(proQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(billId, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BillId)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(0, 21, Short.MAX_VALUE)))))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addGap(29, 29, 29)
                .addComponent(BillId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(billId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(proName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(proQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(proPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 157, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addToBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        proTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Category", "Name", "Quantity", "Price"
            }
        ));
        proTbl.setIntercellSpacing(new java.awt.Dimension(1, 1));
        proTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(proTbl);

        selCat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selCatItemStateChanged(evt);
            }
        });
        selCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selCatActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel3.setText("Category");

        BillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Quantity", "Price", "Total"
            }
        ));
        jScrollPane3.setViewportView(BillTable);

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel7.setText("Receipt");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 3, 84));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/icons8-close-30.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Nimbus Sans", 1, 20)); // NOI18N
        jLabel1.setText("BILLING POINT");

        clearGrd.setBackground(new java.awt.Color(30, 3, 84));
        clearGrd.setForeground(new java.awt.Color(255, 255, 255));
        clearGrd.setText("Clear");

        Grd.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        Grd.setForeground(new java.awt.Color(30, 3, 84));
        Grd.setText("Total:  Ghc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1)
                        .addGap(337, 337, 337)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(clearGrd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(Grd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(selCat, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selCat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearGrd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Grd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(409, 409, 409))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void billIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billIdActionPerformed

    private void proQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proQuantityActionPerformed

    private void proPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proPriceActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtnActionPerformed

    private void addToBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addToBtnActionPerformed

    private void selCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selCatActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void proNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proNameActionPerformed

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
       billId.setText("");
        proName.setText("");
        proQuantity.setText("");
        proPrice. setText("");
    }//GEN-LAST:event_clearBtnMouseClicked

    int i = 0;
    private void addToBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToBtnMouseClicked
        if(proQuantity.getText().isEmpty()||proName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing information");
        }else if (AvailQty <= Integer.valueOf(proQuantity.getText())){
            JOptionPane.showMessageDialog(this, "Not enough in stock");
        }
        else{
            i++;
            ProTotal = price * Integer.valueOf(proQuantity.getText());
            GrdTotal= GrdTotal + ProTotal;
            if(i==1)
            {
                //BillTable.setText(BillTable.getText()+"    ==== INVENTORY MANAGEMENT SYSTEM ====\n"+"NUM      PRODUCT     PRICE       QUANTITY      TOTAL\n"+"  "+i+"         "+proName.getText()+"           "+price+"           "+proQuantity.getText()+"                  "+ProTotal+"\n");
            }
            else{
                //BillTable.setText(BillTable.getText()+ "  "+  i+"         "+proName.getText()+"           "+price+"           "+proQuantity.getText()+"                  "+ProTotal+"\n");
                Grd.setText("Ghc "+GrdTotal);
                update();
            }
        }
    }//GEN-LAST:event_addToBtnMouseClicked

    Double price, ProTotal=0.0,GrdTotal=0.0;
    int AvailQty;
    private void proTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proTblMouseClicked
           DefaultTableModel model = (DefaultTableModel)proTbl.getModel();
        int Myindex = proTbl.getSelectedRow();
        //proId.setText(model.getValueAt(Myindex, 0).toString());
        prid = Integer.valueOf(model.getValueAt(Myindex, 0).toString());
        proName.setText(model.getValueAt(Myindex, 1).toString());
        AvailQty = Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        price = Double.valueOf(model.getValueAt(Myindex, 3).toString()) ;
        //proQty.setText(model.getValueAt(Myindex, 2).toString());
        newQty = AvailQty - Integer.valueOf(proQuantity.getText());
    }//GEN-LAST:event_proTblMouseClicked

    private void selCatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selCatItemStateChanged
         if(selCat.getSelectedItem().toString().equals("Dry / Baking Goods")||selCat.getSelectedItem().toString().equals("Frozen Foods")||selCat.getSelectedItem().toString().equals("Meat")){
        selectBakingGoods();
        
        }else if(selCat.getSelectedItem().toString().equals("Beverages")){
        selectBeverages();
        }else if(selCat.getSelectedItem().toString().equals("Bread / Bakery")){
        selectBread(); 
        }else if(selCat.getSelectedItem().toString().equals("Canned / Jarred Goods")){
        selectCannedGoods(); 
        }else if(selCat.getSelectedItem().toString().equals("Dairy")){
        selectDairy(); 
        }
               
    }//GEN-LAST:event_selCatItemStateChanged

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
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BillId;
    private javax.swing.JTable BillTable;
    private javax.swing.JLabel Grd;
    private javax.swing.JButton addToBtn;
    private javax.swing.JTextField billId;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearGrd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField proName;
    private javax.swing.JTextField proPrice;
    private javax.swing.JTextField proQuantity;
    private javax.swing.JTable proTbl;
    private javax.swing.JComboBox<String> selCat;
    // End of variables declaration//GEN-END:variables
}
