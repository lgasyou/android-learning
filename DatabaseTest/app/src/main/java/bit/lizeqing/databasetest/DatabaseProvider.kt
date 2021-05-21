package bit.lizeqing.databasetest

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

class DatabaseProvider : ContentProvider() {

    companion object {
        const val BOOK_DIR = 0
        const val BOOK_ITEM = 1
        const val CATEGORY_DIR = 2
        const val CATEGORY_ITEM = 3
        const val AUTHORITY = "bit.lizeqing.databasetest.provider"
    }

    private lateinit var dbHelper: MyDatabaseHelper

    private val uriMatcher by lazy {
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
        matcher.addURI(AUTHORITY, "book", BOOK_DIR)
        matcher.addURI(AUTHORITY, "book/#", BOOK_ITEM)
        matcher.addURI(AUTHORITY, "category", CATEGORY_DIR)
        matcher.addURI(AUTHORITY, "category/#", CATEGORY_ITEM)
        matcher
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val db = dbHelper.writableDatabase
        return when (uriMatcher.match(uri)) {
            BOOK_ITEM -> {
                val bookId = uri.pathSegments[1]
                db.delete("Book", "id = ?", arrayOf(bookId))
            }
            BOOK_DIR -> {
                db.delete("Book", selection, selectionArgs)
            }
            CATEGORY_ITEM -> {
                val categoryId = uri.pathSegments[1]
                db.delete("Category", "id = ?", arrayOf(categoryId))
            }
            CATEGORY_DIR -> {
                db.delete("Category", selection, selectionArgs)
            }
            else -> 0
        }
    }

    override fun getType(uri: Uri): String? = when (uriMatcher.match(uri)) {
        BOOK_ITEM -> {
            "vnd.android.cursor.item/vnd.bit.lizeqing.databasetest.provider.book"
        }
        BOOK_DIR -> {
            "vnd.android.cursor.dir/vnd.bit.lizeqing.databasetest.provider.book"
        }
        CATEGORY_ITEM -> {
            "vnd.android.cursor.item/vnd.bit.lizeqing.databasetest.provider.book"
        }
        CATEGORY_DIR -> {
            "vnd.android.cursor.dir/vnd.bit.lizeqing.databasetest.provider.category"
        }
        else -> null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val db = dbHelper.writableDatabase
        return when (uriMatcher.match(uri)) {
            BOOK_ITEM, BOOK_DIR -> {
                val newBookId = db.insert("Book", null, values)
                Uri.parse("content://$AUTHORITY/book/$newBookId")
            }
            CATEGORY_ITEM, CATEGORY_DIR -> {
                val newBookId = db.insert("Category", null, values)
                Uri.parse("content://$AUTHORITY/category/$newBookId")
            }
            else -> null
        }
    }

    override fun onCreate(): Boolean = context?.let {
        dbHelper = MyDatabaseHelper(it, "BookStore.db", 4)
        true
    } ?: false

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val db = dbHelper.readableDatabase
        return when (uriMatcher.match(uri)) {
            BOOK_DIR -> {
                db.query("Book", projection, selection, selectionArgs, null, null, sortOrder)
            }
            BOOK_ITEM -> {
                val bookId = uri.pathSegments[1]
                db.query("Book", projection, "id = ?", arrayOf(bookId), null, null, sortOrder)
            }
            CATEGORY_DIR -> {
                db.query("Category", projection, selection, selectionArgs, null, null, sortOrder)
            }
            CATEGORY_ITEM -> {
                val categoryId = uri.pathSegments[1]
                db.query("Category", projection, "id = ?", arrayOf(categoryId), null, null, sortOrder)
            }
            else -> null
        }
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val db = dbHelper.writableDatabase
        return when (uriMatcher.match(uri)) {
            BOOK_ITEM -> {
                val bookId = uri.pathSegments[1]
                db.update("Book", values, "id = ?", arrayOf(bookId))
            }
            BOOK_DIR -> {
                db.update("Book", values, selection, selectionArgs)
            }
            CATEGORY_ITEM -> {
                val categoryId = uri.pathSegments[1]
                db.update("Category", values, "id = ?", arrayOf(categoryId))
            }
            CATEGORY_DIR -> {
                db.update("Category", values, selection, selectionArgs)
            }
            else -> 0
        }
    }
}