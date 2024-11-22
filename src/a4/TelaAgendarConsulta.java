package a4;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Nicole de Oliveira Medeiros
 */
public class TelaAgendarConsulta extends javax.swing.JFrame {

    /**
     * Creates new form TelaAgendarConsulta
     *
     * @param veterinarios
     * @param donos
     * @param animais
     * @param inicio
     */
    public TelaAgendarConsulta(ArrayList<Veterinario> veterinarios, ArrayList<Dono> donos, ArrayList<Animal> animais, TelaInicial inicio) {
        initComponents();
        this.veterinarios = veterinarios;
        this.inicio = inicio;
        this.donos = donos;
        this.animais = animais;

        //formata��o do campo de data
        try {
            MaskFormatter formatoData = new MaskFormatter("##/##/####");
            formatoData.setPlaceholderCharacter('_');
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatoData));
        } catch (java.text.ParseException e) {
            e.getErrorOffset();
        }

        //valida��o da data
        jFormattedTextFieldData.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                validar_data();
            }

        });

        //habilita��o dos campos
        jFormattedTextFieldCPFDono.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                verificarCampoVazio();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                verificarCampoVazio();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                verificarCampoVazio();
            }

        });

        verificarCampoVazio();

        //formata��o do cpf
        try {
            MaskFormatter formatoCPF = new MaskFormatter("###.###.###-##");
            formatoCPF.setPlaceholderCharacter('_');

            jFormattedTextFieldCPFDono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatoCPF));

        } catch (ParseException e) {
            e.getErrorOffset();
        }
    }

    public void atualizarDados(ArrayList<Veterinario> veterinarios, ArrayList<Dono> donos, ArrayList<Animal> animais) {
        this.veterinarios = veterinarios;
        this.donos = donos;
        this.animais = animais;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupConsultas = new javax.swing.ButtonGroup();
        jLabelDonoCPF = new javax.swing.JLabel();
        jLabelAnimal = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        jButtonMarcar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jComboBoxAnimal = new javax.swing.JComboBox<>();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jLabelData = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabelAgendamentoTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jFormattedTextFieldCPFDono = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListConsultas = new javax.swing.JList<>();
        jLabelListaConsultas = new javax.swing.JLabel();
        jRadioButtonConsultasPendentes = new javax.swing.JRadioButton();
        jRadioButtonConsultasPassadas = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelDonoCPF.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDonoCPF.setText("CPF do Dono");

        jLabelAnimal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAnimal.setText("Animal");

        jLabelHorario.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelHorario.setText("Hor�rio");

        jButtonMarcar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonMarcar.setText("Marcar");
        jButtonMarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarcarActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jComboBoxAnimal.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        jComboBoxHorario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBoxHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00", "9:00", "10:00", "11:00", "14:00", "15:00", "16:00", "17:00" }));

        jLabelData.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelData.setText("Data");

        jFormattedTextFieldData.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabelAgendamentoTitulo.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabelAgendamentoTitulo.setText("Agendamento de Consultas");

        jFormattedTextFieldCPFDono.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jFormattedTextFieldCPFDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCPFDonoActionPerformed(evt);
            }
        });

        jListConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListConsultasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListConsultas);

        jLabelListaConsultas.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelListaConsultas.setText("Lista de Consultas:");

        buttonGroupConsultas.add(jRadioButtonConsultasPendentes);
        jRadioButtonConsultasPendentes.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jRadioButtonConsultasPendentes.setText("Pendentes");
        jRadioButtonConsultasPendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasPendentesActionPerformed(evt);
            }
        });

        buttonGroupConsultas.add(jRadioButtonConsultasPassadas);
        jRadioButtonConsultasPassadas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jRadioButtonConsultasPassadas.setText("Passadas");
        jRadioButtonConsultasPassadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasPassadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHorario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelDonoCPF)
                                .addComponent(jLabelAnimal)
                                .addComponent(jComboBoxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFormattedTextFieldCPFDono, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonMarcar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelListaConsultas)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonConsultasPassadas)
                            .addComponent(jRadioButtonConsultasPendentes))))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAgendamentoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelAgendamentoTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelListaConsultas)
                            .addComponent(jRadioButtonConsultasPendentes))
                        .addGap(2, 2, 2)
                        .addComponent(jRadioButtonConsultasPassadas)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDonoCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldCPFDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabelAnimal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelData)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHorario)
                            .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonMarcar)
                            .addComponent(jButtonVoltar))
                        .addGap(43, 43, 43))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        irInicio();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonMarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcarActionPerformed
        // TODO add your handling code here:
        if (camposPreenchidos() == true) {
            salvar_consulta();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Para continuar, por favor preencha todos os campos.",
                    "Erro...", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonMarcarActionPerformed

    private void jFormattedTextFieldCPFDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFDonoActionPerformed
        // TODO add your handling code here:
        buscar_dono();
    }//GEN-LAST:event_jFormattedTextFieldCPFDonoActionPerformed

    private void jRadioButtonConsultasPendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasPendentesActionPerformed
        // TODO add your handling code here:
        listar_consultas();
    }//GEN-LAST:event_jRadioButtonConsultasPendentesActionPerformed

    private void jRadioButtonConsultasPassadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasPassadasActionPerformed
        // TODO add your handling code here:
        listar_consultas();
    }//GEN-LAST:event_jRadioButtonConsultasPassadasActionPerformed

    private void jListConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListConsultasMouseClicked
        // TODO add your handling code here:
        limpar_tela();
        mostrar_dadosConsulta();
    }//GEN-LAST:event_jListConsultasMouseClicked

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
            java.util.logging.Logger.getLogger(TelaAgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    public ArrayList<Consulta> consultas;
    public ArrayList<Veterinario> veterinarios;
    public ArrayList<Dono> donos;
    public ArrayList<Animal> animais;

    public ListIterator it;
    private TelaInicial inicio;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupConsultas;
    private javax.swing.JButton jButtonMarcar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxAnimal;
    private javax.swing.JComboBox<String> jComboBoxHorario;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPFDono;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabelAgendamentoTitulo;
    private javax.swing.JLabel jLabelAnimal;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDonoCPF;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelListaConsultas;
    private javax.swing.JList<String> jListConsultas;
    private javax.swing.JRadioButton jRadioButtonConsultasPassadas;
    private javax.swing.JRadioButton jRadioButtonConsultasPendentes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public void irInicio() {
        inicio.setVeterinarios(veterinarios);
        inicio.setConsultas(consultas);
        inicio.setVisible(true);
        limpar_tela();
        this.setVisible(false);
    }

    private void salvar_consulta() {

        if (consultas == null) {
            consultas = new ArrayList<>();
        }
        Consulta consult = new Consulta();

        String data = jFormattedTextFieldData.getText() + " [" + jComboBoxHorario.getSelectedItem() + "]";

        Veterinario vetSelecionado = DisponibilidadeVets(data);

        if (vetSelecionado != null) {

            for (Animal animal : animais) {
                if (animal.getNome().equals(jComboBoxAnimal.getSelectedItem().toString())) {
                    consult.setAnimal(animal);
                    break;
                }
            }
            consult.setDiaHora(data);
            consult.setDonoCPF(jFormattedTextFieldCPFDono.getText());
            consult.setVeterinario(vetSelecionado);

            consultas.add(consult);

            String nomeVeterinario = consult.getVeterinario().getNome();

            String[] opcoes = {"Mandar por e-mail","Mandar por SMS", "Ok"};

            JOptionPane.showOptionDialog(null,
                "Consulta marcada\n\nData: " + consult.getDiaHora()
                + "\nVeterin�rio(a): " + nomeVeterinario
                + "\nAnimal: " + consult.getAnimal().getNome(),
                 "Marca��o", 0, 3, null, opcoes, opcoes[2]);

            limpar_tela();

        } else {
            JOptionPane.showMessageDialog(null,
                    "N�o h� nenhum vetein�rio dispon�vel nesta data e hor�rio",
                    "Ops...", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void verificarCampoVazio() {

        String texto = jFormattedTextFieldCPFDono.getText().replaceAll("[^0-9]", ""); //ignora os pontos de formata��o

        if (texto.isEmpty()) {
            jComboBoxHorario.setEnabled(false);
            jComboBoxAnimal.setEnabled(false);
            
            jButtonMarcar.setEnabled(false);
            jFormattedTextFieldData.setEnabled(false);
        } else {
            jComboBoxHorario.setEnabled(true);
            jComboBoxAnimal.setEnabled(true);
            
            jButtonMarcar.setEnabled(true);
            jFormattedTextFieldData.setEnabled(true);
        }
    }

    private void limpar_tela() {
        if (jComboBoxAnimal.getComponentCount() > 0) {
            jComboBoxAnimal.removeAllItems();
        }

        
        jComboBoxHorario.setSelectedIndex(0);
        jFormattedTextFieldData.setText("");
        jFormattedTextFieldCPFDono.setText("");
    }

    private void buscar_dono() {

        boolean dono_encontrado = false;

        if (donos != null) {

            //buscando na lista
            String cpf_digitado = jFormattedTextFieldCPFDono.getText();

            for (Dono dono : donos) {
                if (dono.getCpf().equals(cpf_digitado)) {
                    mostrar_animais(dono);
                    dono_encontrado = true;
                    break;
                }
            }

            if (dono_encontrado == false) {
                JOptionPane.showConfirmDialog(null,
                        "Nenhum dono de CPF "
                        + cpf_digitado + " cadastrado",
                        "CPF digitado...", JOptionPane.PLAIN_MESSAGE);
            }

        } else {
            JOptionPane.showConfirmDialog(null,
                    "Nunhum Dono Cadastrado",
                    "Cadastre Donos primeiro", JOptionPane.PLAIN_MESSAGE);
        }

    }

    private void mostrar_animais(Dono dono) {

        ArrayList<String> Combobox_itens = new ArrayList<>();
        jComboBoxAnimal.removeAllItems();

        if (animais == null) {
            animais = new ArrayList<Animal>();
        }

        //se o animal tiver o cpf do dono igual ao cpf digitado, entra na combobox
        for (Animal animal : animais) {
            if (animal.getCpfD().equals(dono.getCpf())) {
                if (!Combobox_itens.contains(animal.getNome())) {
                    Combobox_itens.add(animal.getNome());
                }
            }
        }

        for (String item : Combobox_itens) {
            jComboBoxAnimal.addItem(item);
        }

    }

    private void validar_data() {
        String textoData = jFormattedTextFieldData.getText();
        boolean isValida;

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            Date dataInserida = formato.parse(textoData);

            Date dataAtual = new Date();
            if (dataAtual.after(dataInserida)) {
                isValida = false;
            } else {
                isValida = true;
            }
        } catch (ParseException e) {
            isValida = false;
        }

        if (isValida == false) {
            JOptionPane.showMessageDialog(null,
                    "Data inv�lida!\n\nPor favor, insira uma data v�lida",
                    "Erro", JOptionPane.ERROR_MESSAGE);

            jFormattedTextFieldData.requestFocus();
            jFormattedTextFieldData.setText("");
        }
    }

    private Veterinario DisponibilidadeVets(String dataCompleta) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm");
        String data = dataCompleta.replaceAll("[\\[\\]]", "");
        LocalDateTime dataHora = LocalDateTime.parse(data, formato);
        
        DayOfWeek diadaSemana = dataHora.getDayOfWeek();
        
        ArrayList<Veterinario> vetsDisponiveis = new ArrayList<>();

        //verifica se lista de vet j� foi inicializada
        if (veterinarios == null) {
            veterinarios = new ArrayList<>();
        }

        //acha vets disponiveis com agenda de trab que contenha o dia selecionado
        for (Veterinario vet : veterinarios) {

            if (vet.getAgendaTrab().contains(diadaSemana.getDisplayName(TextStyle.FULL, Locale.getDefault()))); {
                vetsDisponiveis.add(vet);
            }
        }

        //filtra os vets que tem conflito de hor�rio
        for (Veterinario vet : vetsDisponiveis) {
            boolean temConflito = false;

            for (Consulta c : consultas) {
                if ((c.getDiaHora().equals(dataCompleta) && vet.equals(c.getVeterinario()))) {
                    temConflito = true;
                    break;
                }
            }

            if (temConflito == false) {
                return vet;
            }
        }

        //se nenhum vet estiver disp nesse hor�rio e data
        return null;
    }

    private boolean camposPreenchidos() {

        if (jFormattedTextFieldCPFDono.getText().equals("") || jFormattedTextFieldData.getText().equals("") || jComboBoxAnimal.getItemCount() == 0) {
            return false;
        } else {
            return true;
        }

    }
    
    private void listar_consultas(){
        
        DefaultListModel<String> ModeloLista = new DefaultListModel<>();
        jListConsultas.setModel(ModeloLista);
        boolean isPendente = jRadioButtonConsultasPendentes.isSelected();
        Date dataAtual = new Date();
        Date dataConsulta;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy [HH:mm]");
        
        if (consultas == null) return;
        
        //filtra
        if (isPendente == true){
            
            for (Consulta consulta : consultas){
                try{
                    dataConsulta = formato.parse(consulta.getDiaHora());
                    
                    if (dataAtual.before(dataConsulta)){
                        
                        ModeloLista.addElement(consulta.getDiaHora());
                    }
                    
                } catch (ParseException e){
                    System.out.println("Erro ao converter a data: " + e.getMessage());
                }
            }
            
        } else {
            for (Consulta consulta : consultas){
                try{
                    dataConsulta = formato.parse(consulta.getDiaHora());
                    
                    if (dataAtual.after(dataConsulta)){
                        ModeloLista.addElement(consulta.getDiaHora());
                    }
                    
                } catch (ParseException e){
                    System.out.println("Erro ao converter a data: " + e.getMessage());
                }
            }
        }
    }

    private void mostrar_dadosConsulta() {
        String dataConsulta = jListConsultas.getSelectedValue();
        String[] partes = dataConsulta.split("\\["); //divide a partir do colchete
        
        String data = partes[0];
        String hora = partes[1].replace("]", ""); //pega horario sem o colchete
        
        for (Consulta consulta : consultas){
            if (consulta.getDiaHora().equals(dataConsulta)){
                jComboBoxAnimal.addItem(consulta.getAnimal().toString());
                jFormattedTextFieldCPFDono.setText(consulta.getDonoCPF());
                jFormattedTextFieldData.setText(data);
                jComboBoxHorario.setSelectedItem(hora);
            }
        }
        
    }

}
