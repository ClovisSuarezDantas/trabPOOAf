package service.impl;

/**
 * Classe responsável pelo registro de logs.
 */
public class Logger {

    /** Registra uma mensagem de log.
     *
     *
     * @param mensagem Mensagem a ser registrada.
     */
    public static void log(String mensagem) {
        System.out.println("[LOG] " + mensagem);
    }

    /**
     * Registra uma mensagem de erro.
     *
     * @param mensagem Mensagem de erro a ser registrada.
     */
    public static void error(String mensagem) {
        System.err.println("[ERROR] " + mensagem);
    }
}

