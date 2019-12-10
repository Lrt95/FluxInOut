import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OpChronoWrite {
  public static void chronoWrite() {

    System.out.println("\n");
    System.out.println("------------->Method Chrono Write<-------------");
    System.out.println("\n");

    //Nous déclarons nos objets en dehors du bloc try/catch
    FileInputStream fis;
    FileOutputStream fos;
    BufferedInputStream bis;
    BufferedOutputStream bos;

    try {
      fis = new FileInputStream(new File("IO/test.txt"));
      fos = new FileOutputStream(new File("IO/test2.txt"));
      bis = new BufferedInputStream(new FileInputStream(new File("IO/test.txt")));
      bos = new BufferedOutputStream(new FileOutputStream(new File("IO/test3.txt")));
      byte[] buf = new byte[8];

      //On récupère le temps du système
      long startTime = System.currentTimeMillis();

      while(fis.read(buf) != -1){
        fos.write(buf);
      }
      //On affiche le temps d'exécution
      System.out.println("Temps de lecture + écriture avec FileInputStream et FileOutputStream : " + (System.currentTimeMillis() - startTime));

      //On réinitialise
      startTime = System.currentTimeMillis();

      while(bis.read(buf) != -1){
        bos.write(buf);
      }
      //On réaffiche
      System.out.println("Temps de lecture + écriture avec BufferedInputStream et BufferedOutputStream : " + (System.currentTimeMillis() - startTime));

      //On ferme nos flux de données
      fis.close();
      bis.close();
      fos.close();
      bos.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
