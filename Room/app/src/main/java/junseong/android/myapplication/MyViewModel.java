package junseong.android.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;

import junseong.android.myapplication.model.ItemModel;
import junseong.android.myapplication.model.PageListModel;
import junseong.android.myapplication.retrofit.RetrofitFactory;
import junseong.android.myapplication.retrofit.RetrofitService;
import junseong.android.myapplication.room.AppDatabase;
import junseong.android.myapplication.room.ArticleDAO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {

    private static final String QUERY = "travel";
    private static final String API_KEY = "ebbc3f52dc294e72aa888b8fe88aa962";
    RetrofitService networkService = RetrofitFactory.create();
    AppDatabase db=Room.databaseBuilder(MyApplication.getAppContext(),
            AppDatabase.class, "database-name").build();
    ArticleDAO dao=db.articleDAO();
    public MutableLiveData<List<ItemModel>> getNews(){
        ConnectivityManager connectivityManager=(ConnectivityManager)
                MyApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null){
            return getNewsFromNetwork();
        }else{
            MutableLiveData<List<ItemModel>> liveData=new MutableLiveData<>();
            new GetAllThread(liveData).start();
            return liveData;

        }
    }
    private MutableLiveData<List<ItemModel>> getNewsFromNetwork(){
        MutableLiveData<List<ItemModel>> liveData=new MutableLiveData<>();
        networkService.getList(QUERY,API_KEY,1,10)
                .enqueue(new Callback<PageListModel>() {
                    @Override
                    public void onResponse(Call<PageListModel> call, Response<PageListModel> response) {
                        if(response.isSuccessful()){
                            liveData.postValue(response.body().articles);
                            new InsertDataThread(response.body().articles).start();
                        }
                    }

                    @Override
                    public void onFailure(Call<PageListModel> call, Throwable t) {

                    }
                });
        return liveData;
    }
    class GetAllThread extends Thread{
        MutableLiveData<List<ItemModel>> liveData;
        public GetAllThread(MutableLiveData<List<ItemModel>> liveData){
            this.liveData=liveData;
        }
        @Override
        public void run(){
            List<ItemModel> daoData=dao.getAll();
            liveData.postValue(daoData);
        }
    }
    class InsertDataThread extends Thread{
        List<ItemModel> articles;
        public InsertDataThread(List<ItemModel> articles){
            this.articles=articles;
        }
        @Override
        public void run(){
            dao.deleteAll();
            dao.insertAll(articles.toArray(new ItemModel[articles.size()]));
        }
    }
}