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

public class PrismActivity extends AppCompatActivity {
    private EditText heightValue;
    private EditText lengthValue;
    private EditText widthValue;
    private TextView surfaceValue;
    private TextView diagonalValue;
    private TextView volumeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        heightValue   = (EditText)findViewById(R.id.prism_height_field);
        lengthValue   = (EditText)findViewById(R.id.prism_length_field);
        widthValue    = (EditText)findViewById(R.id.prism_width_field);
        surfaceValue  = (TextView)findViewById(R.id.prism_surface_area_field);
        diagonalValue = (TextView)findViewById(R.id.prism_diagonal_field);
        volumeValue   = (TextView)findViewById(R.id.prism_volume_field);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("PrismActivity.surface",
                Double.parseDouble(surfaceValue.getText().toString()));
        outState.putDouble("PrismActivity.diagonal",
                Double.parseDouble(diagonalValue.getText().toString()));
        outState.putDouble("PrismActivity.volume",
                Double.parseDouble(volumeValue.getText().toString()));

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        surfaceValue.setText(Double.toString(
                savedInstanceState.getDouble("PrismActivity.surface")));
        diagonalValue.setText(Double.toString(
                savedInstanceState.getDouble("PrismActivity.diagonal")));
        volumeValue.setText(Double.toString(
                savedInstanceState.getDouble("PrismActivity.volume")));
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
            double h = Double.parseDouble(heightValue.getText().toString());
            double l = Double.parseDouble(lengthValue.getText().toString());
            double w = Double.parseDouble(widthValue.getText().toString());
            double sa = 2 * ((l*w)+(l*h)+(w*h));
            double d = Math.sqrt((l*l)+(h*h)+(w*w));
            double v = h*w*l;
            surfaceValue.setText(Double.toString(sa));
            diagonalValue.setText(Double.toString(d));
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
