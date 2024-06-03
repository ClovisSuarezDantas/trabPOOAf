package service.impl;

import service.Notificacao;
import service.Pagamento;

/**
 * Classe responsável pelo pagamento via boleto.
 */
public class PagamentoBoleto implements Pagamento {
    private static final double TAXA_BOLETO = 0.10;
    private static final double VALOR_MINIMO = 50.0;

    /**
     * Processa o pagamento via boleto para um valor específico.
     *
     * @param valor Valor a ser pago.
     */
    @Override
    public boolean processarPagamento(double valor) {

        return false;
    }

    /**
     * Realiza o pagamento via boleto, notificando o usuário sobre o status do pagamento.
     *
     * @param valor Valor a ser pago.
     * @param notificacao Objeto de notificação para enviar mensagens ao usuário.
     */
    @Override
    public void pagar(double valor, Notificacao notificacao) {
        if (valor <= 0) {
            Logger.error("Valor de pagamento inválido: " + valor);
            notificacao.enviarNotificacao("Falha ao processar pagamento: valor inválido.");
            return;
        }
        if (valor < VALOR_MINIMO) {
            Logger.error("O valor mínimo para pagamento com boleto é: " + VALOR_MINIMO);
            notificacao.enviarNotificacao("Falha ao processar pagamento: valor abaixo do mínimo permitido.");
            return;
        }

        double valorComTaxa = valor + calcularTaxa(valor);
        Logger.log("Valor total com taxa de boleto: " + valorComTaxa);

        boolean pagamentoBemSucedido = simularProcessamentoPagamento();

        if (pagamentoBemSucedido) {
            Logger.log("Pagamento com boleto no valor de " + valor + " processado com sucesso.");
            notificacao.enviarNotificacao("Pagamento de R$ " + valor + " processado com sucesso via boleto.");
        } else {
            Logger.error("Falha ao processar o pagamento com boleto no valor de " + valor);
            notificacao.enviarNotificacao("Falha ao processar pagamento de R$ " + valor + " via boleto.");
        }
    }

    /**
     * Calcula a taxa de pagamento com base no valor do boleto.
     *
     * @param valor Valor base para cálculo da taxa.
     * @return Taxa calculada.
     */
    private double calcularTaxa(double valor) {

        return valor * TAXA_BOLETO;
    }

    /**
     * Simula o processamento do pagamento, gerando um resultado aleatório.
     *
     * @return true se o pagamento foi processado com sucessoe e false caso contrário.
     */
    private boolean simularProcessamentoPagamento() {
        double randomValue = Math.random();
        return randomValue > 0.1;
    }
}
