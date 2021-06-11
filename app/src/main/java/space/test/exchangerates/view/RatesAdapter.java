package space.test.exchangerates.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import space.test.exchangerates.R;
import space.test.exchangerates.model.Rates;

public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.RatesViewHolder> {

    private Rates rates;

    public void update(Rates r) {
        this.rates = r;
    }

    @NonNull
    @NotNull
    @Override
    public RatesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.rates_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        RatesViewHolder viewHolder = new RatesViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RatesAdapter.RatesViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return this.rates.getLength();
    }

    class RatesViewHolder extends RecyclerView.ViewHolder {
        TextView currency;
        TextView codes;
        TextView buy;
        TextView sale;

        public RatesViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            currency = itemView.findViewById(R.id.CurrValue);
            codes = itemView.findViewById(R.id.CodeValue);
            buy = itemView.findViewById(R.id.BuyValue);
            sale = itemView.findViewById(R.id.SaleValue);
        }

        void bind(int listIndex) {
            currency.setText(rates.getRateByIndex(listIndex).getName());
            codes.setText(rates.getRateByIndex(listIndex).getCodes());
            buy.setText(rates.getRateByIndex(listIndex).getBuy());
            sale.setText(rates.getRateByIndex(listIndex).getSale());
        }
    }
}
