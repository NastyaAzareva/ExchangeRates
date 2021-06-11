package space.test.exchangerates.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import space.test.exchangerates.R;
import space.test.exchangerates.model.Rates;
import space.test.exchangerates.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView ratesList;
    private RatesAdapter ratesAdapter = new RatesAdapter();

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //ToDo зочем
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        ratesList = findViewById(R.id.rv_rates);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ratesList.setLayoutManager(layoutManager);
        ratesList.setHasFixedSize(true);
        ratesList.setAdapter(ratesAdapter);

        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.postRequest(MainActivity.this);

        mainActivityViewModel.currentState.observe(this, new Observer<Rates>() {
            @Override
            public void onChanged(Rates rates) {
                ratesAdapter.update(rates);
                ratesAdapter.notifyDataSetChanged();

                if (rates.getLength() != 0)
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
            }
        });
    }
}