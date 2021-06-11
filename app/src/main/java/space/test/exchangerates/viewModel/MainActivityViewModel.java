package space.test.exchangerates.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Map;

import space.test.exchangerates.model.Constants;
import space.test.exchangerates.model.Rates;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<Rates> currentState = new MutableLiveData<>();

    public MainActivityViewModel() {
        currentState.postValue(new Rates());
    }

    public void postRequest(Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Gson gson = new Gson();
                    Rates rates = gson.fromJson(response, Rates.class);
                    currentState.postValue(rates); //запостить Rates в curSt
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return Constants.HEADERS;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return Constants.REQUEST_BODY.getBytes();
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                Constants.TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
    }
}
