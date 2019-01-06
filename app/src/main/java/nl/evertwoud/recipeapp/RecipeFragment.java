package nl.evertwoud.recipeapp;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import androidx.fragment.app.Fragment;

@EFragment(R.layout.fragment_recipe)
public class RecipeFragment extends Fragment {

    @ViewById(R.id.image)
    ImageView imageView;

    @ViewById(R.id.name)
    TextView nameTv;

    @ViewById(R.id.ingredients)
    TextView ingredientsTv;

    @FragmentArg
    Recipe recipe;


    @AfterViews
    void init(){
        Glide.with(this).load(recipe.getImageUrl()).into(imageView);
        nameTv.setText(recipe.getTitle());
    }
}
