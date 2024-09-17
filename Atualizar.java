import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Atualizar extends Pratos{


    JFrame jf;
    private Path path;
    JButton jbSalvar;
    JTextArea texto;
    private String tipoAtualizacao;



    public Atualizar(Path path, String tipoAtualizacao ){
        this.path = path;
        this.tipoAtualizacao = tipoAtualizacao;


        jf = new JFrame("Atualizar");
        jf.setSize(new Dimension(800, 500));
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        texto = new JTextArea();
        texto.setBounds(0,0,800,400);

         try {
            if(Files.exists(this.path)){

            List<String> contexto = Files.readAllLines(this.path);

            String valor = String.join("\n", contexto);
            texto.setText(valor);
            } else{
                JOptionPane.showMessageDialog(null, "Não existe arquivo" );
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        jbSalvar = new JButton("Salvar");
        jbSalvar.setBounds(340,420,100,20);
        jbSalvar.addActionListener(this :: Salvar);

        jf.add(jbSalvar);
        jf.add(texto);
        jf.setVisible(true);


    }


    private void Salvar(ActionEvent actionevent1) {

        Spanakopita s = new Spanakopita();
        switch (tipoAtualizacao) {
            case "historia":
                s.atualizarHistoria(texto.getText());
                jf.dispose();
                break;
            case "ingredientes":
                    s.atualizarIngredientes(texto.getText());
                    jf.dispose();
                break;
            case "preparo":
                s.atualizarPreparo(texto.getText());
                jf.dispose();
                break;

            default:
                break;
        }






    }

}





