import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GuiLista extends JFrame {
    private JLabel jlPendentes, jlConcluidas, jlInformativo1, jlInformativo2;
    private JCheckBox cbP1,cbP2,cbP3,cbP4 ,cbC1,cbC2,cbC3,cbC4;
    private static GuiLista frame;
    private JMenuBar mbMenu;
    private JMenu jmAcoes;
    private JMenuItem miCriar, miEditar;
    private String obterTarefa;
    public GuiLista (){
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes(){
        setTitle("Lista de Terefas");
        setBounds(0,0,400,350);
        setLayout(null);
        setLayout(new GridLayout(6,1));

        jlPendentes = new JLabel("Pendentes:",JLabel.LEFT);
        jlConcluidas = new JLabel("Concluídas:",JLabel.LEFT);
        jlInformativo1 = new JLabel("Selecione para concluir");
        jlInformativo2 = new JLabel("Selecione para excluir");
        cbP1 = new JCheckBox("");
        cbP2 = new JCheckBox("");
        cbP3 = new JCheckBox("");
        cbP4 = new JCheckBox("");
        cbC1 = new JCheckBox("");
        cbC2 = new JCheckBox("");
        cbC3 = new JCheckBox("");
        cbC4 = new JCheckBox("");

        add(jlPendentes);
        add(jlConcluidas);
        add(jlInformativo1);
        add(jlInformativo2);
        add(cbP1);
        add(cbC1);
        add(cbP2);
        add(cbC2);
        add(cbP3);
        add(cbC3);
        add(cbP4);
        add(cbC4);

        mbMenu = new JMenuBar();
        jmAcoes = new JMenu("Clique aqui para realizar ações");
        miCriar = new JMenuItem("Adicionar tarefa");
        miEditar = new JMenuItem("Editar tarefas");
        jmAcoes.add(miCriar);
        jmAcoes.add(miEditar);
        mbMenu.add(jmAcoes);
        setJMenuBar(mbMenu);

        cbP1.setVisible(false);
        cbP2.setVisible(false);
        cbP3.setVisible(false);
        cbP4.setVisible(false);
        cbC1.setVisible(false);
        cbC2.setVisible(false);
        cbC3.setVisible(false);
        cbC4.setVisible(false);
    }

    public void definirEventos(){
        miCriar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obterTarefa = JOptionPane.showInputDialog("Digite a tarefa que será adicionada:");
                if(cbP4.getText().isEmpty()) {

                    cbP4.setText(cbP3.getText());
                    cbP3.setText(cbP2.getText());
                    cbP2.setText(cbP1.getText());
                    cbP1.setText(obterTarefa);

                    cbP1.setVisible(true);
                    cbP2.setVisible(true);
                    cbP3.setVisible(true);
                    cbP4.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Termine uma tarefa para adicionar outra!");
                }
            }
        });
        cbP1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String aux = cbP1.getText();
                    cbP1.setText("");
                    cbP1.setSelected(false);

                    cbC4.setText(cbC3.getText());
                    cbC3.setText(cbC2.getText());
                    cbC2.setText(cbC1.getText());
                    cbC1.setText(aux);
                    cbC1.setVisible(true);
                    cbC2.setVisible(true);
                    cbC3.setVisible(true);
                    cbC4.setVisible(true);

                    cbP1.setText(cbP2.getText());
                    cbP2.setText(cbP3.getText());
                    cbP3.setText(cbP4.getText());
                    cbP4.setText("");
                }
            }
        });
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new GuiLista();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela =  Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((tela.width - frame.getSize().width) / 2,
                        (tela.height - frame.getSize().height)/2);
                frame.setVisible(true);
            }
        });
    }
}
