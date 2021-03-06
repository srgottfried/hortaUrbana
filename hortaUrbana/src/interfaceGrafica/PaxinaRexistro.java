package interfaceGrafica;

import datos.Conector;
import java.awt.Color;
import javax.swing.JOptionPane;
import usuarios.Sesion;

/**
 * @author Manuel Landín Gómez
 * @author Iago Leirós Pérez
 */
public class PaxinaRexistro extends javax.swing.JDialog {

    /**
     * Creates new form PaxinaRexistro
     */
    public PaxinaRexistro() {
        initComponents();
        limparInterface();
        setModal(true);
        

    }
    
    public void limparInterface() {
        jPanelFormularioRexistro.setVisible(true);
        jTextFieldNovoUsuario.setText("");
        jPasswordNovoContrasinal.setText("");
        jPasswordFieldNovoContrasinal2.setText("");
        jPanelMensaxe.setVisible(false);
    }
    
    public void limparCampos() {
        jTextFieldNovoUsuario.setText("");
        jPasswordNovoContrasinal.setText("");
        jPasswordFieldNovoContrasinal2.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFormularioRexistro = new javax.swing.JPanel();
        jLabelNovoUsuario = new javax.swing.JLabel();
        jTextFieldNovoUsuario = new javax.swing.JTextField();
        jLabelContrasinal = new javax.swing.JLabel();
        jPasswordNovoContrasinal = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabelRepetirContrasinal = new javax.swing.JLabel();
        jPasswordFieldNovoContrasinal2 = new javax.swing.JPasswordField();
        jPanelMensaxe = new javax.swing.JPanel();
        jLabelMensaxe = new javax.swing.JLabel();

        setTitle("Novo usuario");
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(331, 228));

        jLabelNovoUsuario.setText("Novo usuario:");

        jLabelContrasinal.setText("Contrasinal: ");

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelRepetirContrasinal.setText("Repetir contrasinal:");

        javax.swing.GroupLayout jPanelFormularioRexistroLayout = new javax.swing.GroupLayout(jPanelFormularioRexistro);
        jPanelFormularioRexistro.setLayout(jPanelFormularioRexistroLayout);
        jPanelFormularioRexistroLayout.setHorizontalGroup(
            jPanelFormularioRexistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioRexistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormularioRexistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelRepetirContrasinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelContrasinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNovoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioRexistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNovoUsuario)
                    .addComponent(jPasswordNovoContrasinal)
                    .addComponent(jPasswordFieldNovoContrasinal2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelFormularioRexistroLayout.setVerticalGroup(
            jPanelFormularioRexistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioRexistroLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanelFormularioRexistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFormularioRexistroLayout.createSequentialGroup()
                        .addGroup(jPanelFormularioRexistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNovoUsuario)
                            .addComponent(jTextFieldNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFormularioRexistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordNovoContrasinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelContrasinal, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(31, 31, 31))
                    .addGroup(jPanelFormularioRexistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelRepetirContrasinal)
                        .addComponent(jPasswordFieldNovoContrasinal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabelMensaxe.setForeground(new java.awt.Color(255, 0, 0));
        jLabelMensaxe.setText("Erro ao crear o usuario.");

        javax.swing.GroupLayout jPanelMensaxeLayout = new javax.swing.GroupLayout(jPanelMensaxe);
        jPanelMensaxe.setLayout(jPanelMensaxeLayout);
        jPanelMensaxeLayout.setHorizontalGroup(
            jPanelMensaxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMensaxeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMensaxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        jPanelMensaxeLayout.setVerticalGroup(
            jPanelMensaxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMensaxeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMensaxe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMensaxe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jPanelFormularioRexistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFormularioRexistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMensaxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nome, contrasinal, contrasinal2;
        nome = jTextFieldNovoUsuario.getText();
        contrasinal = jPasswordNovoContrasinal.getText();
        contrasinal2 = jPasswordFieldNovoContrasinal2.getText();
        jLabelNovoUsuario.setForeground(Color.black);
        jLabelContrasinal.setForeground(Color.black);
        jLabelRepetirContrasinal.setForeground(Color.black);
        if (nome.isBlank() || nome.isEmpty()) {
            jLabelMensaxe.setForeground(Color.red);
            jLabelMensaxe.setText("O usuario indicado non é válido.");
            jLabelMensaxe.setVisible(true);
            jPanelMensaxe.setVisible(true);
            jLabelNovoUsuario.setForeground(Color.red);
            jTextFieldNovoUsuario.requestFocus();
            limparCampos();
        } else if (contrasinal.isBlank() || contrasinal.isEmpty()) {
            jLabelMensaxe.setForeground(Color.red);
            jLabelMensaxe.setText("O contrasinal indicado non é válido.");
            jLabelMensaxe.setVisible(true);
            jPanelMensaxe.setVisible(true);
            jLabelContrasinal.setForeground(Color.red);
            jPasswordNovoContrasinal.requestFocus();
        } else if (!contrasinal.equals(contrasinal2)) {
            jLabelMensaxe.setForeground(Color.red);
            jLabelMensaxe.setText("Os contrasinais inidcados son diferentes.");
            jLabelMensaxe.setVisible(true);
            jPanelMensaxe.setVisible(true);
            jLabelContrasinal.setForeground(Color.red);
            jLabelRepetirContrasinal.setForeground(Color.red);
            jPasswordNovoContrasinal.requestFocus();
        } else if (Sesion.rexistrarUsuario(nome, contrasinal)) {
            String url = "jdbc:mysql://localhost:3306/hortas";
            String usr = "root";
            String pass = "root";
            Conector c = new Conector(url, usr, pass);
            c.setUpdate("insert into usuarios values (null,'" + nome + "','" + contrasinal + "', current_date())");
            c.close();
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Usuario " + nome + " rexistrado con éxito.", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            
            
        } else {
            jLabelMensaxe.setForeground(Color.red);
            jLabelMensaxe.setText("O usuario indicado xa existe.");
            jPanelMensaxe.setVisible(true);
            jLabelMensaxe.setVisible(true);
            limparCampos();
            jTextFieldNovoUsuario.requestFocus();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelContrasinal;
    private javax.swing.JLabel jLabelMensaxe;
    private javax.swing.JLabel jLabelNovoUsuario;
    private javax.swing.JLabel jLabelRepetirContrasinal;
    private javax.swing.JPanel jPanelFormularioRexistro;
    private javax.swing.JPanel jPanelMensaxe;
    private javax.swing.JPasswordField jPasswordFieldNovoContrasinal2;
    private javax.swing.JPasswordField jPasswordNovoContrasinal;
    private javax.swing.JTextField jTextFieldNovoUsuario;
    // End of variables declaration//GEN-END:variables
}
