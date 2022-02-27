package com.example.geometry4me;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startCircle(View view){
        Intent intent = new Intent(this, CircleActivity.class);

        startActivity(intent);
    }

    public void startRectangle(View view){
        Intent intent = new Intent(this, RectangleActivity.class);

        startActivity(intent);
    }

    public void startTriangle(View view){
        Intent intent = new Intent(this, TriangleActivity.class);

        startActivity(intent);
    }
    
    public void startSphere(View view){
        Intent intent = new Intent(this, SphereActivity.class);

        startActivity(intent);
    }

    public void startPrism(View view){
        Intent intent = new Intent(this, PrismActivity.class);

        startActivity(intent);
    }

    public void startPyramid(View view){
        Intent intent = new Intent(this, PyramidActivity.class);

        startActivity(intent);
    }

    public void startCylinder(View view){
        Intent intent = new Intent(this, CylinderActivity.class);

        startActivity(intent);
    }

    public void startCone(View view){
        Intent intent = new Intent(this, ConeActivity.class);

        startActivity(intent);
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
}
