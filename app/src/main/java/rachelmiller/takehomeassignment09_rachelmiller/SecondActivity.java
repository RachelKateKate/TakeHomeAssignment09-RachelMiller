package rachelmiller.takehomeassignment09_rachelmiller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference assignmentRef = database.getReference("assignment");

    private EditText assignment;
    private EditText hours;
    private CheckBox isComplete;
    private Button firebaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        assignment = (EditText) findViewById(R.id.assignmentName);
        hours = (EditText) findViewById(R.id.hours);
        isComplete = (CheckBox) findViewById(R.id.complete);
        firebaseButton = (Button) findViewById(R.id.addtoFirebaseButton);
    }

    public void addToFirebase(View view) {
        String assignmentName = assignment.getText().toString();
        int timeInHours = Integer.parseInt(hours.getText().toString());
        boolean completed = ((CheckBox) findViewById(R.id.complete)).isChecked();
        assignmentRef.push().setValue(new Assignment(assignmentName, timeInHours, completed));
        Intent mrIntent = new Intent(this, MainActivity.class);
        startActivity(mrIntent);
    }
}
