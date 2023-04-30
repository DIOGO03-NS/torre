import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TorreDeH {
    public static long resolveTorre(int numDiscos, String torreInicio, String torreAux, String torreFim){
        long nOperacoes = 0;
        if(numDiscos > 0){
            nOperacoes += resolveTorre(numDiscos-1, torreInicio, torreFim, torreAux);
            nOperacoes++;                                                           //torre base movida
            nOperacoes += resolveTorre(numDiscos-1, torreInicio, torreAux, torreFim);
        }
        return nOperacoes;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("DIGITE O NUMERO DE DISCOS: ");
        int discos = input.nextInt();

        long start = System.currentTimeMillis();
        System.out.println(resolveTorre(discos, "torre1", "torre2", "torre3"));
        long milliseconds = System.currentTimeMillis() - start;

        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60;
        long millis = milliseconds % 1000;

        System.out.printf("\n%d:%d:%d:%d", hours, minutes, seconds, millis);
    }
}
