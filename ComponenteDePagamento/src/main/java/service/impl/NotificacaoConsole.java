package service.impl;

import service.Notificacao;

/**
 * Classe de notificação por console.
 */
public class NotificacaoConsole implements Notificacao {

    /**
     * Envia uma notificação com uma mensagem específica para o console.
     *
     * @param mensagem Mensagem da notificação.
     */
    public void enviarNotificacao(String mensagem) {
        System.out.println(mensagem);
    }
}
