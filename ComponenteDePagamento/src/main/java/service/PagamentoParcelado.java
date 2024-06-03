package service;

import service.impl.Logger;

/**
 * Classe responsável pelo pagamento parcelado
 */
public class PagamentoParcelado implements Pagamento {
    private int parcelas;

    /**
     * Construtor para a classe PagamentoParcelado
     *
     * @param parcelas Número de parcelas para o pagamento
     */
    public PagamentoParcelado(int parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * Processa o pagamento parcelado para um valor específico
     *
     * @param valor Valor a ser pago
     * @return true se o pagamento foi processado com sucesso e false caso contrário
     */
    @Override
    public boolean processarPagamento(double valor) {
        if (valor <= 0) {
            Logger.error("Valor de pagamento inválido: " + valor);
            return false;
        }
        if (parcelas <= 0) {
            Logger.error("Número de parcelas inválido: " + parcelas);
            return false;
        }

        double valorParcela = valor / parcelas;
        Logger.log("Processando pagamento parcelado em " + parcelas + "x de R$ " + valorParcela);

        // Lógica para processar o pagamento parcelado
        boolean pagamentoBemSucedido = simularProcessamentoPagamento();

        if (pagamentoBemSucedido) {
            Logger.log("Pagamento parcelado no valor de " + valor + " em " + parcelas + "x processado com sucesso.");
            System.out.println("Processando pagamento parcelado no valor de: " + valor);
            return true;
        } else {
            Logger.error("Falha ao processar o pagamento parcelado no valor de " + valor);
            return false;
        }
    }

    /**
     * Realiza o pagamento parcelado, notificando o usuário sobre o status do pagamento
     *
     * @param valor Valor a ser pago.
     * @param notificacao Objeto de notificação para enviar mensagens ao usuário
     */
    @Override
    public void pagar(double valor, Notificacao notificacao) {
        // Implementação necessária
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
