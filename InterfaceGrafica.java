import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class InterfaceGrafica extends JFrame {

    JFrame janela;
    JButton adcReceitas, removerReceitas, mostrarReceitas;
    JLabel imagem, nome;
    JMenuItem spanakopita;

    public InterfaceGrafica() {

        janela = new JFrame("Grécia");
        this.janela.setSize(new Dimension(800, 500));
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);




        BufferedImage img = null;

         try {

            img = ImageIO.read(new File("grecia.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
            ;
        }

        nome = new JLabel();
        nome.setText("Grécia");
        nome.setFont(new Font("Arial", Font.BOLD, 50));
        nome.setBounds(50, 180, 300, 100);
        nome.setForeground(Color.white);

        imagem = new JLabel();
        imagem.setHorizontalTextPosition(JLabel.CENTER);
        imagem.setBorder(BorderFactory.createLineBorder(Color.black));

        Image dimg = img.getScaledInstance(janela.getWidth(), janela.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        imagem.setIcon(imageIcon);


        JMenuBar menu = new JMenuBar();
        janela.setJMenuBar(menu);
        JMenu patrosTipicos = new JMenu("Pratos Tipicos");
         spanakopita = new JMenuItem("Spanakopita");
        JMenuItem moussaka = new JMenuItem("Moussaka");
        JMenuItem gyros = new JMenuItem("Gyros");
        JMenuItem receitas = new JMenuItem("Receitas");
        JMenu sobre = new JMenu("Sobre");
        JMenuItem historia = new JMenuItem("História");
        JMenuItem contextoCultural = new JMenuItem("Contexto Cultural");
        menu.add(patrosTipicos);
        menu.add(sobre);
        sobre.add(historia);
        sobre.add(contextoCultural);
        patrosTipicos.add(spanakopita);
        patrosTipicos.add(moussaka);
        patrosTipicos.add(gyros);
        patrosTipicos.add(receitas);

        spanakopita.addActionListener(this :: Spanakopita);
        moussaka.addActionListener(this :: moussaka);
        gyros.addActionListener(this :: gyros);

        receitas.addActionListener(this :: receita);

        historia.addActionListener(this :: historiaGrecia);
        contextoCultural.addActionListener(this :: contextoGrecia);

        janela.add(nome);
        janela.add(imagem);
        //janela.add(new Ingredientes());

        janela.setVisible(true);

    }


    private void Spanakopita(ActionEvent actionevent1) {
        Spanakopita s = new Spanakopita();
        s.historia();
        s.setarHistoria();
        janela.setVisible(false);

    }


    private void moussaka(ActionEvent actionevent1) {
        Moussaka m = new Moussaka();
        m.historia();
        m.setarHistoria();
       janela.setVisible(false);
    }


    private void gyros(ActionEvent actionevent1) {
        Gyros g = new Gyros();
        g.historia();
        g.setarHistoria();
        janela.setVisible(false);
    }




    private void historiaGrecia(ActionEvent actionevent1) {
        Historia h = new Historia();
        h.definirGreciaA();

        janela.setVisible(false);
    }


    private void contextoGrecia(ActionEvent actionevent1) {
       ContextoCultural c = new ContextoCultural();
        c.definirSpanakopita();

        janela.setVisible(false);
    }


    private void receita(ActionEvent actionevent1) {
       new Receita();
        janela.setVisible(false);
    }

}
