package maribel.claros.android.ejercicio;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import maribel.claros.android.ejercicio.api.Starship;

public class StarshipActivity extends AppCompatActivity {

    private Toolbar toolbarDetallStarship;
    private TextView textViewNameDetalle;
    private TextView textViewModelDetalle;
    private TextView textViewClassDetalle;
    private TextView textViewManufacturerDetalle;
    private TextView textViewLengthDetalle;
    private TextView textViewCrewDetalle;
    private TextView textViewPassengerDetalle;
    private TextView textViewCargoCapacityDetalle;
    private TextView textViewConsumablesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        Starship starship = getIntent().getExtras().getParcelable("detalleStarship");

        toolbarDetallStarship = findViewById(R.id.toolbarDetalleStarship);
        toolbarDetallStarship.setTitle("Detalle Starship");
        setSupportActionBar(toolbarDetallStarship);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        textViewNameDetalle = findViewById(R.id.textViewNameDetalle);
        textViewNameDetalle.setText(starship.getName());

        textViewModelDetalle = findViewById(R.id.textViewModelDetalle);
        textViewModelDetalle.setText(starship.getModel());

        textViewClassDetalle = findViewById(R.id.textViewClassDetalle);
        textViewClassDetalle.setText(starship.getStarshipClass());

        textViewManufacturerDetalle = findViewById(R.id.textViewManufacturerDetalle);
        textViewManufacturerDetalle.setText(starship.getManufacturer());

        textViewLengthDetalle = findViewById(R.id.textViewLengthDetalle);
        textViewLengthDetalle.setText(starship.getLength());

        textViewCrewDetalle = findViewById(R.id.textViewCrewSizeDetalle);
        textViewCrewDetalle.setText(starship.getCrew());

        textViewPassengerDetalle = findViewById(R.id.textViewPassengerDetalle);
        textViewPassengerDetalle.setText(starship.getPassengers());

        textViewCargoCapacityDetalle = findViewById(R.id.textViewCargoCapacityDetalle);
        textViewCargoCapacityDetalle.setText(starship.getCapacity());

        textViewConsumablesDetalle = findViewById(R.id.textViewConsumablesDetalle);
        textViewConsumablesDetalle.setText(starship.getConsumables());

    }

}
