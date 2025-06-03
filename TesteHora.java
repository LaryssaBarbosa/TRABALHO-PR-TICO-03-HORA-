import java.util.Scanner;
import java.util.InputMismatchException;

public class TesteHora {
    public static void main(String[] args) {
        Hora h = new Hora(); // construtor com entrada do usuário
        System.out.println("Hora 24h: " + h.getHora1());
        System.out.println("Hora 12h: " + h.getHora2());
        System.out.println("Segundos: " + h.getSegundos());
    }
}

class Hora {
    private int hora;
    private int min;
    private int seg;

    public Hora() {
        Scanner scan = new Scanner(System.in);
        this.hora = lerValido(scan, "hora", 0, 23);
        this.min = lerValido(scan, "minuto", 0, 59);
        this.seg = lerValido(scan, "segundo", 0, 59);
    }

    public Hora(int h, int m, int s) {
        setHor(h);
        setMin(m);
        setSeg(s);
    }

    public void setHor(int h) {
        if (h >= 0 && h <= 23) this.hora = h;
        else throw new IllegalArgumentException("Hora inválida");
    }

    public void setMin(int m) {
        if (m >= 0 && m <= 59) this.min = m;
        else throw new IllegalArgumentException("Minuto inválido");
    }

    public void setSeg(int s) {
        if (s >= 0 && s <= 59) this.seg = s;
        else throw new IllegalArgumentException("Segundo inválido");
    }

    public void setHor() {
        this.hora = lerValido(new Scanner(System.in), "hora", 0, 23);
    }

    public void setMin() {
        this.min = lerValido(new Scanner(System.in), "minuto", 0, 59);
    }

    public void setSeg() {
        this.seg = lerValido(new Scanner(System.in), "segundo", 0, 59);
    }

    public int getHor() {
        return hora;
    }

    public int getMin() {
        return min;
    }

    public int getSeg() {
        return seg;
    }

    public String getHora1() {
        return String.format("%02d:%02d:%02d", hora, min, seg);
    }

    public String getHora2() {
        String periodo = (hora < 12) ? "AM" : "PM";
        int h12 = (hora == 0 || hora == 12) ? 12 : hora % 12;
        return String.format("%02d:%02d:%02d %s", h12, min, seg, periodo);
    }

    public int getSegundos() {
        return hora * 3600 + min * 60 + seg;
    }

    private int lerValido(Scanner scan, String nomeCampo, int min, int max) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite " + nomeCampo + " (" + min + "-" + max + "): ");
                valor = scan.nextInt();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("Valor inválido. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scan.nextLine(); // limpar buffer
            }
        }
        return valor;
    }
}
