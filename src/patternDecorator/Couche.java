package patternDecorator;

public abstract class Couche extends Patisserie {
  protected Patisserie pat;
  protected String nom;

  public Couche(Patisserie p) {
    this.pat = p;
  }

  public String preparer() {
    String str = pat.preparer();
    return str + this.nom;
  }
}
