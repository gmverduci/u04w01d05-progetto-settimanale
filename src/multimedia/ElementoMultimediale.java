package multimedia;

public abstract class ElementoMultimediale {
    protected String titolo;
    protected int durata;
    protected String tipoFile;



    public ElementoMultimediale(String titolo, int durata, String tipoFile) {
        this.titolo = titolo;
        this.durata = durata;
        this.tipoFile = tipoFile;

    }

    public String getTitolo() {
        return titolo;
    }

    public String getTipoFile() {
        return tipoFile;
    }

    public abstract void esegui();

    public abstract void options(String opzione, String azione);


}
