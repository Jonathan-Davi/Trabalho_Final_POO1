import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sobre {

    private String greciaA;
    private String greciaAT;
    private String Moussaka;
    private String Spanakopita;
    private String Gyros;
    Path path;

    public void fazerGreciaA(){

    path = Path.of("GreciaA.txt"); 

    salvarTexto(this.getGreciaA(), path);

    }

    public void fazerGreciaAT() {

        path = Path.of("GreciaAT.txt");
        salvarTexto(this.getGreciaAT(), path);

    }

    public void fazerMoussaka(){
        path = Path.of("MoussakaCT.txt");
        salvarTexto(this.getMoussaka(), path);

    }

    public void fazerSpanakopita(){
        path = Path.of("spanakopitaCT.txt");
        salvarTexto(this.getSpanakopita(), path);

    }

    public void fazerGyros(){
        path = Path.of("GyrosCT.txt");
        salvarTexto(this.getGyros(), path);

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

    public String getMoussaka() {
      return Moussaka;
    }

    public void setMoussaka(String Moussaka) {
      this.Moussaka = Moussaka;
    }

    public String getSpanakopita() {
      return Spanakopita;
    }

    public void setSpanakopita(String Spanakopita) {
      this.Spanakopita = Spanakopita;
    }

    public String getGyros() {
      return Gyros;
    }

    public void setGyros(String Gyros) {
      this.Gyros = Gyros;
    }


    public String getGreciaA() {
        return greciaA;
    }

    public void setGreciaA(String greciaA) {
        this.greciaA = greciaA;
    }

    public String getGreciaAT() {
        return greciaAT;
    }

    public void setGreciaAT(String greciaAT) {
        this.greciaAT = greciaAT;
    }




}
