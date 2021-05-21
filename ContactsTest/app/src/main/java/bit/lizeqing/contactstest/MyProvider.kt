package bit.lizeqing.contactstest

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

class MyProvider : ContentProvider() {

    companion object {
        const val TABLE1_DIR = 0
        const val TABLE1_ITEM = 1
        const val TABLE2_DIR = 2
        const val TABLE2_ITEM = 3
    }

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    init {
        uriMatcher.addURI("bit.lizeqing.contactstest.provider", "table1", TABLE1_DIR)
        uriMatcher.addURI("bit.lizeqing.contactstest.provider", "table1/#", TABLE1_ITEM)
        uriMatcher.addURI("bit.lizeqing.contactstest.provider", "table2", TABLE2_DIR)
        uriMatcher.addURI("bit.lizeqing.contactstest.provider", "table2/#", TABLE2_ITEM)
    }

    override fun onCreate(): Boolean {
        return false
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        when (uriMatcher.match(uri)) {
            TABLE1_DIR -> {

            }
            TABLE1_ITEM -> {

            }
            TABLE2_DIR -> {

            }
            TABLE2_ITEM -> {

            }
        }
        return null
    }

    override fun getType(uri: Uri): String? = when (uriMatcher.match(uri)) {
        TABLE1_DIR -> "vnd.android.cursor.dir/vnd.bit.lizeqing.contactstest.provider.table1"
        TABLE1_ITEM -> "vnd.android.cursor.item/vnd.bit.lizeqing.contactstest.provider.table1"
        TABLE2_DIR -> "vnd.android.cursor.dir/vnd.bit.lizeqing.contactstest.provider.table2"
        TABLE2_ITEM -> "vnd.android.cursor.item/vnd.bit.lizeqing.contactstest.provider.table2"
        else -> null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

}