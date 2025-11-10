package co.com.AutoLocal.utils.hooks;

public class EsperaImplicita {
    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
