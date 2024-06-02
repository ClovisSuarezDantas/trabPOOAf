package service.factory;

import service.Pagamento;
import service.impl.PagamentoBoleto;

public class PagamentoBoletoFactory implements PagamentoFactory {

    @Override
    public Pagamento novoPagamento() {
        return new PagamentoBoleto();
    }
    
}