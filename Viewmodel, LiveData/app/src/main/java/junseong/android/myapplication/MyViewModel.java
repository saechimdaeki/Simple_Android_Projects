package junseong.android.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {

    private static final String QUERY="flower";
    private static final String API_KEY="ebbc3f52dc294e72aa888b8fe88aa962";
    RetrofitService networkService=RetrofitFactory.create();
    public MutableLiveData<List<ItemModel>> getNews(){
        final MutableLiveData<List<ItemModel>> liveData=new MutableLiveData<>();
        networkService.getList(QUERY,API_KEY,1,10)
                .enqueue(new Callback<PageListModel>() {
                    @Override
                    public void onResponse(Call<PageListModel> call, Response<PageListModel> response) {
                        if(response.isSuccessful()){
                            liveData.postValue(response.body().articles);
                        }
                    }

                    @Override
                    public void onFailure(Call<PageListModel> call, Throwable t) {

                    }
                });
        return liveData;
    }
}
