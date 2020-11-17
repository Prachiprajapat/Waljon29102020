package com.iwtechnocrat.waljon.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iwtechnocrat.waljon.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class Act_profileDetails extends AppCompatActivity {
    LinearLayout edit_profile,edit_background;
    ImageView img_background,img_profile;
    TextView dob,chngenumber;
    private static final int TAKE_PICTURE = 102;
    private static final int TAKE_PICTURE_PAN = 109;
    private static final int TAKE_PICTURE_GST = 116;
    private static final int ADHAR_PICTURE = 105;
    private static final int PICK_IMAGE = 103;
    private static final int ADHAR_IMAGE = 104;
    private static final int PICK_FROM_GALLERY = 1;
    String encodeImage, encodeImage1;
    Bitmap profile, background,PanCardPhoto,GstPhoto;
    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_profile_details);

        edit_profile = findViewById(R.id.edit_profile);
        edit_background = findViewById(R.id.edit_background);
        img_background = findViewById(R.id.img_background);
        img_profile = findViewById(R.id.img_profile);
        dob = findViewById(R.id.dob);
        chngenumber = findViewById(R.id.chngenumber);


        chngenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(),Act_UpdateNumber.class);
                 startActivity(intent);
            }
        });


        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Act_profileDetails.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();

            }
        });


        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    final Dialog dialog = new Dialog(Act_profileDetails.this);
                    dialog.setContentView(R.layout.item_select_camera_gallery);
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                    dialog.getWindow().setAttributes(lp);
                    LinearLayout ll_Camera = dialog.findViewById(R.id.ll_Camera);
                    LinearLayout ll_Gallery = dialog.findViewById(R.id.ll_Gallery);
                    ImageView CancelDiload = dialog.findViewById(R.id.CancelDiload);
                    CancelDiload.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    ll_Camera.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            dialog.dismiss();
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, TAKE_PICTURE);

                        }
                    });
                    ll_Gallery.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Dexter.withActivity(Act_profileDetails.this)
                                    .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                                    .withListener(new PermissionListener() {
                                        @Override
                                        public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                                            Intent intent = new Intent(Intent.ACTION_PICK);
                                            intent.setType("image/*");
                                            startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
                                        }

                                        @Override
                                        public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                                        }

                                        @Override
                                        public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                            permissionToken.continuePermissionRequest();

                                        }

                                    }).check();
                        }
                    });
                    dialog.show();
                }
            }
        });

        edit_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    final Dialog dialog = new Dialog(Act_profileDetails.this);
                    dialog.setContentView(R.layout.item_select_camera_gallery);
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                    dialog.getWindow().setAttributes(lp);
                    LinearLayout ll_Camera = dialog.findViewById(R.id.ll_Camera);
                    LinearLayout ll_Gallery = dialog.findViewById(R.id.ll_Gallery);
                    ImageView CancelDiload = dialog.findViewById(R.id.CancelDiload);
                    CancelDiload.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    ll_Camera.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            dialog.dismiss();
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, ADHAR_IMAGE);

                        }
                    });
                    ll_Gallery.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Dexter.withActivity(Act_profileDetails.this)
                                    .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                                    .withListener(new PermissionListener() {
                                        @Override
                                        public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                                            Intent intent = new Intent(Intent.ACTION_PICK);
                                            intent.setType("image/*");
                                            startActivityForResult(Intent.createChooser(intent, "Select Image"), 2);
                                        }

                                        @Override
                                        public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                                        }

                                        @Override
                                        public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                            permissionToken.continuePermissionRequest();

                                        }

                                    }).check();
                        }
                    });
                    dialog.show();
                }
            }
        });


    }


    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 60, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getFileDataFromDrawable1(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 60, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK) {
            profile = (Bitmap) data.getExtras().get("data");
            img_profile.setImageBitmap(profile);
            Log.e("", "cameraimage::-" + profile);

        } else  if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

            Uri filepath1 = data.getData();
            Log.e("","filwpath"+filepath1);
            try {
                InputStream inputStream = getApplicationContext().getContentResolver().openInputStream(filepath1);
                profile = BitmapFactory.decodeStream(inputStream);
                img_profile.setImageBitmap(profile);
                imageStore(profile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        if (requestCode == ADHAR_IMAGE && resultCode == Activity.RESULT_OK) {
            background = (Bitmap) data.getExtras().get("data");
            img_background.setImageBitmap(background);
            Log.e("", "camera" + background);


        } else if (requestCode == 2 && resultCode == RESULT_OK && data != null) {

            Uri filepath1 = data.getData();
            Log.e("","filwpath"+filepath1);
            try {
                InputStream inputStream = getApplicationContext().getContentResolver().openInputStream(filepath1);
                background = BitmapFactory.decodeStream(inputStream);
                img_background.setImageBitmap(background);
                imageStore1(background);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }




    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private void imageStore(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imageBytes = stream.toByteArray();
        encodeImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    private void imageStore1(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imageBytes = stream.toByteArray();
        encodeImage1 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }
}