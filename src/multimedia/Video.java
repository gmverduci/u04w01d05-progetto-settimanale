package multimedia;

public class Video extends ElementoMultimediale implements Riproducibile {
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita, String tipoFile) {
        super(titolo, durata, tipoFile);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume) + "*".repeat(luminosita));
        }
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

}
