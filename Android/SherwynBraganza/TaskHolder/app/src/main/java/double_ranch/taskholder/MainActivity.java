package double_ranch.taskholder;

import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  FloatingActionButton btn_add;
    private  ListView list_view;
    private ListAdapter adapter;
    private List<TaskLayout> mList;
   private String temp_string;
    public static int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view = (ListView) findViewById(R.id.list_view) ;
        mList = new ArrayList<>();
        mList.add(new TaskLayout(1,"Driving Classes", "nothin"));
        mList.add(new TaskLayout(2, "Do Homework", "Nothing"));

    }

    @Override
    protected void onResume() {
        super.onResume();
        Task_Adder();
        adapter = new ListAdapter(getApplicationContext(),mList);
        list_view.setAdapter(adapter);
        TaskClickListener();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                mList.add(new TaskLayout(count, data.getStringExtra("name"),
                        data.getStringExtra("desc")));

            }
        }
    }

    public void Task_Adder(){
        btn_add = (FloatingActionButton) findViewById(R.id.button_add);

        btn_add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(v.getId() == R.id.button_add) {

                            Intent new_task = new Intent(MainActivity.this, AddTask.class);
                            MainActivity.this.startActivityForResult(new_task, 1);
                            count++;
                        }
                    }
                }
        );
    }

    public void TaskClickListener(){
      list_view.setOnItemClickListener(
              new AdapterView.OnItemClickListener(){

                  @Override
                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                      Intent description = new Intent(MainActivity.this,DescriptionView.class);
                      description.putExtra("desc", mList.get(position).getDesc());
                      startActivity(description);
                  }
              }
      );
    }
}
