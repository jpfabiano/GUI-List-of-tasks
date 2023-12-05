import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
public class GuiLista extends JFrame {
    private JLabel jlPendentes, jlConcluidas, jlInformativo1, jlInformativo2;
    private JCheckBox cbP1,cbP2,cbP3,cbP4 ,cbC1,cbC2,cbC3,cbC4;
    private static GuiLista frame;
    private JMenuBar mbMenu;
    private JMenu jmAcoes;
    private JMenuItem miCriar, miEditar;
    private String obterTarefa, editarTarefa, novaTarefa;
    public GuiLista (){
        inicializarComponentes();
        definirEventos();
        mensagemMotivadora();
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
                    cbC1.setVisible(true);
                    cbC2.setVisible(true);
                    cbC3.setVisible(true);
                    cbC4.setVisible(true);
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
                    cbP1.setSelected(false);

                    cbC4.setText(cbC3.getText());
                    cbC3.setText(cbC2.getText());
                    cbC2.setText(cbC1.getText());
                    cbC1.setText(aux);

                    cbP1.setText(cbP2.getText());
                    cbP2.setText(cbP3.getText());
                    cbP3.setText(cbP4.getText());
                    cbP4.setText("");
                }
            }
        });
        cbP2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String aux = cbP2.getText();
                    cbP2.setSelected(false);

                    cbC4.setText(cbC3.getText());
                    cbC3.setText(cbC2.getText());
                    cbC2.setText(cbC1.getText());
                    cbC1.setText(aux);

                    cbP2.setText(cbP3.getText());
                    cbP3.setText(cbP4.getText());
                    cbP4.setText("");
                }
            }
        });
        cbP3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String aux = cbP3.getText();
                    cbP3.setSelected(false);

                    cbC4.setText(cbC3.getText());
                    cbC3.setText(cbC2.getText());
                    cbC2.setText(cbC1.getText());
                    cbC1.setText(aux);

                    cbP3.setText(cbP4.getText());
                    cbP4.setText("");
                }
            }
        });
        cbP4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String aux = cbP4.getText();
                    cbP4.setText("");
                    cbP4.setSelected(false);

                    cbC4.setText(cbC3.getText());
                    cbC3.setText(cbC2.getText());
                    cbC2.setText(cbC1.getText());
                    cbC1.setText(aux);
                }
            }
        });
        cbC1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cbC1.setSelected(false);

                    cbC1.setText(cbC2.getText());
                    cbC2.setText(cbC3.getText());
                    cbC3.setText(cbC4.getText());
                    cbC4.setText("");
                }
            }
        });
        cbC2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cbC2.setSelected(false);

                    cbC2.setText(cbC3.getText());
                    cbC3.setText(cbC4.getText());
                    cbC4.setText("");
                }
            }
        });
        cbC3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cbC3.setSelected(false);

                    cbC3.setText(cbC4.getText());
                    cbC4.setText("");
                }
            }
        });
        cbC4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cbC4.setSelected(false);

                    cbC4.setText("");
                }
            }
        });
        miEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarTarefa = JOptionPane.showInputDialog(null,"Qual a tarefa que você deseja editar ? " +
                        "(escreva do jeito que ela se encontra)");
                novaTarefa = JOptionPane.showInputDialog(null,"Qual será o novo nome dela ? ");
                if(cbP1.getText().equals(editarTarefa)){
                    cbP1.setText(novaTarefa);
                } else if(cbP2.getText().equals(editarTarefa)){
                    cbP2.setText(novaTarefa);
                } else if(cbP3.getText().equals(editarTarefa)){
                    cbP3.setText(novaTarefa);
                } else if(cbP4.getText().equals(editarTarefa)){
                    cbP4.setText(novaTarefa);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi encontrada nenhuma tarefa com o nome " +
                            editarTarefa);
                }
            }
        });
    }

    public void mensagemMotivadora(){
        String[] meuArray = {"Acredite em você mesmo. Você é mais capaz do que imagina.",
                "As dificuldades de hoje serão os degraus para o seu sucesso amanhã." ,
                "Cada pequeno passo te aproxima do seu grande objetivo." ,
                "Persistência e determinação são chave para alcançar seus sonhos." ,
                "Você é o arquiteto da sua própria felicidade. Construa-a com positividade." ,
                "A jornada pode ser difícil, mas a recompensa valerá a pena." ,
                "Acredite. Você é capaz de superar qualquer desafio que aparecer.",
                "O fracasso é apenas uma oportunidade para recomeçar com mais sabedoria." ,
                "Pequenas atitudes diárias podem levar a grandes mudanças." ,
                "Não desista. Seja paciente e persistente, seus esforços serão recompensados."};
        Random random = new Random();
        int x = random.nextInt(10);
        JOptionPane.showMessageDialog(null,""+meuArray[x]);
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
