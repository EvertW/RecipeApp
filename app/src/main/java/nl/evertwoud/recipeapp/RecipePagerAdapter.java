package nl.evertwoud.recipeapp;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class RecipePagerAdapter extends FragmentPagerAdapter {


    List<Recipe> items;

    public RecipePagerAdapter(FragmentManager fm, List<Recipe> items) {
        super(fm);
        this.items = items;
    }

    public void setItems(List<Recipe> pItems) {
        items = pItems;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return RecipeFragment_.builder().recipe(items.get(position)).build();
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
