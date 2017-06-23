package double_ranch.taskholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 7408588 on 6/22/2017.
 */

public class DescriptionView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_view);

        String description = getIntent().getStringExtra("desc");
        TextView desc = (TextView) findViewById(R.id.tv_desc);
        desc.setText(description);

        Button back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );



    }
}
