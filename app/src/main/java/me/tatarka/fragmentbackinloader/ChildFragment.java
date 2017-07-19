package me.tatarka.fragmentbackinloader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChildFragment extends Fragment implements LoaderManager.LoaderCallbacks<Void> {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.child, container, false);
    }

    @Override
    public Loader<Void> onCreateLoader(int i, Bundle bundle) {
        return new DumbLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Void> loader, Void aVoid) {
        getFragmentManager().beginTransaction()
                .remove(this)
                .commitNowAllowingStateLoss();
    }

    @Override
    public void onLoaderReset(Loader<Void> loader) {

    }
}
