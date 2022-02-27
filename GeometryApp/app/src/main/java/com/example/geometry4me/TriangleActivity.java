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

public class TriangleActivity extends AppCompatActivity {

    private EditText baseValue;
    private TextView heightValue;
    private TextView areaValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        baseValue   = (EditText)findViewById(R.id.triangle_base_field);
        heightValue = (TextView)findViewById(R.id.triangle_height_field);
        areaValue   = (TextView)findViewById(R.id.triangle_area_field);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("TriangleActivity.height",
                Double.parseDouble(heightValue.getText().toString()));
        outState.putDouble("TriangleActivity.area",
                Double.parseDouble(areaValue.getText().toString()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        heightValue.setText(Double.toString(
                savedInstanceState.getDouble("TriangleActivity.height")));
        areaValue.setText(Double.toString(
                savedInstanceState.getDouble("TriangleActivity.area")));
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
            double b = Double.parseDouble(baseValue.getText().toString());
            double h = .5 * Math.sqrt(3) * b;
            double a = .5 * b * h;
            heightValue.setText(Double.toString(h));
            areaValue.setText(Double.toString(a));
        }
        catch(Exception e){

        }
    }

    public void Back(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
