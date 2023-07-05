/*
1.  significantly simplifies working with HTTP.
2.  HttpClient also supports HTTP/2 and WebSocket
3.  HttpClient provides an asynchronous model. The HttpClient.sendAsync() method returns a CompletableFuture, which we can then use to continue working asynchronously
 */
package httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Consumer;

public class NewHttpClientExample {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://dummy.restapiexample.com/api/v1/employees";

        try {
            System.out.println("Calling Sync GET...");
            String response = getSync(url);
            System.out.println("Response : " + response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Calling Async GET...");
        Consumer<String> consumer = (response) -> System.out.println("Response : " + response);
        getAsync(url, consumer);
    }

    static String getSync(String url) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_2).uri(URI.create(url)).GET()
                .timeout(Duration.ofSeconds(20))
                .header("Content-Type", "application/json").build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if (httpResponse.statusCode() != 200) {
            throw new IOException("HTTP response status: " + httpResponse.statusCode());
        }
        return httpResponse.body();
    }

    static void getAsync(String url, Consumer<String> consumer) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_2).uri(URI.create(url)).GET()
                .timeout(Duration.ofSeconds(20))
                .header("Content-Type", "application/json").build();
        httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).
                thenAccept(stringHttpResponse -> {
            if (stringHttpResponse.statusCode() == 200) {
                consumer.accept(stringHttpResponse.body());
            } else {
                System.out.println("Error : " + stringHttpResponse.statusCode());
            }
        });
    }
}
