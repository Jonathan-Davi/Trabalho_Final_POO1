import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Receita extends Pratos {
    JFrame jfI;
    JLabel texto, imagem;
    JButton voltar;
    JComboBox<String> listaReceitas;
    JComboBox<String> receita;
    String valor;

    String[] receitas = { "Spanakopita", "Moussaka", "Gyros" };


    public Receita(){

        jfI = new JFrame("Receitas");
        jfI.setSize(new Dimension(800, 500));
        jfI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfI.setLayout(null);
        jfI.setLocationRelativeTo(null);

        ImageIcon voltarIcon = new ImageIcon("voltar.png");

        voltar = new JButton(voltarIcon);
        voltar.setBounds(680, 400, 80, 30);
        voltar.addActionListener(this :: voltarHistoria);
        voltar.setToolTipText("Clique para voltar");



        imagem = new JLabel();
        imagem.setBounds(0, 0, jfI.getWidth(), jfI.getHeight());



        texto = new JLabel();
        texto.setBounds(430, 10, 350, 400);
        texto.setForeground(Color.BLACK);



        listaReceitas = new JComboBox<>(receitas);
        listaReceitas.setBounds(420, 15, 100, 20);
            listaReceitas.addActionListener(e -> {
            String receitaSelecionada = (String) listaReceitas.getSelectedItem();
            switch (receitaSelecionada) {
                case "Spanakopita":
                    spana(null);
                    break;
                case "Moussaka":
                    moussaka(null);
                    break;
                case "Gyros":
                    gyro(null);
                    break;
            }
        });




        jfI.add(listaReceitas);
        jfI.add(voltar);
        jfI.add(texto);
        jfI.add(imagem);
        jfI.setVisible(true);

        spana(null);
    }


    private void exibirImagem(String caminhoImagem) {
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image dimg = imagemIcon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        imagem.setIcon(new ImageIcon(dimg));
    }




    private void voltarHistoria(ActionEvent actionevent1) {

        new InterfaceGrafica();
        jfI.dispose();
    }


    private void spana(ActionEvent actionevent1) {


        Path path = Path.of("ingredientes.txt");
        Spanakopita s = new Spanakopita();
        s.ingredientes();
        s.fazerIngredientes();

         try {
            List<String> contexto = Files.readAllLines(path);

            valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");


        } catch (IOException e) {

            e.printStackTrace();
        }



        exibirImagem("spanakopitaingre.jpg");

    }


    private void moussaka(ActionEvent actionevent1) {

        int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer ver a receita de Moussaka?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {

        Path path = Path.of("ingredientes.txt");
        Moussaka m = new Moussaka();
        m.ingredientes();
        m.fazerIngredientes();

         try {
            List<String> contexto = Files.readAllLines(path);

            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");

        } catch (IOException e) {

            e.printStackTrace();
        }
        exibirImagem("moussakaingre.jpg");

    }

    }


    private void gyro(ActionEvent actionevent1) {
        int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer ver a receita de Gyros?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
        Path path = Path.of("ingredientes.txt");
        Gyros g = new Gyros();
        g.ingredientes();
        g.fazerIngredientes();
         try {
            List<String> contexto = Files.readAllLines(path);

            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");

        } catch (IOException e) {

            e.printStackTrace();
        }
        exibirImagem("gyrosingre.jpg");
        }
    }

}
