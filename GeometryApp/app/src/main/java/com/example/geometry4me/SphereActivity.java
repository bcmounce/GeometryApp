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

public class SphereActivity extends AppCompatActivity {

    private EditText radiusValue;
    private TextView diameterValue;
    private TextView volumeValue;
    private TextView surfaceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        radiusValue   = (EditText)findViewById(R.id.sphere_radius_field);
        diameterValue = (TextView)findViewById(R.id.sphere_diameter_value);
        volumeValue   = (TextView)findViewById(R.id.sphere_volume_value);
        surfaceValue  = (TextView)findViewById(R.id.sphere_surface_area_value);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("SphereActivity.surface",
                Double.parseDouble(surfaceValue.getText().toString()));
        outState.putDouble("SphereActivity.diagonal",
                Double.parseDouble(diameterValue.getText().toString()));
        outState.putDouble("SphereActivity.volume",
                Double.parseDouble(volumeValue.getText().toString()));

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        surfaceValue.setText(Double.toString(
                savedInstanceState.getDouble("SphereActivity.surface")));
        diameterValue.setText(Double.toString(
                savedInstanceState.getDouble("SphereActivity.diagonal")));
        volumeValue.setText(Double.toString(
                savedInstanceState.getDouble("SphereActivity.volume")));
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
        try{
            double r = Double.parseDouble(radiusValue.getText().toString());
            double d = 2 * r;
            double v = (4 / 3) * Math.PI * r * r * r;
            double sa = 4 * Math.PI * r * r;
            diameterValue.setText(Double.toString(d));
            volumeValue.setText(Double.toString(v));
            surfaceValue.setText(Double.toString(sa));
        }
        catch (Exception e){

        }
    }

    public void Back(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
