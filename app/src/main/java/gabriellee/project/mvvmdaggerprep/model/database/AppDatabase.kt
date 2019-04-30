package gabriellee.project.mvvmdaggerprep.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import gabriellee.project.mvvmdaggerprep.model.Post
import gabriellee.project.mvvmdaggerprep.model.PostDao

@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao() : PostDao
}