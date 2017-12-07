package security.bercy.com.week2day3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import security.bercy.com.week2day3.Model.Animal;

/**
 * Created by Bercy on 12/7/17.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private List<Animal> animalsList;

    public AnimalAdapter(List<Animal> animalsList) {
        this.animalsList = animalsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_list,parent,false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Animal animal = animalsList.get(position);
        holder.tv_name.setText(animal.getName());
        holder.tv_type.setText(animal.getType());
        holder.tv_weight.setText(animal.getWeight());
        holder.tv_description.setText(animal.getDescription());
    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_type;
        TextView tv_weight;
        TextView tv_description;
        public ViewHolder(View itemView) {
            super(itemView);


            tv_name = itemView.findViewById(R.id.name);

            tv_type = itemView.findViewById(R.id.type);

            tv_weight = itemView.findViewById(R.id.type);

            tv_description = itemView.findViewById(R.id.description);

        }
    }
}
