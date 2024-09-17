import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.*;
import java.util.List;

public class ContextoCultural extends Sobre{

    private JFrame jf;
    private JButton voltar;
    private JLabel texto, imagemLabel, imagemLabel1, imagemLabel2;
    private String Moussaka;
    private String spanakopita;
    private String Gyros;
    ImageIcon voltarIcon = new ImageIcon("voltar.png");

    public void definirMoussaka(){
        this.setMoussaka("A moussaka é um prato tradicional da culinária grega com raízes nos Bálcãs e no Oriente Médio. Sua origem antiga reflete influências culturais diversas, estendendo-se para além da Grécia, incluindo Turquia e Bulgária, cada uma com sua abordagem única. A receita tradicional envolve camadas de berinjela, carne moída (cordeiro ou bovino), tomates, cebolas, canela e noz-moscada, cobertas com molho bechamel antes de assar. A técnica de camadas cria uma textura rica e saborosa, enquanto a moussaka incorpora os princípios da dieta mediterrânea, destacando ingredientes frescos e azeite de oliva. Com variações regionais e familiares, a moussaka é um exemplo de prato que evolui e reflete as preferências locais ao longo do tempo.");
        this.fazerMoussaka();

    }

    public void definirSpanakopita(){
        this.setSpanakopita("A spanakopita tem suas raízes na Grécia, onde a tradição culinária mediterrânea desempenha um papel significativo. A combinação de ingredientes como espinafre e queijo feta é representativa da abundância de produtos agrícolas na região.\n" + //
                "A spanakopita é parte integrante da culinária mediterrânea, que enfatiza ingredientes frescos, azeite de oliva e ervas aromáticas. Essa abordagem à alimentação é conhecida por seus benefícios à saúde e é apreciada em todo o mundo.\n" + //
                "Os ingredientes-chave da spanakopita refletem a dieta mediterrânea saudável. O espinafre fornece nutrientes essenciais, enquanto o queijo feta contribui com um sabor rico e salgado. A massa filo, fina e crocante, é outra característica distintiva.\n" + //
                "A cultura grega valoriza o ato de compartilhar refeições com amigos e familiares. A spanakopita, muitas vezes cortada em pedaços menores, é ideal para ser compartilhada, promovendo uma sensação de comunidade ao redor da mesa.");
        this.fazerSpanakopita();
        this.definirMoussaka();
        this.definirGyros();
        this.Interface();

    }

    public void definirGyros(){
        this.setGyros("O gyro (ou giros) é uma especialidade da culinária grega que se tornou popular em muitas partes do mundo. O gyro tem suas raízes na Grécia e é inspirado no döner kebab turco e no shawarma do Oriente Médio. A palavra \"gyros\" significa \"girar\" em grego, referindo-se à técnica de preparação onde a carne é empilhada em um espeto vertical e girada enquanto cozinha. \r\n" + //
                "O gyro é tradicionalmente feito de carne (geralmente carneiro, frango ou porco) marinada com especiarias como alho, orégano, cominho e páprica. A carne é empilhada em um espeto vertical e cozida lentamente enquanto gira. O resultado é uma carne suculenta e saborosa.\r\n" + //
                "Os gyros são frequentemente servidos em pão pita ou enrolados em flatbreads, acompanhados de molhos como tzatziki (um molho de iogurte com pepino e alho), tomate, cebola e, por vezes, batatas fritas. A combinação desses elementos cria uma experiência gastronômica equilibrada.\r\n" + //
                "Na Grécia, a culinária frequentemente reflete o estilo de vida ao ar livre, especialmente durante o verão. Os gyros são uma escolha popular para refeições rápidas e saborosas, seja em festivais, praias ou praças movimentadas.");
        this.fazerGyros();

    }

    public void Interface(){

        jf = new JFrame("Contexto Histórico");
        jf.setSize(new Dimension(800, 500));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);

        voltar = new JButton(voltarIcon);
        voltar.setBounds(680, 400, 80, 28);
        voltar.setToolTipText("Clique para voltar");
        voltar.addActionListener(this::volta);

        imagemLabel = new JLabel();
        imagemLabel.setBounds(0, 0, 800, 500);
        jf.add(imagemLabel);

        imagemLabel1 = new JLabel();
        imagemLabel1.setBounds(0, 0, 800, 500);
        jf.add(imagemLabel1);

        imagemLabel2 = new JLabel();
        imagemLabel2.setBounds(0, 0, 800, 500);
        jf.add(imagemLabel2);

        texto = new JLabel();
        texto.setBounds(430, 0, 350, 450);
        texto.setForeground(Color.BLACK);

        JRadioButton spana = new JRadioButton("Spanakopita");
        spana.setMnemonic(KeyEvent.VK_B);
        spana.setSelected(true);

        if(spana.isSelected() == true){

            Path path2 = Path.of("spanakopitaCT.txt");
        try {
            List<String> contexto = Files.readAllLines(path2);
            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");
            exibirImagem("SpanakopitaCT.png");
          } catch (IOException e) {
            e.printStackTrace();
          }

        }



        spana.setActionCommand(spanakopita);
        spana.setBounds(420, 20, 100, 20);

        JRadioButton gyr = new JRadioButton("Gyros");
        gyr.setMnemonic(KeyEvent.VK_C);
        gyr.setBounds(540, 20, 70, 20);
        gyr.setActionCommand(Gyros);

        JRadioButton mous = new JRadioButton("Moussaka");
        mous.setMnemonic(KeyEvent.VK_D);
        mous.setBounds(630, 20, 100, 20);
        mous.setActionCommand(Moussaka);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(spana);
        grupo.add(gyr);
        grupo.add(mous);

        mous.addActionListener(this :: Moussaka);
        gyr.addActionListener(this :: Gyros);
        spana.addActionListener(this :: Spanakopita);

        jf.add(spana);
        jf.add(gyr);
        jf.add(mous);
        jf.add(imagemLabel);
        jf.add(imagemLabel1);
        jf.add(imagemLabel2);
        jf.add(texto);
        jf.add(voltar);
        jf.setVisible(true);
    }

    private void volta(ActionEvent actionevent) {
        jf.dispose();
        new InterfaceGrafica().janela.setVisible(true);
    }

    private void Moussaka(ActionEvent actionevent1){

        Path path = Path.of("MoussakaCT.txt");
        try {
            List<String> contexto = Files.readAllLines(path);
            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");
            exibirImagem("MoussakaCT.jpeg");
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

    private void Gyros(ActionEvent actionevent2){

        Path path1 = Path.of("GyrosCT.txt");
        try {
            List<String> contexto = Files.readAllLines(path1);
            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");
            exibirImagem("GyrosCT.jpeg");
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

    private void Spanakopita(ActionEvent actionevent3){

        Path path2 = Path.of("spanakopitaCT.txt");
        try {
            List<String> contexto = Files.readAllLines(path2);
            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");
            exibirImagem("SpanakopitaCT.png");
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

    private void exibirImagem(String caminhoImagem) {
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image imagem = imagemIcon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        imagemLabel.setIcon(new ImageIcon(imagem));
    }
}