package service;

/**
 * Interface para diferentes tipos de pagamento com taxa.
 */
public interface PagamentoTaxa {

    /**
     * Processa o pagamento de um valor específico.
     *
     * @param valor Valor a ser pago.
     * @return true se o pagamento foi processado com sucesso, false caso contrário.
     */
    boolean processarPagamento(double valor);

    /**
     * Calcula a taxa de pagamento com base em um valor.
     *
     * @param valor Valor base para cálculo da taxa.
     * @return Taxa calculada.
     */
    double calcularTaxa(double valor);
}
