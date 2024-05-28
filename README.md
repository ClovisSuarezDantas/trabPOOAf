# Sistema de Pagamento

Este é um sistema de pagamento simples implementado em Java, utilizando Maven. Ele suporta diferentes métodos de pagamento, incluindo Boleto, Cartão de Crédito e PIX. O projeto também inclui um sistema de notificação via console.

## Estrutura do Projeto

- **domain**
  - `SistemaPagamento.java`: Classe principal que executa o sistema de pagamento.
- **service**
  - `Notificacao.java`: Interface para notificação.
  - `Pagamento.java`: Interface para diferentes tipos de pagamento.
  - `PagamentoParcelado.java`: Implementação da interface de pagamento para pagamentos parcelados.
  - `PagamentoTaxa.java`: Interface para pagamentos com taxa.
- **service.impl**
  - `Logger.java`: Classe responsável pelo registro de logs.
  - `NotificacaoConsole.java`: Implementação da interface de notificação que envia mensagens para o console.
  - `PagamentoBoleto.java`: Implementação da interface de pagamento para boletos.
  - `PagamentoCartao.java`: Implementação da interface de pagamento para cartões de crédito.
  - `PagamentoPIX.java`: Implementação da interface de pagamento para PIX.

## Funcionalidades

- **Pagamento via Boleto**: Processa pagamentos com boleto e aplica uma taxa.
- **Pagamento via Cartão de Crédito**: Suporta pagamentos parcelados com aplicação de juros para mais de 5 parcelas.
- **Pagamento via PIX**: Processamento simples de pagamentos via PIX.
- **Notificação via Console**: Envia notificações de sucesso ou falha no pagamento para o console.
- **Registro de Logs**: Registra logs de eventos e erros.
