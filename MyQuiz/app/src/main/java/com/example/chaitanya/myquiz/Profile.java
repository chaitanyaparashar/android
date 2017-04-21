package com.example.chaitanya.myquiz;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.chaitanya.myquiz.R.id.btn;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    private static final int RESULT_LOAD_IMAGE = 1;
    Button logOut;
    Button GoHome;
    Button Changepic;
    private Button btn;
    static EditText edit;
    static EditText edit1;
    static EditText edit2;
    static EditText edit3;
    static EditText edit4;
    static EditText edit5;
    private Session session;
    String userChoosenTask;
    private static final int REQUEST_CAMERA = 1888;



    void initViews(){
        logOut = (Button)findViewById(R.id.buttonLogout);
        GoHome = (Button)findViewById(R.id.buttonGoHome);
        Changepic = (Button)findViewById(R.id.buttonChangePic);
        session = new Session(this);
        logOut.setOnClickListener(this);
        GoHome.setOnClickListener(this);
        Changepic.setOnClickListener(this);

        if (!session.loggedin()){
            logout();
        }
    }
    private void logout() {
        session.SetLoggedin(false);
        finish();
        Intent i = new Intent(Profile.this, Login.class);
        startActivity(i);
    }
    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(Profile.this);
                if (items[item].equals("Take Photo")) {
                    userChoosenTask="Take Photo";
                    if(result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask="Choose from Library";
                    if(result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CAMERA);
    }

    private void galleryIntent()
    {
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                ImageView imageView = (ImageView) findViewById(R.id.imgView);
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }
            if (requestCode == REQUEST_CAMERA ) {onCaptureImageResult(data);

            }
        }

    public void onSelectFromGalleryResult(Intent data) {
        Bitmap bm =null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ImageView imageView = (ImageView) findViewById(R.id.imgView);
        imageView.setImageBitmap(thumbnail);
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        boolean success = false;

        FileOutputStream outStream;
        try {

            outStream = new FileOutputStream(destination);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);


            outStream.flush();
            outStream.close();
            success = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String username = getIntent().getStringExtra("Username");
        edit = (EditText) findViewById(R.id.edit);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);
        edit5 = (EditText) findViewById(R.id.edit5);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);
        TextView tvusername = (TextView)findViewById(R.id.textViewUsername);
        tvusername.setText(username);

        initViews();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        QuizHelper db = new QuizHelper(this);
        if( v.getId() == R.id.buttonLogout){
            logout();
        }
        else if (v.getId() == R.id.buttonGoHome){
            Intent i = new Intent(Profile.this,Home.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.buttonChangePic){
            selectImage();
        }
        else if (v.getId() == R.id.btn){
            db.insertIntoDB();
        }


    }
}
