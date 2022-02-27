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

public class CylinderActivity extends AppCompatActivity {

    private EditText radiusValue;
    private EditText heightValue;
    private TextView baseValue;
    private TextView lateralValue;
    private TextView areaValue;
    private TextView volumeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        radiusValue  = (EditText)findViewById(R.id.cylinder_radius_field);
        heightValue  = (EditText)findViewById(R.id.cylinder_height_field);
        baseValue    = (TextView)findViewById(R.id.cylinder_base_field);
        lateralValue = (TextView)findViewById(R.id.cylinder_lateral_field);
        areaValue    = (TextView)findViewById(R.id.cylinder_area_field);
        volumeValue  = (TextView)findViewById(R.id.cylinder_volume_field);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("CylinderActivity.area",
                Double.parseDouble(areaValue.getText().toString()));
        outState.putDouble("CylinderActivity.base",
                Double.parseDouble(baseValue.getText().toString()));
        outState.putDouble("CylinderActivity.lateral",
                Double.parseDouble(lateralValue.getText().toString()));
        outState.putDouble("CylinderActivity.volume",
                Double.parseDouble(volumeValue.getText().toString()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        areaValue.setText(Double.toString(
                savedInstanceState.getDouble("CylinderActivity.area")));
        baseValue.setText(Double.toString(
                savedInstanceState.getDouble("CylinderActivity.base")));
        lateralValue.setText(Double.toString(
                savedInstanceState.getDouble("CylinderActivity.lateral")));
        volumeValue.setText(Double.toString(
                savedInstanceState.getDouble("CylinderActivity.volume")));

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
                startActivity(new Intent(getApplicationContext(),
                        PyramidActivity.class));
                return true;

            case R.id.menuCylinder:
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
            Double r = Double.parseDouble(radiusValue.getText().toString());
            Double h = Double.parseDouble(heightValue.getText().toString());
            Double b = Math.PI * r * r;
            Double l = 2 * Math.PI * r * h;
            Double a = 2 * b + l;
            Double v = Math.PI * r * r * h;
            baseValue.setText(Double.toString(b));
            lateralValue.setText(Double.toString(l));
            areaValue.setText(Double.toString(a));
            volumeValue.setText(Double.toString(v));
        }
        catch (Exception e){

        }
    }

    public void Back(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
