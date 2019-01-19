package sample.tatastrive.snehal.customalert;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Expandable List View
        expandableListView = findViewById(R.id.lvExp);


        //prepare list data
        preparelistdata();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
    }
    private void preparelistdata() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        //Adding Header data
        listDataHeader.add("Topics");
        listDataHeader.add("Topics covered");
        listDataHeader.add("Topics not covered");
        listDataHeader.add("Switch to startActivity for Result");

        //Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Android");
        top250.add("Android Arch..");
        top250.add("Android SDK");
        top250.add("Android UI");
        top250.add("Android Notification");
        top250.add("Android Maps");
        top250.add("Android Bluetooth");
        top250.add("Android WIFI");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Android");
        nowShowing.add("Android Arch..");
        nowShowing.add("Android SDK");
        nowShowing.add("Android UI");
        nowShowing.add("Android Notification");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Android");
        comingSoon.add("Android Arch..");
        comingSoon.add("Android SDK");

        List<String> worken = new ArrayList<String>();
        worken.add("Start Activity and start Activity Result");
        listDataChild.put(listDataHeader.get(0), top250);//header, child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), worken);

    }
}
