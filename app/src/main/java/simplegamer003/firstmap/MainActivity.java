package simplegamer003.firstmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gmap;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b= (Button)findViewById(R.id.btnMap);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady){
                    gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });
        Button bHybrid =(Button)findViewById(R.id.btnHybrid);
        bHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady){
                    gmap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
        });
        Button bSat =(Button)findViewById(R.id.btnSatellite);
        bSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady){
                    gmap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
            }
        });
        Button bTerrain =(Button)findViewById(R.id.btnTerrain);
        bTerrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady){
                    gmap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                }
            }
        });

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        gmap = googleMap;
        LatLng NewDelhi = new LatLng(28.6139, 77.2090);
        CameraPosition target = CameraPosition.builder().target(NewDelhi).zoom(15).tilt(65).build();
        gmap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
