package cl.slash.huntieproject.views.main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.slash.huntieproject.R;
import cl.slash.huntieproject.views.BaseActivity;

public class MainActivity extends BaseActivity {


    @BindView(R.id.activity_main_drawer_container)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.activity_main_nav_drawer)
    ViewGroup mNavDrawer;

    @BindView(R.id.activity_main_nav_drawer_list)
    ListView mNavDrawerList;

    @BindView(R.id.activity_main_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.activity_main_content)
    FrameLayout mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configureNavigationDrawer();
    }

    private void configureNavigationDrawer() {
        //Toolbar
        mToolbar.setTitle(R.string.app_name);

        //Nav Drawer Item List
        String[] items = getResources().getStringArray(R.array.main_nav_drawer_items);
        mNavDrawerList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items));


        //Navigation Drawer
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
}
