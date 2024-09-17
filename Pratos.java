import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class Pratos {

  private String nome;


  private String ingredientes;
  private String preparo;
  private String historia;
  JFrame jf,attt;
  JLabel imagem, texto;
  JButton voltar, receitas, att;
  JTextArea atualizar;
  Path path;

  public void fazerIngredientes() {

    path = Path.of("ingredientes.txt");

    salvarTexto(this.getIngredientes(), path);

    }

    public void fazerPreparo() {

        path = Path.of("preparo.txt");
        salvarTexto(this.getPreparo(), path);

    }

    public void fazerHistoria() {

        path = Path.of("historia.txt");



        this.salvarTexto(this.getHistoria(), path);





    }

    protected void salvarTexto(String texto, Path path){
      try {

      if (Files.notExists(path)) {
        Files.createFile(path);
      }

      Files.writeString(path, texto);

    } catch (IOException e) {
      e.printStackTrace();
    }
    }





      public String getIngredientes() {
        return ingredientes;
      }

      public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
      }

      public String getPreparo() {
        return preparo;
      }

      public void setPreparo(String preparo) {
        this.preparo = preparo;
      }

      public String getHistoria() {
        return historia;
      }

      public void setHistoria(String historia) {
        this.historia = historia;
      }

       public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


}