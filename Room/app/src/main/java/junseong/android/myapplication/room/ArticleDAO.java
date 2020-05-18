package junseong.android.myapplication.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import junseong.android.myapplication.model.ItemModel;

@Dao
public interface ArticleDAO {
    @Query("SELECT * FROM article")
    List<ItemModel> getAll();

    @Insert
    void insertAll(ItemModel... users);

    @Query("DELETE FROM article")
    void deleteAll();

}
