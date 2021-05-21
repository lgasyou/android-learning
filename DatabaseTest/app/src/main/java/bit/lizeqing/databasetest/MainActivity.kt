package bit.lizeqing.databasetest

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    // Database章节
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 4)
//
//        createDatabase.setOnClickListener {
//            dbHelper.writableDatabase
//        }
//
//        addData.setOnClickListener {
//            val db = dbHelper.writableDatabase
//            val value1 = ContentValues().apply {
//                put("name", "The Da Vinci Code")
//                put("author", "Dan Brown")
//                put("pages", 454)
//                put("price", 16.96)
//            }
//            db.insert("Book", null, value1)
//            val value2 = ContentValues().apply {
//                put("name", "The Lost Symbol")
//                put("author", "Dan Brown")
//                put("pages", 510)
//                put("price", 19.95)
//            }
//            db.insert("Book", null, value2)
//        }
//
//        updateData.setOnClickListener {
//            val db = dbHelper.writableDatabase
//            val values = ContentValues()
//            values.put("price", 10.99)
//            db.update("Book", values, "name = ?", arrayOf("The Da Vinci Code"))
//        }
//
//        deleteData.setOnClickListener {
//            val db = dbHelper.writableDatabase
//            db.delete("Book", "pages > ?", arrayOf("500"))
//        }
//
//        queryData.setOnClickListener {
//            val db = dbHelper.readableDatabase
//            val cursor = db.query("Book", null, null, null, null, null, null)
//            cursor.use { c ->
//                if (!c.moveToFirst()) {
//                    return@use
//                }
//                do {
//                    val name = c.getString(c.getColumnIndex("name"))
//                    val author = c.getString(c.getColumnIndex("author"))
//                    val pages = c.getInt(c.getColumnIndex("pages"))
//                    val price = c.getDouble(c.getColumnIndex("price"))
//                    Log.d("MainActivity", "book name is $name")
//                    Log.d("MainActivity", "book author is $author")
//                    Log.d("MainActivity", "book pages is $pages")
//                    Log.d("MainActivity", "book price is $price")
//                } while (c.moveToNext())
//            }
//        }
//
//        replaceData.setOnClickListener {
//            val db = dbHelper.writableDatabase
//            db.beginTransaction()
//            try {
//                db.delete("Book", null, null)
////                if (true) {
////                    throw NullPointerException()
////                }
//                val v = contentValuesOf(
//                        "name" to "Game of Thrones",
//                        "author" to "George Martin",
//                        "pages" to 720,
//                        "price" to 20.85
//                )
//                val values = ContentValues().apply {
//                    put("name", "Game of Thrones")
//                    put("author", "George Martin")
//                    put("pages", 720)
//                    put("price", 20.85)
//                }
//                db.insert("Book", null, values)
//                db.setTransactionSuccessful()
//            } catch (e: Exception) {
//                e.printStackTrace()
//            } finally {
//                db.endTransaction()
//            }
//        }
//    }

    var bookId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addData.setOnClickListener {
            val uri = Uri.parse("content://bit.lizeqing.databasetest.provider/book")
            val values = contentValuesOf(
                "name" to "A Clash of Kings",
                "author" to "George Martin",
                "pages" to 1040,
                "price" to 22.85
            )
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
        }

        queryData.setOnClickListener {
            val uri = Uri.parse("content://bit.lizeqing.databasetest.provider/book")
            contentResolver.query(uri, null, null, null, null)?.apply {
                while (moveToNext()) {
                    val name = getString(getColumnIndex("name"))
                    val author = getString(getColumnIndex("author"))
                    val pages = getInt(getColumnIndex("pages"))
                    val price = getDouble(getColumnIndex("price"))
                    Log.d("MainActivity", "book name is $name")
                    Log.d("MainActivity", "book author is $author")
                    Log.d("MainActivity", "book pages is $pages")
                    Log.d("MainActivity", "book price is $price")
                }
                close()
            }
        }

        updateData.setOnClickListener {
            bookId?.let {
                val uri = Uri.parse("content://bit.lizeqing.databasetest.provider/book/$it")
                val values = contentValuesOf(
                    "name" to "A Storm of Swords",
                    "pages" to 1216,
                    "price" to 24.05
                )
                contentResolver.update(uri, values, null, null)
            }
        }

        deleteData.setOnClickListener {
            bookId?.let {
                val uri = Uri.parse("content://bit.lizeqing.databasetest.provider/book/$it")
                contentResolver.delete(uri, null, null)
            }
        }
    }
}