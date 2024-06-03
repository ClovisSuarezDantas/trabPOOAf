package service.impl;

import service.Notificacao;
import service.Pagamento;

/**
 * Classe responsável pelo pagamento via PIX
 */
public class PagamentoPIX implements Pagamento {

    /**
     * Processa o pagamento via PIX para um valor específico
     *
     * @param valor Valor a ser pago.
     */
    @Override
    public boolean processarPagamento(double valor) {
        return false;
    }

    /**
     * Realiza o pagamento via PIX, notificando o usuário sobre o status do pagamento
     *
     * @param valor Valor a ser pago
     * @param notificacao Objeto de notificação para enviar mensagens ao usuário
     */
    @Override
    public void pagar(double valor, Notificacao notificacao) {
        if (valor <= 0) {
            Logger.error("Valor de pagamento inválido: " + valor);
            notificacao.enviarNotificacao("Falha ao processar pagamento: valor inválido.");
            return;
        }

        // Simulação de processamento de pagamento via PIX
        boolean pagamentoBemSucedido = simularProcessamentoPagamento();

        if (pagamentoBemSucedido) {
            Logger.log("Pagamento via PIX no valor de " + valor + " processado com sucesso.");
            notificacao.enviarNotificacao("Pagamento de R$ " + valor + " processado com sucesso via PIX.");
        } else {
            Logger.error("Falha ao processar o pagamento via PIX no valor de " + valor);
            notificacao.enviarNotificacao("Falha ao processar pagamento de R$ " + valor + " via PIX.");
        }
    }

    /**
     * Simula o processamento do pagamento, gerando um resultado aleatório
     *
     * @return true se o pagamento foi processado com sucesso e false caso contrário
     */
    private boolean simularProcessamentoPagamento() {
        double randomValue = Math.random();
        return randomValue > 0.1; // 90% de chance de sucesso
    }
}
