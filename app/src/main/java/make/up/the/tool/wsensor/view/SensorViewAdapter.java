package make.up.the.tool.wsensor.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import make.up.the.tool.wsensor.databinding.SensorDataBinding;
import make.up.the.tool.wsensor.view_model.SensorViewModel;

/**
 * @author Anatolii Nosenko
 * @version 25 February 2018
 */

public class SensorViewAdapter extends RecyclerView.Adapter<SensorViewHolder> {
    private List<SensorViewModel> models;
    private LayoutInflater inflater;

    public SensorViewAdapter(List<SensorViewModel> models) {
        this.models = models;
    }

    @Override
    public SensorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        SensorDataBinding dataBinding = SensorDataBinding.inflate(inflater, parent, false);
        return new SensorViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(SensorViewHolder holder, int position) {
        final SensorViewModel model = models.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
