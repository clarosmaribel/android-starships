package maribel.claros.android.ejercicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.List;

import maribel.claros.android.ejercicio.api.PostService;
import maribel.claros.android.ejercicio.api.RetrofitClient;
import maribel.claros.android.ejercicio.api.Starship;
import maribel.claros.android.ejercicio.api.Starships;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements RecyclerAdapterStarships.OnStarshipListener {

    private ProgressDialog progressDialog;
    private RecyclerView recyclerViewStarships;
    private List<Starship> starships;
    private Toolbar toolbarListadoStarships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarListadoStarships = findViewById(R.id.toolbarListadoStarships);
        toolbarListadoStarships.setTitle("Listado");
        setSupportActionBar(toolbarListadoStarships);

        recyclerViewStarships = findViewById(R.id.recyclerViewListadoStarship);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewStarships.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerViewStarships.addItemDecoration(dividerItemDecoration);


        //Intenta llenar la lista pero todavía está vacía. Si lo saco, lanza un warning
        RecyclerAdapterStarships recyclerAdapterStarships = new RecyclerAdapterStarships(this, starships, this);
        recyclerViewStarships.setAdapter(recyclerAdapterStarships);

        Toast.makeText(MainActivity.this, "Cargando...", Toast.LENGTH_SHORT).show();

        getStarship();

    }

    private void getStarship() {

        Retrofit retrofit = RetrofitClient.recuperarRetrofit();
        PostService postService = retrofit.create(PostService.class);
        Call<Starships> call = postService.getStarships();
        call.enqueue(new Callback<Starships>() {
            @Override
            public void onResponse(Call<Starships> call, Response<Starships> response) {
                starships = response.body().getStarshipList();
                //Al llamarlo acá, con todos los datos, llena la lista.
                setearAdapter();
                if (!response.isSuccessful()) {
                    System.out.println(response.code());

                }
            }

            @Override
            public void onFailure(Call<Starships> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    private void setearAdapter () {
        RecyclerAdapterStarships recyclerAdapterStarships = new RecyclerAdapterStarships(this, starships, this);
        recyclerViewStarships.setAdapter(recyclerAdapterStarships);
    }

    @Override
    public void OnStarshipClick(int position) {
        irADetalleDeStarship(position);
    }

    private void irADetalleDeStarship(int position) {
        Intent intentDetalleStarship = new Intent(this, StarshipActivity.class);
        Starship starshipDetalle = starships.get(position);
        intentDetalleStarship.putExtra("detalleStarship", starshipDetalle);
        startActivity(intentDetalleStarship);
    }
}
