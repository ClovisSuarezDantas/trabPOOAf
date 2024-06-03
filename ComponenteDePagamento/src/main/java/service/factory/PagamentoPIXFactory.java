package service.factory;

import service.Pagamento;
import service.impl.PagamentoPIX;

public class PagamentoPIXFactory implements PagamentoFactory {

    @Override
    public Pagamento novoPagamento() {
        return new PagamentoPIX();
    }
    
}