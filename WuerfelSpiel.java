import javax.swing.*;
import java.util.Arrays;

public class Wuerfelspiel {
    public static void main(String[] spiel) {
        boolean isError;
        int eingabeSpieler = 0;
        int eingabeWuerfe = 0;
        String erg = "";
        do {
            try {
                isError = false;
                eingabeSpieler = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Bitte geben Sie an, wie viele mitspielen möchten"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falsche Angaben");
                isError = true;
            }
        } while (isError);
        do {
            try {
                isError = false;
                eingabeWuerfe = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Bitte geben Sie an, wie oft gewürfelt werden soll"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falsche Angaben");
                isError = true;
            }
        }while(isError);
        int[][] duplicates = new int[eingabeSpieler][6];
        for (int player = 0; player < eingabeSpieler; player++) {
            erg += "Spieler " + (player + 1) + " würfelt: ";
            int[] wuerfe = new int[eingabeWuerfe];
            for (int i = 0; i < eingabeWuerfe; i++) {
                wuerfe[i] = (int) (Math.random() * 6) + 1;
            }
            Arrays.sort(wuerfe);
            int sum = 0;
            for (int i = 0; i < eingabeWuerfe; i++) {
                erg += wuerfe[i];
                sum += wuerfe[i];
                if (i < eingabeWuerfe - 1) {
                    erg += ", ";
                } else {
                    for (int wurf : wuerfe) {
                        duplicates[player][wurf - 1]++;
                    }
                }
            }
            erg += "\n\tSumme: " + sum + "\t";
            erg += "Gezählte Würfe: ";
            boolean isFirst = true;
            for (int count = 1; count <= eingabeWuerfe; count++) {
                for (int i = 0; i < 6; i++) {
                    if (duplicates[player][i] == count) {
                        if (!isFirst) {
                            erg += ", ";
                        }
                        erg += duplicates[player][i] + " mal " + (i + 1);
                        isFirst = false;
                    }
                }
            }
            erg += "\n";
        }
        System.out.println(erg);
    }
}
