package com.example.zhangyi.djtu_test2;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;

import android.os.Handler;
import android.webkit.WebViewClient;

/**
 * Created by zhangyi on 16/3/9.
 */
public class Course_list extends ActionBarActivity{
    private WebView webView;
    private Handler handler=new Handler();
    SharedPreferences sharedPreferences;
    private String Cookies;

    private String url="http://jw.djtu.edu.cn/academic/manager/coursearrange/showTimetable.do?id=290552&yearid=36&termid=1&timetableType=STUDENT&sectionType=BASE";
    //"http://jw.djtu.edu.cn/academic/manager/coursearrange/showTimetable.do?id=290552&yearid=36&termid=1&timetableType=STUDENT&sectionType=BASE"
    //http://jw.djtu.edu.cn/academic/manager/coursearrange/showTimetable.do?id=290552&yearid=36&termid=1&timetableType=STUDENT&sectionType=COMBINE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);
        webView=(WebView)findViewById(R.id.course_List);
        sharedPreferences = getSharedPreferences("params", Context.MODE_PRIVATE);
        Cookies=sharedPreferences.getString("Cookie",null);
        /*CookieSyncManager cookieSyncManager = CookieSyncManager.createInstance(Course_list.this);
        cookieSyncManager.sync();
        android.webkit.CookieManager cookieManager= android.webkit.CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        android.webkit.CookieManager.getInstance().removeAllCookie();
        cookieManager.setCookie(url, Cookies);
        CookieSyncManager.getInstance().sync();*/
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //  new Course_list_Get("http://jw.djtu.edu.cn/academic/manager/coursearrange/showTimetable.do?id=290552&yearid=36&termid=1&timetableType=STUDENT&sectionType=COMBINE",webView,handler).start();
    }
}
