package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.sax.Element;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button domBtn;
    Button saxBtn;
    Button pullBtn;
    Button jsonBtn;

    TextView cityView;
    TextView tempView;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        domBtn = findViewById(R.id.lab2_dom);
        saxBtn =  findViewById(R.id.lab2_sax);
        pullBtn = findViewById(R.id.lab2_pull);
        jsonBtn =  findViewById(R.id.lab2_json);

        cityView = findViewById(R.id.lab2_city);
        tempView =  findViewById(R.id.lab2_temperature);
        resultView =  findViewById(R.id.lab2_result_title);

        domBtn.setOnClickListener(this);
        saxBtn.setOnClickListener(this);
        pullBtn.setOnClickListener(this);
        jsonBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == domBtn) {
            domParsing();
        } else if (v == saxBtn) {
            saxParsing();
        } else if (v == pullBtn) {
            pullParsing();
        } else if (v == jsonBtn) {
            jsonParsing();
        }
    }

    private void domParsing() {


        try{
            InputStream inputStream=getAssets().open("test.xml");
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc=builder.parse(inputStream, null);

            org.w3c.dom.Element tempElement=(org.w3c.dom.Element)doc.getElementsByTagName("temperature").item(0);
            String temperature=tempElement.getAttribute("value");

            org.w3c.dom.Element cityElement=(org.w3c.dom.Element)doc.getElementsByTagName("city").item(0);
            String city=cityElement.getAttribute("name");

            resultView.setText("DOM Parsing Result");
            cityView.setText(city);
            tempView.setText(temperature);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void saxParsing() {


        resultView.setText("SAX Parsing Result");
        RootElement root=new RootElement("current");
        Element cityElement=root.getChild("city");
        Element tempElement=root.getChild("temperature");

        cityElement.setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                cityView.setText(attributes.getValue("name"));
            }
        });
        tempElement.setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                tempView.setText(attributes.getValue("value"));
            }
        });

        try {
            InputStream inputStream=getAssets().open("test.xml");
            Xml.parse(inputStream, Xml.Encoding.UTF_8, root.getContentHandler());
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private void pullParsing() {


        resultView.setText("Pull Parsing Result");
        try {
            InputStream inputStream=getAssets().open("test.xml");
            XmlPullParser parser=Xml.newPullParser();
            parser.setInput(inputStream, null);
            int eventType=parser.getEventType();
            boolean done=false;

            while (eventType != XmlPullParser.END_DOCUMENT && !done){
                String name=null;
                if(eventType==XmlPullParser.START_TAG){
                    name=parser.getName();
                    if(name.equals("city")){
                        cityView.setText(parser.getAttributeValue(null, "name"));
                    }else if(name.equals("temperature")){
                        tempView.setText(parser.getAttributeValue(null, "value"));
                    }
                }
                eventType=parser.next();
            }

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    private void jsonParsing() {

        resultView.setText("JSON Parsing Result..");
        String json=null;
        try {
            InputStream is=getAssets().open("test.json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            json=new String(buffer, "UTF-8");
            JSONObject root=new JSONObject(json);

            cityView.setText(root.getString("name"));
            JSONObject main=root.getJSONObject("main");
            tempView.setText(main.getString("temp"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
