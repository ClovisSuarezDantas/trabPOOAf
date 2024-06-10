package domain;

import service.Notificacao;
import service.Pagamento;
import service.impl.NotificacaoConsole;
import service.impl.PagamentoBoleto;
import service.impl.PagamentoCartao;
import service.impl.PagamentoPIX;

import java.util.Scanner;

/**
 * Classe principal responsável pelo sistema de pagamento.
 */
public class SistemaPagamento {

    /**
     * Método principal que executa o sistema de pagamento.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Notificacao notificacao = new NotificacaoConsole();
        Pagamento pagamento = null;
        int opcao = -1;
        
        while (opcao != 9) {
            String menu = """
                    Sistema de Pagamento

                    Escolha a forma de pagamento:
                    1 - Boleto
                    2 - Cartão
                    3 - PIX
                    4 - Sair ...""";

            System.out.println(menu);

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    pagamento = new PagamentoBoleto();
                    break;
                case 2:
                    System.out.println("Digite o número de parcelas:");
                    int parcelas = scanner.nextInt();
                    pagamento = new PagamentoCartao(parcelas);
                    break;
                case 3:
                    pagamento = new PagamentoPIX();
                    break;
                case 4:
                    System.out.println("Closing the application!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }
        }

        System.out.println("Digite o valor do pagamento:");
        double valor = scanner.nextDouble();

        if (pagamento != null) {
            pagamento.pagar(valor, notificacao);
        }
    }
}
