package domain;

import java.util.Scanner;

import service.Notificacao;
import service.PagamentoService;
import service.factory.PagamentoBoletoFactory;
import service.factory.PagamentoCartaoFactory;
import service.factory.PagamentoPIXFactory;
import service.impl.NotificacaoConsole;

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
        PagamentoService pagamentoService = null;

        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Boleto");
        System.out.println("2. Cartão");
        System.out.println("3. PIX");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                pagamentoService = new PagamentoService(new PagamentoBoletoFactory());
                break;
            case 2:
                System.out.println("Digite o número de parcelas:");
                int parcelas = scanner.nextInt();
                pagamentoService = new PagamentoService(new PagamentoCartaoFactory(parcelas));
                break;
            case 3:
                pagamentoService = new PagamentoService(new PagamentoPIXFactory());
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        System.out.println("Digite o valor do pagamento:");
        double valor = scanner.nextDouble();

        if (pagamentoService != null) {
            pagamentoService.novoPagamento(valor, notificacao);
        }

        scanner.close();
    }
}
