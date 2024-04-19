package main;

import multimedia.ElementoMultimediale;
import multimedia.Immagine;
import multimedia.RegistrazioneAudio;
import multimedia.Riproducibile;
import multimedia.Video;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LettoreMultimediale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] playlist = new ElementoMultimediale[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Indica il tipo di elemento (Audio, Video o Immagine):");
            System.out.println("Scrivi come vuoi: non è case-sensitive (Es. Audio, audio o AUDIO).");
            String tipo = scanner.next();
            if (!tipo.equalsIgnoreCase("Audio") && !tipo.equalsIgnoreCase("Video") && !tipo.equalsIgnoreCase("Immagine")) {
                System.out.println("Tipo non esistente!");
                return;
            } else {
                scanner.nextLine();

                System.out.println("Inserisci il titolo:");
                String titolo = scanner.nextLine();

                if (tipo.equalsIgnoreCase("Audio")) {
                    System.out.println("Inserisci la durata:");
                    int durata = scanner.nextInt();
                    System.out.println("Inserisci il volume:");
                    int volume = scanner.nextInt();
                    playlist[i] = new RegistrazioneAudio(titolo, durata, volume, "Audio");
                } else if (tipo.equalsIgnoreCase("Video")) {
                    System.out.println("Inserisci la durata:");
                    int durata = scanner.nextInt();
                    System.out.println("Inserisci il volume:");
                    int volume = scanner.nextInt();
                    System.out.println("Inserisci la luminosità:");
                    int luminosita = scanner.nextInt();
                    playlist[i] = new Video(titolo, durata, volume, luminosita, "Video");
                } else {
                    System.out.println("Inserisci la luminosità:");
                    int luminosita = scanner.nextInt();
                    playlist[i] = new Immagine(titolo, luminosita, "Immagine");
                }
            }
        }


        int scelta;
        do {
            System.out.println("Scegli dalla playlist:");
            System.out.println("1: " + playlist[0].getTitolo() + ", Tipo: " + playlist[0].getTipoFile());
            System.out.println("2: " + playlist[1].getTitolo() + ", Tipo: " + playlist[1].getTipoFile());
            System.out.println("3: " + playlist[2].getTitolo() + ", Tipo: " + playlist[2].getTipoFile());
            System.out.println("4: " + playlist[3].getTitolo() + ", Tipo: " + playlist[3].getTipoFile());
            System.out.println("5: " + playlist[4].getTitolo() + ", Tipo: " + playlist[4].getTipoFile());

            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= 5) {
                if (playlist[scelta - 1] instanceof Immagine) {
                    ((Immagine) playlist[scelta - 1]).show();
                } else {
                    ((Riproducibile) playlist[scelta - 1]).play();
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);


        System.out.println("Programma terminato.");
        scanner.close();
    }
}
