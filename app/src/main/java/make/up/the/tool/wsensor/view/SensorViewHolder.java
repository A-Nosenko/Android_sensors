package make.up.the.tool.wsensor.view;

import android.support.v7.widget.RecyclerView;

import make.up.the.tool.wsensor.databinding.SensorDataBinding;
import make.up.the.tool.wsensor.view_model.SensorViewModel;

/**
 * @author Anatolii Nosenko
 * @version 25 February 2018
 */

class SensorViewHolder extends RecyclerView.ViewHolder {
    private SensorDataBinding dataBinding;

    SensorViewHolder(SensorDataBinding dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
    }

    void bind(SensorViewModel viewModel) {
        this.dataBinding.setViewModel(viewModel);
    }
}
