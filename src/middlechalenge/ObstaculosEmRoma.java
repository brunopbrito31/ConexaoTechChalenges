package middlechalenge;

import java.util.Arrays;
import java.util.Scanner;

//Descrição do desafio no final do código

public class ObstaculosEmRoma {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int qtPlacasTrajeto = reader.nextInt();
        reader.nextLine();
        String[] numerosPlacas = new String[qtPlacasTrajeto];

        while (qtPlacasTrajeto > 0) {
            int numero = reader.nextInt();
            reader.nextLine();
            numerosPlacas[numerosPlacas.length - qtPlacasTrajeto] = converterDecimalEmRomano(numero);
            qtPlacasTrajeto--;
        }
        Arrays.asList(numerosPlacas).stream().forEach(System.out::println);
    }

    public static String converterDecimalEmRomano(int num) {
        String numeroConvertido = "";
        int milhar = 0, centena = 0, dezena = 0, auxiliar = num;

        if (auxiliar >= 1000) {
            milhar = auxiliar / 1000;
            auxiliar = auxiliar % 1000;
            String numeroAPassar = tabelaRomanos(milhar).replace('I', 'M');
            numeroConvertido = numeroConvertido.concat(numeroAPassar);
        }
        if (auxiliar >= 100) {
            centena = auxiliar / 100;
            auxiliar = auxiliar % 100;
            String numeroAPassar = tabelaRomanos(centena).replace('I', 'C')
                    .replace('V', 'D')
                    .replace('X', 'M');
            numeroConvertido = numeroConvertido.concat(numeroAPassar);
        }
        if (auxiliar >= 10) {
            dezena = auxiliar / 10;
            auxiliar = auxiliar % 10;
            String numeroAPassar = tabelaRomanos(dezena).replace('I', 'X')
                    .replace('V', 'L')
                    .replace('x', 'C');
            numeroConvertido = numeroConvertido.concat(numeroAPassar);
        }
        numeroConvertido = numeroConvertido.concat(tabelaRomanos(auxiliar));
        return numeroConvertido.trim();

    }

    public static String tabelaRomanos(int num) {
        String algRomano = "";
        if (num >= 1 && num < 4) {
            for (int i = 0; i < num; i++) {
                algRomano = algRomano.concat("I");
            }
            return algRomano;
        } else if (num == 4) {
            return "IV";
        } else if (num == 5) {
            return "V";
        } else if (num > 5 && num < 9) {
            algRomano = "V".concat(tabelaRomanos(num - 5));
            return algRomano;
        } else if (num == 9) {
            return "IX";
        } else if (num == 10) {
            return "X";
        }
        return "";
    }

}

/*
Entrada
A entrada consiste de um número natural(N*) que representa a quantidade de placas no trajeto e em seguida os números naturais(N*) de cada placa.

Saída
Dado um número na placa, a saída será a conversão do número natural(N*) para o número romano.
* */