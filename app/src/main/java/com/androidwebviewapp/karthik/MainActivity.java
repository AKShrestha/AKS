package com.androidwebviewapp.karthik;


import android.app.ActionBar;
 import android.app.Activity;
 import android.content.Intent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuItem;
 import android.view.View;
 import android.webkit.WebSettings;
 import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ShareActionProvider;




         public class MainActivity extends Activity {


                 private WebView mWebView;

                 @Override
         protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_main);


                 mWebView = (WebView) findViewById(R.id.activity_main_webview);
                 WebSettings webSettings = mWebView.getSettings();
                 webSettings.setJavaScriptEnabled(true);


                     //improve WebView
                     mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                     mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                     mWebView.getSettings().setAppCacheEnabled(true);
                     mWebView.setScrollBarStyle(mWebView.SCROLLBARS_INSIDE_OVERLAY);

                     webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                     webSettings.setUseWideViewPort(true);
                     webSettings.setSavePassword(true);
                     webSettings.setSaveFormData(true);
                     webSettings.setEnableSmoothTransition(true);


                 mWebView.loadUrl("http://m.royaljk.com/");
                     mWebView.setWebViewClient(new WebViewClient());

                     mWebView.setWebViewClient(new com.androidwebviewapp.karthik.MyAppWebViewClient(){
                         @Override
                         public void onPageFinished(WebView view, String url) {
                                 //hide loading image
                                 findViewById(R.id.progressBar2).setVisibility(View.GONE);
                                 //show webview
                                 findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
                             mWebView.setWebViewClient(new WebViewClient());
                             }});



           }

     @Override
        public void onBackPressed() {
                 if(mWebView.canGoBack()) {
                         mWebView.goBack();
                     } else {
                         super.onBackPressed();
                     }
            }



                 private ShareActionProvider mShareActionProvider;
         @Override
         public boolean onCreateOptionsMenu(Menu menu) {


                 /** Inflating the current activity's menu with res/menu/items.xml */
                 getMenuInflater().inflate(R.menu.menu_main, menu);


                 /** Getting the actionprovider associated with the menu item whose id is share */
                 mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share).getActionProvider();


                 /** Setting a share intent */
                 mShareActionProvider.setShareIntent(getDefaultShareIntent());


                 return super.onCreateOptionsMenu(menu);


             }

                 /** Returns a share intent */
                          private Intent getDefaultShareIntent(){
                          Intent intent = new Intent(Intent.ACTION_SEND);
                          intent.setType("text/plain");
                          intent.putExtra(Intent.EXTRA_SUBJECT, "Shopping site");
                          intent.putExtra(Intent.EXTRA_TEXT," Vist http://m.royaljk.com/ if you Want online shopping exprience");
                          return intent;
                      }

                      }

