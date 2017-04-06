package com.example.osmdroidofflinedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

/**
 * @author Luca Campana
 * This activity load the tiles and show them in the mapView
 * In order to make and move your tiles see the read.me
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView map = (MapView) findViewById(R.id.map);

        //This ensure that the application will work offline
        map.setUseDataConnection(false);

        //Set the tileSource, in order to use other tileSources, see https://github.com/osmdroid/osmdroid/wiki/Map-Sources
        map.setTileSource(TileSourceFactory.MAPNIK);

        //This enable more map controls
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        //We set a point, center the map and add a marker on it
        IMapController controller = map.getController();
        GeoPoint startPoint = new GeoPoint(46.071067, 13.234579);
        controller.setCenter(startPoint);
        Marker startMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(startMarker);

        //Set current max and minimum zoom level
        controller.setZoom(10);
        map.setMinZoomLevel(9);
        map.setMaxZoomLevel(13);

        //If you are experiencing issues consider enabling those
        //Configuration.getInstance().setDebugMode(true);
        //Configuration.getInstance().setDebugMapView(true);
        //Configuration.getInstance().setDebugTileProviders(true);
    }

}
