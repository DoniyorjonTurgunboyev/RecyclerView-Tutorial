package uz.gita.recyclerviewtutorial.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import uz.gita.recyclerviewtutorial.R;
import uz.gita.recyclerviewtutorial.adapters.MessageAdapter;
import uz.gita.recyclerviewtutorial.data.Message;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Message> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Message("zoom" + i, "info salom yaxshi" + i, ("" + Calendar.getInstance().getTime()).substring(0, 20)));
        }
        rv = findViewById(R.id.rv);
        MessageAdapter adapter = new MessageAdapter(list, m -> {
            Toast.makeText(this, m.companyName + m.info, Toast.LENGTH_SHORT).show();
        });
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setAdapter(adapter);
        rv.setLayoutManager(llm);
    }
}