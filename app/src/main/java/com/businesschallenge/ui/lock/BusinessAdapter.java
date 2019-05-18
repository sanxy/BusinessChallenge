package com.businesschallenge.ui.lock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.businesschallenge.Constants;
import com.businesschallenge.DataProccessor;
import com.businesschallenge.R;
import com.businesschallenge.databinding.ItemBusinessBinding;
import com.businesschallenge.model.Business;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BusinessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<Business> mBusinessList;

    private BusinessListViewModel mViewModel;

    public BusinessAdapter(Context context, List<Business> businesses, BusinessListViewModel viewModel) {
        mContext = context;
        mViewModel = viewModel;
        replaceData(businesses);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemBusinessBinding binding =
                ItemBusinessBinding.inflate(layoutInflater, parent, false);
        return new BusinessViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Business business = mBusinessList.get(position);
        BusinessViewHolder businessViewHolder = (BusinessViewHolder) holder;

        // business image
        Picasso.get()
                .load(R.drawable.start)
                .placeholder(R.drawable.start)
                .error(R.drawable.start)
                .into(businessViewHolder.binding.imageBusiness);

        // business name
        businessViewHolder.binding.textDay.setText(business.getMainName());

        DataProccessor dataProccessor = new DataProccessor(mContext);

        if (position == 0){
            Picasso.get()
                    .load(R.drawable.day1)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_ONE)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            }else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }

       }
        if (position == 1){
            Picasso.get()
                    .load(R.drawable.day2)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_TWO) ){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 2){
            if (dataProccessor.getBool(Constants.DAY_THREE)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 3){
            if (dataProccessor.getBool(Constants.DAY_FOUR)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 4){
            Picasso.get()
                    .load(R.drawable.day5)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_FIVE)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 5){
            if (dataProccessor.getBool(Constants.DAY_SIX)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 6){
            Picasso.get()
                    .load(R.drawable.day7)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_SEVEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 7){
            if (dataProccessor.getBool(Constants.DAY_EIGHT)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 8){
            Picasso.get()
                    .load(R.drawable.day9)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_NINE)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 9){
            if (dataProccessor.getBool(Constants.DAY_TEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 10){
            Picasso.get()
                    .load(R.drawable.day11)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_ELEVEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 11){
            if (dataProccessor.getBool(Constants.DAY_TWELVE)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 12){
            if (dataProccessor.getBool(Constants.DAY_THIRTEEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 13){
            if (dataProccessor.getBool(Constants.DAY_FOURTEEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 14){
            if (dataProccessor.getBool(Constants.DAY_FIFTEEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 15){
            if (dataProccessor.getBool(Constants.DAY_SIXTEEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 16){
            Picasso.get()
                    .load(R.drawable.day17)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_SEVENTEEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 17){
            if (dataProccessor.getBool(Constants.DAY_EIGHTEEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 18){
            if (dataProccessor.getBool(Constants.DAY_NINETEEN)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 19){
            if (dataProccessor.getBool(Constants.DAY_TWENTY)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 20){
            Picasso.get()
                    .load(R.drawable.day21)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_21)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 21){
            if (dataProccessor.getBool(Constants.DAY_22)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 22){
            if (dataProccessor.getBool(Constants.DAY_23)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 23){
            if (dataProccessor.getBool(Constants.DAY_24)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 24){
            Picasso.get()
                    .load(R.drawable.day25)
                    .placeholder(R.drawable.start)
                    .error(R.drawable.ic_error)
                    .into(businessViewHolder.binding.imageBusiness);
            if (dataProccessor.getBool(Constants.DAY_25)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 25){
            if (dataProccessor.getBool(Constants.DAY_26)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 26){
            if (dataProccessor.getBool(Constants.DAY_27)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 27){
            if (dataProccessor.getBool(Constants.DAY_28)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 28){
            if (dataProccessor.getBool(Constants.DAY_29)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }
        if (position == 29){
            if (dataProccessor.getBool(Constants.DAY_30)){
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock_open);
            } else {
                businessViewHolder.binding.imageLock.setImageResource(R.drawable.ic_lock);
            }
        }


        // click event
        businessViewHolder.itemView.setOnClickListener(view -> {
            int position1 = holder.getAdapterPosition();

            mViewModel.getOpenBusinessEvent().setValue(position1);
        });

        businessViewHolder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mBusinessList != null ? mBusinessList.size() : 0;
    }

    public void replaceData(List<Business> sandwiches) {
        mBusinessList = sandwiches;
        notifyDataSetChanged();
    }

    /**
     * The {@link BusinessViewHolder} class.
     * Provides a binding reference to each view in sandwich cardView.
     */
    public class BusinessViewHolder extends RecyclerView.ViewHolder {

        private final ItemBusinessBinding binding;

        public BusinessViewHolder(final ItemBusinessBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
