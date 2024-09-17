import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javax.swing.*;


public class Moussaka extends Pratos {

    JFrame jfH, jfI, jfP, attt;
    JLabel imagem, texto, ler;
    JButton voltar, voltar1, voltar3;
    JButton receitas;
    JButton attPrep;
    JButton att; 
    JButton attIngre;
    JTextArea atualizar;
    private String acao;
    boolean botaoAttIngre = false;
    ImageIcon voltarIcon = new ImageIcon("voltar.png");
    ImageIcon receitaIcon = new ImageIcon("receita.png");
    ImageIcon pranchetaIcon = new ImageIcon("prancheta.png");
    ImageIcon atualizaIcon = new ImageIcon("atualizada.png");


    public void ingredientes(){
            this.setIngredientes(" Ingredientes:\n" + //
            "       3 unidades de berinjela em rodelas\n" + //
            "      2 dentes de alho picados\n" + //
            "      1 unidade de cebola picada\n" + //
            "     2 colheres (sopa) de azeite de oliva\n" + //
            "      250 gr de carne moída\n" + //
            "      1/2 colher (chá) de canela-da-china em pó\n" + //
            "      Sal e pimenta-do-reino a gosto\n" + //
            "      1/4 xícara (chá) de molho de tomate\n" + //
            "      2 colheres (sopa) de salsinha picada\n" + //
            "      2 unidades de batata descascadas e em rodelas\n" + //
            "      2 colheres (sopa) de parmesão\n" + //
            "      2 unidades de ovo batidos\n" + //
            "      1 xícara (chá) de iogurte natural\n" + //
            "      1/2 xícara (chá) de leite\n" + //
            "      1 pitada de páprica picante\n" );
    }


    public void setarIngredietes(){

        this.setNome("Ingredientes");
        this.fazerIngredientes();

        criarIngredientes();


        receitas = new JButton(pranchetaIcon);
        receitas.setBounds(580, 400, 80, 28);
        receitas.addActionListener(this :: mPreparo);
        receitas.setToolTipText("Modo de Preparo");
        jfI.add(receitas);

        attIngre = new JButton(atualizaIcon);
        attIngre.setBounds(470, 400, 90, 28);
        attIngre.addActionListener(this :: atualizarIngredientes);
        attIngre.setToolTipText("Atualizar");
        jfI.add(attIngre);


        exibirImagem("moussakaingre.jpg"); 
    }

    private void exibirImagem(String caminhoImagem) {
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image dimg = imagemIcon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        imagem.setIcon(new ImageIcon(dimg));
    }


    public void preparo(){
        this.setPreparo(" Preparo:\n" + //
        "      1. Salpique sal nas rodelas de berinjela e deixe-as descansar por 30 min.\n" + //
        "      2. Numa panela, refogue a cebola e o alho em 1 colher de azeite. Adicione a carne e cozinhe até soltar toda a água e ficar cozida.\n"
        + //
        "      3. Acrescente o sal, a pimenta, a canela, o molho de tomate e a salsinha, e cozinhe por cerca de 20 min.\n"
        + //
        "      4. Escorra a água que soltou da berinjela e numa frigideira, com um fio de azeite, doure as rodelas de berinjela dos dois lados. Reserve.\n" + //
        "      5. Numa outra frigideira (eu fiz na mesma frigideira), com restante de azeite, doure as rodelas de batata.\n"
        + //
        "      6. Numa tigela, junte os ovos batidos, o iogurte, o leite e a páprica. Salpique com sal e pimenta e reserve.\n"+
        "      7. Preaqueça o forno à 180ºC.\n"+
        "      8. Numa travessa untada com gotinhas de azeite, faça uma camada com as rodelas de batata e espalhe a carne.\n"+
        "      9. Arrume as rodelas de berinjela por cima e salpique com queijo parmesão. Despeje o molho de iogurte por cima e leve ao forno até dourar.\n");
    }

    public void setarPreparo(){


        this.setNome("Preparo");
        this.fazerPreparo();
        criarIngredientes();

        attPrep = new JButton(atualizaIcon);
        attPrep.setBounds(580, 400, 90, 28);
        attPrep.addActionListener(this :: atualizarPreparo);
        attPrep.setToolTipText("Atualizar");
        jfI.add(attPrep);

        exibirImagem("moussakaprep.jpg"); 


    }

    public void historia(){
        this.setHistoria(
            "Moussaka é um prato à base de berinjela (beringela) ou de batata, muitas vezes incluindo carne moída, no Levante, no Oriente Médio e nos Bálcãs, com muitas variações locais e regionais.\n" + //
            "      A versão mais famosa do prato hoje apareceu na década de 1920 com a publicação do livro culinário de Nikolaos Tselementes na Grécia. Muitas versões têm uma camada superior feita de molho à base de leite engrossado com ovo (creme) ou farinha (molho béchamel). \n" + //
            "      Na Grécia, o prato é em camadas e normalmente servido quente. Na Turquia, a berinjela em fatias finas é frita e servida em um molho de carne à base de tomate. \n" + //
            "      A mussaca turca pode ser consumida morna ou à temperatura ambiente. No mundo árabe, geralmente é comido frio.\n" + //
            "      Nomes e etimologia: O nome em inglês para moussaka tem origem árabe, musaqqa'a, literalmente aquilo que é alimentado com líquido. Foi retirado dos mousakás gregos e de outras línguas dos Balcãs, todos emprestados da palavra do império otomano.\n" + //
            "      A palavra foi primeiramente publicada em inglês em 1862, escrita mùzàkkà.");
    }

    public void setarHistoria(){

        this.setNome("Historia");
        this.fazerHistoria();
        criarIngredientes();

        receitas = new JButton(receitaIcon);
        receitas.setBounds(580, 400, 80, 28);
        receitas.addActionListener(this :: receita);
        receitas.setToolTipText("Ingredientes");
        jfI.add(receitas);

        att= new JButton(atualizaIcon);
        att.setBounds(470, 400, 90, 28);
        att.addActionListener(this :: atualizarHistoria);
        att.setToolTipText("Atualizar");
        jfI.add(att);

        exibirImagem("moussaka.jpg"); 
    }



    public void criarIngredientes() {



        jfI = new JFrame(this.getNome());
        jfI.setSize(new Dimension(800, 500));
        jfI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfI.setLayout(null);
        jfI.setLocationRelativeTo(null);


        imagem = new JLabel();
        imagem.setBounds(0, 0, jfI.getWidth(), jfI.getHeight());

        voltar = new JButton(voltarIcon);
        voltar.setBounds(680, 400, 80, 28);
        voltar.addActionListener(this :: voltar);
        voltar.setToolTipText("Clique para voltar");
        this.jfI.add(voltar);


        texto = new JLabel();
        texto.setBounds(430, 10, 350, 400);
        texto.setForeground(Color.BLACK);

        try {
            List<String> contexto = Files.readAllLines(this.path);

            String valor = String.join("<br/>", contexto);
            texto.setText("<html>" + valor + "</html>");

        } catch (IOException e) {

            e.printStackTrace();
        }


        jfI.add(texto);
        jfI.add(imagem);
        jfI.setVisible(true);

    }




    public void atualizarHistoria(String texto){

        this.setHistoria(texto);
        this.setarHistoria();


    }

    public void atualizarIngredientes(String texto){

        this.setIngredientes(texto);
        this.setarIngredietes();

    }

    public void atualizarPreparo(String texto){

        this.setPreparo(texto);
        this.setarPreparo();

    }




    private void voltar(ActionEvent actionevent1) {

        new InterfaceGrafica();
        jfI.dispose();
    }

    private void receita(ActionEvent actionevent1) {
        this.ingredientes();
        jfI.setVisible(false);
        setarIngredietes();


    }

    private void mPreparo(ActionEvent actionevent1) {
        this.preparo();
        jfI.setVisible(false);
        setarPreparo();

    }


    private void atualizarIngredientes(ActionEvent actionevent1) {



            acao = "ingredientes";
            new Atualizar(path, acao);
            jfI.dispose();
    }

    private void atualizarHistoria(ActionEvent actionevent1) {
            acao = "historia";
            new Atualizar(path, acao);
            jfI.dispose();
    }

    private void atualizarPreparo(ActionEvent actionevent1) {
            acao = "preparo";
            new Atualizar(path, acao);
            jfI.dispose();
    }




    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }



}

