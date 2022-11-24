    package com.example.dikr;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    public class activitytasbih extends AppCompatActivity {
    TextView t1;
    Button b1,b2;
    int i=0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_activitytasbih);
            t1=(TextView) findViewById(R.id.txt_count);
            b1=(Button) findViewById(R.id.btn_clear);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     t1.setText("0");
                     i=0;
                }
            });
            b2=(Button) findViewById(R.id.btn_click);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i++;
                    t1.setText(""+i);
                }
            });
        }
    }