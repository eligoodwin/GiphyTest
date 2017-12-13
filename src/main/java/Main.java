import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        String urlPart1 = "https://api.giphy.com/v1/gifs/search?api_key=aSwtNdW8hKSoqrcFwUNyfhu7Kh1IyQTN&q=";
        String urlPart2 = "&limit=10&offset=0&rating=R&lang=en";
        String searchQuery = "\"get tampons\"";

        String finalurl = urlPart1 + searchQuery + urlPart2;

        GetExample gifs = new GetExample();
        String response = "Nope";
        try {
            response = gifs.run(finalurl);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(response);
    }
}

class GetExample {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}