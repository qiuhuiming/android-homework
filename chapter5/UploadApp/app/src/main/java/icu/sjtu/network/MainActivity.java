package icu.sjtu.network;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import icu.sjtu.network.model.GetVideoResponse;
import icu.sjtu.network.model.UploadResponse;
import icu.sjtu.network.service.UploadService;
import icu.sjtu.network.util.MyPartBuilder;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api-sjtu-camp.bytedance.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private final UploadService uploadService = retrofit.create(UploadService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 点击Upload按钮
        findViewById(R.id.uploadButton).setOnClickListener(v -> {
            Log.d(TAG, "onCreate: click upload button");
            uploadFile();
        });

        // 点击Get按钮
        findViewById(R.id.getButton).setOnClickListener(v -> {
            Log.d(TAG, "onCreate: click get button");
            getVideoList();
        });
    }

    private void uploadFile() {
        AssetManager assets = getAssets();
        MultipartBody.Part coverImage = new MyPartBuilder()
                .setAssetManager(assets)
                .setFileName("pic.png")
                .setMediaType("image/png")
                .setKey("cover_image")
                .build();
        MultipartBody.Part video = new MyPartBuilder()
                .setAssetManager(assets)
                .setFileName("video.mp4")
                .setMediaType("application/octet-stream")
                .setKey("video")
                .build();
        uploadService.uploadVideo("123", "xxx", coverImage, video)
                .enqueue(new Callback<UploadResponse>() {
                    @Override
                    public void onResponse(Call<UploadResponse> call, Response<UploadResponse> response) {
                        Log.d(TAG, "onResponse: received");
                        if (! response.isSuccessful()) {
                            Log.d(TAG, "onResponse: response failed");
                            return;
                        }
                        Log.d(TAG, "response: " + response.body());
                    }

                    @Override
                    public void onFailure(Call<UploadResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t);
                        Log.d(TAG, "onFailure: ");
                    }
                });
    }

    private void getVideoList() {
        uploadService.getVideoList().enqueue(new Callback<GetVideoResponse>() {
            @Override
            public void onResponse(Call<GetVideoResponse> call, Response<GetVideoResponse> response) {
                Log.d(TAG, "onResponse: received");
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<GetVideoResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }

}