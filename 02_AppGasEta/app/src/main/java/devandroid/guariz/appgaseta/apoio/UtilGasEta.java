package devandroid.guariz.appgaseta.apoio;

public class UtilGasEta {

    public void metodoNaoEstatico() {

    }

    public static void metodoEstatico(){

    }

    public static String mensagem() {

        return "Qualquer mensagem...";
    }

    public static String calculaMelhorOpcao(double gasolina, double etanol) {
        // Preco da Gasolina: R$ 5,12
        // Preco do Etanol: R$ 3,99

        // Preco Ideal: = gasolina * 0.70 = R$ 3,548

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal) {
            mensagemDeRetorno = "Abastecer com Etanol";
        } else {
            mensagemDeRetorno = "Abastecer com Gasolina";
        }

        // se o preço do etanol for igual ou menor que o predo ideal,
        // melhor abastecer com etanol, caso contrário, a gasolina é
        // mais vantagem

        return mensagemDeRetorno;

    }
}
