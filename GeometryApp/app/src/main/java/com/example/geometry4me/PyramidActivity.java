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

public class PyramidActivity extends AppCompatActivity {

    private EditText heightValue;
    private EditText baseValue;
    private TextView lateralValue;
    private TextView surfaceValue;
    private TextView volumeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyramid);

        heightValue  = (EditText)findViewById(R.id.pyramid_height_field);
        baseValue    = (EditText)findViewById(R.id.pyramid_base_field);
        lateralValue = (TextView)findViewById(R.id.pyramid_lateral_area_field);
        surfaceValue = (TextView)findViewById(R.id.pyramid_surface_area_field);
        volumeValue  = (TextView)findViewById(R.id.pyramid_volume_field);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("PyramidActivity.surface",
                Double.parseDouble(surfaceValue.getText().toString()));
        outState.putDouble("PyramidActivity.lateral",
                Double.parseDouble(lateralValue.getText().toString()));
        outState.putDouble("PyramidActivity.volume",
                Double.parseDouble(volumeValue.getText().toString()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        surfaceValue.setText(Double.toString(
                savedInstanceState.getDouble("PyramidActivity.surface")));
        lateralValue.setText(Double.toString(
                savedInstanceState.getDouble("PyramidActivity.lateral")));
        volumeValue.setText(Double.toString(
                savedInstanceState.getDouble("PyramidActivity.volume")));

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
                startActivity(new Intent(getApplicationContext(),
                        CircleActivity.class));
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
            double b = Double.parseDouble(baseValue.getText().toString());
            double h = Double.parseDouble(heightValue.getText().toString());
            double la = b * Math.sqrt((b * b) + (4 * h * h));
            double sa = (b * b) + (2 * b * Math.sqrt(((b * b) / 4) + (h * h)));
            double v = b * b * (h / 3);
            lateralValue.setText(Double.toString(la));
            surfaceValue.setText(Double.toString(sa));
            volumeValue.setText(Double.toString(v));
        }
        catch(Exception e){

        }
    }

    public void Back(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
