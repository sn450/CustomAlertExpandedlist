package sample.tatastrive.snehal.customalert;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomAlertActivity extends AppCompatActivity {
final Context context=this;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_main);
                Button dialogButton = dialog.findViewById(R.id.button);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        dialog.dismiss();
                        Toast.makeText(CustomAlertActivity.this,"Dismissed..!!",Toast.LENGTH_LONG);
                        Intent intent = new Intent(CustomAlertActivity.this,ExpandedListViewActivity.class);
                        startActivity(intent);
                    }
                });


                dialog.show();

            }
        });


    }
}
