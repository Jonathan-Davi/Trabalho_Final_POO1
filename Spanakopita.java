import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javax.swing.*;



public class Spanakopita extends Pratos {

    JFrame jfH, jfI, jfP, attt;
    JLabel imagem, texto, ler;
    JButton voltar, voltar1, voltar3;
    JButton receitas;
    JButton attPrep;
    JButton att; 
    JButton attIngre;
    JTextArea atualizar;
    private String acao;
    boolean botaoAttIngre;
    ImageIcon voltarIcon = new ImageIcon("voltar.png");
    ImageIcon receitaIcon = new ImageIcon("receita.png");
    ImageIcon pranchetaIcon = new ImageIcon("prancheta.png");
    ImageIcon atualizaIcon = new ImageIcon("atualizada.png");


    public void ingredientes(){
            this.setIngredientes(" Recheio:\n" + //
                "      2 colheres (sopa) de azeite\n" + //
                "      1 maço de espinafre\n" + //
                "      7 Vegetais\n" + //
                "      250 g de queijo meia cura, amassado\n" + //
                "      3 ovos\n" + //
                "      2 colheres (sopa) de dill\n" + //
                "      2 colheres (sopa) de salsa picada\n" + //
                "      3 colheres (sopa) de cebolinha-verde picada\n" + //
                "      1 pitada de pimenta-do-reino\n" + //
                "      1 pitada de noz-moscada\n" + //
                "      \n" + //
                " Montagem:\n" + //
                "      1 pacote de massa folhada\n" + //
                "      1 ovo para pincelar\n ");
    }


    public void setarIngredietes(){

        this.setNome("Ingredientes");

        this.fazerIngredientes();

        this.criarIngredientes();

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


        this.exibirImagem("spanakopitaingre.jpg"); 
    }

    private void exibirImagem(String caminhoImagem) {
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image dimg = imagemIcon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        imagem.setIcon(new ImageIcon(dimg));
    }


    public void preparo(){
        this.setPreparo(" Recheio:\n" + //
                "      1. Em uma panela, aqueça o azeite e refogue o espinafre.\n" + //
                "      2. Junte o queijo, os ovos ligeiramente batidos, o dill, a salsa, a cebolinha, a pimenta-do-reino e a noz-moscada e misture bem.\n"
                + //
                "      \n" + //
                " Montagem:\n" + //
                "      3. Abra a massa folhada, forre o fundo e as laterais de um recipiente refratário médio (25 x 25 cm) untado com manteiga com metade da massa e distribua o recheio de espinafre.\n"
                + //
                "      4. Cubra com a outra metade da massa e pincele com o ovo.\n" + //
                "      5. Pressione as bordas com um garfo e leve ao forno médio-alto (200°C), preaquecido, por cerca de 30 minutos ou até que a superfície esteja dourada.\n"
                + //
                "      6. Sirva quente ou fria.\n");
    }

    public void setarPreparo(){


        this.setNome("Preparo");
        this.fazerPreparo();
        this.criarIngredientes();


        attPrep = new JButton(atualizaIcon);
        attPrep.setBounds(580, 400, 90, 28);
        attPrep.addActionListener(this :: atualizarPreparo);
        attPrep.setToolTipText("Atualizar");
        this.jfI.add(attPrep);

        this.exibirImagem("preparospanakopita.jpg"); 



    }

    public void historia(){
        this.setHistoria(
                "A spanakopita tem suas raízes na culinária grega antiga e é um prato que tem sido apreciado por séculos.\n"+"Acredita-se que a receita original tenha sido criada na região da Ásia Menor, que hoje faz parte da Turquia. \n" +" No entanto, com o passar do tempo, a spanakopita se tornou um prato emblemático da culinária grega e é amplamente\n" + "consumida em toda a Grécia e em muitos outros países.");
    }

    public void setarHistoria(){

        this.setNome("Historia");

        this.fazerHistoria();
        this.criarIngredientes();


        receitas = new JButton(receitaIcon);
        receitas.setBounds(580, 400, 80, 28);
        receitas.addActionListener(this :: receita);
        receitas.setToolTipText("Ingredientes");
        this.jfI.add(receitas);

        att= new JButton(atualizaIcon);
        att.setBounds(470, 400, 90, 28);
        att.addActionListener(this :: atualizarHistoria);
        att.setToolTipText("Atualizar");
        this.jfI.add(att);

        exibirImagem("spanakopita.jpg"); 

    }



     public void criarIngredientes() {

        jfI = new JFrame(this.getNome());
        jfI.setSize(new Dimension(800, 500));
        jfI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfI.setLayout(null);
        jfI.setLocationRelativeTo(null);

        voltar = new JButton(voltarIcon);
        voltar.setBounds(680, 400, 80, 28);
        voltar.addActionListener(this :: voltar);
        voltar.setToolTipText("Clique para voltar");
        this.jfI.add(voltar);


        imagem = new JLabel();
        imagem.setBounds(0, 0, jfI.getWidth(), jfI.getHeight());



        texto = new JLabel();
        texto.setBounds(430, 20, 350, 400);
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

        this.botaoAttIngre = true;

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
