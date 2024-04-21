package multimedia;

public class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita, String tipoFile) {
        super(titolo, 0, tipoFile);
        this.luminosita = luminosita;
    }

    public void show() {
        System.out.println(titolo + " " + "*".repeat(luminosita));
    }

    @Override
    public void esegui() {
        show();
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

    @Override
    public void options(String opzione, String azione) {
        switch (opzione.toUpperCase()) {
            case "LUMINOSITA":
                if (azione.equalsIgnoreCase("AUMENTA")) {
                    aumentaLuminosita();
                } else if (azione.equalsIgnoreCase("DIMINUISCI")) {
                    diminuisciLuminosita();
                }
                break;
            default:
                System.out.println("Opzione non supportata.");
        }
    }

}
