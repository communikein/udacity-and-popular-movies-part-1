package it.communikein.popularmovies;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import it.communikein.popularmovies.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements
        MoviesGridAdapter.MovieClickCallback {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initGrid();

        final MoviesGridAdapter moviesAdapter = new MoviesGridAdapter(this);
        mBinding.listRecyclerview.setAdapter(moviesAdapter);
    }

    private void initGrid() {
        /*
         * The second parameter is for the number of rows.
         * the third parameter is for the horizontal scroll.
         * the fourth parameter is boolean, when it set to false, layout from start to end
         */
        GridLayoutManager gridHorizontal = new GridLayoutManager(this,
                3,
                GridLayoutManager.VERTICAL,
                false);
        mBinding.listRecyclerview.setLayoutManager(gridHorizontal);
        mBinding.listRecyclerview.setHasFixedSize(true);
    }


    @Override
    public void onListNewsClick(Movie movie) {

    }
}
