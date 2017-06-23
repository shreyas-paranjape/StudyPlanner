package double_ranch.taskholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {

    private EditText task_name;
    private  EditText description;
    private TaskLayout new_task;
    private static int count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        task_name = (EditText) findViewById(R.id.task_name);
        description = (EditText) findViewById(R.id.desc);


        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AddTask.this, "Saved", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.putExtra("name", task_name.getText().toString());
                        intent.putExtra("desc", description.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
        );
    }
}


