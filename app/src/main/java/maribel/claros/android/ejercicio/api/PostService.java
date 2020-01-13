package maribel.claros.android.ejercicio.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("starships/")
    public Call<Starships> getStarships();

}
