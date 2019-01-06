package nl.evertwoud.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @ViewById(R.id.viewpager)
    ViewPager pager;

    RecipePagerAdapter adapter;

    List<Recipe> recipes = new ArrayList<>();

    @AfterViews
    void init() {
        adapter = new RecipePagerAdapter(getSupportFragmentManager(), recipes);
        pager.setAdapter(adapter);

        requestData();
    }


    private void requestData() {
        APIService service = APIService.retrofit.create(APIService.class);
        Call<APIResponse> call = service.getRecipes();
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                adapter.setItems(response.body().recipes);
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
