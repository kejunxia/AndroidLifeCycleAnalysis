package com.test.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    static String parseNull(Object obj){
        return obj == null?"null"  : "Object";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("ActivityCycle", "onCreate: bundle="+parseNull(savedInstanceState));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DummyFragment())
                    .commit();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("ActivityCycle", "onConfigurationChanged");
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Log.e("ActivityCycle", "onCreateView");
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        Log.e("ActivityCycle", "onPostCreate: bundle="+parseNull(savedInstanceState));
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.e("ActivityCycle", "onResume");
        super.onResume();
    }

    @Override
    protected void onPostResume() {
        Log.e("ActivityCycle", "onPostResume");
        super.onPostResume();
    }

    @Override
    protected void onResumeFragments() {
        Log.e("ActivityCycle", "onResumeFragments");
        super.onResumeFragments();
    }

    @Override
    protected void onStop() {
        Log.e("ActivityCycle", "onStop");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.e("ActivityCycle", "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.e("ActivityCycle", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e("ActivityCycle", "onSaveInstanceState: outState="+parseNull(outState));
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.e("ActivityCycle", "onAttachFragment");
        super.onAttachFragment(fragment);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e("ActivityCycle", "onRestoreInstanceState: bundle="+parseNull(savedInstanceState));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        Log.e("ActivityCycle", "onRestart");
        super.onRestart();
    }

    @Override
    public void onAttachedToWindow() {
        Log.e("ActivityCycle", "onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        Log.e("ActivityCycle", "onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    @Override
    protected void onStart() {
        Log.e("ActivityCycle", "onStart");
        super.onStart();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.e("ActivityCycle", "onWindowFocusChanged");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onLowMemory() {
        Log.e("ActivityCycle", "onLowMemory");
        super.onLowMemory();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A dummy fragment containing a simple view.
     */
    public static class DummyFragment extends Fragment {
        private int count = 0;
        public DummyFragment() {
//            setRetainInstance(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            Log.d("FragmentCycle===>", "onCreateView: bundle="+parseNull(savedInstanceState));
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.textView);
            textView.setText(String.valueOf(++count));
            return rootView;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            Log.d("FragmentCycle===>", "onCreate: bundle="+parseNull(savedInstanceState));
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onAttach(Activity activity) {
            Log.d("FragmentCycle===>", "onAttach");
            super.onAttach(activity);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Log.d("FragmentCycle===>", "onViewCreated: bundle="+parseNull(savedInstanceState));
            super.onViewCreated(view, savedInstanceState);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            Log.d("FragmentCycle===>", "onActivityCreated: bundle="+parseNull(savedInstanceState));
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public void onViewStateRestored(Bundle savedInstanceState) {
            Log.d("FragmentCycle===>", "onViewStateRestored: bundle="+parseNull(savedInstanceState));
            super.onViewStateRestored(savedInstanceState);
        }

        @Override
        public void onStart() {
            Log.d("FragmentCycle===>", "onStart");
            super.onStart();
        }

        @Override
        public void onResume() {
            Log.d("FragmentCycle===>", "onResume");
            super.onResume();
        }

        @Override
        public void onPause() {
            Log.d("FragmentCycle===>", "onPause");
            super.onPause();
        }

        @Override
        public void onStop() {
            Log.d("FragmentCycle===>", "onStop");
            super.onStop();
        }

        @Override
        public void onDestroyView() {
            Log.d("FragmentCycle===>", "onDestroyView");
            super.onDestroyView();
        }

        @Override
        public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
            Log.d("FragmentCycle===>", "onInflate: bundle="+parseNull(savedInstanceState));
            super.onInflate(activity, attrs, savedInstanceState);
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            Log.d("FragmentCycle===>", "onSaveInstanceState: outState="+parseNull(outState));
            super.onSaveInstanceState(outState);
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            Log.d("FragmentCycle===>", "onConfigurationChanged");
            super.onConfigurationChanged(newConfig);
        }

        @Override
        public void onDestroy() {
            Log.d("FragmentCycle===>", "onDestroy");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.d("FragmentCycle===>", "onDetach");
            super.onDetach();
        }

        @Override
        public void setInitialSavedState(SavedState state) {
            Log.d("FragmentCycle===>", "setInitialSavedState");
            super.setInitialSavedState(state);
        }

        @Override
        public void onHiddenChanged(boolean hidden) {
            Log.d("FragmentCycle===>", "onHiddenChanged");
            super.onHiddenChanged(hidden);
        }

        @Override
        public void onLowMemory() {
            Log.d("FragmentCycle===>", "onLowMemory");
            super.onLowMemory();
        }
    }

}
