package junseong.android.myapplication.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import junseong.android.myapplication.model.ItemModel;

@Database(entities = {ItemModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDAO articleDAO();
}
