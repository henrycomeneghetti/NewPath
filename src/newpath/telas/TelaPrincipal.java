/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newpath.telas;

import dao.ContadorDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modelo.Contador;
 import javax.swing.Timer;

/**
 *
 * @author hmq48
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private String loginUsuario;
    

    /**
     * Creates new form TelaPrincipal
     */
        public TelaPrincipal() {
            initComponents();
            getContentPane().setBackground(new Color(40, 40, 40));
        }
        
        public TelaPrincipal(String login){
            initComponents();
            this.loginUsuario = login;
            getContentPane().setBackground(new Color(40, 40, 40));
            ImagePanel imgPanel1 = new ImagePanel(getClass().getResource("/img/logo.png"));

            imgPanel1.setBounds(panelLogo.getBounds());
            this.remove(panelLogo);
            this.add(imgPanel1);
            this.repaint();
            menuNewPath.setBackground(new Color(40, 40, 40));
            



            
            
           
            lblOla.setText("Bem-vindo, " + loginUsuario + "!");
            Date dataEntrada;
            LocalDate  atualData = LocalDate.now(); 
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String dataStr = atualData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
                dataEntrada = new Date(format.parse(dataStr).getTime());
            } 
        
            catch (ParseException e) {
                throw new RuntimeException(e);
            }
        
            Contador contador = new Contador();
            contador.setLogin(loginUsuario);
            ContadorDao contadorDao = new ContadorDao();
            Contador contadorComData = contadorDao.getDataAtualByLogin(loginUsuario);
            Date dataAtual = contadorComData.getDataAtual();
            String vicio = contadorComData.getVicio();
            if (dataAtual != null) {
            long diferencaMillis = dataEntrada.getTime() - dataAtual.getTime();
            long diasSobriedade = TimeUnit.MILLISECONDS.toDays(diferencaMillis);
            String diasSobriedadeStr = String.valueOf(diasSobriedade);
            int diasSobriedadeInt = (int) diasSobriedade;  
            if (diasSobriedadeInt == 0){
               panelImagem.setVisible(false);
               
            }
            if (diasSobriedadeInt == 1){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/1.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
           TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
           telaContador.setVisible(true);
            }
            });
            }
            
            if (diasSobriedadeInt == 2){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/2.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
                telaContador.setVisible(true);
            }
            });
            }
            
            if (diasSobriedadeInt == 3){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/3.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
            telaContador.setVisible(true);
            }
            });
            }
            
            if (diasSobriedadeInt == 4){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/4.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
            telaContador.setVisible(true);
            }
            });
            }
            
             if (diasSobriedadeInt == 5){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/5.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
            telaContador.setVisible(true);
            }
            });
            }
            
             if (diasSobriedadeInt == 6){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/6.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
            telaContador.setVisible(true);
            }
            });
            }
             
             
            
            if (diasSobriedadeInt >= 7 && diasSobriedadeInt < 30){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/7.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
            telaContador.setVisible(true);
            }
            });
            }
            
            if (diasSobriedadeInt >= 30 && diasSobriedadeInt < 365){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/8.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
            telaContador.setVisible(true);
            }
            });
            }
            if (diasSobriedadeInt >= 365){
            ImagePanel imgPanel = new ImagePanel(getClass().getResource("/img/9.png"));
            imgPanel.setBounds(panelImagem.getBounds());
            this.remove(panelImagem);
            this.add(imgPanel);
            this.repaint();
            imgPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
            telaContador.setVisible(true);
            }
            });
            }
            if (diasSobriedadeInt == 7) {
                Timer timer = new Timer(1000, e -> {
                TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
                telaContador.setVisible(true);
                
                });
                timer.setRepeats(false);
                timer.start();
            }
            if (diasSobriedadeInt == 30){
                Timer timer = new Timer(1000, e -> {
                TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
                telaContador.setVisible(true);
                
                });
                timer.setRepeats(false);
                timer.start();
            
            }
             if (diasSobriedadeInt == 365){
               

                Timer timer = new Timer(1000, e -> {
                TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
                telaContador.setVisible(true);
                
                });
                timer.setRepeats(false); 
                timer.start();
 
                
            
            }
            
            
            
            
                
            
            
            
        }
        if(loginUsuario == "") {
          

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

        jMenu2 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        lblOla = new javax.swing.JLabel();
        btnNotas = new GradientButton("Notas");
        btnContadorSobriedade = new GradientButton("Contador");
        btnFechar = new GradientButton1("Fechar");
        painel1 = new java.awt.Panel();
        panelImagem = new javax.swing.JPanel();
        btnEstimativaEconomia = new GradientButton("Economia");
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panelLogo = new java.awt.Panel();
        lblFrase = new javax.swing.JLabel();
        menuNewPath = new javax.swing.JMenuBar();
        newpath = new javax.swing.JMenu();

        jMenu2.setText("jMenu2");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));

        lblOla.setBackground(new java.awt.Color(255, 255, 255));
        lblOla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblOla.setForeground(new java.awt.Color(255, 255, 255));
        lblOla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOla.setText("Bem vindo, ********************");
        lblOla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnNotas.setBackground(new java.awt.Color(0, 0, 255));
        btnNotas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNotas.setForeground(new java.awt.Color(255, 255, 255));
        btnNotas.setText("Notas");
        btnNotas.setAutoscrolls(true);
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });

        btnContadorSobriedade.setBackground(new java.awt.Color(0, 0, 255));
        btnContadorSobriedade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnContadorSobriedade.setForeground(new java.awt.Color(255, 255, 255));
        btnContadorSobriedade.setText("Contador");
        btnContadorSobriedade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContadorSobriedadeActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        painel1.setLayout(new java.awt.BorderLayout());

        panelImagem.setBackground(new java.awt.Color(40, 40, 40));
        panelImagem.setForeground(new java.awt.Color(30, 30, 30));
        panelImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelImagemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelImagemLayout = new javax.swing.GroupLayout(panelImagem);
        panelImagem.setLayout(panelImagemLayout);
        panelImagemLayout.setHorizontalGroup(
            panelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        panelImagemLayout.setVerticalGroup(
            panelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        btnEstimativaEconomia.setBackground(new java.awt.Color(0, 0, 255));
        btnEstimativaEconomia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEstimativaEconomia.setForeground(new java.awt.Color(255, 255, 255));
        btnEstimativaEconomia.setText("Economia");
        btnEstimativaEconomia.setAutoscrolls(true);
        btnEstimativaEconomia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstimativaEconomiaActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelLogo.setBackground(new java.awt.Color(40, 40, 40));
        panelLogo.setForeground(new java.awt.Color(40, 40, 40));

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        lblFrase.setForeground(new java.awt.Color(255, 255, 255));
        lblFrase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrase.setText("Um Novo Caminho para a mudança de vida");

        newpath.setText("NewPath");
        menuNewPath.add(newpath);

        setJMenuBar(menuNewPath);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblOla, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnContadorSobriedade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEstimativaEconomia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblFrase, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblOla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFrase)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnContadorSobriedade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEstimativaEconomia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFechar)
                            .addComponent(panelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        panelLogo.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasActionPerformed
        // TODO add your handling code here:
        TelaNotas telaNotas = new TelaNotas(loginUsuario);
        telaNotas.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnNotasActionPerformed

    private void btnContadorSobriedadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContadorSobriedadeActionPerformed
        // TODO add your handling code here:
        TelaContadorSobriedade telaContador = new TelaContadorSobriedade(loginUsuario);
        telaContador.setVisible(true);
        
        
    }//GEN-LAST:event_btnContadorSobriedadeActionPerformed

    private void panelImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelImagemMouseClicked
        // TODO add your handling code here:
        
        
            
            
        
        
    }//GEN-LAST:event_panelImagemMouseClicked

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnEstimativaEconomiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstimativaEconomiaActionPerformed
        // TODO add your handling code here:
        TelaEstimativaDeEconomia telaEconomia = new TelaEstimativaDeEconomia(loginUsuario);
        telaEconomia.setVisible(true);
        
        
        
        
    }//GEN-LAST:event_btnEstimativaEconomiaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContadorSobriedade;
    private javax.swing.JButton btnEstimativaEconomia;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNotas;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblFrase;
    private javax.swing.JLabel lblOla;
    private javax.swing.JMenuBar menuNewPath;
    private javax.swing.JMenu newpath;
    private java.awt.Panel painel1;
    private javax.swing.JPanel panelImagem;
    private java.awt.Panel panelLogo;
    // End of variables declaration//GEN-END:variables
}
