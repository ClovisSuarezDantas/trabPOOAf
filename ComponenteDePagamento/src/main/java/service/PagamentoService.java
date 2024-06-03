package service;

import service.factory.PagamentoFactory;

public class PagamentoService {

    private PagamentoFactory pagamentoFactory;

    public PagamentoService(PagamentoFactory pagamentoFactory) {
        this.pagamentoFactory = pagamentoFactory;
    }

    public void novoPagamento(double valor, Notificacao notificacao) {
        Pagamento pagamento = pagamentoFactory.novoPagamento();
        pagamento.pagar(valor, notificacao);
    }
    
}
