package sample.tatastrive.snehal.customalert;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StartActivityCompareActivity extends Activity implements View.OnClickListener {

    Button start, startFor;
    EditText sendET;
    TextView gotAnswer;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_compare);
        initialize();
//		rl = (RelativeLayout)findViewById(R.id.relLayout);
//		AdView ad = new AdView(Data.this, AdSize.BANNER, "YOUR_ADMOB_ID");
//		rl.addView(ad);
//		ad.loadAd(new AdRequest());
    }

    private void initialize() {
        // TODO Auto-generated method stub
        start = findViewById(R.id.btnStart);
        startFor =  findViewById(R.id.btnResult);
        sendET = findViewById(R.id.etSend);
        gotAnswer = findViewById(R.id.tvGot);
        start.setOnClickListener(this);
        startFor.setOnClickListener(this);
    }

    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.btnStart:
                String bread = sendET.getText().toString();
                Bundle basket = new Bundle();
                basket.putString("key", bread);
                Intent a = new Intent(StartActivityCompareActivity.this, StartActivityCompareActivityOpened.class);
                a.putExtras(basket);
                startActivity(a);
                break;
            case R.id.btnResult:
                Intent i = new Intent(StartActivityCompareActivity.this, StartActivityCompareActivityOpened.class);
                startActivityForResult(i, 0);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle basket = data.getExtras();
            String s = basket.getString("answer");
            gotAnswer.setText(s);
        }
    }

}
