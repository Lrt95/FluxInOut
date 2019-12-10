import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpChronoRead {
  public static void chronoRead() {
    System.out.println("\n");
    System.out.println("------------->Method Chrono Read<-------------");
    System.out.println("\n");

    //Nous déclarons nos objets en dehors du bloc try/catch
    FileInputStream fis;
    BufferedInputStream bis;
    try {
      fis = new FileInputStream(new File("IO/test.txt"));
      bis = new BufferedInputStream(new FileInputStream(new File("IO/test.txt")));
      byte[] buf = new byte[8];

      //On récupère le temps du système
      long startTime = System.currentTimeMillis();
      //Inutile d'effectuer des traitements dans notre boucle
      while(fis.read(buf) != -1);
      //On affiche le temps d'exécution
      System.out.println("Temps de lecture avec FileInputStream : " + (System.currentTimeMillis() - startTime));

      //On réinitialise
      startTime = System.currentTimeMillis();
      //Inutile d'effectuer des traitements dans notre boucle
      while(bis.read(buf) != -1);
      //On réaffiche
      System.out.println("Temps de lecture avec BufferedInputStream : " + (System.currentTimeMillis() - startTime));

      //On ferme nos flux de données
      fis.close();
      bis.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
