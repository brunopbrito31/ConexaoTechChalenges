package easychalenge;

import java.util.Arrays;
import java.util.Scanner;

// Descrição do desafio no final do código

public class TramposDeEletricista {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int qtJogadas = reader.nextInt();
        String[] palavrasAImprimir = new String[qtJogadas];
        reader.nextLine();

        while(qtJogadas > 0){
            String palavra = reader.nextLine().trim();
            palavrasAImprimir[palavrasAImprimir.length-qtJogadas] = verificaCondicaoVitoria(palavra);
            qtJogadas--;
        }
        Arrays.stream(palavrasAImprimir).forEach(System.out::println);
    }

    public static String verificaCondicaoVitoria(String jogada){
        if(jogada.equals("Alicate")) return "Martelo";
        else if(jogada.equals("Plastico")) return "Alicate";
        else if(jogada.equals("Martelo")) return "Plastico";
        return "Jogada Inválida";
    }
}


/*Morpheus deixou uma explicação do combate Trampos de Eletricista para você:

Plástico embrulha Martelo
Martelo destrói Alicate
Alicate corta Plástico
Resumindo:

Se o Agente Smith jogar...	Vença o com
Plastico	Alicate
Martelo	Plastico
Alicate	Martelo
.

Lembre-se: você possui 5 tentativas para enviar!
ATENÇÃO:
A entrada representa a inserção de dados no terminal pelo o usuário e a saída desejada são apenas Impressões na Tela (prints), que devem variar de acordo com a entrada do usuário. Caso tenha dúvidas, não se esqueça de ver o vídeo da resolução do Desafio Exemplo!!! Observações:

Não é necessário escrita/leitura em arquivos.
É preciso submeter todo o código da solução, implementando a leitura dos dados do usuários e a impressão da saída desejada. Você poderá criar funções, contudo apenas a resposta impressa na tela será considerada.
Não insira textos extras e não escreva saídas diferentes dos exemplos. Não utilize acentuação.
Os exemplos no enunciado podem te ajudar, mas não se limite a eles! Os exemplos demonstra o funcionamento do algoritmo, contudo seu código deve atender a diversos casos de teste!
Entrada
A entrada consiste de uma linha contendo um número natural(N*) para o número de combates passado por Trinity. A(s) outra(s) linha(s) será o valor da jogada do Agente Smith.

Saída
A saída consiste de uma linha ou mais linhas contendo o valor da jogada de Neo, fazendo com que o mesmo derrote o Agente Smith.
* */
