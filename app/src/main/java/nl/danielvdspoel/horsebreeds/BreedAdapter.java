package nl.danielvdspoel.horsebreeds;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.ViewHolder> {

    Context context;
    ArrayList<BreedModel> breedModels;

    public BreedAdapter(Context context, ArrayList<BreedModel> breedModels) {
        this.context = context;
        this.breedModels = breedModels;
    }


    @NonNull
    @Override
    public BreedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where we inflate the view (giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new BreedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreedAdapter.ViewHolder holder, int position) {
        //This is where we set the data to the view
        holder.breedName.setText(breedModels.get(position).getName());
        holder.breedColor.setText(breedModels.get(position).getColor());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BreedDetailActivity.class);
            intent.putExtra("id", breedModels.get(position).getId());
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        //How many items do we have?
        return breedModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView breedName;
        TextView breedColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //OnCreate for the ViewHolder
            breedName = itemView.findViewById(R.id.breedName);
            breedColor = itemView.findViewById(R.id.breedColor);
        }
    }
}
