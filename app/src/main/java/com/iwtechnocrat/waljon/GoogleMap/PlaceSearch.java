package com.iwtechnocrat.waljon.GoogleMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.api.Places;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.iwtechnocrat.waljon.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static android.content.ContentValues.TAG;

public class PlaceSearch extends AppCompatActivity implements OnMapReadyCallback {

    private static int AUTOCOMPLETE_REQUEST_CODE = 1;
    TextView tv_add;
    Button btn_message;
    Context context;
    public static double latitude = 0.0, longitude = 0.0;
    public static GoogleMap map;
    private GoogleMap.OnCameraIdleListener onCameraIdleListener;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_search);

        context = this;
        tv_add = findViewById(R.id.tv_add);

        Places.initialize(getApplicationContext(), getString(R.string.google_maps_web_key));

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapview_home);

        mapFragment.getMapAsync(this);

        configureCameraIdle();

//        showBottomSheetDialog();

        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Places.isInitialized()) {
                    Places.initialize(context, context.getResources().getString(R.string.google_maps_web_key));
                }


                // Set the fields to specify which types of place data to return.
                List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS);

                // Start the autocomplete intent.
                Intent intent = new Autocomplete.IntentBuilder(
                        AutocompleteActivityMode.FULLSCREEN, fields)
                        .build(context);
                startActivityForResult(intent, 112);
            }
        });


    }

    private void configureCameraIdle() {
        onCameraIdleListener = new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {

                LatLng latLng = map.getCameraPosition().target;
                Geocoder geocoder = new Geocoder(context);

                try {
                    List<Address> addressList = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        String locality = addressList.get(0).getAddressLine(0);
                        String country = addressList.get(0).getCountryName();
                        if (!locality.isEmpty() && !country.isEmpty())
                            tv_add.setText(locality + "  " + country);
                        latitude = latLng.latitude;
                        longitude = latLng.longitude;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
     /*   map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);*/
        map.setOnCameraIdleListener(onCameraIdleListener);

        map.setMinZoomPreference(16);
        LatLng ny = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
        map.moveCamera(CameraUpdateFactory.newLatLng(ny));
        if (map != null) {
            map.addMarker(new MarkerOptions()
                    .position(ny)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .draggable(false).visible(true));
        }
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            Log.e("qqqqqqqqqqqqqqqqqqqq", locationAddress);
            getCompleteAddressString(latitude, longitude);

        }

        private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
            String strAdd = "";

            try {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
                if (addresses != null) {
                    int maxAddressLine = addresses.get(0).getMaxAddressLineIndex();
                    String cityName = addresses.get(0).getAddressLine(maxAddressLine);
                    String stateName = addresses.get(0).getAddressLine(1);
                    String countryName = addresses.get(0).getAddressLine(2);

                    tv_add.setText(cityName);
                }
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");
                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
                Log.e("nnnnnnnnnnnn", strAdd);
                // Log.w("My Current loction address", strReturnedAddress.toString());

            } catch (Exception e) {
                e.printStackTrace();
                //Log.w("My Current loction address", "Canont get Address!");
            }

            return strAdd;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 112) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());

                latitude = place.getLatLng().latitude;
                longitude = place.getLatLng().longitude;

                map.clear();
                map.setMinZoomPreference(16);
                LatLng ny = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
                map.moveCamera(CameraUpdateFactory.newLatLng(ny));
                if (map != null) {
                    map.addMarker(new MarkerOptions()
                            .position(ny)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                            .draggable(false).visible(true));
                }


                tv_add.setText(place.getAddress());


            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage());
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }


    }

    public void showBottomSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet, null);
        final BottomSheetDialog dialog = new BottomSheetDialog(this);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                BottomSheetDialog d = (BottomSheetDialog) dialog;

                FrameLayout bottomSheet = (FrameLayout) d.findViewById(R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        dialog.setContentView(view);



        dialog.show();
    }
}