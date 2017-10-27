package com.tardins.tardinsexoplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText uriText;
    private Button playButton;
    public static final String URI_TEXT = "URI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.play_button);
        uriText = (EditText)findViewById(R.id.editText);
        uriText.setText(getString(R.string.sample_video_hls));
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, PlayerActivity.class);
        if(uriText.getText().length() > 0 ){
            intent.putExtra(URI_TEXT, uriText.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(view.getContext(), "URI field is empty. ", Toast.LENGTH_LONG).show();
        }
    }
}
