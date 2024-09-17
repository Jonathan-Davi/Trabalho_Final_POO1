import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.*;
import java.util.List;

public class Historia extends Sobre{

    private String historia, historiaA;
    private JFrame jf;
    private JLabel imagemLabel, imagemLabel1, texto;
    private JButton voltar;
    private ButtonGroup grupo;
    private String greciaAString = "Grécia Antiga";
    private String greciaATString = "Grécia Atual";
    ImageIcon voltarIcon = new ImageIcon("voltar.png");

    public void definirGreciaA(){
        this.setGreciaA("A Grécia Antiga foi uma civilização entre os séculos VIII a.C. e VI a.C., composta por cidades-estado como Atenas e Esparta. Destacou-se por sua influência na filosofia, arte, arquitetura e ciência. A democracia surgiu em Atenas. O legado grego, incluindo figuras como Sócrates e obras como o Partenon, moldou profundamente a cultura ocidental.");
        this.fazerGreciaA();
        this.Interface();
    }

    public void definirGreciaAT(){
        this.setGreciaAT("A Grécia contemporânea é uma república parlamentar democrática e membro da União Europeia desde 1981. Após desafios econômicos na crise de 2008, o país mantém uma rica herança cultural, impulsionando o turismo. Geopoliticamente, a Grécia desempenha um papel estratégico entre a Europa e o Oriente Médio, enfrentando questões com a Turquia e a disputa em Chipre. Recomenda-se verificar fontes recentes para informações atualizadas.");
        this.fazerGreciaAT();

    }

    public void Interface(){


        jf = new JFrame("História");
        jf.setSize(new Dimension(800, 500));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);

        imagemLabel = new JLabel();
        imagemLabel.setBounds(0, 0, 800, 500);
        jf.add(imagemLabel);

        imagemLabel1 = new JLabel();
        imagemLabel1.setBounds(0, 0, 800, 500);
        jf.add(imagemLabel1);

        voltar = new JButton(voltarIcon);
        voltar.setBounds(680, 400, 80, 28);
        voltar.setToolTipText("Clique para voltar");
        voltar.addActionListener(this::volta);

        texto = new JLabel();
        texto.setBounds(430, 35, 350, 300);
        texto.setForeground(Color.BLACK);

        JRadioButton greciaAntiga = new JRadioButton("Grécia Antiga");
        greciaAntiga.setMnemonic(KeyEvent.VK_B);
        greciaAntiga.setSelected(true);

        if(greciaAntiga.isSelected() == true){

             Path path = Path.of("GreciaA.txt");
        try {
            List<String> contexto = Files.readAllLines(path);

            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");
            exibirImagem("greciaantiga.jpg");
          } catch (IOException e) {

            e.printStackTrace();
          }

        }
        greciaAntiga.setActionCommand(greciaAString);
        greciaAntiga.setBounds(420, 20, 110, 20);

        JRadioButton greciaAtual = new JRadioButton("Grécia Atual");
        greciaAtual.setMnemonic(KeyEvent.VK_C);
        greciaAtual.setBounds(530, 20, 130, 20);
        greciaAtual.setActionCommand(greciaATString);

        grupo = new ButtonGroup();
        grupo.add(greciaAntiga);
        grupo.add(greciaAtual);

        greciaAntiga.addActionListener(this :: ver);
        greciaAtual.addActionListener(this :: ver1);

        jf.add(greciaAntiga);
        jf.add(greciaAtual);
        jf.add(texto);
        jf.add(imagemLabel1);
        jf.add(imagemLabel);
        jf.add(voltar);
        jf.setVisible(true);
    }

    private void ver(ActionEvent actionEvent) {

        definirGreciaAT();

        Path path = Path.of("GreciaA.txt");
        try {
            List<String> contexto = Files.readAllLines(path);

            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");
            exibirImagem("greciaantiga.jpg");
          } catch (IOException e) {

            e.printStackTrace();
          }


    }

    public void ver1(ActionEvent actionevent1){

        Path path1 = Path.of("GreciaAT.txt");
        try {
            List<String> contexto = Files.readAllLines(path1);

            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");
            exibirImagem("greciaatual.jpeg");
          } catch (IOException e) {

            e.printStackTrace();
          }
    } 

    private void volta(ActionEvent actionevent1) {
        jf.dispose();
        new InterfaceGrafica().janela.setVisible(true);
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getHistoriaA() {
        return historiaA;
    }

    public void setHistoriaA(String historiaA) {
        this.historiaA = historiaA;
    }

    private void exibirImagem(String caminhoImagem) {
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image imagem = imagemIcon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        imagemLabel.setIcon(new ImageIcon(imagem));
    }
}