package com.hatem.noureddine.carrefour.demo;

import com.hatem.noureddine.carrefour.demo.network.data.Movie;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener, Filterable {

	private MainView mainView;
	private SharedPreferences sharedPreferences;
	private FindItemsInteractor findItemsInteractor;
	@Nullable
	private String currentFilter;
	private List<Movie> allItems;

	public MainPresenterImpl(MainView mainView, FindItemsInteractor findItemsInteractor, SharedPreferences sharedPreferences) {
		this.mainView = mainView;
		this.findItemsInteractor = findItemsInteractor;
		this.sharedPreferences = sharedPreferences;
	}

	@Override
	public void onCreate() {
		if (mainView != null) {
			mainView.showProgress();
		}
	}

	@Override
	public void onResume() {
		if (mainView != null) {
			mainView.showProgress();
		}

		findItemsInteractor.findItems(sharedPreferences, this);
	}

	@Override
	public void onItemClicked(int position) {
		if (mainView != null) {
			mainView.showMessage(String.format("Position %d clicked", position + 1));
		}
	}

	@Override
	public void onDestroy() {
		mainView = null;
	}

	@Override
	public void loadData(@Nullable final String query) {
		findItemsInteractor.findItems(sharedPreferences, this);
		currentFilter = query;
	}

	@Override
	public void onFinished(List<Movie> items) {
		allItems = new ArrayList<>(items);
		if (mainView != null) {
			if (TextUtils.isEmpty(currentFilter)) {
				notifyItemsChange(items);
			}
			else {
				getFilter().filter(currentFilter);
			}
			mainView.hideProgress();
		}
	}

	void notifyItemsChange(final List<Movie> items) {
		mainView.setItems(items);
	}

	public MainView getMainView() {
		return mainView;
	}

	@Override
	public Filter getFilter() {
		return new MovieFilter(this, allItems);
	}

	private static class MovieFilter extends Filter {
		private MainPresenterImpl mMainPresenter;
		private List<Movie> mMovieList;

		public MovieFilter(final MainPresenterImpl mainPresenter, final List<Movie> movies) {
			mMainPresenter = mainPresenter;
			this.mMovieList = movies;
		}

		@Override
		protected FilterResults performFiltering(final CharSequence constraint) {
			String filter = constraint.toString()
			                          .toLowerCase();
			List<Movie> filteredList;

			if (filter.isEmpty()) {
				filteredList = mMovieList;
			}
			else {
				filteredList = new ArrayList<>();
				for (Movie movie : mMovieList) {
					if (movie.title.toLowerCase()
					               .contains(filter) || movie.synopsis.contains(filter)) {
						filteredList.add(movie);
					}
				}
			}

			FilterResults filterResults = new FilterResults();
			filterResults.values = filteredList;
			return filterResults;
		}

		@Override
		protected void publishResults(final CharSequence constraint, final FilterResults results) {
			List<Movie> filteredList = (ArrayList<Movie>) results.values;
			mMainPresenter.notifyItemsChange(filteredList);
		}
	}
}