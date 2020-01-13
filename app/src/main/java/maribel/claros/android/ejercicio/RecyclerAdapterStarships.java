package maribel.claros.android.ejercicio;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import maribel.claros.android.ejercicio.api.Starship;

public class RecyclerAdapterStarships extends RecyclerView.Adapter<RecyclerAdapterStarships.StarshipViewHolder> {

    private Context context;
    private List<Starship> starships;
    private OnStarshipListener onStarshipListener;


    public RecyclerAdapterStarships(Context context, List<Starship> starships, OnStarshipListener onStarshipListener) {
        this.context = context;
        this.starships = starships;
        this.onStarshipListener = onStarshipListener;
    }

    @Override
    public RecyclerAdapterStarships.StarshipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_adapter_starships, parent,false);
        return new StarshipViewHolder(view, onStarshipListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipViewHolder holder, int position) {

        holder.textViewName.setText(starships.get(position).getName());
        holder.textViewModel.setText(starships.get(position).getModel());

    }

    @Override
    public int getItemCount() {
        if(starships != null) {
            return starships.size();
        }
        return 0;
    }

    public class StarshipViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewName;
        public TextView textViewModel;
        OnStarshipListener onStarshipListener;

        public StarshipViewHolder(@NonNull View itemView, OnStarshipListener onStarshipListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewModel = itemView.findViewById(R.id.textViewModel);
            this.onStarshipListener = onStarshipListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onStarshipListener.OnStarshipClick(getAdapterPosition());

        }
    }

    public interface OnStarshipListener {
        void OnStarshipClick(int position);
    }
}
