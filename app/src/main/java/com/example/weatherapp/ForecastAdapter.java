package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.itemViewHolder> {
    public Toast mToast;

    private String[] mWeatherData;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;


    public ForecastAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    //    The first thing we want to do is inflate the item we want in onCreate
    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.forecast_list_item, parent, false);
        return new itemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        String weatherForThisDay = mWeatherData[position];
        holder.mWeatherData.setText(weatherForThisDay);

    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null)
            return 0;
        return mWeatherData.length;
    }

    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
    public class itemViewHolder extends RecyclerView.ViewHolder {

        public TextView mWeatherData;
        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            mWeatherData = (TextView) itemView.findViewById(R.id.tv_weather_data);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAbsoluteAdapterPosition();
                    mToast.makeText(mContext,
                            "This card number " +"" + Integer.toString(position),
                            Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}
