import android.app.Activity;
import android.location.Location;
import android.util.Log;
/*
public class DineroApi {

    public interface DineroCallback {
        void onDineroInfoReady(boolean dataIsAvaible, DineroInfo info);
    }


    public  static void getDineroInfo(Activity contet, Location location, DineroCallback callback) {
        String url = "https://api.bluelytics.com.ar/v2/latest";
        OkHttpClient client;
        client = new OkHttpClient();
        Request request = new Request.Builder()
                    .url(url)
                    .build();
        Response response = null;
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                //TODO: Mostrar mensaje de error
                e.printStackTrace();
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                processWeatherResponse(response, context, callback);
            }
        });


    }
}
*/