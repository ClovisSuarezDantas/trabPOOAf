package service.impl;

import service.Notificacao;
import service.Pagamento;

/**
 * Classe responsável pelo pagamento via cartão de crédito.
 */
public class PagamentoCartao implements Pagamento {
    private int parcelas;
    private static final double JUROS_MENSAL = 0.02; // 2% ao mês

    /**
     * Construtor para a classe PagamentoCartao.
     *
     * @param parcelas Número de parcelas para o pagamento.
     */
    public PagamentoCartao(int parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * Processa o pagamento via cartão de crédito para um valor específico.
     *
     * @param valor Valor a ser pago.
     */
    @Override
    public boolean processarPagamento(double valor) {

        return false;
    }

    /**
     * Realiza o pagamento via cartão de crédito, notificando o usuário sobre o status do pagamento.
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
        if (parcelas <= 0) {
            Logger.error("Número de parcelas inválido: " + parcelas);
            notificacao.enviarNotificacao("Falha ao processar pagamento: número de parcelas inválido.");
            return;
        }

        double valorTotal = valor;
        if (parcelas > 5) {
            valorTotal = calcularValorComJuros(valor, parcelas);
            Logger.log("Valor original: R$ " + valor + ", valor com juros: R$ " + valorTotal);
        }

        double valorParcela = valorTotal / parcelas;
        Logger.log("Processando pagamento de R$ " + valorTotal + " em " + parcelas + " parcelas de R$ " + valorParcela + " cada.");

        boolean pagamentoBemSucedido = simularProcessamentoPagamento();

        if (pagamentoBemSucedido) {
            Logger.log("Pagamento com cartão no valor de R$ " + valorTotal + " processado com sucesso.");
            notificacao.enviarNotificacao("Pagamento de R$ " + valorTotal + " processado com sucesso via cartão em " + parcelas + " parcelas.");
        } else {
            Logger.error("Falha ao processar o pagamento com cartão no valor de R$ " + valorTotal);
            notificacao.enviarNotificacao("Falha ao processar pagamento de R$ " + valorTotal + " via cartão.");
        }
    }

    /**
     * Calcula o valor total com juros com base no valor original e no número de parcelas.
     *
     * @param valor Valor original.
     * @param parcelas Número de parcelas.
     * @return Valor total com juros.
     */
    private double calcularValorComJuros(double valor, int parcelas) {
        double valorComJuros = valor * Math.pow(1 + JUROS_MENSAL, parcelas - 5);
        return valorComJuros;
    }

    /**
     * Simula o processamento do pagamento, gerando um resultado aleatório.
     *
     * @return true se o pagamento foi processado com sucesso e false caso contrário.
     */
    private boolean simularProcessamentoPagamento() {
        double randomValue = Math.random();
        return randomValue > 0.1;
    }
}

