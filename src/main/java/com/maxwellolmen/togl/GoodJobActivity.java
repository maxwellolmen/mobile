package com.maxwellolmen.togl;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class GoodJobActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_job);

        final Bundle b = getIntent().getExtras();

        Button back = (Button) findViewById(R.id.back);
        Button replay = (Button) findViewById(R.id.replay);
        Button next = (Button) findViewById(R.id.next);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (b.getInt("level")) {
                    case 1:
                        Intent intent = new Intent(GoodJobActivity.this, GameActivity2.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        intent = new Intent(GoodJobActivity.this, GameActivity3.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        intent = new Intent(GoodJobActivity.this, GameActivity4.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 5:
                        intent = new Intent(GoodJobActivity.this, GameActivity5.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 6:
                        intent = new Intent(GoodJobActivity.this, GameActivity6.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 7:
                        intent = new Intent(GoodJobActivity.this, GameActivity7.class);
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (b.getInt("level")) {
                    case 1:
                        Intent intent = new Intent(GoodJobActivity.this, GameActivity2.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        intent = new Intent(GoodJobActivity.this, GameActivity3.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        intent = new Intent(GoodJobActivity.this, GameActivity4.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 4:
                        intent = new Intent(GoodJobActivity.this, GameActivity5.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 5:
                        intent = new Intent(GoodJobActivity.this, GameActivity6.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 6:
                        intent = new Intent(GoodJobActivity.this, GameActivity7.class);
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });
    }
}
