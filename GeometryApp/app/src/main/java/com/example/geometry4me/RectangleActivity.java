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

public class RectangleActivity extends AppCompatActivity {

    private TextView perimeterValue;
    private TextView diagonalValue;
    private TextView areaValue;
    private EditText baseText;
    private EditText heightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        perimeterValue = (TextView)findViewById(R.id.rectangle_perimeter_field);
        diagonalValue  = (TextView)findViewById(R.id.rectangle_diagonal_field);
        areaValue      = (TextView)findViewById(R.id.rectangle_area_field);
        baseText       = (EditText)findViewById(R.id.rectangle_base_field);
        heightText     = (EditText)findViewById(R.id.rectangle_height_field);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("RectangleActivity.area",
                Double.parseDouble(areaValue.getText().toString()));
        outState.putDouble("RectangleActivity.diagonal",
                Double.parseDouble(diagonalValue.getText().toString()));
        outState.putDouble("RectangleActivity.perimeter",
                Double.parseDouble(perimeterValue.getText().toString()));

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        areaValue.setText(Double.toString(
                savedInstanceState.getDouble("RectangleActivity.area")));
        diagonalValue.setText(Double.toString(
                savedInstanceState.getDouble("RectangleActivity.diagonal")));
        perimeterValue.setText(Double.toString(
                savedInstanceState.getDouble("RectangleActivity.perimeter")));
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
            double b = Double.parseDouble(baseText.getText().toString());
            double h = Double.parseDouble(heightText.getText().toString());

            double perimeter = 2 * (b + h);
            double diagonal = Math.sqrt((b * b) + (h * h));
            double area = b * h;

            perimeterValue.setText(Double.toString(perimeter));
            diagonalValue.setText(Double.toString(diagonal));
            areaValue.setText(Double.toString(area));
        }
        catch (Exception e){

        }
    }

    public void Back(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
