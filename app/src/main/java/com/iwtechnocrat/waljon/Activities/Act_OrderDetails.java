package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.iwtechnocrat.waljon.R;

public class Act_OrderDetails extends AppCompatActivity {
     ImageView back;
     LinearLayout lay_placetrack,btn_track,lay_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);

        back = findViewById(R.id.back);
        lay_placetrack = findViewById(R.id.lay_placetrack);
        btn_track = findViewById(R.id.btn_track);
        lay_cancel = findViewById(R.id.lay_cancel);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_MyOrder.class);
                startActivity(intent);
            }
        });

        lay_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_CancelOrder.class);
                startActivity(intent);
            }
        });


        lay_placetrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.iwtechnocrat.waljon.Activities.Order_TrackBottomSheet bottomSheet = new com.iwtechnocrat.waljon.Activities.Order_TrackBottomSheet();
                bottomSheet.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });

        btn_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.iwtechnocrat.waljon.Activities.Order_TrackBottomSheet bottomSheet = new com.iwtechnocrat.waljon.Activities.Order_TrackBottomSheet();
                bottomSheet.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });
    }

    public void showBottomSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet, null);
        final com.google.android.material.bottomsheet.BottomSheetDialog dialog = new com.google.android.material.bottomsheet.BottomSheetDialog(this);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                com.google.android.material.bottomsheet.BottomSheetDialog d = (BottomSheetDialog) dialog;

                FrameLayout bottomSheet = (FrameLayout) d.findViewById(R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        dialog.setContentView(view);


        dialog.show();
    }
}