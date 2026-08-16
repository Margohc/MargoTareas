import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final int PUERTO = 8080;
    private static final Path PUBLIC_DIR = Path.of("public");
    private static final Map<String, String> TIPOS = new HashMap<>();

    static {
        TIPOS.put(".html", "text/html; charset=UTF-8");
        TIPOS.put(".css", "text/css; charset=UTF-8");
        TIPOS.put(".js", "application/javascript; charset=UTF-8");
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PUERTO), 0);
        server.createContext("/", Main::servirArchivo);
        server.setExecutor(null);
        server.start();

        System.out.println("Mundialito de canchitas iniciado");
        System.out.println("Abre esta direccion en tu navegador: http://localhost:" + PUERTO);
    }

    private static void servirArchivo(HttpExchange exchange) throws IOException {
        String ruta = exchange.getRequestURI().getPath();
        if (ruta.equals("/")) {
            ruta = "/index.html";
        }

        Path archivo = PUBLIC_DIR.resolve(ruta.substring(1)).normalize();
        if (!archivo.startsWith(PUBLIC_DIR) || !Files.exists(archivo) || Files.isDirectory(archivo)) {
            enviarRespuesta(exchange, 404, "text/plain; charset=UTF-8", "Archivo no encontrado");
            return;
        }

        String tipo = obtenerTipoContenido(archivo);
        byte[] contenido = Files.readAllBytes(archivo);
        enviarRespuesta(exchange, 200, tipo, contenido);
    }

    private static String obtenerTipoContenido(Path archivo) {
        String nombre = archivo.getFileName().toString();
        for (Map.Entry<String, String> tipo : TIPOS.entrySet()) {
            if (nombre.endsWith(tipo.getKey())) {
                return tipo.getValue();
            }
        }
        return "application/octet-stream";
    }

    private static void enviarRespuesta(HttpExchange exchange, int codigo, String tipo, String mensaje)
            throws IOException {
        enviarRespuesta(exchange, codigo, tipo, mensaje.getBytes());
    }

    private static void enviarRespuesta(HttpExchange exchange, int codigo, String tipo, byte[] contenido)
            throws IOException {
        exchange.getResponseHeaders().set("Content-Type", tipo);
        exchange.sendResponseHeaders(codigo, contenido.length);
        try (OutputStream salida = exchange.getResponseBody()) {
            salida.write(contenido);
        }
    }
}
