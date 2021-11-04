package com.example.retrofitmvvmrecyclerviewrxjava.ui.main;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.retrofitmvvmrecyclerviewrxjava.data.PostsClient;
import com.example.retrofitmvvmrecyclerviewrxjava.pojo.PostModel;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";
    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();

    // getPosts Responsible for taking data from
    public void getPosts(){
        Observable observable = PostsClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

      Observer<List<PostModel>> observer = new Observer<List<PostModel>>() {
          @Override
          public void onSubscribe(Disposable d) {}
          @Override
          public void onNext(List<PostModel> value) {
              postMutableLiveData.setValue(value);
          }
          @Override
          public void onError(Throwable e) {
              Log.d(TAG, "onError: "+e);
          }
          @Override
          public void onComplete() { }
      };
      observable.subscribe(observer);

    }
}
