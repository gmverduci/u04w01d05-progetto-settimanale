package multimedia;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume, String tipoFile) {
        super(titolo, durata, tipoFile);
        this.volume = volume;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume));
        }
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void alzaVolume() {
        volume++;
    }

    @Override
    public void esegui() {
        play();
    }

    @Override
    public void options(String opzione, String azione) {
        switch (opzione.toUpperCase()) {
            case "VOLUME":
                if (azione.equalsIgnoreCase("AUMENTA")) {
                    alzaVolume();
                } else if (azione.equalsIgnoreCase("DIMINUISCI")) {
                    abbassaVolume();
                }
                break;
            default:
                System.out.println("Opzione non supportata.");
        }
    }
}
