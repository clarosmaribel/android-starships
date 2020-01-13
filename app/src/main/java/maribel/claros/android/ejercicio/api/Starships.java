package maribel.claros.android.ejercicio.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Starships {
    @SerializedName("results")
    private List<Starship> starshipList;

    public List<Starship> getStarshipList() {
        return starshipList;
    }
}
