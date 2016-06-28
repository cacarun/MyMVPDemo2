package com.android.mvp2.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.mvp2.R;
import com.android.mvp2.SimpleObserver;
import com.android.mvp2.base.BaseActivity;
import com.android.mvp2.inject.component.ActivityComponent;
import com.android.mvp2.data.bean.Repo;
import com.android.mvp2.service.GitHubApiService;
import com.android.mvp2.ui.adapter.ListAdapter;
import com.android.mvp2.util.OSHelper;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReposListActivity extends BaseActivity {

    private static final String TAG = ReposListActivity.class.getName();

    @Bind(R.id.repos_rv_list)
    RecyclerView mRvList;

    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;


    @Inject
    GitHubApiService gitHubApiService;

    OSHelper osHelper;

    @Inject
    ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_repo_list;
    }

    @Override
    public void injectDagger() {
        // 注入
        ActivityComponent component = activityComponent();
        component.inject(this);

//        GitHubApiComponent gitHubApiComponent = DaggerGitHubApiComponent.builder().gitHubApiModule(new GitHubApiModule())
//                .appComponent(((AppApplication)getApplication()).getAppComponent()).build();
//        gitHubApiComponent.inject(this);
//
//        osHelper = gitHubApiComponent.getOSHelper();
//        Log.e(TAG, "os helper brand: " + osHelper.getDeviceBrand());
    }


    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvList.setLayoutManager(manager);

//        ListAdapter adapter = new ListAdapter();
        mRvList.setAdapter(mAdapter);
        loadData(mAdapter);
    }

    private void loadData(final ListAdapter adapter) {
        showLoading(true);
        gitHubApiService.getRepoData(getUser())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<ArrayList<Repo>>() {
            @Override
            public void onNext(ArrayList<Repo> repos) {
                showLoading(false);
                adapter.setRepos(repos);
            }

            @Override
            public void onError(Throwable e) {
                showLoading(false);
            }
        });
    }

    private String getUser() {
        return "bird1015";
    }

    public void showLoading(boolean loading) {
        Log.i("info", loading + " Repos");
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}