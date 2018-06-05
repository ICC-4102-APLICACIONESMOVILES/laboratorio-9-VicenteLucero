package com.example.gamma.lab9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebChromeClient(new WebChromeClient(){
            public void onConsoleMessage(String message, int lineNumber, String sourceID){
                Log.d("MyApplication", message + "--From line"+lineNumber+" of "+sourceID);
            }
        });
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://demo.tutorialzine.com/2012/04/mobile-touch-gallery/");
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event){
        if ((KeyCode==KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()){
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(KeyCode, event);
    }
}
