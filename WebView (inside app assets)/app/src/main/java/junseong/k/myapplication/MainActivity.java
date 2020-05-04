package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button linebtn;
    Button barbtn;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webview);
        linebtn=findViewById(R.id.btn_chart_line);
        barbtn=findViewById(R.id.btn_chart_bar);
        linebtn.setOnClickListener(this);
        barbtn.setOnClickListener(this);
        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/text.html");
        webView.addJavascriptInterface(new JavascriptTest(),"android");
        webView.setWebViewClient(new MyWebClient());
        webView.setWebChromeClient(new MyWebChrome());
    }

    @Override
    public void onClick(View view) {
        if(view==linebtn)
            webView.loadUrl("javascript:lineChart()");
        else if(view==barbtn)
            webView.loadUrl("javascript:barChart()");
    }
    class JavascriptTest{
        @JavascriptInterface
        public String getChartData(){
            StringBuffer buffer=new StringBuffer();
            buffer.append("[");
            for(int i=0; i<14; i++)
            {
                buffer.append("["+i+","+Math.sin(i)+"]");
                if(i<13)buffer.append(",");
            }
            buffer.append("]");
            return buffer.toString();
        }
    }
    class MyWebClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView,String url){
            Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
            return true;
        }
    }
    class MyWebChrome extends WebChromeClient{
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result){
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            result.confirm();
            return true;
        }
    }
}
