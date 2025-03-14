package com.yogaxd.exam;

import android.app.*;
import android.os.*;
import android.webkit.*;
import android.util.*;

public class MainActivity extends Activity 
{
	WebView webView;
	public class JSBride{
		@JavascriptInterface
		public void checkBimasoftExamClient(String message) {
			Log.i("ARIA", message);
			}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		webView = findViewById(R.id.webView);
		webView.setWebViewClient(new WebViewClient());

		WebSettings setweb = webView.getSettings();
		setweb.setJavaScriptEnabled(true);
		setweb.setDomStorageEnabled(true);
		setweb.setUseWideViewPort(true);
		setweb.setLoadWithOverviewMode(true);
		setweb.setBuiltInZoomControls(true);
		setweb.setDisplayZoomControls(true);

		webView.setKeepScreenOn(true);
		webView.loadUrl("https://link-redirect-plum.vercel.app/");
		webView.addJavascriptInterface(new JSBride(),"JSBridge");
    }
}
