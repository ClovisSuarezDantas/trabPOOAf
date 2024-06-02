package service.factory;

import service.Pagamento;
import service.impl.PagamentoCartao;

public class PagamentoCartaoFactory implements PagamentoFactory {

    private int parcelas;

    public PagamentoCartaoFactory(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public Pagamento novoPagamento() {
        return new PagamentoCartao(parcelas);
    }

}