/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import dao.ContadorDao;
import dao.ContatoDao;
import dao.HumorDao;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Contador;
 import javax.swing.Timer;
import modelo.Contato;
import modelo.Humor;


/**
 *
 * @author hmq48
 */
public class TelaPrincipal extends javax.swing.JFrame {
    public String loginUsuario;
    

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
            HumorDao humorDao = new HumorDao();
            boolean humorRegistro = humorDao.verificaHumor(dataEntrada, loginUsuario);
            if (humorRegistro == true){
                sliderHumor.setVisible(false);
                lblValor.setVisible(false);
                btnRegistrar.setVisible(false);
            }
            else {
                
                lblHumorRegistrado.setText("Em uma escala de 0 a 10, como está seu humor hoje?");
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblOla = new javax.swing.JLabel();
        btnNotas = new GradientButton("Notas");
        btnContadorSobriedade = new GradientButton("Contador");
        btnFechar = new GradientButton1("Fechar");
        painel1 = new java.awt.Panel();
        panelImagem = new javax.swing.JPanel();
        btnEstimativaEconomia = new GradientButton("Economia");
        jSeparator1 = new javax.swing.JSeparator();
        panelLogo = new java.awt.Panel();
        lblFrase = new javax.swing.JLabel();
        btnHumor = new GradientButton("Humor");
        btnRecaida = new GradientButton1("recaida");
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        sliderHumor = new javax.swing.JSlider();
        lblValor = new javax.swing.JLabel();
        btnRegistrar = new GradientButton("botao");
        lblHumorRegistrado = new javax.swing.JLabel();
        menuNewPath = new javax.swing.JMenuBar();
        newpath = new javax.swing.JMenu();

        jMenu2.setText("jMenu2");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jButton1.setText("jButton1");

        jLabel1.setText("jLabel1");

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

        lblFrase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrase.setForeground(new java.awt.Color(255, 255, 255));
        lblFrase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrase.setText("Um Novo Caminho para a mudança de vida");

        btnHumor.setBackground(new java.awt.Color(0, 0, 255));
        btnHumor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHumor.setForeground(new java.awt.Color(255, 255, 255));
        btnHumor.setText("Humor");
        btnHumor.setAutoscrolls(true);
        btnHumor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHumorActionPerformed(evt);
            }
        });

        btnRecaida.setBackground(new java.awt.Color(0, 0, 255));
        btnRecaida.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnRecaida.setForeground(new java.awt.Color(255, 255, 255));
        btnRecaida.setText("Registrar Recaída");
        btnRecaida.setAutoscrolls(true);
        btnRecaida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecaidaActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        sliderHumor.setForeground(new java.awt.Color(255, 255, 255));
        sliderHumor.setMajorTickSpacing(1);
        sliderHumor.setMaximum(10);
        sliderHumor.setPaintLabels(true);
        sliderHumor.setPaintTicks(true);
        sliderHumor.setValue(5);
        sliderHumor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderHumorStateChanged(evt);
            }
        });

        lblValor.setForeground(new java.awt.Color(255, 255, 255));
        lblValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValor.setText("Seu humor: 5");

        btnRegistrar.setText("Registrar Humor");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblHumorRegistrado.setForeground(new java.awt.Color(255, 255, 255));
        lblHumorRegistrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHumorRegistrado.setText("Seu humor ja foi registrado hoje!");

        newpath.setText("NewPath");
        menuNewPath.add(newpath);

        setJMenuBar(menuNewPath);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(lblOla, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecaida, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar)
                                .addGap(188, 188, 188)
                                .addComponent(btnFechar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(sliderHumor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFrase, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnContadorSobriedade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEstimativaEconomia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnHumor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lblHumorRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblOla))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRecaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(lblFrase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnContadorSobriedade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnEstimativaEconomia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4)
                        .addComponent(jSeparator5))
                    .addComponent(btnHumor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFechar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblHumorRegistrado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderHumor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar)
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void btnHumorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHumorActionPerformed
        // TODO add your handling code here:
        TelaHumor telaHumor = new TelaHumor(loginUsuario);
        telaHumor.setVisible(true);
    }//GEN-LAST:event_btnHumorActionPerformed

    private void btnRecaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecaidaActionPerformed
        // TODO add your handling code here:
        Integer resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente registrar recaida?");
        if (resposta == JOptionPane.YES_OPTION) {
            LocalDate data4 = LocalDate.now();
            Date dataAtual;
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String dataStr = data4.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
                dataAtual = new Date(format.parse(dataStr).getTime());
                } 

            catch (ParseException e) {
            throw new RuntimeException(e);
            }

            Contato contato = new Contato ();
            contato.setLogin(loginUsuario);
            contato.setDataAtual(dataAtual);
            ContatoDao contatoDao = new ContatoDao();
            contatoDao.atualizaData(contato);
            this.dispose();
            TelaPrincipal telaPrincipal = new TelaPrincipal(loginUsuario);
            telaPrincipal.setVisible(true);
            Contato contato2 = contatoDao.getContatoByLogin(loginUsuario);
            String nome = contato2.getNome();
            JOptionPane.showMessageDialog(null, "Sentimos muito, " + nome + 
            ". \nLembre-se, recaídas são parte da jornada. Aprenda com elas e continue andando." +
            "\nSeu Contador de Sobriedade foi redefinido, continue Firme!");
           
           
            
            }
       
        
        
    }//GEN-LAST:event_btnRecaidaActionPerformed

    private void sliderHumorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderHumorStateChanged
        // TODO add your handling code here:
        int valor = sliderHumor.getValue();
        lblValor.setText("Seu humor: " + valor);

    }//GEN-LAST:event_sliderHumorStateChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        Humor humor = new Humor(); 
        int valor = sliderHumor.getValue();
        LocalDate data3 = LocalDate.now();
        Date dataHumor;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dataStr = data3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
            dataHumor = new Date(format.parse(dataStr).getTime());
        } 

        catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(dataHumor);
        humor.setLogin(loginUsuario);
        humor.setValor(valor);
        humor.setDataHumor(dataHumor);
        HumorDao humorDao = new HumorDao();
        humorDao.adicionaHumor(humor);
        JOptionPane.showMessageDialog(null, "Humor Diário registrado com sucesso!");
        this.dispose();
        TelaPrincipal telaPrincipal = new TelaPrincipal(loginUsuario);
        telaPrincipal.setVisible(true);
                
                
        
        
       
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
    private javax.swing.JButton btnHumor;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnRecaida;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblFrase;
    private javax.swing.JLabel lblHumorRegistrado;
    private javax.swing.JLabel lblOla;
    private javax.swing.JLabel lblValor;
    private javax.swing.JMenuBar menuNewPath;
    private javax.swing.JMenu newpath;
    private java.awt.Panel painel1;
    private javax.swing.JPanel panelImagem;
    private java.awt.Panel panelLogo;
    private javax.swing.JSlider sliderHumor;
    // End of variables declaration//GEN-END:variables
}
