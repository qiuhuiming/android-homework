package icu.sjtu.network.service;

import icu.sjtu.network.model.GetVideoResponse;
import icu.sjtu.network.model.UploadResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface UploadService {

    @Multipart
    @POST("/invoke/video")
    Call<UploadResponse> uploadVideo(@Query("student_id") String studentId,
                                     @Query("user_name") String userName,
                                     @Part MultipartBody.Part image,
                                     @Part MultipartBody.Part video);

    @GET("/invoke/video")
    Call<GetVideoResponse> getVideoList();

}
