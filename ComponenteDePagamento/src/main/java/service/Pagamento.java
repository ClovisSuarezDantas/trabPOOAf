package service;

/**
 * Interface para diferentes tipos de pagamento
 */
public interface Pagamento {

    /**
     * Processa o pagamento de um valor específico
     *
     * @param valor Valor a ser pago.
     * @return true se o pagamento foi processado com sucesso e false caso contrário
     */
    boolean processarPagamento(double valor);

    /**
     * Realiza o pagamento e notifica o usuário sobre o status do pagamento
     *
     * @param valor Valor a ser pago
     * @param notificacao Objeto de notificação para enviar mensagens ao usuário
     */
    void pagar(double valor, Notificacao notificacao);
}
