package sample.tatastrive.snehal.customalert;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class StartActivityCompareActivityOpened extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {


    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread, setData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_compare_activity_opened);
        initialize();

        SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String et = getData.getString("name", "Chandan is ...");
        String values = getData.getString("list", "4");
        if (values.contentEquals("1")) {
            question.setText(et);
        }

    }

    private void initialize() {
        // TODO Auto-generated method stub
        question = (TextView) findViewById(R.id.txtmsg);
        test = (TextView) findViewById(R.id.tvTest);
        returnData = (Button) findViewById(R.id.returnbtn);
        returnData.setOnClickListener(this);
        selectionList = (RadioGroup) findViewById(R.id.rtype);
        selectionList.setOnCheckedChangeListener(this);
    }

    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer", setData);
        person.putExtras(backpack);
        setResult(RESULT_OK, person);
        finish();
    }

    public void onCheckedChanged(RadioGroup arg0, int arg1) {
        // TODO Auto-generated method stub
        switch (arg1) {
            case R.id.rfamily:
                setData = " Family member I am fine";
                break;
            case R.id.rfriend:
                setData = " Friend's I am fine";
                break;
            case R.id.rlove:
                setData = " Dear love I am fine";
                break;

        }
        test.setText(setData);
    }
}