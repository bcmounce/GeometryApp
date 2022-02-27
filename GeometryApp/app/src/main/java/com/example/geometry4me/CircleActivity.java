package com.example.geometry4me;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CircleActivity extends AppCompatActivity {
    private TextView circumferenceValue;
    private TextView areaValue;
    private TextView diameterValue;
    private EditText radiusValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        radiusValue        = (EditText)findViewById(R.id.circle_radius_field);
        circumferenceValue = (TextView)findViewById(R.id.circle_circumference_value);
        areaValue          = (TextView)findViewById(R.id.circle_area_value);
        diameterValue      = (TextView)findViewById(R.id.circle_diameter_value);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("CircleActivity.area",
                Double.parseDouble(areaValue.getText().toString()));
        outState.putDouble("CircleActivity.diameter",
                Double.parseDouble(diameterValue.getText().toString()));
        outState.putDouble("CircleActivity.circumference",
                Double.parseDouble(circumferenceValue.getText().toString()));

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        areaValue.setText(Double.toString(
                savedInstanceState.getDouble("CircleActivity.area")));
        diameterValue.setText(Double.toString(
                savedInstanceState.getDouble("CircleActivity.diameter")));
        circumferenceValue.setText(Double.toString(
                savedInstanceState.getDouble("CircleActivity.circumference")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.menuMain:
                startActivity(new Intent(getApplicationContext(),
                        MainActivity.class));
                return true;

            case R.id.menuCircle:
                return true;

            case R.id.menuRectangle:
                startActivity(new Intent(getApplicationContext(),
                        RectangleActivity.class));
                return true;

            case R.id.menuTriangle:
                startActivity(new Intent(getApplicationContext(),
                        TriangleActivity.class));
                return true;

            case R.id.menuSphere:
                startActivity(new Intent(getApplicationContext(),
                        SphereActivity.class));
                return true;

            case R.id.menuRectPrism:
                startActivity(new Intent(getApplicationContext(),
                        PrismActivity.class));
                return true;

            case R.id.menuPyramid:
                startActivity(new Intent(getApplicationContext(),
                        PyramidActivity.class));
                return true;

            case R.id.menuCylinder:
                startActivity(new Intent(getApplicationContext(),
                        CylinderActivity.class));
                return true;

            case R.id.menuCone:
                startActivity(new Intent(getApplicationContext(),
                        ConeActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Calculate(View view){
        try {
            double r = Double.parseDouble(radiusValue.getText().toString());
            double diameter = 2 * r;
            double circumference = diameter * Math.PI;
            double area = Math.PI * r * r;
            diameterValue.setText(Double.toString(diameter));
            circumferenceValue.setText(Double.toString(circumference));
            areaValue.setText(Double.toString(area));
        }
        catch(Exception e){
            
        }
    }

    public void Back(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
