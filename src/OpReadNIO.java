import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OpReadNIO {
  public static void readNio() {
    Path path = Paths.get("IO/test.txt");
    System.out.println("Chemin absolu du fichier : " + path.toAbsolutePath());
    System.out.println("Est-ce qu'il existe ? " + Files.exists(path));
    System.out.println("Nom du fichier : " + path.getFileName());
    System.out.println("Est-ce un répertoire ? " + Files.isDirectory(path));

    //On récupère maintenant la liste des répertoires dans une collection typée
//Via l'objet FileSystem qui représente le système de fichier de l'OS hébergeant la JVM
    Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();

//Maintenant, il ne nous reste plus qu'à parcourir
    for(Path chemin : roots){
      System.out.println(chemin);
      //Pour lister un répertoire, il faut utiliser l'objet DirectoryStream
      //L'objet Files permet de créer ce type d'objet afin de pouvoir l'utiliser
      try(DirectoryStream<Path> listing = Files.newDirectoryStream(chemin, "*.txt")){

        int i = 0;
        for(Path nom : listing){
          System.out.print("\t\t" + ((Files.isDirectory(nom)) ? nom+"/" : nom));
          i++;
          if(i%4 == 0)System.out.println("\n");
        }

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
