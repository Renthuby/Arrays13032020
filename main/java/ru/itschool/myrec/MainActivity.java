package ru.itschool.myrec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    HashSet<People> hashSet =  new HashSet<People>();
    TreeSet<String> peopletree = new TreeSet<String>();
    TextView textView;
    Button gobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.inputtext);
        gobtn = findViewById(R.id.gobtn);
        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecurceActivity.class);
                startActivity(intent);
            }
        });

        textView.setText("" + LenFib(10));

    }

    private int Factorial(int i) {
        if (i == 0) return 1;
        return Factorial(i - 1) * i;
    }

    private double Factorial2(double i) {
        double f = 1;
        for (int j = 1; j <= i; j++) {
            f *= j;
        }
        return f;
    }

    private int nFib(int n) {
        if (n == 0 || n == 1) return 1;
        return nFib(n - 1) + nFib(n - 2);
    }

    private String LenFib(int n) {
        String s = "";
        for (int i = 0; i <= n; i++) {
            s += i + 1 + "\t" + nFib(i) + "\n";
        }
        return s;
    }

    public void HeshClick(View view) {


        String s = editText.getText().toString();
        if (!s.isEmpty()) {
            String[] people = s.split(" ");
            String name = people[0];
            int age = Integer.parseInt(people[1]);
            hashSet.add(new People(s, age));
        } else {
            Toast.makeText(getApplicationContext(), "Clear", Toast.LENGTH_SHORT).show();
        }

        HeshOut();
        editText.setText("");

    }

    private void HeshOut() {
        for (People t:hashSet) {
            textView.append(t  + " " + t.hashCode() + "\n");
        }
    }

    public void TreeClick(View view) {
        String s = editText.getText().toString();
        if (!s.isEmpty()) {
            String[] people = s.split(" ");
            String name = people[0];
            int age = Integer.parseInt(people[1]);
            peopletree.add(s);
        } else {
            Toast.makeText(getApplicationContext(), "Clear", Toast.LENGTH_SHORT).show();
        }

        TreeOut();
        editText.setText("");
    }

    private void TreeOut() {
        textView.setText("");
        for (String t:peopletree) {
            textView.append(t.toString()  + " " + t.hashCode() + "\n");
        }
    }
}
