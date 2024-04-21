import multimedia.ElementoMultimediale;
import multimedia.Immagine;
import multimedia.RegistrazioneAudio;
import multimedia.Riproducibile;
import multimedia.Video;

import java.util.Scanner;

public class LettoreMultimediale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] playlist = new ElementoMultimediale[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Indica il tipo di elemento (Audio, Video o Immagine):");
            System.out.println("(Scrivi come vuoi, non è case sensitive.)");
            String tipo = scanner.next();
            scanner.nextLine();

            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();

            switch (tipo.toLowerCase()) {
                case "audio":
                    System.out.println("Inserisci la durata:");
                    int durataAudio = scanner.nextInt();
                    System.out.println("Inserisci il volume:");
                    int volumeAudio = scanner.nextInt();
                    playlist[i] = new RegistrazioneAudio(titolo, durataAudio, volumeAudio, "Audio");
                    break;
                case "video":
                    System.out.println("Inserisci la durata:");
                    int durataVideo = scanner.nextInt();
                    System.out.println("Inserisci il volume:");
                    int volumeVideo = scanner.nextInt();
                    System.out.println("Inserisci la luminosità:");
                    int luminosita = scanner.nextInt();
                    playlist[i] = new Video(titolo, durataVideo, volumeVideo, luminosita, "Video");
                    break;
                case "immagine":
                    System.out.println("Inserisci la luminosità:");
                    int luminositaImmagine = scanner.nextInt();
                    playlist[i] = new Immagine(titolo, luminositaImmagine, "Immagine");
                    break;
                default:
                    System.out.println("Tipo non riconosciuto. Inserimento annullato.");
                    i--;
                    break;
            }
        }

        ElementoMultimediale elementoInEsecuzione = null;

        while (true) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1: Esegui elemento multimediale");
            System.out.println("2: Modifica opzioni (Volume o Luminosità) dell'ultimo elemento riprodotto");
            System.out.println("0: Esci");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Scegli dalla playlist:");
                    for (int i = 0; i < 5; i++) {
                        System.out.println((i + 1) + " - Titolo: " + playlist[i].getTitolo() + ", Tipo: " + playlist[i].getTipoFile());
                    }

                    int indiceElemento = scanner.nextInt() - 1;

                    if (indiceElemento >= 0 && indiceElemento < playlist.length) {
                        elementoInEsecuzione = playlist[indiceElemento];
                        elementoInEsecuzione.esegui();
                    } else {
                        System.out.println("Indice non valido.");
                    }
                    break;

                case 2:
                    if (elementoInEsecuzione != null) {
                        if (elementoInEsecuzione instanceof RegistrazioneAudio) {
                            System.out.println("Modifica volume (Aumenta o Diminuisci)");
                            String azione = scanner.next();
                            elementoInEsecuzione.options("volume", azione);
                        } else if (elementoInEsecuzione instanceof Video || elementoInEsecuzione instanceof Immagine) {
                            System.out.println("Modifica luminosità (Aumenta o Diminuisci):");
                            String azione = scanner.next();
                            elementoInEsecuzione.options("luminosità", azione);
                        }
                        elementoInEsecuzione.esegui();
                    } else {
                        System.out.println("Nessun elemento attualmente in esecuzione.");
                    }
                    break;

                case 0:
                    System.out.println("Chiusura Lettore Multimediale.");
                    return;

                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }
    }
}
