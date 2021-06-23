import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Config {
    String apiKey;
    String toLang;
    String fromLang;
    String textToTranslate;
    static String translatedText;

    public Config() throws IOException, InterruptedException {
        apiKey = "e06e91fbf6mshd96a8897e9beb9ap1b4c96jsn7fe138f2e79b";
        toLang = "";
        fromLang = "";
        textToTranslate = "";
    }

    public void test() throws IOException, InterruptedException {
        translatedText = "";
        textToTranslate = URLEncoder.encode(textToTranslate, "UTF-8");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nlp-translation.p.rapidapi.com/v1/translate?text=" + textToTranslate + "&to=" + toLang + "&from=" + fromLang))
                .header("x-rapidapi-key", apiKey)
                .header("x-rapidapi-host", "nlp-translation.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        translatedText = response.body();
        Gson g = new Gson();
        WrapperResponseTranslation wrapperResponseTranslation = g.fromJson(translatedText, WrapperResponseTranslation.class);
        translatedText = wrapperResponseTranslation.translated_text.pl;
    }

    class WrapperResponseTranslation {
        WrapperResponseTranslatedText translated_text;
    }

    class WrapperResponseTranslatedText {
        String pl;
    }


}
