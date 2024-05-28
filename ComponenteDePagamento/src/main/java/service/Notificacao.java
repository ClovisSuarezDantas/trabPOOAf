package service;

/**
 * Interface para notificação.
 */
public interface Notificacao {

    /**
     * Envia uma notificação com uma mensagem específica.
     *
     * @param mensagem Mensagem da notificação.
     */
    void enviarNotificacao(String mensagem);
}
