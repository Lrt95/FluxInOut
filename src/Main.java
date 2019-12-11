import java.io.File;
import patternDecorator.CoucheBiscuit;
import patternDecorator.CoucheCaramel;
import patternDecorator.CoucheChocolat;
import patternDecorator.Gateau;
import patternDecorator.Patisserie;

public class Main {
  public static void main(String[] args) {
    Patisserie patisserie = new CoucheChocolat(
        new CoucheCaramel(
            new CoucheBiscuit(
                new CoucheChocolat(
                    new Gateau()))));
    System.out.println(patisserie.preparer());
  }
}
