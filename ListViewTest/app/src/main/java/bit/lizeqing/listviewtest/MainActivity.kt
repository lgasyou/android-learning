package bit.lizeqing.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private val data = listOf(
//            "apple", "banana", "orange", "watermelon", "pear", "grape",
//            "pineapple", "strawberry", "cherry", "mango",
//            "apple", "banana", "orange", "watermelon", "pear", "grape",
//            "pineapple", "strawberry", "cherry", "mango"
//    )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//        listView.adapter = adapter
//    }

    private val fruitList = mutableListOf<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()
        val adapter = FruitAdapter(this, R.layout.layout_fruit, fruitList)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
//            parent.getItemAtPosition(position)
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("apple", R.drawable.apple_pic))
            fruitList.add(Fruit("banana", R.drawable.banana_pic))
            fruitList.add(Fruit("orange", R.drawable.orange_pic))
            fruitList.add(Fruit("watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("pear", R.drawable.pear_pic))
            fruitList.add(Fruit("grape", R.drawable.grape_pic))
            fruitList.add(Fruit("pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("mango", R.drawable.mango_pic))
        }
    }

}