import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javax.swing.*;


public class Gyros extends Pratos {

    JFrame jfI;
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
            this.setIngredientes("1 cebola bem picada\n" + //
                    "        1kg de carne de cordeiro moída\n" + //
                    "        1 colher (sopa) de alho picado\n" + //
                    "        1 colher (café) de orégano\n" + //
                    "        1 colher (café) de cominho\n" + //
                    "        1 colher (café) de manjerona seca\n" + //
                    "        1 colher (café) de tomilho fresco\n" + //
                    "        1 tomate em tiras\n" + //
                    "        1 cebola roxa em tiras\n" + //
                    "        Batatas fritas\n" + //
                    "        Alface americana\n" + //
                    "        6 pães folha");
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


        exibirImagem("gyrosingre.jpg"); 
    }

    private void exibirImagem(String caminhoImagem) {
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        Image dimg = imagemIcon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        imagem.setIcon(new ImageIcon(dimg));
    }


    public void preparo(){
        this.setPreparo("1: Em um bowl, misture a carne com os temperos e a cebola bem picada.\n" + //
                "      2: Faça pequenos bolinhos.\n" + //
                "      3: Asse em forno preaquecido a 180 graus, até que o interior não esteja mais rosado OU grelhe em uma frigideira untada\n"+" com um pouco de azeite.\n" + //
                "      4: Corte em tiras e reserve.\n" + //
                "      5: Recheie o pão folha com a carne, o tomate, a cebola, a alface, as batatas fritas.\n" + //
                "      6: Sirva com o molho tzatziki.");
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

        exibirImagem("gyrosprep.jpg"); 


    }

    public void historia(){
        this.setHistoria("O Gyros, pronunciado como “guiros”, é um prato com uma história impressionante que remonta ao século XIX no extinto Império Otomano.\n " +" A técnica especial para assar carnes no espeto, que envolvia girar as carnes em grelhas rotativas, deu origem ao nome do prato.\n"+" Quando o Império Otomano começou a se dissolver, imigrantes levaram essa técnica para a Grécia, onde foi adaptada e transformada\n"+" na refeição completa conhecida como Gyros. Na década de 1920, o Gyros já era popular em Atenas e, desde então, se espalhou para outras\n"+" partes do mundo, incluindo cidades como Chicago e Nova York.");
    }

    public void setarHistoria(){

        this.setNome("Historia");
        this.fazerHistoria();
        criarIngredientes();


        receitas = new JButton(receitaIcon);
        receitas.setBounds(580, 400, 80, 28);
        receitas.addActionListener(this :: receita);
        receitas.setToolTipText("Clique para ver a Receita");
        jfI.add(receitas);

        att= new JButton(atualizaIcon);
        att.setBounds(470, 400, 90, 28);
        att.addActionListener(this :: atualizarHistoria);
        att.setToolTipText("Atualizar");
        jfI.add(att);

        exibirImagem("gyros.jpg"); 
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

        botaoAttIngre = true;

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

