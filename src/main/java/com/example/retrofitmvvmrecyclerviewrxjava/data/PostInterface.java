package com.example.retrofitmvvmrecyclerviewrxjava.data;

import com.example.retrofitmvvmrecyclerviewrxjava.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Observable<List<PostModel>> getPosts();
}
